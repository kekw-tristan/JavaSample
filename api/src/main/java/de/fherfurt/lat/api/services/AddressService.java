package de.fherfurt.lat.api.services;

import de.fherfurt.lat.storage.data.core.DataController;
import de.fherfurt.lat.storage.data.repositories.IAddressRepository;
import de.fherfurt.lat.storage.models.Address;

import java.util.List;
import java.util.Optional;

public class AddressService implements IAddressService{

    private final IAddressRepository addressRepository;

    public AddressService() {
        this(DataController
                .getInstance()
                .getAddressRepository());
    }

    public AddressService(IAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }



    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.getAllAddresses();
    }

    @Override
    public Optional<Address> getAddressById(int addressId) {
        return Optional.ofNullable(addressRepository.getAddress(addressId));
    }

    @Override
    public boolean addAddress(Address address) {
        return addressRepository.createAddress(address);
    }

    @Override
    public boolean deleteAddress(int addressId) {
        return addressRepository.deleteAddress(addressId);
    }
}