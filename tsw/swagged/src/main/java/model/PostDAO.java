package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDAO extends AbstractDAO<PostBean> {
    private static final String TABLE_NAME = "post";

    public synchronized void doSave(PostBean bean) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;

        String query = "INSERT INTO " + TABLE_NAME + " (titolo, corpo, immagine, segnalazioni, likes, utenteEmail, communityId) VALUES (?,?,?,?,?,?,?)";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setString(1, bean.getTitolo());
            statement.setString(2, bean.getCorpo());
            statement.setString(3, bean.getImmagine());
            statement.setInt(4, bean.getSegnalazioni());
            statement.setInt(5, bean.getLikes()); // Set likes after segnalazioni
            statement.setString(6, bean.getUtenteEmail());
            statement.setInt(7, bean.getCommunityId());

            statement.executeUpdate();
            con.commit();
        } finally {
            if (statement != null) statement.close();
            DriverManagerConnectionPool.releaseConnection(con);
        }
    }

    public synchronized PostBean doRetrieveById(int key) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        PostBean post = new PostBean();

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);
            statement.setInt(1, key);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                post.setId(result.getInt("id"));
                post.setTitolo(result.getString("titolo"));
                post.setCorpo(result.getString("corpo"));
                post.setImmagine(result.getString("immagine"));
                post.setSegnalazioni(result.getInt("segnalazioni"));
                post.setLikes(result.getInt("likes")); // Retrieve likes after segnalazioni
                post.setUtenteEmail(result.getString("utenteEmail"));
                post.setCommunityId(result.getInt("communityId"));
            }
        } finally {
            if (statement != null) statement.close();
            DriverManagerConnectionPool.releaseConnection(con);
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
                post.setLikes(result.getInt("likes")); // Include likes after segnalazioni
                post.setUtenteEmail(result.getString("utenteEmail"));
                post.setCommunityId(result.getInt("communityId"));
                posts.add(post);
            }
        } finally {
            if (statement != null) statement.close();
            DriverManagerConnectionPool.releaseConnection(con);
        }
        return posts;
    }

    public synchronized List<PostBean> doRetrieveByEmail(String key) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        List<PostBean> posts = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE utenteEmail = ?";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);
            statement.setString(1, key);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                PostBean post = new PostBean();
                post.setId(result.getInt("id"));
                post.setTitolo(result.getString("titolo"));
                post.setCorpo(result.getString("corpo"));
                post.setImmagine(result.getString("immagine"));
                post.setSegnalazioni(result.getInt("segnalazioni"));
                post.setLikes(result.getInt("likes")); // Add likes after segnalazioni
                post.setUtenteEmail(result.getString("utenteEmail"));
                post.setCommunityId(result.getInt("communityId"));
                posts.add(post);
            }
        } finally {
            if (statement != null) statement.close();
            DriverManagerConnectionPool.releaseConnection(con);
        }
        return posts;
    }
    
    public synchronized List<PostBean> doRetrieveByTitleSubstring(String substring) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        List<PostBean> posts = new ArrayList<>();

        // Use the SQL LIKE operator for substring matching
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE titolo LIKE ?;";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            // Prepare the substring for the SQL query, adding wildcards for partial matches
            statement.setString(1, "%" + substring + "%");

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                PostBean post = new PostBean();
                post.setId(result.getInt("id"));
                post.setTitolo(result.getString("titolo"));
                post.setCorpo(result.getString("corpo"));
                post.setImmagine(result.getString("immagine"));
                post.setSegnalazioni(result.getInt("segnalazioni"));
                post.setLikes(result.getInt("likes")); // Include likes after segnalazioni
                post.setUtenteEmail(result.getString("utenteEmail"));
                post.setCommunityId(result.getInt("communityId"));
                posts.add(post);
            }
        } finally {
            if (statement != null) statement.close();
            DriverManagerConnectionPool.releaseConnection(con);
        }
        return posts;
    }

    public synchronized void doDelete(int id) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;

        String query = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
            con.commit(); // Commit the transaction
        } finally {
            if (statement != null) statement.close();
            DriverManagerConnectionPool.releaseConnection(con);
        }
    }
    
    public synchronized boolean doUpdate(PostBean bean) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        int result = 0;

        String query = "UPDATE " + TABLE_NAME + " SET titolo = ?, corpo = ?, immagine = ?, segnalazioni = ?, likes = ?, utenteEmail = ?, communityId = ? WHERE id = ?";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            // Set the parameters based on the PostBean object
            statement.setString(1, bean.getTitolo());
            statement.setString(2, bean.getCorpo());
            statement.setString(3, bean.getImmagine());
            statement.setInt(4, bean.getSegnalazioni());
            statement.setInt(5, bean.getLikes());
            statement.setString(6, bean.getUtenteEmail());
            statement.setInt(7, bean.getCommunityId());
            statement.setInt(8, bean.getId()); // ID must be set last for the WHERE clause

            // Execute the update and capture the result
            result = statement.executeUpdate();
            
            con.commit(); // Commit the transaction
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }

        // Return true if at least one row was updated, false otherwise
        return result != 0;
    }


    public synchronized void updateLikes(int postId, boolean increase) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;

        // Define the SQL query based on whether we want to increase or decrease the likes
        String query;
        if (increase) {
            query = "UPDATE " + TABLE_NAME + " SET likes = likes + 1 WHERE id = ?";
        } else {
            query = "UPDATE " + TABLE_NAME + " SET likes = likes - 1 WHERE id = ? AND likes > 0"; // Ensure likes do not go negative
        }

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);
            statement.setInt(1, postId); // Set the post ID parameter

            statement.executeUpdate();
            con.commit(); // Commit the transaction
        } finally {
            if (statement != null) statement.close();
            DriverManagerConnectionPool.releaseConnection(con);
        }
    }

}
