package de.fherfurt.lat.storage;

import de.fherfurt.lat.storage.models.Address;

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
}