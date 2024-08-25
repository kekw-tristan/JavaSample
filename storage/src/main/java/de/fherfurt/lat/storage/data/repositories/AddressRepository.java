package de.fherfurt.lat.storage.data.repositories;

import de.fherfurt.lat.storage.data.daos.IGenericDao;
import de.fherfurt.lat.storage.models.Address;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository class for managing {@link Address} entities.
 * <p>
 * This class implements the {@link IAddressRepository} interface and provides methods
 * to perform CRUD operations on {@link Address} entities using a data access object (DAO).
 * </p>
 */
@AllArgsConstructor
public class AddressRepository implements IAddressRepository {

    private final IGenericDao<Address> addressDao;

    /**
     * Retrieves all addresses from the data store.
     *
     * @return a list of all addresses.
     */
    @Override
    public List<Address> getAllAddresses() {
        return new ArrayList<>(addressDao.findAll());
    }

    /**
     * Retrieves a specific address by its unique identifier.
     *
     * @param addressId the unique identifier of the address.
     * @return the address with the specified id, or {@code null} if not found.
     */
    @Override
    public Address getAddress(int addressId) {
        return addressDao.findById(addressId);
    }

    /**
     * Creates a new address in the data store.
     *
     * @param address the address to be created.
     * @return {@code true} if the address was created successfully, {@code false} otherwise.
     */
    @Override
    public boolean createAddress(Address address) {
        return addressDao.create(address);
    }

    /**
     * Deletes an address by its unique identifier.
     *
     * @param addressId the unique identifier of the address to be deleted.
     * @return {@code true} if the address was deleted successfully, {@code false} otherwise.
     */
    @Override
    public boolean deleteAddress(int addressId) {
        return addressDao.delete(addressId);
    }
}