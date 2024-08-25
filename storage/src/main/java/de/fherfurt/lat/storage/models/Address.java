package de.fherfurt.lat.storage.models;

import de.fherfurt.lat.storage.data.core.AbstractDatabaseEntity;
import lombok.*;

import javax.persistence.Entity;
import java.util.Objects;

/**
 * Represents an address entity with detailed address information.
 * <p>
 * The {@code Address} class extends {@link AbstractDatabaseEntity} and maps to the "addresses" table in the database.
 * It includes attributes such as house number, street, postal code, city, and country.
 * </p>
 */
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "addresses")
public class Address extends AbstractDatabaseEntity {
    private int houseNumber;
    private String street;
    private String postalCode;
    private String city;
    private String country;

    /**
     * Constructs a new {@code Address} with the specified details.
     *
     * @param houseNumber the house number of the address.
     * @param street      the street of the address.
     * @param postalCode  the postal code of the address.
     * @param city        the city of the address.
     * @param country     the country of the address.
     */
    public Address(int houseNumber, String street, String postalCode, String city, String country) {
        this.houseNumber = houseNumber;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    /**
     * Creates a new {@code Address} instance using the provided details.
     *
     * @param houseNumber the house number of the address.
     * @param street      the street of the address.
     * @param postalCode  the postal code of the address.
     * @param city        the city of the address.
     * @param country     the country of the address.
     * @return a new {@code Address} instance with the specified details.
     */
    public static Address create(int houseNumber, String street, String postalCode, String city, String country) {
        return new Address(houseNumber, street, postalCode, city, country);
    }

    /**
     * Compares this {@code Address} to another object for equality.
     * <p>
     * Two {@code Address} instances are considered equal if all their attributes are the same.
     * </p>
     *
     * @param o the object to compare this {@code Address} against.
     * @return {@code true} if the specified object is equal to this {@code Address}; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return houseNumber == address.houseNumber &&
                Objects.equals(street, address.street) &&
                Objects.equals(postalCode, address.postalCode) &&
                Objects.equals(city, address.city) &&
                Objects.equals(country, address.country);
    }

    /**
     * Returns a hash code value for this {@code Address}.
     * <p>
     * The hash code is computed based on the attributes of the {@code Address}.
     * </p>
     *
     * @return the hash code value for this {@code Address}.
     */
    @Override
    public int hashCode() {
        return Objects.hash(houseNumber, street, postalCode, city, country);
    }

    /**
     * Returns a string representation of this {@code Address}.
     * <p>
     * The string representation includes the house number, street, postal code, city, and country.
     * </p>
     *
     * @return a string representation of this {@code Address}.
     */
    @Override
    public String toString() {
        return String.format("%d %s, %s %s (%s)", houseNumber, street, postalCode, city, country);
    }
}