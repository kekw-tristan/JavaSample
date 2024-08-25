package de.fherfurt.lat.storage.data.repositories;

import de.fherfurt.lat.storage.models.Studio;
import de.fherfurt.lat.storage.data.daos.JpaGenericDao;
import de.fherfurt.lat.storage.Constants;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudioRepositoryTest {
    private static EntityManagerFactory entityManagerFactory;
    private JpaGenericDao<Studio> studioDao;
    private StudioRepository studioRepository;

    @BeforeAll
    static void beforeAll() {
        entityManagerFactory = Persistence.createEntityManagerFactory("lat-unit-test");
    }

    @BeforeEach
    void setUp() {
        EntityManager em = entityManagerFactory.createEntityManager();
        studioDao = new JpaGenericDao<>(Studio.class, em);

        studioRepository = new StudioRepository(studioDao);
    }

    @AfterEach
    void tearDown() {
        List<Studio> allAddresses = (List<Studio>)studioDao.findAll();
        studioDao.delete(allAddresses);

        studioRepository = null;
        studioDao = null;
    }

    @Test
    void testGetAllAddresses() {
        Studio firstStudio = Constants.getFirstStudio();
        Studio secondStudio = Constants.getSecondStudio();
        boolean isFirstAdded = studioDao.create(firstStudio);
        boolean isSecondAdded = studioDao.create(secondStudio);

        List<Studio> resultStudios = studioRepository.getAllStudios();

        assertTrue(isFirstAdded);
        assertTrue(isSecondAdded);

        assertEquals(2, resultStudios.size());
        assertTrue(resultStudios.contains(firstStudio));
        assertTrue(resultStudios.contains(secondStudio));
    }

    @Test
    void testGetAddress() {
        Studio studio = Constants.getFirstStudio();
        boolean isAdded = studioDao.create(studio);

        Studio resultStudio = studioRepository.getStudio(studio.getId());

        assertTrue(isAdded);

        assertEquals(studio, resultStudio);
    }

    @Test
    void testCreateAddress() {
        Studio studio = Constants.getFirstStudio();

        int sizeBeforeAdding = studioRepository.getAllStudios().size();

        boolean resultIsAdded = studioRepository.createStudio(studio);

        List<Studio> allAddedStudios = studioRepository.getAllStudios();

        assertEquals(0, sizeBeforeAdding);
        assertTrue(resultIsAdded);

        assertEquals(1, allAddedStudios.size());
        assertTrue(allAddedStudios.contains(studio));
    }

    @Test
    void testDeleteAddress() {
        Studio studio = Constants.getFirstStudio();

        int sizeBeforeAdding = studioRepository.getAllStudios().size();
        studioRepository.createStudio(studio);

        int sizeBeforeDeleting = studioRepository.getAllStudios().size();

        boolean resultIsDeleted = studioRepository.deleteStudio(studio.getId());

        assertTrue(resultIsDeleted);

        assertEquals(sizeBeforeAdding + 1, sizeBeforeDeleting);
        assertEquals(sizeBeforeDeleting - 1, studioRepository.getAllStudios().size());
    }
}
