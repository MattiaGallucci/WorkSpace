package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UtenteDAO extends AbstractDAO<UtenteBean>{
    private static final String TABLE_NAME = "utente";

    public synchronized void doSave(UtenteBean bean) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;

        String query = "INSERT INTO " + TABLE_NAME + " (email, username, password, immagine, segnalazioni, bandito, follower, seguiti, admin) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setString(1, bean.getEmail());
            statement.setString(2, bean.getUsername());
            statement.setString(3, bean.getPassword());
            statement.setString(4, bean.getImmagine());
            statement.setInt(5, bean.getSegnalazioni());
            statement.setBoolean(6, bean.isBandito());
            statement.setInt(7, bean.getFollower());  // Aggiungi follower
            statement.setInt(8, bean.getSeguiti());   // Aggiungi seguiti
            statement.setBoolean(9, bean.isAdmin());

            statement.executeUpdate();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }
    
    public synchronized boolean doDelete(String key) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        int result = 0;

        String query = "DELETE FROM " + TABLE_NAME + " WHERE email = ?";
        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);
            statement.setString(1, key);

            result = statement.executeUpdate();
        } finally {
            try {
                if(statement != null) {
                    statement.close();
                }
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
        return result != 0;
    }

    public synchronized UtenteBean doRetrieveByEmail(String key) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        UtenteBean utente = new UtenteBean();

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE email = ?";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);
            statement.setString(1, key);

            ResultSet result = statement.executeQuery();

            while(result.next()) {
                utente.setEmail(result.getString("email"));
                utente.setUsername(result.getString("username"));
                utente.setPassword(result.getString("password"));
                utente.setImmagine(result.getString("immagine"));
                utente.setSegnalazioni(result.getInt("segnalazioni"));
                utente.setBandito(result.getBoolean("bandito"));
                utente.setAdmin(result.getBoolean("admin"));
            }
        } finally {
            try {
                if(statement != null) {
                    statement.close();
                }
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
        return utente;
    }

    public synchronized UtenteBean doRetrieveByUsername(String key) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        UtenteBean utente = new UtenteBean();

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE username = ?";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);
            statement.setString(1, key);

            ResultSet result = statement.executeQuery();

            while(result.next()) {
                utente.setEmail(result.getString("email"));
                utente.setUsername(result.getString("username"));
                utente.setPassword(result.getString("password"));
                utente.setImmagine(result.getString("immagine"));
                utente.setSegnalazioni(result.getInt("segnalazioni"));
                utente.setBandito(result.getBoolean("bandito"));
                utente.setAdmin(result.getBoolean("admin"));
            }
        } finally {
            try {
                if(statement != null) {
                    statement.close();
                }
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }

        return utente;
    }

    public synchronized List<UtenteBean> doRetrieveAll(String order) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;

        List<UtenteBean> utenti = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME;

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                UtenteBean utente = new UtenteBean();

                utente.setEmail(result.getString("email"));
                utente.setUsername(result.getString("username"));
                utente.setPassword(result.getString("password"));
                utente.setImmagine(result.getString("immagine"));
                utente.setSegnalazioni(result.getInt("segnalazioni"));
                utente.setBandito(result.getBoolean("bandito"));
                utente.setFollower(result.getInt("follower"));  // Aggiungi follower
                utente.setSeguiti(result.getInt("seguiti"));    // Aggiungi seguiti
                utente.setAdmin(result.getBoolean("admin"));

                utenti.add(utente);
            }
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
        return utenti;
    }

    public synchronized boolean doUpdate(UtenteBean bean, String key) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        int result = 0;

        String query = "UPDATE " + TABLE_NAME + " SET username = ?, password = ?, immagine = ?, segnalazioni = ?, bandito = ?, follower = ?, seguiti = ?, admin = ? WHERE email = ?;";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setString(1, bean.getUsername());
            statement.setString(2, bean.getPassword());
            statement.setString(3, bean.getImmagine());
            statement.setInt(4, bean.getSegnalazioni());
            statement.setBoolean(5, bean.isBandito());
            statement.setInt(6, bean.getFollower()); // Aggiungi follower
            statement.setInt(7, bean.getSeguiti());  // Aggiungi seguiti
            statement.setBoolean(8, bean.isAdmin());
            statement.setString(9, key);

            result = statement.executeUpdate();

            con.commit();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
        return result != 0;
    }
    
    public synchronized List<UtenteBean> doRetrieveByUsernameSubstring(String substring) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        List<UtenteBean> utenti = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE username LIKE ?;";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            // Aggiungi i caratteri jolly per la ricerca parziale
            statement.setString(1, "%" + substring + "%");

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                UtenteBean utente = new UtenteBean();
                utente.setEmail(result.getString("email"));
                utente.setUsername(result.getString("username"));
                utente.setPassword(result.getString("password"));
                utente.setImmagine(result.getString("immagine"));
                utente.setSegnalazioni(result.getInt("segnalazioni"));
                utente.setBandito(result.getBoolean("bandito"));
                utente.setFollower(result.getInt("follower"));
                utente.setSeguiti(result.getInt("seguiti"));
                utente.setAdmin(result.getBoolean("admin"));
                utenti.add(utente);
            }
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }

        return utenti;
    }


    public synchronized boolean checkEmail(String email) throws SQLException {
        boolean alreadyUsed = false;
        Connection con = null;
        PreparedStatement statement = null;

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE email = ?";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setString(1, email);
            ResultSet result = statement.executeQuery();

            if(result.next()) {
                alreadyUsed = true;
            }
        } finally {
            try {
                if(statement != null) {
                    statement.close();
                }
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }

        return alreadyUsed;
    }

    public synchronized boolean checkUsername(String username) throws SQLException{
        boolean alreadyUsed = false;
        Connection con = null;
        PreparedStatement statement = null;

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE username = ?";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setString(1, username);
            ResultSet result = statement.executeQuery();

            if(result.next()) {
                alreadyUsed = true;
            }
        } finally {
            try {
                if(statement != null) {
                    statement.close();
                }
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }

        return alreadyUsed;
    }
}