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

public class CalendarResource {
    private final ICalendarService calendarService;

    public CalendarResource() {
        this.calendarService = new CalendarService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CalendarEntryDto> getCalendarEntries()
    {
        return this.calendarService.
                getCalendarEntries()
                .stream()
                .map(Mapper::calendarEntryToDto)
                .toList();
    }

    @GET
    @Path("{entryId:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEntry(@PathParam("entryId") int entryId) {
        Optional<CalendarEntry> entry = this.calendarService.getCalendarEntry((entryId));

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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createEntry(CalendarEntryDto entryDto,  @Context HttpHeaders headers) {

        CalendarEntry entry = Mapper.dtoToCalendarEntry(entryDto);

        // Call service to create entry
        boolean isAdded = this.calendarService.addCalendarEntry(entry);

        if(isAdded) {
            return Response
                    .status(Response.Status.CREATED)
                    .build();
        } else {
            return Response
                    .status(Response.Status.NOT_MODIFIED)
                    .build();
        }

        // Return response with created entry and a status code of 201 (Created)

    }
}
