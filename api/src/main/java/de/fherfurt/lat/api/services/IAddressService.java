package de.fherfurt.lat.api.services;

import de.fherfurt.lat.storage.models.Address;

import java.util.List;
import java.util.Optional;

/**
 * Interface for address service operations.
 * <p>
 * This interface defines the contract for services that manage address entities.
 * It provides methods to retrieve, add, and delete address records.
 * Implementations of this interface are expected to interact with a data repository
 * to perform CRUD operations on address data.
 * </p>
 */
public interface IAddressService {

    /**
     * Retrieves a list of all addresses.
     * <p>
     * This method is used to obtain all address records from the data source.
     * </p>
     *
     * @return a {@link List} of {@link Address} objects representing all addresses.
     */
    List<Address> getAllAddresses();

    /**
     * Retrieves a specific address by its ID.
     * <p>
     * This method is used to obtain an address record by its unique ID.
     * </p>
     *
     * @param addressId the ID of the address to retrieve.
     * @return an {@link Optional} containing the {@link Address} if found, or an empty {@link Optional} if not found.
     */
    Optional<Address> getAddressById(int addressId);

    /**
     * Adds a new address.
     * <p>
     * This method is used to create a new address record in the data source.
     * </p>
     *
     * @param address the {@link Address} to be added.
     * @return {@code true} if the address was successfully created, {@code false} otherwise.
     */
    boolean addAddress(Address address);

    /**
     * Deletes a specific address by its ID.
     * <p>
     * This method is used to remove an address record from the data source based on its unique ID.
     * </p>
     *
     * @param addressId the ID of the address to be deleted.
     * @return {@code true} if the address was successfully deleted, {@code false} otherwise.
     */
    boolean deleteAddress(int addressId);
}