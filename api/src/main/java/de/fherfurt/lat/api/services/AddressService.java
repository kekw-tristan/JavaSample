package de.fherfurt.lat.api.services;

import de.fherfurt.lat.storage.models.Studio;
import de.fherfurt.lat.storage.models.Address;

import java.util.List;
import java.util.Optional;

public class AddressService implements IAddressService{

    @Override
    public List<Address> getAllAddresses() {
        return List.of();
    }

    @Override
    public List<Address> getAllAddresses(Studio studio) {
        return List.of();
    }

    @Override
    public Optional<Address> getAddressById(int addressId) {
        return Optional.empty();
    }

    @Override
    public boolean addAddress(Address address) {
        return false;
    }

    @Override
    public boolean updateAddress(Address address) {
        return false;
    }

    @Override
    public boolean deleteAddress(int addressId) {
        return false;
    }
}