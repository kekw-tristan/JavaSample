package de.fherfurt.lat.api.resources;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Root resource class for the API.
 * <p>
 * This class serves as the base path for all API endpoints and provides access to sub-resources
 * like {@link AddressResource}, {@link CalendarResource}, and {@link StudioResource}.
 * It also includes a simple endpoint to verify that the API is operational.
 * </p>
 *
 * <p>
 * The base path for this resource is "/api", and the sub-resources are accessible via
 * "/api/address", "/api/calendar", and "/api/studio".
 * </p>
 */
@Path("/api")
public class BaseResource {

    /**
     * A simple endpoint to check if the API is working.
     * <p>
     * This endpoint is accessible to all users and returns a simple "Working" message.
     * It can be used to verify that the API is up and running.
     * </p>
     *
     * @return a string message "Working" indicating that the API is operational.
     */
    @GET
    @PermitAll
    public String info() {
        return "Working";
    }

    /**
     * Provides access to the {@link AddressResource} sub-resource.
     * <p>
     * This method is mapped to the "/api/address" path and returns a new instance of {@link AddressResource}.
     * </p>
     *
     * @return a new instance of {@link AddressResource}.
     */
    @Path("/address")
    public AddressResource getAddressResource() {
        return new AddressResource();
    }

    /**
     * Provides access to the {@link CalendarResource} sub-resource.
     * <p>
     * This method is mapped to the "/api/calendar" path and returns a new instance of {@link CalendarResource}.
     * </p>
     *
     * @return a new instance of {@link CalendarResource}.
     */
    @Path("/calendar")
    public CalendarResource getCalendarResource() {
        return new CalendarResource();
    }

    /**
     * Provides access to the {@link StudioResource} sub-resource.
     * <p>
     * This method is mapped to the "/api/studio" path and returns a new instance of {@link StudioResource}.
     * </p>
     *
     * @return a new instance of {@link StudioResource}.
     */
    @Path("/studio")
    public StudioResource getStudioResource() {
        return new StudioResource();
    }
}