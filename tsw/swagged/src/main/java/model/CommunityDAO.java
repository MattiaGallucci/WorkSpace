package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommunityDAO extends AbstractDAO<CommunityBean>{
    private static final String TABLE_NAME = "community";

    public synchronized void doSave(CommunityBean bean) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;

        String query = "INSERT INTO " + TABLE_NAME + " (nome, descrizione, segnalazioni, iscritti, utenteEmail) VALUES (?,?,?,?,?);";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setString(1, bean.getNome());
            statement.setString(2, bean.getDescrizione());
            statement.setInt(3, bean.getSegnalazioni());
            statement.setInt(4, bean.getIscritti());
            statement.setString(5, bean.getUtenteEmail());

            statement.executeUpdate();
            con.commit();
        } finally {
            if (statement != null) statement.close();
            DriverManagerConnectionPool.releaseConnection(con);
        }
    }

    public synchronized boolean doDelete(int key) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        int result = 0;

        String query = "DELETE FROM " + TABLE_NAME + " WHERE id = ?;";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);
            statement.setInt(1, key);

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

    public synchronized CommunityBean doRetrieveById(int key) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        CommunityBean community = new CommunityBean();

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?;";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);
            statement.setInt(1, key);

            ResultSet result = statement.executeQuery();
            if (result.next()) {
                community.setId(result.getInt("id"));
                community.setNome(result.getString("nome"));
                community.setDescrizione(result.getString("descrizione"));
                community.setSegnalazioni(result.getInt("segnalazioni"));
                community.setIscritti(result.getInt("iscritti"));
                community.setUtenteEmail(result.getString("utenteEmail"));
            }
        } finally {
            if (statement != null) statement.close();
            DriverManagerConnectionPool.releaseConnection(con);
        }
        return community;
    }

    public synchronized List<CommunityBean> doRetrieveAll() throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        List<CommunityBean> communities = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_NAME;

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                CommunityBean community = new CommunityBean();
                community.setId(result.getInt("id"));
                community.setNome(result.getString("nome"));
                community.setDescrizione(result.getString("descrizione"));
                community.setSegnalazioni(result.getInt("segnalazioni"));
                community.setIscritti(result.getInt("iscritti"));
                community.setUtenteEmail(result.getString("utenteEmail"));

                communities.add(community);
            }
        } finally {
            if (statement != null) statement.close();
            DriverManagerConnectionPool.releaseConnection(con);
        }
        return communities;
    }

    public synchronized boolean doUpdate(CommunityBean bean) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        int result = 0;

        String query = "UPDATE " + TABLE_NAME + " SET nome = ?, descrizione = ?, segnalazioni = ?, iscritti = ?, utenteEmail = ? WHERE id = ?;";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setString(1, bean.getNome());
            statement.setString(2, bean.getDescrizione());
            statement.setInt(3, bean.getSegnalazioni());
            statement.setInt(4, bean.getIscritti());
            statement.setString(5, bean.getUtenteEmail());
            statement.setInt(6, bean.getId());

            result = statement.executeUpdate();
            con.commit();
        } finally {
            if (statement != null) statement.close();
            DriverManagerConnectionPool.releaseConnection(con);
        }
        return result != 0;
    }

    public synchronized List<CommunityBean> doRetrieveByEmail(String key) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        List<CommunityBean> communities = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE utenteEmail = ?;";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                CommunityBean community = new CommunityBean();
                community.setId(result.getInt("id"));
                community.setNome(result.getString("nome"));
                community.setDescrizione(result.getString("descrizione"));
                community.setSegnalazioni(result.getInt("segnalazioni"));
                community.setIscritti(result.getInt("iscritti"));
                community.setUtenteEmail(result.getString("utenteEmail"));

                communities.add(community);
            }
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
        return communities;
    }
    
    public synchronized List<CommunityBean> doRetrieveByNameSubstring(String substring) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        List<CommunityBean> communities = new ArrayList<>();

        // Use the SQL LIKE operator for substring matching
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE nome LIKE ?;";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            // Prepare the substring for the SQL query, adding wildcards for partial matches
            statement.setString(1, "%" + substring + "%");

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                CommunityBean community = new CommunityBean();
                community.setId(result.getInt("id"));
                community.setNome(result.getString("nome"));
                community.setDescrizione(result.getString("descrizione"));
                community.setSegnalazioni(result.getInt("segnalazioni"));
                community.setIscritti(result.getInt("iscritti"));
                community.setUtenteEmail(result.getString("utenteEmail"));

                communities.add(community);
            }
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
        return communities;
    }
    
    
}