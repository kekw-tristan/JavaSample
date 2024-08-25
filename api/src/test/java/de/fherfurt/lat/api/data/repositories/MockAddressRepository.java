package de.fherfurt.lat.api.data.repositories;

import de.fherfurt.lat.storage.data.repositories.IAddressRepository;
import de.fherfurt.lat.storage.models.Address;

import java.util.List;
import java.util.ArrayList;

public class MockAddressRepository implements IAddressRepository {
    public static final Address firstAddress = new Address(
            25,
            "Altonaer Strasse",
            "99085",
            "Erfurt",
            "DE"
    );
    public static final Address secondAddress = new Address(
            8,
            "Ernst-Abbe-Platz",
            "77043",
            "Jena",
            "DE"
    );

    public static final List<Address> addresses = List.of(firstAddress, secondAddress);

    @Override
    public List<Address> getAllAddresses() {
        return new ArrayList<>(addresses);
    }

    @Override
    public Address getAddress(int addressId) {
        if (addressId < 0 || addressId >= addresses.size()) {
            return null;
        }
        return getAllAddresses().get(addressId);
    }

    @Override
    public boolean createAddress(Address address) { return false;}

    @Override
    public boolean updateAddress(Address address) {
        return false;
    }

    @Override
    public boolean deleteAddress(int addressId) {
        return false;
    }
}
