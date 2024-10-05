package it.unisa;

import java.sql.*;


public class DatabaseOperation
{
    public static synchronized String operation(String login, String password, String number1, String number2) throws Exception
    {
        PreparedStatement stmt = null;
        Connection con = null;
        String value = "";

        try
        {
        	if(login == null || login.equals("")) {
                throw new Exception("Login is required");
            } 
        	if(number1 == null || number2 == null) {
                throw new Exception("Inputs are not numbers");
            }    
                    	
            double num1 = Double.parseDouble(number1);
            double num2 = Double.parseDouble(number2);
            
            DBConnectionPool.loadDbProperties(login, password);
            
            con = DBConnectionPool.getConnection();
            
            stmt = con.prepareStatement("SELECT ?+? AS RESULT FROM DUAL");
            stmt.setString(1, Double.toString(num1));
            stmt.setString(2, Double.toString(num2));
           
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
            	value = rs.getString("result");
            }
        }
        catch(SQLException e)
        {
            System.out.println((new StringBuilder("SQL exception:")).append(e.getMessage()).toString());
            throw new Exception(e);
        }
        catch(NumberFormatException e)
        {
            System.out.println((new StringBuilder("Number format exception:")).append(e.getMessage()).toString());
            throw new Exception(e);
        }
        finally {
			try
			{
				if (stmt != null)
					stmt.close();
			} catch (SQLException e)
			{
	            System.out.println((new StringBuilder("SQL Exception:")).append(e.getMessage()).toString());
	            throw new Exception(e);
			} finally
			{
				if (con != null) {
					DBConnectionPool.releaseConnection(con);
					DBConnectionPool.clearConnections();
				}
			}        	
        }
        return value;
    }

}
