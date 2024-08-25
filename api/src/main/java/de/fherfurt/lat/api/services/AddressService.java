package de.fherfurt.lat.api.services;

import de.fherfurt.lat.storage.data.core.DataController;
import de.fherfurt.lat.storage.data.repositories.IAddressRepository;
import de.fherfurt.lat.storage.models.Address;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing address entities.
 * <p>
 * This class implements the {@link IAddressService} interface and provides methods for
 * retrieving, adding, and deleting address entities. It interacts with the
 * {@link IAddressRepository} to perform CRUD operations on address data.
 * </p>
 *
 * <p>
 * The service can be initialized with a default repository obtained from the
 * {@link DataController} or with a custom repository instance.
 * </p>
 */
public class AddressService implements IAddressService {

    private final IAddressRepository addressRepository;

    /**
     * Constructs a new {@code AddressService} using the default address repository
     * from the {@link DataController}.
     */
    public AddressService() {
        this(DataController
                .getInstance()
                .getAddressRepository());
    }

    /**
     * Constructs a new {@code AddressService} with a specified address repository.
     *
     * @param addressRepository the {@link IAddressRepository} to be used for address operations.
     */
    public AddressService(IAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    /**
     * Retrieves a list of all addresses.
     * <p>
     * This method calls the repository's method to get all addresses and returns them as a list.
     * </p>
     *
     * @return a list of {@link Address} objects representing all addresses.
     */
    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.getAllAddresses();
    }

    /**
     * Retrieves a specific address by its ID.
     * <p>
     * This method calls the repository's method to get an address by its ID and wraps it in an {@link Optional}.
     * </p>
     *
     * @param addressId the ID of the address to retrieve.
     * @return an {@link Optional} containing the {@link Address} if found, or an empty {@link Optional} if not found.
     */
    @Override
    public Optional<Address> getAddressById(int addressId) {
        return Optional.ofNullable(addressRepository.getAddress(addressId));
    }

    /**
     * Adds a new address.
     * <p>
     * This method calls the repository's method to create a new address and returns a boolean indicating success or failure.
     * </p>
     *
     * @param address the {@link Address} to be added.
     * @return {@code true} if the address was successfully created, {@code false} otherwise.
     */
    @Override
    public boolean addAddress(Address address) {
        return addressRepository.createAddress(address);
    }

    /**
     * Deletes a specific address by its ID.
     * <p>
     * This method calls the repository's method to delete an address by its ID and returns a boolean indicating success or failure.
     * </p>
     *
     * @param addressId the ID of the address to be deleted.
     * @return {@code true} if the address was successfully deleted, {@code false} otherwise.
     */
    @Override
    public boolean deleteAddress(int addressId) {
        return addressRepository.deleteAddress(addressId);
    }
}