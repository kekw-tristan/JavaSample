package de.fherfurt.lat.api.data.repositories;

import de.fherfurt.lat.storage.data.repositories.ICalendarEntryRepository;
import de.fherfurt.lat.storage.models.CalendarEntry;
import de.fherfurt.lat.storage.models.Studio;
import de.fherfurt.lat.storage.models.Address;

import java.util.List;
import java.util.ArrayList;

public class MockCalendarEntryRepository implements ICalendarEntryRepository {
    public static final CalendarEntry firstEntry = new CalendarEntry(
            0,
            "2024-08-25",
            "2024-09-01",
            "Hans",
            "Peter",
            "hans@gmail.com"
    );

    public static final CalendarEntry secondEntry = new CalendarEntry(
            2,
            "2024-09-25",
            "2024-10-01",
            "Petra",
            "Müller",
            "petra@gmail.com"
    );

    public static List<CalendarEntry> entries = new ArrayList<>();

    private static void resetStudiosList() {
        entries = new ArrayList<>();
        entries.add(firstEntry);
        entries.add(secondEntry);
    }

    public MockCalendarEntryRepository() { resetStudiosList(); }
    @Override
    public List<CalendarEntry> getCalendarEntries() {
        return new ArrayList<>(entries);
    }

    @Override
    public CalendarEntry getCalendarEntry(int id) {
        if (id < 0 || id >= entries.size()) {
            return null;
        } else {
            return entries.get(id);
        }
    }

    @Override
    public boolean createCalendarEntry(CalendarEntry calendarEntry) {
        entries.add(calendarEntry);
        return true;
    }

    @Override
    public boolean deleteCalendarEntry(CalendarEntry calendarEntry) {
        CalendarEntry foundEntry = getCalendarEntry(calendarEntry.getId());
        if (foundEntry != null) {
            entries.remove(foundEntry.getId());
            return true;
        } else {
            return false;
        }
    }
}
