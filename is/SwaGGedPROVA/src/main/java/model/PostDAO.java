package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDAO extends AbstractDAO<PostBean>{
    private static final String TABLE_NAME = "post";

    public synchronized void doSave(PostBean bean) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;

        String query = "INSERT INTO " + TABLE_NAME + " (titolo, corpo, immagine, segnalazioni, utenteEmail, communityId) VALUES (?,?,?,?,?,?)";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setString(1, bean.getTitolo());
            statement.setString(2, bean.getCorpo());
            statement.setString(3, bean.getImmagine());
            statement.setInt(4, bean.getSegnalazioni());
            statement.setString(5, bean.getUtenteEmail());
            statement.setInt(6, bean.getCommunityId());

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

    public synchronized boolean doDelete(String key) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        int result = 0;
        String query = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";

        try{
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);
            statement.setString(1, key);

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

    public synchronized PostBean doRetrieveById(String key) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        PostBean post = new PostBean();

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);
            statement.setString(1, key);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                post.setId(result.getInt("id"));
                post.setTitolo(result.getString("titolo"));
                post.setCorpo(result.getString("corpo"));
                post.setImmagine(result.getString("immagine"));
                post.setSegnalazioni(result.getInt("segnalazioni"));
                post.setUtenteEmail(result.getString("utenteEmail"));
                post.setCommunityId(result.getInt("communityId"));
            }
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
        return post;
    }

    public synchronized List<PostBean> doRetrieveAll() throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;

        List<PostBean> posts = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_NAME;

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                PostBean post = new PostBean();
                post.setId(result.getInt("id"));
                post.setTitolo(result.getString("titolo"));
                post.setCorpo(result.getString("corpo"));
                post.setImmagine(result.getString("immagine"));
                post.setSegnalazioni(result.getInt("segnalazioni"));
                post.setUtenteEmail(result.getString("utenteEmail"));
                post.setCommunityId(result.getInt("communityId"));

                posts.add(post);
            }
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
        return posts;
    }

    public synchronized List<PostBean> doRetrieveByEmail(String key) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        List<PostBean> posts = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE utenteEmail = ?;";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                PostBean post = new PostBean();
                post.setId(result.getInt("id"));
                post.setTitolo(result.getString("titolo"));
                post.setCorpo(result.getString("corpo"));
                post.setImmagine(result.getString("immagine"));
                post.setSegnalazioni(result.getInt("segnalazioni"));
                post.setUtenteEmail(result.getString("utenteEmail"));
                post.setCommunityId(result.getInt("communityId"));

                posts.add(post);
            }
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
        return posts;
    }
}