package de.fherfurt.lat.api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) class for representing an address.
 * <p>
 * This class is used to transfer address-related data between different layers of the application,
 * such as from the database layer to the service layer or from the service layer to the presentation layer.
 * </p>
 * <p>
 * The {@code AddressDto} class is a simple POJO (Plain Old Java Object) with properties for the ID,
 * house number, street, postal code, city, and country. It includes standard getter and setter methods,
 * as well as constructors for convenience.
 * </p>
 *
 * <p>
 * The class uses Lombok annotations to automatically generate boilerplate code:
 * </p>
 * <ul>
 *   <li>{@link Getter} - generates getter methods for all fields</li>
 *   <li>{@link Setter} - generates setter methods for all fields</li>
 *   <li>{@link AllArgsConstructor} - generates a constructor with parameters for all fields</li>
 *   <li>{@link NoArgsConstructor} - generates a no-argument constructor</li>
 * </ul>
 *
 * @see lombok.Getter
 * @see lombok.Setter
 * @see lombok.AllArgsConstructor
 * @see lombok.NoArgsConstructor
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    private int id;
    private int houseNumber;
    private String street;
    private String postalCode;
    private String city;
    private String country;
}