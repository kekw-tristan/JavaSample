package de.fherfurt.lat.storage.logic;

import de.fherfurt.lat.storage.data.core.DatabaseConnection;

public class Logic
{
    private DatabaseConnection db;

    private String host = "localhost";
    private String database = "javaprojekt";
    private int port = 3306;
    private String username = "user";
    private String password = "password";

    String url = buildUrl(host, port, database);

    public void init()
    {
        ConnectDatabase();
    }

    public void run()
    {

    }

    public void fin()
    {
        db.closeDatabaseConnection();
    }

    private void ConnectDatabase()
    {

        db = DatabaseConnection.getInstance();
        db.connectToDatabase(url, username, password);
    }

    private String buildUrl(String host, int port, String database) {
        return "jdbc:" +
                "mariadb" +
                "://" +
                host +
                ":" +
                port +
                "/" +
                database;
    }

}
