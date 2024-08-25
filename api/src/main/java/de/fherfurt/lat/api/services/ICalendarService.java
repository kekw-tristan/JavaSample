package de.fherfurt.lat.api.services;

import de.fherfurt.lat.storage.models.CalendarEntry;

import java.util.List;
import java.util.Optional;

/**
 * Interface for calendar entry service operations.
 * <p>
 * This interface defines the contract for services that manage calendar entry entities.
 * It provides methods to retrieve, add, and delete calendar entries.
 * Implementations of this interface are expected to interact with a data repository
 * to perform CRUD operations on calendar entry data.
 * </p>
 */
public interface ICalendarService {

    /**
     * Retrieves a list of all calendar entries.
     * <p>
     * This method is used to obtain all calendar entry records from the data source.
     * </p>
     *
     * @return a {@link List} of {@link CalendarEntry} objects representing all calendar entries.
     */
    List<CalendarEntry> getCalendarEntries();

    /**
     * Retrieves a specific calendar entry by its ID.
     * <p>
     * This method is used to obtain a calendar entry record by its unique ID.
     * </p>
     *
     * @param id the ID of the calendar entry to retrieve.
     * @return an {@link Optional} containing the {@link CalendarEntry} if found, or an empty {@link Optional} if not found.
     */
    Optional<CalendarEntry> getCalendarEntry(int id);

    /**
     * Adds a new calendar entry.
     * <p>
     * This method is used to create a new calendar entry record in the data source.
     * </p>
     *
     * @param calendarEntry the {@link CalendarEntry} to be added.
     * @return {@code true} if the calendar entry was successfully created, {@code false} otherwise.
     */
    boolean addCalendarEntry(CalendarEntry calendarEntry);

    /**
     * Deletes a specific calendar entry.
     * <p>
     * This method is used to remove a calendar entry record from the data source.
     * </p>
     *
     * @param calendarEntry the {@link CalendarEntry} to be deleted.
     * @return {@code true} if the calendar entry was successfully deleted, {@code false} otherwise.
     */
    boolean deleteCalendarEntry(CalendarEntry calendarEntry);
}