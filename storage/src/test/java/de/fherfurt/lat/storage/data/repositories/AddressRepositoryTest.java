package de.fherfurt.lat.storage.data.repositories;

import de.fherfurt.lat.storage.data.daos.JpaGenericDao;
import de.fherfurt.lat.storage.models.Address;
import lombok.AllArgsConstructor;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AddressRepositoryTes {
    private static EntityManagerFactory entityManagerFactory;
    private final JpaGenericDao<Address> addressDao;

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
