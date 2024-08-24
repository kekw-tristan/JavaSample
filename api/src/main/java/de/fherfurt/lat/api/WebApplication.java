package de.fherfurt.lat.api;

import de.fherfurt.lat.api.resources.AddressResource;
import de.fherfurt.lat.api.resources.BaseResource;
import de.fherfurt.lat.storage.data.core.DataController;
import de.fherfurt.lat.storage.data.core.DatabaseConnection;
import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    /**
     * Main Method, for building and starting the Jetty Server
     * @param args args
     */
    public static void main(String[] args) {
        Logger LOG = LoggerFactory.getLogger( WebApplication.class );
        System.out.println( "test" );

        DatabaseConnection db = DatabaseConnection.getInstance();
        db.connectToDatabase();

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
        DataController.getInstance();
    }

}
