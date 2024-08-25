package de.fherfurt.lat.api.resources;

import de.fherfurt.lat.api.mapping.Mapper;
import de.fherfurt.lat.api.models.CalendarEntryDto;
import de.fherfurt.lat.api.services.CalendarService;
import de.fherfurt.lat.api.services.ICalendarService;
import de.fherfurt.lat.storage.models.CalendarEntry;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

/**
 * RESTful resource class for managing calendar entries.
 * <p>
 * This resource provides endpoints to retrieve, create, and manage calendar entries.
 * It interacts with the {@link ICalendarService} to perform CRUD operations on calendar entries,
 * and uses the {@link Mapper} to convert between entities and data transfer objects (DTOs).
 * </p>
 *
 * <p>
 * The following HTTP methods are supported:
 * </p>
 * <ul>
 *     <li>GET - Retrieve all calendar entries or a specific entry by ID</li>
 *     <li>POST - Create a new calendar entry</li>
 * </ul>
 *
 * @see ICalendarService
 * @see Mapper
 * @see CalendarService
 * @see CalendarEntryDto
 */
public class CalendarResource {
    private final ICalendarService calendarService;

    /**
     * Constructs a new {@code CalendarResource} and initializes the calendar service.
     * <p>
     * The {@link CalendarService} is used as the implementation of {@link ICalendarService}.
     * </p>
     */
    public CalendarResource() {
        this.calendarService = new CalendarService();
    }

    /**
     * Retrieves a list of all calendar entries.
     * <p>
     * This method maps the {@link CalendarEntry} entities to {@link CalendarEntryDto} objects and returns them as a JSON list.
     * </p>
     *
     * @return a list of {@link CalendarEntryDto} objects representing all calendar entries.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CalendarEntryDto> getCalendarEntries() {
        return this.calendarService
                .getCalendarEntries()
                .stream()
                .map(Mapper::calendarEntryToDto)
                .toList();
    }

    /**
     * Retrieves a specific calendar entry by its ID.
     * <p>
     * If the calendar entry with the specified ID is found, it is returned as a JSON response.
     * If not found, a 404 (Not Found) status is returned.
     * </p>
     *
     * @param entryId the ID of the calendar entry to retrieve.
     * @return a {@link Response} containing the {@link CalendarEntryDto} if found, or a 404 status if not found.
     */
    @GET
    @Path("{entryId:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEntry(@PathParam("entryId") int entryId) {
        Optional<CalendarEntry> entry = this.calendarService.getCalendarEntry(entryId);

        if (entry.isPresent()) {
            return Response
                    .ok(Mapper.calendarEntryToDto(entry.get()))
                    .build();
        } else {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }
    }

    /**
     * Creates a new calendar entry.
     * <p>
     * This method accepts a {@link CalendarEntryDto} in the request body, converts it to a {@link CalendarEntry} entity,
     * and attempts to save it using the calendar service. If the calendar entry is successfully created, a 201 (Created)
     * status is returned. If the creation fails, a 304 (Not Modified) status is returned.
     * </p>
     *
     * @param entryDto the {@link CalendarEntryDto} representing the calendar entry to be created.
     * @param headers the HTTP headers of the request (optional, used for additional context if needed).
     * @return a {@link Response} indicating the outcome of the create operation.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createEntry(CalendarEntryDto entryDto, @Context HttpHeaders headers) {
        CalendarEntry entry = Mapper.dtoToCalendarEntry(entryDto);

        // Call service to create entry
        boolean isAdded = this.calendarService.addCalendarEntry(entry);

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
}