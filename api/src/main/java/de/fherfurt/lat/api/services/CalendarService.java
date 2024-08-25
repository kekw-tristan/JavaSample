package de.fherfurt.lat.api.services;

import de.fherfurt.lat.storage.data.core.DataController;
import de.fherfurt.lat.storage.data.repositories.ICalendarEntryRepository;
import de.fherfurt.lat.storage.models.CalendarEntry;

import java.util.List;
import java.util.Optional;

public class CalendarService implements ICalendarService {

    private final ICalendarEntryRepository calendarEntryRepository;

    public CalendarService(){
        this(DataController
                .getInstance()
                .getCalendarEntryRepository());
    }

    public CalendarService(ICalendarEntryRepository calendarEntryRepository) {
        this.calendarEntryRepository = calendarEntryRepository;
    }

    @Override
    public List<CalendarEntry> getCalendarEntries() {
        return calendarEntryRepository.getCalendarEntries();
    }

    // todo
    @Override
    public List<CalendarEntry> getCalendarEntriesOfMonth(int month) {
        return List.of();
    }

    @Override
    public Optional<CalendarEntry> getCalendarEntry(int id) {
        return Optional.ofNullable(calendarEntryRepository.getCalendarEntry(id));
    }


    @Override
    public boolean addCalendarEntry(CalendarEntry calendarEntry) {
        return false;
    }

    @Override
    public boolean deleteCalendarEntry(int id) {
        return false;
    }
}
