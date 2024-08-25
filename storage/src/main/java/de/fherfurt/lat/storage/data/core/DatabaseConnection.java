package de.fherfurt.lat.storage.data.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton class for managing the database connection.
 * <p>
 * This class provides methods to connect to and disconnect from a database.
 * It follows the singleton pattern to ensure that only one instance of the connection
 * is created and used throughout the application.
 * </p>
 */
public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;

    /**
     * Private constructor to prevent instantiation from outside the class.
     * <p>
     * The constructor is private to enforce the singleton pattern.
     * </p>
     */
    private DatabaseConnection() {
    }

    /**
     * Connects to the default database using the predefined URL, username, and password.
     * <p>
     * This method uses a hardcoded URL ("jdbc:mariadb://mariadb:3306/lat") to connect to a MariaDB database.
     * </p>
     *
     * @return {@code true} if the connection is successful, {@code false} otherwise.
     */
    public boolean connectToDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:mariadb://mariadb:3306/lat", "user", "password");
            System.out.println("Connected to Database");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Connects to the database using a custom URL.
     * <p>
     * This method allows specifying a custom URL to connect to the database. It uses a hardcoded username
     * and password for authentication.
     * </p>
     *
     * @param url the JDBC URL of the database to connect to.
     * @return {@code true} if the connection is successful, {@code false} otherwise.
     */
    public boolean connectToDatabase(String url) {
        try {
            connection = DriverManager.getConnection(url, "user", "password");
            System.out.println("Connected to Database");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Closes the current database connection.
     * <p>
     * This method closes the connection to the database and prints a confirmation message.
     * It returns {@code true} if the connection is successfully closed, and {@code false} otherwise.
     * </p>
     *
     * @return {@code true} if the connection is successfully closed, {@code false} otherwise.
     */
    public boolean closeDatabaseConnection() {
        try {
            connection.close();
            System.out.println("Database Closed");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Retrieves the current database connection.
     * <p>
     * This method returns the active {@link Connection} object.
     * </p>
     *
     * @return the current {@link Connection} object.
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Provides the singleton instance of the {@link DatabaseConnection} class.
     * <p>
     * If the instance does not exist, it creates a new one. Otherwise, it returns the existing instance.
     * </p>
     *
     * @return the singleton instance of {@link DatabaseConnection}.
     */
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}