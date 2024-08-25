package de.fherfurt.lat.storage.data.repositories;

import de.fherfurt.lat.storage.Constants;
import de.fherfurt.lat.storage.data.daos.JpaGenericDao;
import de.fherfurt.lat.storage.models.CalendarEntry;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalendarEntryRepositoryTest {
    private static EntityManagerFactory entityManagerFactory;
    private JpaGenericDao<CalendarEntry> entryDao;
    private CalendarEntryRepository entryRepository;

    @BeforeAll
    static void beforeAll() {
        entityManagerFactory = Persistence.createEntityManagerFactory("lat-unit-test");
    }

    @BeforeEach
    void setUp() {
        EntityManager em = entityManagerFactory.createEntityManager();
        entryDao = new JpaGenericDao<>(CalendarEntry.class, em);

        entryRepository = new CalendarEntryRepository(entryDao);
    }

    @AfterEach
    void tearDown() {
        List<CalendarEntry> allAddresses = (List<CalendarEntry>)entryDao.findAll();
        entryDao.delete(allAddresses);

        entryRepository = null;
        entryDao = null;
    }

    @Test
    void testGetCalendarEntries() {
        CalendarEntry firstEntry = Constants.getFirstCalenderEntry();
        CalendarEntry secondEntry = Constants.getSecondCalenderEntry();
        boolean isFirstAdded = entryDao.create(firstEntry);
        boolean isSecondAdded = entryDao.create(secondEntry);

        List<CalendarEntry> resultEntry = entryRepository.getCalendarEntries();

        assertTrue(isFirstAdded);
        assertTrue(isSecondAdded);

        assertEquals(2, resultEntry.size());
        assertTrue(resultEntry.contains(firstEntry));
        assertTrue(resultEntry.contains(secondEntry));
    }

    @Test
    void testGetAddress() {
        CalendarEntry firstEntry = Constants.getFirstCalenderEntry();
        boolean isAdded = entryDao.create(firstEntry);

        CalendarEntry resultEntry = entryRepository.getCalendarEntry(firstEntry.getId());

        assertTrue(isAdded);

        assertEquals(firstEntry, resultEntry);
    }

    @Test
    void testCreateAddress() {
        CalendarEntry entry = Constants.getFirstCalenderEntry();

        int sizeBeforeAdding = entryRepository.getCalendarEntries().size();

        boolean resultIsAdded = entryRepository.createCalendarEntry(entry);

        List<CalendarEntry> allEntries = entryRepository.getCalendarEntries();

        assertEquals(0, sizeBeforeAdding);
        assertTrue(resultIsAdded);

        assertEquals(1, allEntries.size());
        assertTrue(allEntries.contains(entry));
    }

    @Test
    void testDeleteAddress() {
        CalendarEntry entry = Constants.getFirstCalenderEntry();

        int sizeBeforeAdding = entryRepository.getCalendarEntries().size();
        entryRepository.createCalendarEntry(entry);

        int sizeBeforeDeleting = entryRepository.getCalendarEntries().size();

        boolean resultIsDeleted = entryRepository.deleteCalendarEntry(entry);

        assertTrue(resultIsDeleted);

        assertEquals(sizeBeforeAdding + 1, sizeBeforeDeleting);
        assertEquals(sizeBeforeDeleting - 1, entryRepository.getCalendarEntries().size());
    }
}