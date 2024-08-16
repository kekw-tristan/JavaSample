package de.fherfurt.lat.storage.data.repositories;


import de.fherfurt.lat.storage.models.Address;

import java.util.List;

public interface IAddressRepository {
    List<Address> getAllAddresses();

    Address getAddress( int addressId );
    boolean createAddress( Address address );
    boolean updateAddress( Address address );
    boolean deleteAddress( int addressId );
}
