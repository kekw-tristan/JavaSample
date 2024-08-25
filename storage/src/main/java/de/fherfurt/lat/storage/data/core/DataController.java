package de.fherfurt.lat.storage.data.core;

import de.fherfurt.lat.storage.data.daos.IGenericDao;
import de.fherfurt.lat.storage.data.daos.JpaGenericDao;
import de.fherfurt.lat.storage.data.repositories.*;
import de.fherfurt.lat.storage.models.Address;
import de.fherfurt.lat.storage.models.CalendarEntry;
import de.fherfurt.lat.storage.models.Studio;
import lombok.Getter;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.logging.Logger;

/**
 * Singleton class responsible for managing data access through JPA (Java Persistence API).
 * <p>
 * The {@link DataController} class initializes and provides access to repositories for various entities
 * (Address, Studio, CalendarEntry) based on the runtime environment. It uses an {@link EntityManagerFactory}
 * to create entity managers for interacting with the database.
 * </p>
 */
public class DataController {

    private static final Logger LOGGER = Logger.getLogger(DataController.class.getSimpleName());

    private static final String PERSISTENCE_UNIT_NAME = "lat-unit";
    private static final String PERSISTENCE_UNIT_TEST_NAME = "lat-unit-test";
    private static final String PERSISTENCE_UNIT_DEV_NAME = "lat-unit-dev";

    private final EntityManagerFactory entityManagerFactory;

    @Getter
    private final IAddressRepository addressRepository;

    @Getter
    private final IStudioRepository studioRepository;

    @Getter
    private final ICalendarEntryRepository calendarEntryRepository;

    private static DataController INSTANCE;

    /**
     * Provides the singleton instance of the {@link DataController} class.
     * <p>
     * If the instance does not exist, it creates a new one. Otherwise, it returns the existing instance.
     * </p>
     *
     * @return the singleton instance of {@link DataController}.
     */
    public static DataController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DataController();
        }
        return INSTANCE;
    }

    /**
     * Private constructor to initialize the {@link DataController} class.
     * <p>
     * Initializes the {@link EntityManagerFactory} based on the runtime environment and creates the repositories
     * for Address, Studio, and CalendarEntry entities.
     * </p>
     */
    private DataController() {
        LOGGER.info("Init Data Controller");
        String runMode = System.getenv("RUN_MODE");

        // Prepare Entity Manager Factory
        if (runMode == null) {
            // Running on local machine, with DB in compose
            this.entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_DEV_NAME);
        } else if (runMode.equalsIgnoreCase("PRODUCTION")) {
            // Running in production
            this.entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        } else {
            // Running tests
            this.entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_TEST_NAME);
        }

        // Create Repository
        LOGGER.info("Create RepositoryImpl");
        this.addressRepository = new AddressRepository(this.getAddressDao());
        this.studioRepository = new StudioRepository(this.getStudioDao());
        this.calendarEntryRepository = new CalendarEntryRepository(this.getCalendarEntryDao());
    }

    /**
     * Creates and returns a new {@link IGenericDao} instance for {@link CalendarEntry}.
     * <p>
     * This method uses the current {@link EntityManagerFactory} to create an entity manager and
     * then creates a {@link JpaGenericDao} for the {@link CalendarEntry} entity.
     * </p>
     *
     * @return a new {@link IGenericDao} instance for {@link CalendarEntry}.
     */
    public IGenericDao<CalendarEntry> getCalendarEntryDao() {
        return new JpaGenericDao<>(
                CalendarEntry.class,
                this.entityManagerFactory.createEntityManager()
        );
    }

    /**
     * Creates and returns a new {@link IGenericDao} instance for {@link Address}.
     * <p>
     * This method uses the current {@link EntityManagerFactory} to create an entity manager and
     * then creates a {@link JpaGenericDao} for the {@link Address} entity.
     * </p>
     *
     * @return a new {@link IGenericDao} instance for {@link Address}.
     */
    public IGenericDao<Address> getAddressDao() {
        return new JpaGenericDao<>(
                Address.class,
                this.entityManagerFactory.createEntityManager()
        );
    }

    /**
     * Creates and returns a new {@link IGenericDao} instance for {@link Studio}.
     * <p>
     * This method uses the current {@link EntityManagerFactory} to create an entity manager and
     * then creates a {@link JpaGenericDao} for the {@link Studio} entity.
     * </p>
     *
     * @return a new {@link IGenericDao} instance for {@link Studio}.
     */
    public IGenericDao<Studio> getStudioDao() {
        return new JpaGenericDao<>(
                Studio.class,
                this.entityManagerFactory.createEntityManager()
        );
    }
}