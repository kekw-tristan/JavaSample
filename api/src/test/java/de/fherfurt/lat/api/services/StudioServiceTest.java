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
import static org.junit.jupiter.api.Assertions.assertFalse;

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
        // Act
        // Assert
    }

    @Test
    void testUpdateStudio() {
        // Arrange
        // Act
        // Assert
    }

    @Test
    void testDeleteStudio() {
        // Arrange
        // Act
        // Assert
    }
}
