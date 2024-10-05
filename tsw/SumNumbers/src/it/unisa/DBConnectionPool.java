package it.unisa;

import java.io.IOException;
import java.sql.*;
import java.util.*;

public class DBConnectionPool
{
	
	static {
		freeDbConnections = new LinkedList<Connection>();
		try {
			DBConnectionPool.loadDbProperties("","");
			DBConnectionPool.loadDbDriver();
		} catch (ClassNotFoundException e) {
			System.out.println("DB driver not found: "+e.getMessage());
		} catch (IOException e) {
			System.out.println("DB connection pool error: "+e.getMessage());
		}
	}

	private static Properties dbProperties;
	private static List<Connection> freeDbConnections;
	

	public static synchronized Connection getConnection() throws SQLException {
		Connection connection;

		if (!freeDbConnections.isEmpty()) {
			connection = (Connection) freeDbConnections.get(0);
			DBConnectionPool.freeDbConnections.remove(0);

			try {
				if (connection.isClosed())
					connection = DBConnectionPool.getConnection();
			} catch (SQLException e) {
				connection = DBConnectionPool.getConnection();
			}
		} else
			connection = DBConnectionPool.createDBConnection();

		return connection;
	}	
	
	public static synchronized void releaseConnection(Connection pReleasedConnection) {
		DBConnectionPool.freeDbConnections.add(pReleasedConnection);
	}

	public static synchronized void clearConnections() {
		for(Connection connection : DBConnectionPool.freeDbConnections) {
			try {
				if (!connection.isClosed())
					connection.close();
			} catch(SQLException e) {
				
			}
		}
		DBConnectionPool.freeDbConnections.clear();
	}	
	
	
	private static Connection createDBConnection() throws SQLException {
		Connection newConnection = null;

		newConnection = DriverManager.getConnection(DBConnectionPool.dbProperties.getProperty("url"),
				DBConnectionPool.dbProperties.getProperty("username"),
				DBConnectionPool.dbProperties.getProperty("password"));

		newConnection.setAutoCommit(false);
		return newConnection;
	}

	private static void loadDbDriver() throws ClassNotFoundException {
		Class.forName(DBConnectionPool.dbProperties.getProperty("driver"));
	}
	
	public static void loadDbProperties(String dbLogin, String dbPassword) throws IOException {
        String dbIp = "localhost";
        String dbPort = "3306";
		
		DBConnectionPool.dbProperties = new Properties();

		DBConnectionPool.dbProperties.put("driver", "com.mysql.cj.jdbc.Driver"); 
		DBConnectionPool.dbProperties.put("url", "jdbc:mysql://"+ dbIp+":"+ dbPort +"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false");
			
		DBConnectionPool.dbProperties.put("username", dbLogin);
		DBConnectionPool.dbProperties.put("password", dbPassword);			
	}	
}
