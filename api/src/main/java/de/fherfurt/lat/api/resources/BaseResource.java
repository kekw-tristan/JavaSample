package de.fherfurt.lat.api.resources;

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
    public AddressResource getAddressRessource() {
        return new AddressResource();
    }

    @Path("/Studio")
    public StudioRessource getStudioRessource() { return new StudioRessource(); }
}
