package de.fherfurt.lat.api.resources;

import de.fherfurt.lat.storage.data.repositories.CalendarEntryRepository;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/api")
public class BaseResource {

    @GET
    @PermitAll
    public String info() {
        return "Working";
    }

    @Path("/address")
    public AddressResource getAddressResource() {
        return new AddressResource();
    }

    @Path("/calendar")
    public CalendarResource getCalendarResource() { return new CalendarResource(); }

    @Path("/Studio")
    public StudioResource getStudioRessource() { return new StudioResource(); }
}
