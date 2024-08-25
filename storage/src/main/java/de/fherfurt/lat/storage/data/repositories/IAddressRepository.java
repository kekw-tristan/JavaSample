package de.fherfurt.lat.storage.data.repositories;

import de.fherfurt.lat.storage.models.Address;

import java.util.List;

/**
 * Repository interface for managing {@link Address} entities.
 * <p>
 * This interface defines methods for performing CRUD (Create, Read, Update, Delete) operations
 * on {@link Address} entities. Implementations of this interface are responsible for
 * interacting with the underlying data store.
 * </p>
 */
public interface IAddressRepository {

    /**
     * Retrieves all addresses from the data store.
     *
     * @return a list of all addresses.
     */
    List<Address> getAllAddresses();

    /**
     * Retrieves a specific address by its unique identifier.
     *
     * @param addressId the unique identifier of the address.
     * @return the address with the specified id, or {@code null} if not found.
     */
    Address getAddress(int addressId);

    /**
     * Creates a new address in the data store.
     *
     * @param address the address to be created.
     * @return {@code true} if the address was created successfully, {@code false} otherwise.
     */
    boolean createAddress(Address address);

    /**
     * Deletes an address from the data store by its unique identifier.
     *
     * @param addressId the unique identifier of the address to be deleted.
     * @return {@code true} if the address was deleted successfully, {@code false} otherwise.
     */
    boolean deleteAddress(int addressId);
}