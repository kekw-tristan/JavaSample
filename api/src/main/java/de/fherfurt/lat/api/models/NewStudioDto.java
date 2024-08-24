package de.fherfurt.lat.api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewStudioDto {
    private double prizePerDay;
    private int houseNumber;
    private String street;
    private String postalCode;
    private String city;
    private String country;
}