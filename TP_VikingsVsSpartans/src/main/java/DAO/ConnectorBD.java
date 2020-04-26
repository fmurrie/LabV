package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorBD
{
    //Properties:
    private static Connection connection = null;
    private static String DB_DRIVER;
    private static String DB_URL;
    private static String DB_NAME;
    private static String DB_USER;
    private static String DB_PASSWORD;

    //Constructors:
    private ConnectorBD()
    {
        try
        {
            BuildConnection("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/", "tp_vikings_vs_spartans", "root", "");
            connection = DriverManager.getConnection(DB_URL+DB_NAME, DB_USER, DB_PASSWORD);

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //Properties getters:
    public static String getDbDriver()
    {
        return DB_DRIVER;
    }

    public static String getDbUrl()
    {
        return DB_URL;
    }

    public static String getDbName()
    {
        return DB_NAME;
    }

    public static String getDbUser()
    {
        return DB_USER;
    }

    public static String getDbPassword()
    {
        return DB_PASSWORD;
    }

    //Methods:
    public static void BuildConnection(String dbDriver,String dbUrl,String dbName,String dbUser,String dbPassword)
    {
        DB_DRIVER=dbDriver;
        DB_URL=dbUrl;
        DB_NAME=dbName;
        DB_USER=dbUser;
        DB_PASSWORD=dbPassword;
    }

    public static Connection OpenConnection() throws SQLException
    {
        if (connection == null){
            new ConnectorBD();
        }

        return connection;
    }

    public static void CloseConnection()
    {
        try
        {
            if((connection!=null)&&(!connection.isClosed()))
            {
                connection.close();
                connection=null;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
