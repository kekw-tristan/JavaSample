package de.fherfurt.lat.api.mapping;

import de.fherfurt.lat.api.models.AddressDto;
import de.fherfurt.lat.api.models.StudioDto;
import de.fherfurt.lat.storage.models.Address;
import de.fherfurt.lat.storage.models.Studio;

public class Mapper {
    public static AddressDto addressToDto(Address address) {
        return new AddressDto(
                address.getId(),
                address.getHouseNumber(),
                address.getStreet(),
                address.getPostalCode(),
                address.getCity(),
                address.getCountry()
        );
    }

    public static StudioDto studioToDto(Studio studio) {
        return new StudioDto(
                studio.getId(),
                studio.getPrizePerDay(),
                studio.getAddress()
        );
    }
}
