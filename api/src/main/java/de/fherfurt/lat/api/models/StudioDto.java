package de.fherfurt.lat.api.models;

import de.fherfurt.lat.storage.models.Address;
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
public class StudioDto {
    private int id;
    private double prizePerDay;
    private Address address;
}
