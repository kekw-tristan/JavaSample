package de.fherfurt.lat.api.resources;

import de.fherfurt.lat.api.mapping.Mapper;
import de.fherfurt.lat.api.models.StudioDto;
import de.fherfurt.lat.api.services.StudioService;
import de.fherfurt.lat.api.services.IStudioService;
import de.fherfurt.lat.storage.models.Studio;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

/**
 * RESTful resource class for managing studio entities.
 * <p>
 * This resource provides endpoints to retrieve, create, and delete studio entities.
 * It interacts with the {@link IStudioService} to perform operations on studio entities
 * and uses the {@link Mapper} to convert between entities and data transfer objects (DTOs).
 * </p>
 *
 * <p>
 * The following HTTP methods are supported:
 * </p>
 * <ul>
 *     <li>GET - Retrieve all studios or a specific studio by ID</li>
 *     <li>POST - Create a new studio</li>
 *     <li>DELETE - Remove a studio by ID</li>
 * </ul>
 *
 * @see IStudioService
 * @see Mapper
 * @see StudioService
 * @see StudioDto
 */
public class StudioResource {
    private final IStudioService studioService;

    /**
     * Constructs a new {@code StudioResource} and initializes the studio service.
     * <p>
     * The {@link StudioService} is used as the implementation of {@link IStudioService}.
     * </p>
     */
    public StudioResource() {
        this.studioService = new StudioService();
    }

    /**
     * Retrieves a specific studio by its ID.
     * <p>
     * If the studio with the specified ID is found, it is returned as a JSON response.
     * If not found, a 404 (Not Found) status is returned.
     * </p>
     *
     * @param studioId the ID of the studio to retrieve.
     * @return a {@link Response} containing the {@link StudioDto} if found, or a 404 status if not found.
     */
    @GET
    @Path("{studioId:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudio(@PathParam("studioId") int studioId) {
        Optional<Studio> studio = this.studioService.getStudioById(studioId);

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

    /**
     * Retrieves a list of all studios.
     * <p>
     * This method maps the {@link Studio} entities to {@link StudioDto} objects and returns them as a JSON list.
     * </p>
     *
     * @return a list of {@link StudioDto} objects representing all studios.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<StudioDto> getStudios() {
        return this.studioService
                .getAllStudios()
                .stream()
                .map(Mapper::studioToDto)
                .toList();
    }

    /**
     * Creates a new studio.
     * <p>
     * This method accepts a {@link StudioDto} in the request body, converts it to a {@link Studio} entity,
     * and attempts to save it using the studio service. If the studio is successfully created, a 201 (Created)
     * status is returned. If the creation fails, a 304 (Not Modified) status is returned.
     * </p>
     *
     * @param studioDto the {@link StudioDto} representing the studio to be created.
     * @return a {@link Response} indicating the outcome of the create operation.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createStudio(StudioDto studioDto) {
        Studio studio = Mapper.dtoToStudio(studioDto);

        // Call service to create studio
        boolean isAdded = this.studioService.addStudio(studio);

        if (isAdded) {
            return Response
                    .status(Response.Status.CREATED)
                    .build();
        } else {
            return Response
                    .status(Response.Status.NOT_MODIFIED)
                    .build();
        }
    }

    /**
     * Deletes a specific studio by its ID.
     * <p>
     * If the studio with the specified ID is found and successfully deleted, a 200 (OK) status is returned.
     * If the studio is not found, a 404 (Not Found) status is returned.
     * </p>
     *
     * @param studioId the ID of the studio to delete.
     * @return a {@link Response} indicating the outcome of the delete operation.
     */
    @DELETE
    @Path("{studioId:\\d+}")
    public Response deleteStudio(@PathParam("studioId") int studioId) {
        boolean success = this.studioService.deleteStudio(studioId);

        if (success) {
            return Response
                    .ok()
                    .build();
        } else {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }
    }
}