package de.fherfurt.lat.api.services;

import de.fherfurt.lat.api.services.CalendarService;
import de.fherfurt.lat.storage.models.Studio;
import de.fherfurt.lat.storage.models.Address;
import de.fherfurt.lat.storage.models.CalendarEntry;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class CalenderServiceTest {
    private CalendarService calendarService;

    @BeforeEach
    void setUp() {
        studioService = new StudioService(mockStudioRepository);
    }

    @AfterEach
    void tearDown() {
        mockStudioRepository = null;
        studioService = null;
    }