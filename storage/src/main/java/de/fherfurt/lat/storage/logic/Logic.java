package de.fherfurt.lat.storage.logic;

import de.fherfurt.lat.storage.data.core.DatabaseConnection;

public class Logic
{
    private DatabaseConnection db;

    private String host = "mariadb";
    private String database = "javaprojekt";
    private int port = 3306;
    private String username = "user";
    private String password = "password";

    String url = buildUrl("mariadb", host, port, database);

    public void init()
    {

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

    private String buildUrl(String connectorName, String host, int port, String database) {
        return new StringBuilder()
                .append("jdbc:")
                .append(connectorName)
                .append("://")
                .append(host)
                .append(":")
                .append(port)
                .append("/")
                .append(database)
                .toString();
    }

}
