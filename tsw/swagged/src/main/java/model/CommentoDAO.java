package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentoDAO extends AbstractDAO<CommentoBean> {
    private static final String TABLE_NAME = "commento";

    public synchronized void doSave(CommentoBean bean) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;

        String query = "INSERT INTO " + TABLE_NAME + " (corpo, segnalazioni, likes, padre, utenteEmail, postId) VALUES (?,?,?,?,?,?)";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setString(1, bean.getCorpo());
            statement.setInt(2, bean.getSegnalazioni());
            statement.setInt(3, bean.getLikes());
            statement.setInt(4, bean.getPadre());
            statement.setString(5, bean.getUtenteEmail());
            statement.setInt(6, bean.getPostId());

            statement.executeUpdate();
            con.commit();
        } finally {
            if (statement != null) statement.close();
            DriverManagerConnectionPool.releaseConnection(con);
        }
    }

    public synchronized boolean doDelete(int id) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        int result = 0;

        String query = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);
            statement.setInt(1, id);

            result = statement.executeUpdate();
            con.commit();
        } finally {
            if (statement != null) statement.close();
            DriverManagerConnectionPool.releaseConnection(con);
        }
        return result != 0;
    }

    public synchronized CommentoBean doRetrieveById(int id) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        CommentoBean commento = new CommentoBean();

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                commento.setId(result.getInt("id"));
                commento.setCorpo(result.getString("corpo"));
                commento.setSegnalazioni(result.getInt("segnalazioni"));
                commento.setLikes(result.getInt("likes"));
                commento.setPadre(result.getInt("padre"));
                commento.setUtenteEmail(result.getString("utenteEmail"));
                commento.setPostId(result.getInt("postId"));
            }
        } finally {
            if (statement != null) statement.close();
            DriverManagerConnectionPool.releaseConnection(con);
        }
        return commento;
    }

    public synchronized List<CommentoBean> doRetrieveAll() throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        List<CommentoBean> comments = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_NAME;

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                CommentoBean commento = new CommentoBean();
                commento.setId(result.getInt("id"));
                commento.setCorpo(result.getString("corpo"));
                commento.setSegnalazioni(result.getInt("segnalazioni"));
                commento.setLikes(result.getInt("likes"));
                commento.setPadre(result.getInt("padre"));
                commento.setUtenteEmail(result.getString("utenteEmail"));
                commento.setPostId(result.getInt("postId"));

                comments.add(commento);
            }
        } finally {
            if (statement != null) statement.close();
            DriverManagerConnectionPool.releaseConnection(con);
        }
        return comments;
    }

    public synchronized List<CommentoBean> doRetrieveByPostId(int postId) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        List<CommentoBean> comments = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE postId = ?";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);
            statement.setInt(1, postId);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                CommentoBean commento = new CommentoBean();
                commento.setId(result.getInt("id"));
                commento.setCorpo(result.getString("corpo"));
                commento.setSegnalazioni(result.getInt("segnalazioni"));
                commento.setLikes(result.getInt("likes"));
                commento.setPadre(result.getInt("padre"));
                commento.setUtenteEmail(result.getString("utenteEmail"));
                commento.setPostId(result.getInt("postId"));

                comments.add(commento);
            }
        } finally {
            if (statement != null) statement.close();
            DriverManagerConnectionPool.releaseConnection(con);
        }
        return comments;
    }

    // New method to retrieve comments by a specific user's email
    public synchronized List<CommentoBean> doRetrieveByUtenteEmail(String utenteEmail) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        List<CommentoBean> comments = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE utenteEmail = ?";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);
            statement.setString(1, utenteEmail);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                CommentoBean commento = new CommentoBean();
                commento.setId(result.getInt("id"));
                commento.setCorpo(result.getString("corpo"));
                commento.setSegnalazioni(result.getInt("segnalazioni"));
                commento.setLikes(result.getInt("likes"));
                commento.setPadre(result.getInt("padre"));
                commento.setUtenteEmail(result.getString("utenteEmail"));
                commento.setPostId(result.getInt("postId"));

                comments.add(commento);
            }
        } finally {
            if (statement != null) statement.close();
            DriverManagerConnectionPool.releaseConnection(con);
        }
        return comments;
    }
    
    public synchronized boolean doUpdate(CommentoBean bean) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        int result = 0;

        String query = "UPDATE " + TABLE_NAME + " SET corpo = ?, segnalazioni = ?, likes = ?, padre = ?, utenteEmail = ?, postId = ? WHERE id = ?";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setString(1, bean.getCorpo());
            statement.setInt(2, bean.getSegnalazioni());
            statement.setInt(3, bean.getLikes());
            statement.setInt(4, bean.getPadre());
            statement.setString(5, bean.getUtenteEmail());
            statement.setInt(6, bean.getPostId());
            statement.setInt(7, bean.getId()); // Assicurati di passare l'ID del commento che vuoi aggiornare

            result = statement.executeUpdate();
            con.commit();
        } finally {
            if (statement != null) statement.close();
            DriverManagerConnectionPool.releaseConnection(con);
        }
        return result != 0; // Restituisce true se l'aggiornamento è andato a buon fine
    }

}
