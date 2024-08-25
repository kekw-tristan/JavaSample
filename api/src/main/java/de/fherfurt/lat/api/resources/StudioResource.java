package de.fherfurt.lat.api.resources;

import de.fherfurt.lat.api.mapping.Mapper;
import de.fherfurt.lat.api.models.StudioDto;
import de.fherfurt.lat.api.services.StudioService;
import de.fherfurt.lat.api.services.IStudioService;
import de.fherfurt.lat.storage.models.Address;
import de.fherfurt.lat.storage.models.Studio;


import javax.ws.rs.*;
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
    public Response getStudio(@PathParam("studioId") int studioId) {
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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<StudioDto> getStudios() {
        return this.studioService
                .getAllStudios()
                .stream()
                .map(Mapper::studioToDto)
                .toList();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createStudio(
            StudioDto studioDto
    ) {
        Studio studio = Mapper.dtoToStudio(studioDto);

        // Call service to create address
        boolean isAdded = this.studioService.addStudio(studio);

        if(isAdded) {
            return Response
                    .status(Response.Status.CREATED)
                    .build();
        } else {
            return Response
                    .status(Response.Status.NOT_MODIFIED)
                    .build();
        }

        // Return response with created address and a status code of 201 (Created)

    }

    /*
    @PUT
    @Path("{studioId:\\d+}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateStudio(
            @PathParam("studioId") int studioId
    ) {

        Studio studioUpdates = null;
        try {
            studioUpdates = Mapper.newPersonDtoToPerson(personToUpdate, owner.get());
        } catch (MappingException me) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(me.getMessage())
                    .build();
        }

        studioUpdates.setId(studioId);

        boolean success = this.studioService.updateStudio( studioUpdates );

        if( success ) {
            return Response
                    .ok(Mapper.studioToDto(studioUpdates))
                    .build();
        } else {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .build();
        }
    }*/

    @DELETE
    @Path("{studioId:\\d+}")
    public Response deleteStudio(
            @PathParam("studioId") int studioId
    ) {
        boolean success = this.studioService.deleteStudio( studioId );

        if( success ) {
            return Response
                    .ok()
                    .build();
        }
        else {
            return Response
                    .status( Response.Status.NOT_FOUND )
                    .build();
        }
    }
}