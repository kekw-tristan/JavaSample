package de.fherfurt.lat.storage.logic;

import de.fherfurt.lat.storage.data.core.DatabaseConnection;

public class Logic
{

    // Database members
    private DatabaseConnection db;

    public void init()
    {
        ConnectDatabase();
    }

    public void run()
    {
    }

    public void fin()
    {
        if(!db.closeDatabaseConnection())
            System.out.println("Could not close Database!");
    }

    private void ConnectDatabase()
    {
        final int port          = 3306;
        final String host       = "localhost";
        final String database   = "javaprojekt";
        final String username   = "user";
        final String password   = "password";
        final String url        = "jdbc:mariadb://" + host + ":" + port + "/" + database;

        db = DatabaseConnection.getInstance();

        if(!db.connectToDatabase(url, username, password))
            System.out.println("Connection to Database failed!");

    }
}
