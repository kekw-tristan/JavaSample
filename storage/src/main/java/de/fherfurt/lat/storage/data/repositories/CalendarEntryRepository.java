package de.fherfurt.lat.storage.data.repositories;

import de.fherfurt.lat.storage.data.daos.IGenericDao;
import de.fherfurt.lat.storage.models.CalendarEntry;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository class for managing {@link CalendarEntry} entities.
 * <p>
 * This class implements the {@link ICalendarEntryRepository} interface and provides methods
 * to perform CRUD operations on {@link CalendarEntry} entities using a data access object (DAO).
 * </p>
 */
@AllArgsConstructor
public class CalendarEntryRepository implements ICalendarEntryRepository {

    private final IGenericDao<CalendarEntry> calendarEntryDao;

    /**
     * Retrieves all calendar entries from the data store.
     *
     * @return a list of all calendar entries.
     */
    @Override
    public List<CalendarEntry> getCalendarEntries() {
        return new ArrayList<>(calendarEntryDao.findAll());
    }

    /**
     * Retrieves a specific calendar entry by its unique identifier.
     *
     * @param id the unique identifier of the calendar entry.
     * @return the calendar entry with the specified id, or {@code null} if not found.
     */
    @Override
    public CalendarEntry getCalendarEntry(int id) {
        return calendarEntryDao.findById(id);
    }

    /**
     * Creates a new calendar entry in the data store.
     *
     * @param calendarEntry the calendar entry to be created.
     * @return {@code true} if the calendar entry was created successfully, {@code false} otherwise.
     */
    @Override
    public boolean createCalendarEntry(CalendarEntry calendarEntry) {
        return calendarEntryDao.create(calendarEntry);
    }

    /**
     * Deletes a calendar entry from the data store.
     *
     * @param calendarEntry the calendar entry to be deleted.
     * @return {@code true} if the calendar entry was deleted successfully, {@code false} otherwise.
     */
    @Override
    public boolean deleteCalendarEntry(CalendarEntry calendarEntry) {
        return calendarEntryDao.delete(calendarEntry);
    }
}