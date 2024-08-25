package de.fherfurt.lat.api.services;

import de.fherfurt.lat.api.data.repositories.MockAddressRepository;
import de.fherfurt.lat.storage.data.repositories.IAddressRepository;
import de.fherfurt.lat.storage.models.Address;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AddressServiceTest {
    private IAddressRepository mockAddressRepository;

    private AddressService addressService;

    @BeforeEach
    void setUp() {
        mockAddressRepository = new MockAddressRepository();

        addressService = new AddressService(mockAddressRepository);
    }

    @AfterEach
    void tearDown() {
        mockAddressRepository = null;

        addressService = null;
    }

    @Test
    void testGetAllAddresses() {
        // Arrange

        // Act
        List<Address> resultAllAddresses = addressService.getAllAddresses();

        // Assert
        assertNotNull(resultAllAddresses);
        assertEquals(2, resultAllAddresses.size());
        assertTrue(resultAllAddresses.containsAll(MockAddressRepository.addresses));
    }

    @Test
    void testGetAddressById() {
        // Arrange
        int validAddressId = 0;
        int invalidAddressId = 5;

        // Act
        Optional<Address> resultGetAddress = addressService.getAddressById(validAddressId);
        Optional<Address> resultGetNoAddress = addressService.getAddressById(invalidAddressId);

        // Assert
        assertTrue(resultGetAddress.isPresent());
        assertEquals(MockAddressRepository.firstAddress, resultGetAddress.get());
        assertNotEquals(MockAddressRepository.secondAddress, resultGetAddress.get());

        assertFalse(resultGetNoAddress.isPresent());
    }

    @Test
    void testAddAddress() {
        // Arrange
        Address newAddress = getTestAddress();

        int addressAmountBefore = MockAddressRepository.addresses.size();

        // Act
        boolean resultAddressAdded = addressService.addAddress(newAddress);

        // Assert
        assertTrue(resultAddressAdded);
        assertEquals(addressAmountBefore + 1, MockAddressRepository.addresses.size());
        assertTrue(MockAddressRepository.addresses.contains(newAddress));
    }

    @Test
    void testDeleteAddress() {
        // Arrange
        int invalidAddressId = 5;

        Address newAddress = getTestAddress();

        int addressAmountBeforeAdding = MockAddressRepository.addresses.size();
        addressService.addAddress(newAddress);

        int addressAmountBeforeDeleting = MockAddressRepository.addresses.size();

        // Act
        boolean resultAddressRemoved = addressService.deleteAddress(2);
        boolean resultAddressNotRemoved = addressService.deleteAddress(invalidAddressId);

        // Assert
        assertTrue(resultAddressRemoved);
        assertEquals(addressAmountBeforeAdding + 1, addressAmountBeforeDeleting);
        assertEquals(addressAmountBeforeDeleting - 1, MockAddressRepository.addresses.size());

        assertFalse(resultAddressNotRemoved);
    }

    private Address getTestAddress() {
        return new Address (
                1,
                "sesamstrasse",
                "12345",
                "Stadt",
                "USA"
        );
    }
}
