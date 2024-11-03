package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApprezzaPostDAO extends AbstractDAO<ApprezzaPostBean> {
    private static final String TABLE_NAME = "apprezzaPost";

    public synchronized void doSave(ApprezzaPostBean bean) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;

        String query = "INSERT INTO " + TABLE_NAME + " (utenteEmail, postId, apprezzamento) VALUES (?, ?, ?)";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setString(1, bean.getUtenteEmail());
            statement.setInt(2, bean.getPostId());
            statement.setInt(3, bean.getApprezzamento());

            statement.executeUpdate();
            con.commit();
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    public synchronized boolean doDelete(String utenteEmail, int postId) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        int result = 0;

        String query = "DELETE FROM " + TABLE_NAME + " WHERE utenteEmail = ? AND postId = ?";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setString(1, utenteEmail);
            statement.setInt(2, postId);

            result = statement.executeUpdate();
            con.commit();
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
        return result != 0;
    }

    public synchronized ApprezzaPostBean doRetrieveByKey(String utenteEmail, int postId) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        ApprezzaPostBean apprezzaPost = null;

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE utenteEmail = ? AND postId = ?";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setString(1, utenteEmail);
            statement.setInt(2, postId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                apprezzaPost = new ApprezzaPostBean();
                apprezzaPost.setUtenteEmail(resultSet.getString("utenteEmail"));
                apprezzaPost.setPostId(resultSet.getInt("postId"));
                apprezzaPost.setApprezzamento(resultSet.getInt("apprezzamento"));
            }
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
        return apprezzaPost;
    }

    public synchronized List<ApprezzaPostBean> doRetrieveByEmail(String utenteEmail) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        List<ApprezzaPostBean> apprezzaPosts = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE utenteEmail = ?";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setString(1, utenteEmail);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ApprezzaPostBean apprezzaPost = new ApprezzaPostBean();
                apprezzaPost.setUtenteEmail(resultSet.getString("utenteEmail"));
                apprezzaPost.setPostId(resultSet.getInt("postId"));
                apprezzaPost.setApprezzamento(resultSet.getInt("apprezzamento"));

                apprezzaPosts.add(apprezzaPost);
            }
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
        return apprezzaPosts;
    }

    public synchronized List<ApprezzaPostBean> doRetrieveAll(String order) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        List<ApprezzaPostBean> apprezzaPosts = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_NAME;

        if (order != null && !order.isEmpty()) {
            query += " ORDER BY " + order;
        }

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ApprezzaPostBean apprezzaPost = new ApprezzaPostBean();
                apprezzaPost.setUtenteEmail(resultSet.getString("utenteEmail"));
                apprezzaPost.setPostId(resultSet.getInt("postId"));
                apprezzaPost.setApprezzamento(resultSet.getInt("apprezzamento"));

                apprezzaPosts.add(apprezzaPost);
            }
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
        return apprezzaPosts;
    }

    public synchronized boolean doUpdate(ApprezzaPostBean bean, String utenteEmail, int postId) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        int result = 0;

        String query = "UPDATE " + TABLE_NAME + " SET apprezzamento = ? WHERE utenteEmail = ? AND postId = ?";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setInt(1, bean.getApprezzamento());
            statement.setString(2, utenteEmail);
            statement.setInt(3, postId);

            result = statement.executeUpdate();
            con.commit();
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
        return result != 0;
    }
    
    public synchronized boolean doLike(String utenteEmail, int postId) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        int result = 0;

        String query = "INSERT INTO " + TABLE_NAME + " (utenteEmail, postId, apprezzamento) VALUES (?, ?, 1)";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);
            statement.setString(1, utenteEmail);
            statement.setInt(2, postId);
            
            result = statement.executeUpdate();
            con.commit();
        } finally {
            try {
                if (statement != null) statement.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
        return result != 0;
    }

    public synchronized boolean doUnlike(String utenteEmail, int postId) throws SQLException {
        return doDelete(utenteEmail, postId); // Utilize the existing delete method for unliking
    }

}