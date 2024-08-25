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

/**
 * Main entry point for starting the web application.
 * <p>
 * This class configures and starts a Jetty server with Jersey as the JAX-RS implementation.
 * It sets up the base URI, registers the resources, and manages the server lifecycle.
 * </p>
 */
public class WebApplication {

    /**
     * The base URI for the web application.
     * <p>
     * This URI is used by the Jetty server to listen for incoming HTTP requests.
     * </p>
     */
    public static final String BASE_URI = "http://localhost:8080/";

    /**
     * Creates and starts the Jetty server with the registered resources.
     * <p>
     * This method configures the Jetty server, registers the {@link BaseResource} class,
     * and initializes the server with the specified base URI.
     * </p>
     *
     * @return the {@link Server} instance representing the running Jetty server.
     */
    public static Server startServer() {
        final ResourceConfig config = new ResourceConfig();

        // Register resources for the web application
        config.register(BaseResource.class);

        // Uncomment to enable Basic Authentication filter
        // config.register(BasicAuthFilter.class);

        // Create and start the Jetty server with the specified base URI and configuration
        Server server = JettyHttpContainerFactory.createServer(URI.create(BASE_URI), config);

        return server;
    }

    /**
     * Main method to build and start the Jetty server.
     * <p>
     * This method initializes the database connection, starts the server, and sets up a shutdown hook
     * to gracefully stop the server when the application is terminated.
     * </p>
     *
     * @param args command-line arguments (not used).
     */
    public static void main(String[] args) {
        Logger LOG = LoggerFactory.getLogger(WebApplication.class);
        System.out.println("test");

        // Initialize and connect to the database
        DatabaseConnection db = DatabaseConnection.getInstance();
        db.connectToDatabase();

        try {
            // Start the Jetty server
            final Server server = startServer();

            // Add shutdown hook to stop the server gracefully
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    LOG.info("Shutting down the application...");
                    server.stop();
                    LOG.info("Done, exit.");
                } catch (Exception e) {
                    LOG.error("Error occurred during shutdown", e);
                }
            }));

            LOG.info("Application started. -- Stop the application using CTRL+C\n");

            // Keep the main thread alive to keep the server running
            Thread.currentThread().join();
        } catch (InterruptedException ex) {
            LOG.error("Application interrupted", ex);
        }

        // Initialize DataController to ensure it is available
        DataController.getInstance();
    }
}