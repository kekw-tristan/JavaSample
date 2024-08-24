package de.fherfurt.lat.api.mapping;

import de.fherfurt.lat.api.models.AddressDto;
import de.fherfurt.lat.api.models.StudioDto;
import de.fherfurt.lat.storage.models.Address;
import de.fherfurt.lat.storage.data.core.AbstractDatabaseEntity;
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

    public static Object studioToDto(Studio studio) {
        return new StudioDto(
                studio.getId(),
                studio.getPrizePerDay(),
                studio.getAddress()
        );
    }

    public static Address dtoToAddress(AddressDto addressDto) {
        if (addressDto == null) {
            return null;
        }

        // Use the factory method to create Address
        return Address.create(
                addressDto.getHouseNumber(),
                addressDto.getStreet(),
                addressDto.getPostalCode(),
                addressDto.getCity(),
                addressDto.getCountry()
        );
    }
}
