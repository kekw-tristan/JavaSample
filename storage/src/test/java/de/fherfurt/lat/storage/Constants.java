package de.fherfurt.lat.storage;

import de.fherfurt.lat.storage.models.Address;
import de.fherfurt.lat.storage.models.Studio;

public class Constants {

    //  FIRST ADDRESS
    public static final int FIRST_ADDRESS_HOUSENUMBER = 1;
    public static final String FIRST_ADDRESS_STREET = "Altonaer Strasse";
    public static final String FIRST_ADDRESS_POSTAL_CODE = "99085";
    public static final String FIRST_ADDRESS_CITY = "Erfurt";
    public static final String FIRST_ADDRESS_COUNTRY = "DE";

    public static Address getFirstAddress() {
        return new Address(
                FIRST_ADDRESS_HOUSENUMBER,
                FIRST_ADDRESS_STREET,
                FIRST_ADDRESS_POSTAL_CODE,
                FIRST_ADDRESS_CITY,
                FIRST_ADDRESS_COUNTRY
        );
    }

    //  SECOND ADDRESS
    public static final int SECOND_ADDRESS_HOUSENUMBER = 1;
    public static final String SECOND_ADDRESS_STREET = "Schlossgasse";
    public static final String SECOND_ADDRESS_POSTAL_CODE = "07743";
    public static final String SECOND_ADDRESS_CITY = "Jena";
    public static final String SECOND_ADDRESS_COUNTRY = "DE";

    public static Address getSecondAddress() {
        return new Address(
                SECOND_ADDRESS_HOUSENUMBER,
                SECOND_ADDRESS_STREET,
                SECOND_ADDRESS_POSTAL_CODE,
                SECOND_ADDRESS_CITY,
                SECOND_ADDRESS_COUNTRY
        );
    }

    // First Studio
    public static final double FIRST_STUDIO_PRIZE_PER_DAY = 110.95;
    public static final int FIRST_STUDIO_ADDRESS_ID = 0;

    public static Studio getFirstStudio() {
        return new Studio(
                FIRST_STUDIO_PRIZE_PER_DAY,
                FIRST_STUDIO_ADDRESS_ID
        );
    }

    // Second Studio
    public static final double SECOND_STUDIO_PRIZE_PER_DAY = 120.10;
    public static final int SECOND_STUDIO_ADDRESS_ID = 1;

    public static Studio getSecondStudio() {
        return new Studio(
                SECOND_STUDIO_PRIZE_PER_DAY,
                SECOND_STUDIO_ADDRESS_ID
        );
    }
}