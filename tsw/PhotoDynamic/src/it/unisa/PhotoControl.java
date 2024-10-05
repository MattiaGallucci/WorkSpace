package it.unisa;

import java.sql.SQLException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PhotoControl {
	public synchronized static byte[] load(String id) {

		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		byte[] bt = null;

		try {
			connection = DBConnectionPool.getConnection();
			String sql = "SELECT photo FROM lectures WHERE id = ?";
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				bt = rs.getBytes("photo");
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
		return bt;
	}
	
	public synchronized static void updatePhoto(String idA, InputStream photo) 
			throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBConnectionPool.getConnection();
			stmt = con.prepareStatement("UPDATE lectures SET photo = ? WHERE id = ?");
			try {
				stmt.setBinaryStream(1, photo, photo.available());
				stmt.setString(2, idA);	
				stmt.executeUpdate();
				con.commit();
			} catch (IOException e) {
				System.out.println(e);
			}
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException sqlException) {
				System.out.println(sqlException);
			} finally {
				if (con != null)
					DBConnectionPool.releaseConnection(con);
			}
		}
	}
}
