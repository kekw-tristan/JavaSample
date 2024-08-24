package de.fherfurt.lat.storage.models;


import de.fherfurt.lat.storage.data.core.AbstractDatabaseEntity;
import lombok.*;

import javax.persistence.Entity;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "addresses")
public class Address extends AbstractDatabaseEntity
{
    private int     houseNumber;
    private String  street;
    private String  postalCode;
    private String  city;
    private String  country;


    public Address(int houseNumber, String street, String postalCode, String city, String country)
    {
        this.houseNumber = houseNumber;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }


    public static Address create(int houseNumber, String street, String postalCode, String city, String country) {
        return new Address(houseNumber, street, postalCode, city, country);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return houseNumber == address.houseNumber && Objects.equals(street, address.street) && Objects.equals(postalCode, address.postalCode) && Objects.equals(city, address.city) && Objects.equals(country, address.country);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(houseNumber, street, postalCode, city, country);
    }

    @Override
    public String toString()
    {
        return String.format("%d %s, %s %s (%s)", houseNumber, street, postalCode, city, country);
    }

    public int getHouseNumber() { return houseNumber; }
    public void setHouseNumber(int houseNumber) { this.houseNumber = houseNumber; }
    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }
    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

}
