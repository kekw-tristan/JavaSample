package de.fherfurt.lat.storage.data.repositories;

import de.fherfurt.lat.storage.models.Address;
import de.fherfurt.lat.storage.data.daos.JpaGenericDao;
import de.fherfurt.lat.storage.Constants;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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

    }
}
