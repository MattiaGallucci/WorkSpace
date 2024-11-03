package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SegueUtenteDAO extends AbstractDAO<SegueUtenteBean> {
    private static final String TABLE_NAME = "segueUtente";

    public synchronized void doSave(SegueUtenteBean bean) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;

        String query = "INSERT INTO " + TABLE_NAME + " (seguaceEmail, seguitoEmail) VALUES (?,?)";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setString(1, bean.getSeguaceEmail());
            statement.setString(2, bean.getSeguitoEmail());

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

    public synchronized boolean doDelete(String seguaceEmail, String seguitoEmail) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        int result = 0;

        String query = "DELETE FROM " + TABLE_NAME + " WHERE seguaceEmail = ? AND seguitoEmail = ?";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setString(1, seguaceEmail);
            statement.setString(2, seguitoEmail);

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

    public synchronized SegueUtenteBean doRetrieveByKey(String seguaceEmail, String seguitoEmail) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        SegueUtenteBean seguiUtente = null;

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE seguaceEmail = ? AND seguitoEmail = ?";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setString(1, seguaceEmail);
            statement.setString(2, seguitoEmail);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                seguiUtente = new SegueUtenteBean();
                seguiUtente.setSeguaceEmail(resultSet.getString("seguaceEmail"));
                seguiUtente.setSeguitoEmail(resultSet.getString("seguitoEmail"));
            }
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
        return seguiUtente;
    }

    public synchronized List<SegueUtenteBean> doRetrieveAll(String order) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        List<SegueUtenteBean> seguiUtenti = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_NAME;

        if (order != null && !order.isEmpty()) {
            query += " ORDER BY " + order;
        }

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                SegueUtenteBean seguiUtente = new SegueUtenteBean();
                seguiUtente.setSeguaceEmail(resultSet.getString("seguaceEmail"));
                seguiUtente.setSeguitoEmail(resultSet.getString("seguitoEmail"));

                seguiUtenti.add(seguiUtente);
            }
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
        return seguiUtenti;
    }

    public synchronized List<SegueUtenteBean> doRetrieveBySeguace(String seguaceEmail) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        List<SegueUtenteBean> seguiUtenti = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE seguaceEmail = ?";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setString(1, seguaceEmail);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                SegueUtenteBean seguiUtente = new SegueUtenteBean();
                seguiUtente.setSeguaceEmail(resultSet.getString("seguaceEmail"));
                seguiUtente.setSeguitoEmail(resultSet.getString("seguitoEmail"));

                seguiUtenti.add(seguiUtente);
            }
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
        return seguiUtenti;
    }
}
