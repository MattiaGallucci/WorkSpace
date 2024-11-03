package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SegnalaUtenteDAO extends AbstractDAO<SegnalaUtenteBean>{
    private static final String TABLE_NAME = "segnalaUtente";

    public synchronized void doSave(SegnalaUtenteBean bean) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;

        String query = "INSERT INTO " + TABLE_NAME + " (segnalatoreEmail, segnalatoEmail) VALUES (?,?)";

        try{
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setString(1, bean.getSegnalatoreEmail());
            statement.setString(2, bean.getSegnalatoEmail());

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

    public synchronized boolean doDelete(String segnalatoreEmail, String segnalatoEmail) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        int result = 0;

        String query = "DELETE FROM " + TABLE_NAME + " WHERE segnalatoreEmail = ? AND segnalatoEmail = ?";

        try{
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setString(1, segnalatoreEmail);
            statement.setString(2, segnalatoEmail);

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

    public synchronized SegnalaUtenteBean doRetrieveByKey(String segnalatoreEmail, String segnalatoEmail) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        SegnalaUtenteBean segnalaUtente = null;

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE segnalatoreEmail = ? AND segnalatoEmail = ?";

        try{
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setString(1, segnalatoreEmail);
            statement.setString(2, segnalatoEmail);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                segnalaUtente = new SegnalaUtenteBean();
                segnalaUtente.setSegnalatoreEmail(resultSet.getString("segnalatoreEmail"));
                segnalaUtente.setSegnalatoEmail(resultSet.getString("segnalatoEmail"));
            }
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
        return segnalaUtente;
    }

    public synchronized List<SegnalaUtenteBean> doRetrieveAll(String order) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        List<SegnalaUtenteBean> segnalaUtenti = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_NAME;

        if (order != null && !order.isEmpty()) {
            query += " ORDER BY " + order;
        }

        try{
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                SegnalaUtenteBean segnalaUtente = new SegnalaUtenteBean();
                segnalaUtente.setSegnalatoreEmail(resultSet.getString("segnalatoreEmail"));
                segnalaUtente.setSegnalatoEmail(resultSet.getString("segnalatoEmail"));

                segnalaUtenti.add(segnalaUtente);
            }
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
        return segnalaUtenti;
    }
}
