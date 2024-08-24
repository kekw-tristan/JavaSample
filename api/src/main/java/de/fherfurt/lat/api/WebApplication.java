package de.fherfurt.lat.api;

import de.fherfurt.lat.api.resources.BaseResource;
import de.fherfurt.lat.storage.data.core.DatabaseConnection;
import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.crypto.Data;
import java.net.URI;


public class WebApplication {
    public static final String BASE_URI = "http://localhost:8080/";


    /**
     * Method for creating the Jetty Server, and adding Resources
     *
     * @return Jetty Server Instance
     */
    public static Server startServer() {
        final ResourceConfig config = new ResourceConfig();

        config.register(BaseResource.class);

        // ?? was ist mit dem Authenticator config.register(BasicAuthFilter.class);

        Server server = JettyHttpContainerFactory.createServer(URI.create( BASE_URI ), config);

        return server;
    }

    private static boolean ConnectDatabase()
    {

        final int port          = 3306;
        final String host       = "mariadb";
        final String database   = "lat";
        final String username   = "user";
        final String password   = "password";
        final String url        = "jdbc:mariadb://" + host + ":" + port + "/" + database;

        DatabaseConnection db = DatabaseConnection.getInstance();

        return db.connectToDatabase(url, username, password);
    }

    /**
     * Main Method, for building and starting the Jetty Server
     * @param args args
     */
    public static void main(String[] args) {
        Logger LOG = LoggerFactory.getLogger( WebApplication.class );
        System.out.println( "test" );
        DatabaseConnection db = DatabaseConnection.getInstance();
        if(ConnectDatabase())
        {
            System.out.println("Connected to the database");
        }

        try {

            final Server server = startServer();


            Runtime.getRuntime().addShutdownHook( new Thread(() -> {
                try {
                    LOG.info("Shutting down the application...");
                    server.stop();
                    LOG.info("Done, exit.");
                } catch (Exception e) {
                    LOG.error(null, e);
                }
            }));

            LOG.info("Application started. -- Stop the application using CTRL+C\n");

            Thread.currentThread().join();
        } catch (InterruptedException ex) {
            LOG.error(null, ex);
        }
    }

    /**
     * Method to connect to the Database
     *
     */


}
