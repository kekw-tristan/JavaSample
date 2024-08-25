package de.fherfurt.lat.api.services;

import de.fherfurt.lat.api.data.repositories.MockCalendarEntryRepository;
import de.fherfurt.lat.storage.data.repositories.ICalendarEntryRepository;
import de.fherfurt.lat.storage.models.CalendarEntry;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class CalenderServiceTest {
    private ICalendarEntryRepository mockCalendarEntryRepository;
    private CalendarService calendarService;

    @BeforeEach
    void setUp() {
        mockCalendarEntryRepository = new MockCalendarEntryRepository();
        calendarService = new CalendarService(mockCalendarEntryRepository);
    }

    @AfterEach
    void tearDown() {
        mockCalendarEntryRepository = null;
        calendarService = null;
    }

    @Test
    void testGetCalendarEntries() {
        List<CalendarEntry> calendarEntries = calendarService.getCalendarEntries();

        assertNotNull(calendarEntries);
        assertEquals(2, calendarEntries.size());
    }

    @Test
    void testGetCalendarEntry() {
        int validStudioId = 0;
        int invalidStudioId = 5;

        Optional<CalendarEntry> foundValidEntry = calendarService.getCalendarEntry(validStudioId);
        Optional<CalendarEntry> foundInvalidEntry = calendarService.getCalendarEntry(invalidStudioId);

        assertTrue(foundValidEntry.isPresent());
        assertFalse(foundInvalidEntry.isPresent());

        assertEquals(MockCalendarEntryRepository.firstEntry, foundValidEntry.get());
    }

    @Test
    void testAddCalendarEntry() {
        CalendarEntry newEntry = getTestEntry();

        int entryAmountBefore = calendarService.getCalendarEntries().size();

        // Act
        boolean resultStudioAdded = calendarService.addCalendarEntry(newEntry);

        // Assert
        assertTrue(resultStudioAdded);
        assertEquals(entryAmountBefore + 1, MockCalendarEntryRepository.entries.size());
        assertTrue(MockCalendarEntryRepository.entries.contains(newEntry));
    }

    @Test
    void testDeleteCalendarEntry() {
        CalendarEntry newEntry = getTestEntry();

        int AmountBeforeAdding = MockCalendarEntryRepository.entries.size();
        calendarService.addCalendarEntry(newEntry);

        int AmountBeforeDeleting = MockCalendarEntryRepository.entries.size();

        // Act
        boolean resultEntryRemoved = calendarService.deleteCalendarEntry(newEntry);

        // Assert
        assertTrue(resultEntryRemoved);
        assertEquals(AmountBeforeAdding + 1, AmountBeforeDeleting);
        assertEquals(AmountBeforeDeleting - 1, MockCalendarEntryRepository.entries.size());
    }

    private CalendarEntry getTestEntry() {
        return new CalendarEntry(
                2,
                "2024-08-20",
                "2024-09-02",
                "Reiner",
                "Baum",
                "Reiner@gmail.com"
        );
    }
}