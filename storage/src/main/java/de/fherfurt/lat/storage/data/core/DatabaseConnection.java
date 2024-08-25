package de.fherfurt.lat.storage.data.core;

import java.sql.*;

public class DatabaseConnection
{
    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection()
    {
    }

    public boolean connectToDatabase()
    {
        try
        {

            connection = DriverManager.getConnection("jdbc:mariadb://mariadb:3306/lat", "user", "password");
            System.out.println("connected to Database");
            return true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }

    }

    public boolean connectToDatabase(String url)
    {
        try
        {

            connection = DriverManager.getConnection(url, "user", "password");
            System.out.println("connected to Database");
            return true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }

    }

    public boolean closeDatabaseConnection()
    {
        try
        {
            connection.close();
            System.out.println("Database Closed");
            return true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public Connection getConnection()
    {
        return connection;
    }

    public static DatabaseConnection getInstance()
    {
        if(instance == null)
        {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}