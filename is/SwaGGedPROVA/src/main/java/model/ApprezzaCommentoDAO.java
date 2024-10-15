package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApprezzaCommentoDAO extends AbstractDAO<ApprezzaCommentoBean> {
    private static final String TABLE_NAME = "apprezzaCommento";

    public synchronized void doSave(ApprezzaCommentoBean bean) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;

        String query = "INSERT INTO " + TABLE_NAME + " (utenteEmail, commentoId, apprezzamento) VALUES (?, ?, ?)";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setString(1, bean.getUtenteEmail());
            statement.setInt(2, bean.getCommentoId());
            statement.setInt(3, bean.getApprezzamento());

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

    public synchronized ApprezzaCommentoBean doRetrieveByKey(String utenteEmail, int commentoId) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        ApprezzaCommentoBean apprezzaCommento = null;

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE utenteEmail = ? AND commentoId = ?";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setString(1, utenteEmail);
            statement.setInt(2, commentoId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                apprezzaCommento = new ApprezzaCommentoBean();
                apprezzaCommento.setUtenteEmail(resultSet.getString("utenteEmail"));
                apprezzaCommento.setCommentoId(resultSet.getInt("commentoId"));
                apprezzaCommento.setApprezzamento(resultSet.getInt("apprezzamento"));
            }
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
        return apprezzaCommento;
    }

    public synchronized List<ApprezzaCommentoBean> doRetrieveByEmail(String utenteEmail) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        List<ApprezzaCommentoBean> apprezzaCommentos = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE utenteEmail = ?";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setString(1, utenteEmail);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ApprezzaCommentoBean apprezzaCommento = new ApprezzaCommentoBean();
                apprezzaCommento.setUtenteEmail(resultSet.getString("utenteEmail"));
                apprezzaCommento.setCommentoId(resultSet.getInt("commentoId"));
                apprezzaCommento.setApprezzamento(resultSet.getInt("apprezzamento"));

                apprezzaCommentos.add(apprezzaCommento);
            }
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
        return apprezzaCommentos;
    }

    public synchronized List<ApprezzaCommentoBean> doRetrieveAll(String order) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        List<ApprezzaCommentoBean> apprezzaCommentos = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_NAME;

        if (order != null && !order.isEmpty()) {
            query += " ORDER BY " + order;
        }

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ApprezzaCommentoBean apprezzaCommento = new ApprezzaCommentoBean();
                apprezzaCommento.setUtenteEmail(resultSet.getString("utenteEmail"));
                apprezzaCommento.setCommentoId(resultSet.getInt("commentoId"));
                apprezzaCommento.setApprezzamento(resultSet.getInt("apprezzamento"));

                apprezzaCommentos.add(apprezzaCommento);
            }
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
        return apprezzaCommentos;
    }

    public synchronized boolean doUpdate(ApprezzaCommentoBean bean, String utenteEmail, int commentoId) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        int result = 0;

        String query = "UPDATE " + TABLE_NAME + " SET apprezzamento = ? WHERE utenteEmail = ? AND commentoId = ?";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setInt(1, bean.getApprezzamento());
            statement.setString(2, utenteEmail);
            statement.setInt(3, commentoId);

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
}
