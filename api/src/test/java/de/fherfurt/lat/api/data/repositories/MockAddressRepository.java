package de.fherfurt.lat.api.data.repositories;

import de.fherfurt.lat.storage.data.repositories.IAddressRepository;
import de.fherfurt.lat.storage.models.Address;
import de.fherfurt.lat.storage.models.Studio;

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

    public static List<Address> addresses = new ArrayList<>();

    private static void resetAddressesList() {
        addresses = new ArrayList<>();
        addresses.add(firstAddress);
        addresses.add(secondAddress);
    }

    public MockAddressRepository() { resetAddressesList(); }

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
    public boolean createAddress(Address address) {
        addresses.add(address);
        return true;
    }

    @Override
    public boolean deleteAddress(int addressId) {
        Address foundAddress = getAddress(addressId);
        if (foundAddress != null) {
            addresses.remove(foundAddress);
            return true;
        } else {
            return false;
        }
    }
}
