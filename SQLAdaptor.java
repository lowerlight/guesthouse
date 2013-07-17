/**************************************************************************************************/
//
//  Project : Kalong Bay Guesthouse Reservation and Logistic System
//  Filename : SQLAdaptor.java
//  Author : Jeffrey Nursalim
//  Student No: TP031319
//  Module Code & Title: CE00204-7 Object-Oriented Software Systems Engineering
//  Due Date : 15 July 2013
//
/**************************************************************************************************/
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import java.sql.*;

import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.math.BigDecimal;



public class SQLAdaptor
{
    private final static String jdbcDriver = "com.mysql.jdbc.Driver";
    private final static String url = "jdbc:mysql://localhost:3306/kalongbaydb";
    private final static String user = "javauser";
    private final static String pswd = "apiit";
    private static Connection conn = null;

    public static ArrayList query(String sql, Object... param)
    {
        ArrayList result = null;
        System.out.println(sql);

        try
        {
            //Load JDBC driver and register it first
            DbUtils.loadDriver(jdbcDriver);
            Class.forName(jdbcDriver).newInstance();
        }
        catch(Exception e)
        {
            Logger lgr = Logger.getLogger(SQLAdaptor.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
        }

        try
        {
            //Create connection to the database
            conn = DriverManager.getConnection(url, user, pswd);

            //Prepare the runner and execute the query
            QueryRunner qRunner = new QueryRunner();
            result = (ArrayList) qRunner.query(conn, sql, new ArrayListHandler(), param);
        }
        catch(SQLException ex)
        {
            Logger lgr = Logger.getLogger(SQLAdaptor.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        finally
        {
            try
            {
                DbUtils.close(conn);
            }
            catch(SQLException ex)
            {
                Logger lgr = Logger.getLogger(SQLAdaptor.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        return result;
    }

    public static int update(String sql, Object... param)
    {
        int status=0;
        System.out.println(sql);

        try
        {
            //Load JDBC driver and register it first
            DbUtils.loadDriver(jdbcDriver);
            Class.forName(jdbcDriver).newInstance();
        }
        catch(Exception e)
        {
            Logger lgr = Logger.getLogger(SQLAdaptor.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
        }

        try
        {
            //Create connection to the database
            conn = DriverManager.getConnection(url, user, pswd);

            //Prepare the runner and execute the update
            QueryRunner qRunner = new QueryRunner();
            status = qRunner.update(conn, sql, param);
        }
        catch(SQLException ex)
        {
            Logger lgr = Logger.getLogger(SQLAdaptor.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        finally
        {
            try
            {
                DbUtils.close(conn);
            }
            catch(SQLException ex)
            {
                Logger lgr = Logger.getLogger(SQLAdaptor.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        return status;
    }
}