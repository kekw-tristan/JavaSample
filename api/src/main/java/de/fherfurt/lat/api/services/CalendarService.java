package de.fherfurt.lat.api.services;

import de.fherfurt.lat.storage.data.core.DataController;
import de.fherfurt.lat.storage.data.repositories.ICalendarEntryRepository;
import de.fherfurt.lat.storage.models.CalendarEntry;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing calendar entries.
 * <p>
 * This class implements the {@link ICalendarService} interface and provides methods to
 * retrieve, add, and delete calendar entries. It interacts with the {@link ICalendarEntryRepository}
 * to perform CRUD operations on calendar entry data.
 * </p>
 *
 * <p>
 * The service can be initialized with a default repository obtained from the
 * {@link DataController} or with a custom repository instance.
 * </p>
 */
public class CalendarService implements ICalendarService {

    private final ICalendarEntryRepository calendarEntryRepository;

    /**
     * Constructs a new {@code CalendarService} using the default calendar entry repository
     * from the {@link DataController}.
     */
    public CalendarService() {
        this(DataController
                .getInstance()
                .getCalendarEntryRepository());
    }

    /**
     * Constructs a new {@code CalendarService} with a specified calendar entry repository.
     *
     * @param calendarEntryRepository the {@link ICalendarEntryRepository} to be used for calendar entry operations.
     */
    public CalendarService(ICalendarEntryRepository calendarEntryRepository) {
        this.calendarEntryRepository = calendarEntryRepository;
    }

    /**
     * Retrieves a list of all calendar entries.
     * <p>
     * This method calls the repository's method to get all calendar entries and returns them as a list.
     * </p>
     *
     * @return a list of {@link CalendarEntry} objects representing all calendar entries.
     */
    @Override
    public List<CalendarEntry> getCalendarEntries() {
        return calendarEntryRepository.getCalendarEntries();
    }

    /**
     * Retrieves a specific calendar entry by its ID.
     * <p>
     * This method calls the repository's method to get a calendar entry by its ID and wraps it in an {@link Optional}.
     * </p>
     *
     * @param id the ID of the calendar entry to retrieve.
     * @return an {@link Optional} containing the {@link CalendarEntry} if found, or an empty {@link Optional} if not found.
     */
    @Override
    public Optional<CalendarEntry> getCalendarEntry(int id) {
        return Optional.ofNullable(calendarEntryRepository.getCalendarEntry(id));
    }

    /**
     * Adds a new calendar entry.
     * <p>
     * This method calls the repository's method to create a new calendar entry and returns a boolean indicating success or failure.
     * </p>
     *
     * @param calendarEntry the {@link CalendarEntry} to be added.
     * @return {@code true} if the calendar entry was successfully created, {@code false} otherwise.
     */
    @Override
    public boolean addCalendarEntry(CalendarEntry calendarEntry) {
        return calendarEntryRepository.createCalendarEntry(calendarEntry);
    }

    /**
     * Deletes a specific calendar entry.
     * <p>
     * This method calls the repository's method to delete a calendar entry and returns a boolean indicating success or failure.
     * </p>
     *
     * @param calendarEntry the {@link CalendarEntry} to be deleted.
     * @return {@code true} if the calendar entry was successfully deleted, {@code false} otherwise.
     */
    @Override
    public boolean deleteCalendarEntry(CalendarEntry calendarEntry) {
        return calendarEntryRepository.deleteCalendarEntry(calendarEntry);
    }
}