package de.fherfurt.lat.storage.data.core;

import java.sql.*;

public class DatabaseConnection
{
    private static DatabaseConnection instance;

    private String jdbcUrl;
    private String username;
    private String password;

    private Connection connection;

    private DatabaseConnection()
    {
    }

    public boolean connectToDatabase(String jdbcUrl, String username, String password)
    {
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;

        try
        {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, username, password);

            System.out.println("connected to Database");

            return true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        catch (ClassNotFoundException e)
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

    public static DatabaseConnection getInstance()
    {
        if(instance == null)
        {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}