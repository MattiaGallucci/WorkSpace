package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalvaPostDAO extends AbstractDAO<SalvaPostBean> {
    private static final String TABLE_NAME = "salvaPost";

    public synchronized void doSave(SalvaPostBean bean) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;

        String query = "INSERT INTO " + TABLE_NAME + " (utenteEmail, postId) VALUES (?, ?)";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setString(1, bean.getUtenteEmail());
            statement.setInt(2, bean.getPostId());

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

    public synchronized SalvaPostBean doRetrieveByKey(String utenteEmail, int postId) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        SalvaPostBean salvaPost = null;

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE utenteEmail = ? AND postId = ?";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setString(1, utenteEmail);
            statement.setInt(2, postId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                salvaPost = new SalvaPostBean();
                salvaPost.setUtenteEmail(resultSet.getString("utenteEmail"));
                salvaPost.setPostId(resultSet.getInt("postId"));
            }
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
        return salvaPost;
    }

    public synchronized List<SalvaPostBean> doRetrieveByEmail(String utenteEmail) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        List<SalvaPostBean> salvaPosts = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE utenteEmail = ?";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setString(1, utenteEmail);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                SalvaPostBean salvaPost = new SalvaPostBean();
                salvaPost.setUtenteEmail(resultSet.getString("utenteEmail"));
                salvaPost.setPostId(resultSet.getInt("postId"));

                salvaPosts.add(salvaPost);
            }
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
        return salvaPosts;
    }

    public synchronized List<SalvaPostBean> doRetrieveAll(String order) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        List<SalvaPostBean> salvaPosts = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_NAME;

        if (order != null && !order.isEmpty()) {
            query += " ORDER BY " + order;
        }

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                SalvaPostBean salvaPost = new SalvaPostBean();
                salvaPost.setUtenteEmail(resultSet.getString("utenteEmail"));
                salvaPost.setPostId(resultSet.getInt("postId"));

                salvaPosts.add(salvaPost);
            }
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
        return salvaPosts;
    }
}
