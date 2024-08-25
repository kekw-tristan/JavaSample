package de.fherfurt.lat.storage.data.repositories;


import de.fherfurt.lat.storage.data.daos.IGenericDao;
import de.fherfurt.lat.storage.models.Address;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class AddressRepositoryTest implements IAddressRepository {
    private final IGenericDao<Address> addressDao;

    @Override
    public List<Address> getAllAddresses() {
        return new ArrayList<>(addressDao.findAll());
    }

    @Override
    public Address getAddress(int addressId) {
        return addressDao.findById(addressId);
    }


    @Override
    public boolean createAddress(Address address) {
        return addressDao.create(address);
    }


    @Override
    public boolean deleteAddress(int addressId) {
        return addressDao.delete(addressId);
    }
}
