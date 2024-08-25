package de.fherfurt.lat.storage.data.repositories;

import de.fherfurt.lat.storage.models.Address;
import de.fherfurt.lat.storage.data.daos.JpaGenericDao;
import de.fherfurt.lat.storage.Constants;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddressRepositoryTest {
    private static EntityManagerFactory entityManagerFactory;
    private JpaGenericDao<Address> addressDao;
    private AddressRepository addressRepository;

    @BeforeAll
    static void beforeAll() {
        entityManagerFactory = Persistence.createEntityManagerFactory("lat-unit-test");
    }

    @BeforeEach
    void setUp() {
        EntityManager em = entityManagerFactory.createEntityManager();
        addressDao = new JpaGenericDao<>(Address.class, em);

        addressRepository = new AddressRepository(addressDao);
    }

    @AfterEach
    void tearDown() {
        List<Address> allAddresses = (List<Address>)addressDao.findAll();
        addressDao.delete(allAddresses);

        addressRepository = null;
        addressDao = null;
    }

    @Test
    void testGetAllAddresses() {
        Address firstAddress = Constants.getFirstAddress();
        Address secondAddress = Constants.getSecondAddress();
        boolean isFirstAdded = addressDao.create(firstAddress);
        boolean isSecondAdded = addressDao.create(secondAddress);

        List<Address> resultAddresses = addressRepository.getAllAddresses();

        assertTrue(isFirstAdded);
        assertTrue(isSecondAdded);

        assertEquals(2, resultAddresses.size());
        assertTrue(resultAddresses.contains(firstAddress));
        assertTrue(resultAddresses.contains(secondAddress));
    }

    @Test
    void testGetAddress() {
        Address Address = Constants.getFirstAddress();
        boolean isAdded = addressDao.create(Address);

        Address resultAddress = addressRepository.getAddress(Address.getId());

        assertTrue(isAdded);

        assertEquals(Address, resultAddress);
    }

    @Test
    void testCreateAddress() {
        Address address = Constants.getFirstAddress();

        int sizeBeforeAdding = addressRepository.getAllAddresses().size();

        boolean resultIsAdded = addressRepository.createAddress(address);

        List<Address> allAddedAddresses = addressRepository.getAllAddresses();

        assertEquals(0, sizeBeforeAdding);
        assertTrue(resultIsAdded);

        assertEquals(1, allAddedAddresses.size());
        assertTrue(allAddedAddresses.contains(address));
    }

    @Test
    void testDeleteAddress() {
        Address address = Constants.getFirstAddress();

        int sizeBeforeAdding = addressRepository.getAllAddresses().size();
        addressRepository.createAddress(address);

        int sizeBeforeDeleting = addressRepository.getAllAddresses().size();

        boolean resultIsDeleted = addressRepository.deleteAddress(address.getId());

        assertTrue(resultIsDeleted);

        assertEquals(sizeBeforeAdding + 1, sizeBeforeDeleting);
        assertEquals(sizeBeforeDeleting - 1, addressRepository.getAllAddresses().size());
    }
}
