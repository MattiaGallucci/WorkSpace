package it.unisa;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import it.unisa.model.Lecture;

public class LecturerControl {
	public synchronized static List<Lecture> load() {

		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Lecture> model = new ArrayList<Lecture>();

		try {
			connection = DBConnectionPool.getConnection();
			String sql = "SELECT * FROM lectures";
			stmt = connection.prepareStatement(sql);

			rs = stmt.executeQuery();

			while (rs.next()) {
				Lecture item = new Lecture();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setSurname(rs.getString("surname"));
				
				model.add(item);
			}

		} catch (SQLException sqlException) {
			System.out.println(sqlException);
		} 
			finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException sqlException) {
				System.out.println(sqlException);
			} finally {
				if (connection != null) 
					DBConnectionPool.releaseConnection(connection);
			}
		}
		return model;
	}
	
	public static void add(Lecture model) {
		Connection connection = null;
		PreparedStatement stmt = null;	

		String sql = "INSERT INTO lectures (NAME, SURNAME) VALUES (?, ?)";
		try {
			connection = DBConnectionPool.getConnection();
			stmt = connection.prepareStatement(sql);			
			
			stmt.setString(1, model.getName());
			stmt.setString(2, model.getSurname());
			
			stmt.executeUpdate();	
			
			connection.commit();
			
		} catch (SQLException sqlException) {
			System.out.println(sqlException);
		} 
			finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException sqlException) {
				System.out.println(sqlException);
			} finally {
				if (connection != null) 
					DBConnectionPool.releaseConnection(connection);
			}
		}
	}	
}
