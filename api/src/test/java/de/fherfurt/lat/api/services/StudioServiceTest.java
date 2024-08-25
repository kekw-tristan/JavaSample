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

    }
}
