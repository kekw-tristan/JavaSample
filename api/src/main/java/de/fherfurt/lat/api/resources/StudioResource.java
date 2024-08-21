package de.fherfurt.lat.api.resources;

import de.fherfurt.lat.api.mapping.Mapper;
import de.fherfurt.lat.api.models.StudioDto;
import de.fherfurt.lat.api.services.AddressService;
import de.fherfurt.lat.api.services.IAddressService;
import de.fherfurt.lat.api.services.StudioService;
import de.fherfurt.lat.api.services.IStudioService;
import de.fherfurt.lat.storage.models.Address;
import de.fherfurt.lat.storage.models.Studio;

import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

public class StudioResource {
    private final IStudioService studioService;

    public StudioResource() { this.studioService = new StudioService(); }

    @GET
    @Path("{studioId:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAddress(@PathParam("studioId") int studioId) {
        Optional<Studio> studio = this.studioService.getStudioById((studioId));

        if (studio.isPresent()) {
            return Response
                    .ok(Mapper.studioToDto(studio.get()))
                    .build();
        } else {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }
    }
}