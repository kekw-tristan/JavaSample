package de.fherfurt.lat.api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO Class for Address
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
