package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SegnalaCommentoDAO extends AbstractDAO<SegnalaCommentoBean> {
    private static final String TABLE_NAME = "segnalaCommento";

    public synchronized void doSave(SegnalaCommentoBean bean) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;

        String query = "INSERT INTO " + TABLE_NAME + " (utenteEmail, commentoId) VALUES (?, ?)";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setString(1, bean.getUtenteEmail());
            statement.setInt(2, bean.getCommentoId());

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

    public synchronized boolean doDelete(String utenteEmail, int commentoId) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        int result = 0;

        String query = "DELETE FROM " + TABLE_NAME + " WHERE utenteEmail = ? AND commentoId = ?";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setString(1, utenteEmail);
            statement.setInt(2, commentoId);

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

    public synchronized SegnalaCommentoBean doRetrieveByKey(String utenteEmail, int commentoId) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        SegnalaCommentoBean segnalaCommento = null;

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE utenteEmail = ? AND commentoId = ?";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setString(1, utenteEmail);
            statement.setInt(2, commentoId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                segnalaCommento = new SegnalaCommentoBean();
                segnalaCommento.setUtenteEmail(resultSet.getString("utenteEmail"));
                segnalaCommento.setCommentoId(resultSet.getInt("commentoId"));
            }
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
        return segnalaCommento;
    }

    public synchronized List<SegnalaCommentoBean> doRetrieveAll(String order) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        List<SegnalaCommentoBean> segnalaCommenti = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_NAME;

        if (order != null && !order.isEmpty()) {
            query += " ORDER BY " + order;
        }

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                SegnalaCommentoBean segnalaCommento = new SegnalaCommentoBean();
                segnalaCommento.setUtenteEmail(resultSet.getString("utenteEmail"));
                segnalaCommento.setCommentoId(resultSet.getInt("commentoId"));

                segnalaCommenti.add(segnalaCommento);
            }
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
        return segnalaCommenti;
    }
}