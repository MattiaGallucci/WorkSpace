package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SegnalaCommunityDAO extends AbstractDAO<SegnalaCommunityBean>{
    private static final String TABLE_NAME = "segnalaCommunity";

    public synchronized void doSave(SegnalaCommunityBean bean) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;

        String query = "INSERT INTO " + TABLE_NAME + " (utenteEmail, communityId) VALUES (?,?)";

        try{
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setString(1, bean.getUtenteEmail());
            statement.setInt(2, bean.getCommunityId());

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

    public synchronized boolean doDelete(String utenteEmail, int communityId) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        int result = 0;

        String query = "DELETE FROM " + TABLE_NAME + " WHERE utenteEmail = ? AND communityId = ?";

        try{
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setString(1, utenteEmail);
            statement.setInt(2, communityId);

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

    public synchronized SegnalaCommunityBean doRetrieveByKey(String utenteEmail, int communityId) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        SegnalaCommunityBean segnalaCommunity = null;

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE utenteEmail = ? AND communityId = ?";

        try{
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setString(1, utenteEmail);
            statement.setInt(2, communityId);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                segnalaCommunity = new SegnalaCommunityBean();
                segnalaCommunity.setUtenteEmail(resultSet.getString("utenteEmail"));
                segnalaCommunity.setCommunityId(resultSet.getInt("communityId"));
            }
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
        return segnalaCommunity;
    }

    public synchronized List<SegnalaCommunityBean> doRetrieveAll(String order) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        List<SegnalaCommunityBean> segnalaCommunities = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_NAME;

        if (order != null && !order.isEmpty()) {
            query += " ORDER BY " + order;
        }
        try{
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                SegnalaCommunityBean segnalaCommunity = new SegnalaCommunityBean();
                segnalaCommunity.setUtenteEmail(resultSet.getString("utenteEmail"));
                segnalaCommunity.setCommunityId(resultSet.getInt("communityId"));

                segnalaCommunities.add(segnalaCommunity);
            }
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
        return segnalaCommunities;
    }
}