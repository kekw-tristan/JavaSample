package de.fherfurt.lat.storage.data.repositories;

import de.fherfurt.lat.storage.models.CalendarEntry;

import java.util.List;

public interface ICalendarEntryRepository {
    List<CalendarEntry> getCalendarEntries();
    CalendarEntry getCalendarEntry(int id);
    boolean createCalendarEntry(CalendarEntry calendarEntry);
    boolean deleteCalendarEntry(CalendarEntry calendarEntry);
}
