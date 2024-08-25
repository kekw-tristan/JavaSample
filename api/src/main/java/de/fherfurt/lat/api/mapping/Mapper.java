package de.fherfurt.lat.api.mapping;

import de.fherfurt.lat.api.models.AddressDto;
import de.fherfurt.lat.api.models.CalendarEntryDto;
import de.fherfurt.lat.api.models.StudioDto;
import de.fherfurt.lat.storage.models.Address;
import de.fherfurt.lat.storage.models.CalendarEntry;
import de.fherfurt.lat.storage.models.Studio;

/**
 * The {@code Mapper} class provides static methods for converting between
 * data transfer objects (DTOs) and entity models.
 * <p>
 * It includes methods for mapping {@link Address}, {@link Studio}, and {@link CalendarEntry} entities
 * to their corresponding DTOs, and vice versa.
 * </p>
 *
 * This class is intended to be used as a utility class, and therefore has only static methods.
 * It cannot be instantiated.
 */
public class Mapper {

    /**
     * Converts an {@link Address} entity to an {@link AddressDto}.
     *
     * @param address the {@link Address} entity to convert.
     * @return an {@link AddressDto} representing the given {@link Address}.
     */
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

    /**
     * Converts a {@link Studio} entity to a {@link StudioDto}.
     *
     * @param studio the {@link Studio} entity to convert.
     * @return a {@link StudioDto} representing the given {@link Studio}.
     */
    public static StudioDto studioToDto(Studio studio) {
        return new StudioDto(
                studio.getId(),
                studio.getPrizePerDay(),
                studio.getAddressId()
        );
    }

    /**
     * Converts an {@link AddressDto} to an {@link Address} entity.
     * <p>
     * If the provided {@link AddressDto} is {@code null}, this method returns {@code null}.
     * </p>
     *
     * @param addressDto the {@link AddressDto} to convert.
     * @return an {@link Address} entity corresponding to the given {@link AddressDto},
     * or {@code null} if the {@link AddressDto} is {@code null}.
     */
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

    /**
     * Converts a {@link StudioDto} to a {@link Studio} entity.
     * <p>
     * If the provided {@link StudioDto} is {@code null}, this method returns {@code null}.
     * </p>
     *
     * @param studioDto the {@link StudioDto} to convert.
     * @return a {@link Studio} entity corresponding to the given {@link StudioDto},
     * or {@code null} if the {@link StudioDto} is {@code null}.
     */
    public static Studio dtoToStudio(StudioDto studioDto) {
        if (studioDto == null) {
            return null;
        }

        // Use the factory method to create Studio
        return Studio.create(
                studioDto.getPrizePerDay(),
                studioDto.getAddressId()
        );
    }

    /**
     * Converts a {@link CalendarEntry} entity to a {@link CalendarEntryDto}.
     *
     * @param entry the {@link CalendarEntry} entity to convert.
     * @return a {@link CalendarEntryDto} representing the given {@link CalendarEntry}.
     */
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

    /**
     * Converts a {@link CalendarEntryDto} to a {@link CalendarEntry} entity.
     * <p>
     * If the provided {@link CalendarEntryDto} is {@code null}, this method returns {@code null}.
     * </p>
     *
     * @param entryDto the {@link CalendarEntryDto} to convert.
     * @return a {@link CalendarEntry} entity corresponding to the given {@link CalendarEntryDto},
     * or {@code null} if the {@link CalendarEntryDto} is {@code null}.
     */
    public static CalendarEntry dtoToCalendarEntry(CalendarEntryDto entryDto) {
        if (entryDto == null) {
            return null;
        }

        // Use the factory method to create CalendarEntry
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