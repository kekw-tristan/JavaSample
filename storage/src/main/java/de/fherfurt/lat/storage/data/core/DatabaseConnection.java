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
            connection = DriverManager.getConnection(jdbcUrl, username, password);

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