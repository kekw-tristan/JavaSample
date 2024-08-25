package de.fherfurt.lat.storage.data.repositories;

import de.fherfurt.lat.storage.models.CalendarEntry;

import java.util.List;

/**
 * Repository interface for managing {@link CalendarEntry} entities.
 * <p>
 * This interface defines methods for performing CRUD (Create, Read, Update, Delete) operations
 * on {@link CalendarEntry} entities. Implementations of this interface are responsible for
 * interacting with the underlying data store.
 * </p>
 */
public interface ICalendarEntryRepository {

    /**
     * Retrieves all calendar entries from the data store.
     *
     * @return a list of all calendar entries.
     */
    List<CalendarEntry> getCalendarEntries();

    /**
     * Retrieves a specific calendar entry by its unique identifier.
     *
     * @param id the unique identifier of the calendar entry.
     * @return the calendar entry with the specified id, or {@code null} if not found.
     */
    CalendarEntry getCalendarEntry(int id);

    /**
     * Creates a new calendar entry in the data store.
     *
     * @param calendarEntry the calendar entry to be created.
     * @return {@code true} if the calendar entry was created successfully, {@code false} otherwise.
     */
    boolean createCalendarEntry(CalendarEntry calendarEntry);

    /**
     * Deletes a calendar entry from the data store.
     *
     * @param calendarEntry the calendar entry to be deleted.
     * @return {@code true} if the calendar entry was deleted successfully, {@code false} otherwise.
     */
    boolean deleteCalendarEntry(CalendarEntry calendarEntry);
}