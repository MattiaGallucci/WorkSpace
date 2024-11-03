package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SegueCommunityDAO extends AbstractDAO<SegueCommunityBean>{
    private static final String TABLE_NAME = "segueCommunity";

    public synchronized void doSave(SegueCommunityBean bean) throws SQLException {
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

    public synchronized SegueCommunityBean doRetrieveByKey(String utenteEmail, int communityId) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        SegueCommunityBean segueCommunity = null;

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE utenteEmail = ? AND communityId = ?";

        try{
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setString(1, utenteEmail);
            statement.setInt(2, communityId);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                segueCommunity = new SegueCommunityBean();
                segueCommunity.setUtenteEmail(resultSet.getString("utenteEmail"));
                segueCommunity.setCommunityId(resultSet.getInt("communityId"));
            }
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
        return segueCommunity;
    }

    public synchronized List<SegueCommunityBean> doRetrieveByEmail(String utenteEmail) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        List<SegueCommunityBean> segueCommunities = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE utenteEmail = ?";

        try {
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            statement.setString(1, utenteEmail);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                SegueCommunityBean segueCommunity = new SegueCommunityBean();
                segueCommunity.setUtenteEmail(resultSet.getString("utenteEmail"));
                segueCommunity.setCommunityId(resultSet.getInt("communityId"));

                segueCommunities.add(segueCommunity);
            }
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
        return segueCommunities;
    }


    public synchronized List<SegueCommunityBean> doRetrieveAll(String order) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        List<SegueCommunityBean> segueCommunities = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_NAME;

        if (order != null && !order.isEmpty()) {
            query += " ORDER BY " + order;
        }
        try{
            con = DriverManagerConnectionPool.getConnection();
            statement = con.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                SegueCommunityBean segueCommunity = new SegueCommunityBean();
                segueCommunity.setUtenteEmail(resultSet.getString("utenteEmail"));
                segueCommunity.setCommunityId(resultSet.getInt("communityId"));

                segueCommunities.add(segueCommunity);
            }
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
        return segueCommunities;
    }
}
