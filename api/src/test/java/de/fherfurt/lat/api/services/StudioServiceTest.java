package de.fherfurt.lat.api.services;

import de.fherfurt.lat.api.data.repositories.MockStudioRepository;
import de.fherfurt.lat.storage.data.repositories.IStudioRepository;
import de.fherfurt.lat.storage.models.Studio;
import de.fherfurt.lat.storage.models.Address;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class StudioServiceTest {
    private IStudioRepository mockStudioRepository;
    private StudioService studioService;

    @BeforeEach
    void setUp() {
        mockStudioRepository = new MockStudioRepository();
        studioService = new StudioService(mockStudioRepository);
    }

    @AfterEach
    void tearDown() {
        mockStudioRepository = null;
        studioService = null;
    }

    @Test
    void testGetAllStudios() {
        // Act
        List<Studio> studios = studioService.getAllStudios();

        // Assert
        assertNotNull(studios);
        assertEquals(2, studios.size());
    }

    @Test
    void testGetStudioById() {
        // Arrange
        int validStudioId = 0;
        int invalidStudioId = 5;

        // Act
        Optional<Studio> foundValidStudio = studioService.getStudioById(validStudioId);
        Optional<Studio> foundInvalidStudio = studioService.getStudioById(invalidStudioId);

        // Assert
        assertTrue(foundValidStudio.isPresent());
        assertEquals(MockStudioRepository.firstStudio, foundValidStudio.get());

        assertFalse(foundInvalidStudio.isPresent());
    }

    @Test
    void testAddStudio() {
        // Arrange
        Studio newStudio = getTestStudio();

        int studioAmountBefore = studioService.getAllStudios().size();

        // Act
        boolean resultStudioAdded = studioService.addStudio(newStudio);

        // Assert
        assertTrue(resultStudioAdded);
        assertEquals(studioAmountBefore + 1, MockStudioRepository.studios.size());
        assertTrue(MockStudioRepository.studios.contains(newStudio));
    }
/*
    @Test
    void testUpdateStudio() {
        // Arrange
        // Arrange
        Studio newStudio = getTestStudio();

        int studioAmountBeforeAdding = MockStudioRepository.studios.size();
        studioService.addStudio(newStudio);

        int studioAmountBeforeUpdating = MockStudioRepository.studios.size();

        // Act
        boolean resultStudioUpdated = studioService.updateStudio(newStudio);

        // Assert
        assertTrue(resultStudioUpdated);

        assertEquals(studioAmountBeforeAdding + 1, studioAmountBeforeUpdating);
        assertEquals(studioAmountBeforeUpdating, MockStudioRepository.studios.size());

        assertTrue(MockStudioRepository.studios.contains(newStudio));
    }*/

    @Test
    void testDeleteStudio() {
        // Arrange
        int invalidPersonId = 5;

        Studio newStudio = getTestStudio();

        int studioAmountBeforeAdding = MockStudioRepository.studios.size();
        studioService.addStudio(newStudio);

        int studioAmountBeforeDeleting = MockStudioRepository.studios.size();

        // Act
        boolean resultStudioRemoved = studioService.deleteStudio(2);
        boolean resultStudioNotRemoved = studioService.deleteStudio(invalidPersonId);

        // Assert
        assertTrue(resultStudioRemoved);
        assertEquals(studioAmountBeforeAdding + 1, studioAmountBeforeDeleting);
        assertEquals(studioAmountBeforeDeleting - 1, MockStudioRepository.studios.size());

        assertFalse(resultStudioNotRemoved);
    }

    private Studio getTestStudio() {
        return new Studio (
                120.30,
                1
        );
    }
}
