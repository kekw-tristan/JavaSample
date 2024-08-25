package de.fherfurt.lat.storage.data.repositories;

import de.fherfurt.lat.storage.data.daos.IGenericDao;
import de.fherfurt.lat.storage.models.CalendarEntry;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class CalendarEntryRepository implements ICalendarEntryRepository {

    private final IGenericDao<CalendarEntry> calendarEntryDao;


    @Override
    public List<CalendarEntry> getCalendarEntries() {
        return new ArrayList<>(calendarEntryDao.findAll());
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
