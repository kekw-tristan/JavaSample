package de.fherfurt.lat.storage.data.core;

import de.fherfurt.lat.storage.data.daos.IGenericDao;
import de.fherfurt.lat.storage.data.daos.IStudioDao;
import de.fherfurt.lat.storage.data.daos.JpaGenericDao;
import de.fherfurt.lat.storage.data.repositories.*;
import de.fherfurt.lat.storage.models.Address;
import de.fherfurt.lat.storage.models.CalendarEntry;
import de.fherfurt.lat.storage.models.Studio;
import lombok.Getter;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.logging.Logger;

public class DataController {
    private static final Logger LOGGER = Logger.getLogger( DataController.class.getSimpleName() );

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

    public static DataController getInstance() {
        if( INSTANCE == null ) {
            INSTANCE = new DataController();
        }

        return INSTANCE;
    }

    private DataController() {
        LOGGER.info( "Init Data Controller" );
        String runMode = System.getenv("RUN_MODE");

        // Prepare Entity Manager Factory
        if (runMode == null) {
            // Running on local machine, with db in compose
            this.entityManagerFactory = Persistence.createEntityManagerFactory( PERSISTENCE_UNIT_DEV_NAME );
        } else if (runMode.equalsIgnoreCase("PRODUCTION")) {
            // Running container, with db in compose
        this.entityManagerFactory = Persistence.createEntityManagerFactory( PERSISTENCE_UNIT_NAME );
        } else {
            // Running tests
            this.entityManagerFactory = Persistence.createEntityManagerFactory( PERSISTENCE_UNIT_TEST_NAME );
        }

        // Create Repository
        LOGGER.info( "Create RepositoryImpl" );
        this.addressRepository = new AddressRepository( this.getAddressDao() );
        this.studioRepository = new StudioRepository( this.getStudioDao());
        this.calendarEntryRepository = new CalendarEntryRepository(this.getCalendarEntryDao());

    }

    public IGenericDao<CalendarEntry> getCalendarEntryDao()
    {
        return new JpaGenericDao<>(
                CalendarEntry.class,
                this.entityManagerFactory.createEntityManager()
        );
    }

    public IGenericDao<Address> getAddressDao() {
        return new JpaGenericDao<>(
                Address.class,
                this.entityManagerFactory.createEntityManager()
        );
    }

    public IGenericDao<Studio> getStudioDao() {
        return new JpaGenericDao<>(
                Studio.class,
                this.entityManagerFactory.createEntityManager()
        );
    }

}
