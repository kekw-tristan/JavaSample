package de.fherfurt.lat.api.services;

import de.fherfurt.lat.storage.models.CalendarEntry;

import java.util.List;
import java.util.Optional;

public interface ICalendarService {
    List<CalendarEntry> getCalendarEntries();
    Optional<CalendarEntry> getCalendarEntry(int id);
    boolean addCalendarEntry(CalendarEntry calendarEntry);
    boolean deleteCalendarEntry(CalendarEntry calendarEntry) ;
}
