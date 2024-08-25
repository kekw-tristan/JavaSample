package de.fherfurt.lat.api.mapping;

import de.fherfurt.lat.api.models.AddressDto;
import de.fherfurt.lat.api.models.CalendarEntryDto;
import de.fherfurt.lat.api.models.StudioDto;
import de.fherfurt.lat.storage.models.Address;
import de.fherfurt.lat.storage.models.CalendarEntry;
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
                studio.getAddressId()
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

    public static Studio dtoToStudio(StudioDto studioDto) {
        if (studioDto == null) {
            return null;
        }

        // Use the factory method to create Address
        return Studio.create(
                studioDto.getPrizePerDay(),
                studioDto.getAddressId()
        );
    }

    public static CalendarEntryDto calendarEntryToDto(CalendarEntry entry) {
        return new CalendarEntryDto(
                entry.getId(),
                entry.getStudioId(),
                entry.getStartDate(),
                entry.getEndDate(),
                entry.getFirstName(),
                entry.getLastName(),
                entry.getEmail()
        );
    }

    public static CalendarEntry dtoToCalendarEntry(CalendarEntryDto entryDto) {
        if (entryDto == null) {
            return null;
        }

        // Use the factory method to create Address
        return CalendarEntry.create(
                entryDto.getStudioId(),
                entryDto.getStartDate(),
                entryDto.getEndDate(),
                entryDto.getFirstName(),
                entryDto.getLastName(),
                entryDto.getEmail()
        );
    }

}
