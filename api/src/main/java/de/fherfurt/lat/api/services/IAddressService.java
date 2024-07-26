package de.fherfurt.lat.api.services;

import de.fherfurt.lat.storage.models.Address;
import de.fherfurt.lat.storage.models.Studio;

import java.util.List;
import java.util.Optional;

public interface IAddressService {

    List<Address> getAllAddresses();

    List<Address> getAllAddresses(Studio studio);

    Optional<Address> getAddressById(int addressId);

    boolean addAddress(Address address);

    boolean updateAddress(Address address);

    boolean deleteAddress(int addressId);
}
