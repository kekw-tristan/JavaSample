package de.fherfurt.lat.api.data.repositories;

import de.fherfurt.lat.storage.data.repositories.ICalendarEntryRepository;
import de.fherfurt.lat.storage.models.CalendarEntry;
import de.fherfurt.lat.storage.models.Studio;
import de.fherfurt.lat.storage.models.Address;

import java.util.List;
import java.util.ArrayList;

public class MockCalendarEntryRepository implements ICalendarEntryRepository {

    public static List<CalendarEntry> entries = new ArrayList<>();

    private static void resetStudiosList() {
        entries = new ArrayList<>();
        entries.add(firstEntry);
        entries.add(secondEntry);
    }

    public MockCalendarEntryRepository() { resetStudiosList(); }
    @Override
    public List<CalendarEntry> getCalendarEntries() {
        return new );
    }

    @Override
    public CalendarEntry getCalendarEntry(int id) {
        return calendarEntryDao.findById(id);
    }

    @Override
    public boolean createCalendarEntry(CalendarEntry calendarEntry) {
        return calendarEntryDao.create(calendarEntry);
    }

    @Override
    public boolean deleteCalendarEntry(CalendarEntry calendarEntry) {
        return calendarEntryDao.delete(calendarEntry);
    }
}
