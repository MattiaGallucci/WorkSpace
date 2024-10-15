package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SegnalaPostDAO extends AbstractDAO<SegnalaPostBean> {
    private static final String TABLE_NAME = "segnalaPost";

    public synchronized void doSave(SegnalaPostBean bean) throws SQLException {
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

    public synchronized SegnalaPostBean doRetrieveByKey(String utenteEmail, int postId) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        SegnalaPostBean segnalaPost = null;

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE utenteEmail = ? AND postId = ?";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setString(1, utenteEmail);
            statement.setInt(2, postId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                segnalaPost = new SegnalaPostBean();
                segnalaPost.setUtenteEmail(resultSet.getString("utenteEmail"));
                segnalaPost.setPostId(resultSet.getInt("postId"));
            }
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
        return segnalaPost;
    }

    public synchronized List<SegnalaPostBean> doRetrieveAll(String order) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        List<SegnalaPostBean> segnalaPosts = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_NAME;

        if (order != null && !order.isEmpty()) {
            query += " ORDER BY " + order;
        }

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                SegnalaPostBean segnalaPost = new SegnalaPostBean();
                segnalaPost.setUtenteEmail(resultSet.getString("utenteEmail"));
                segnalaPost.setPostId(resultSet.getInt("postId"));

                segnalaPosts.add(segnalaPost);
            }
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
        return segnalaPosts;
    }
}
