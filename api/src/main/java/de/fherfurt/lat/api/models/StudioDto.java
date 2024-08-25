package de.fherfurt.lat.api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) class for representing a studio.
 * <p>
 * This class is used to transfer studio-related data between different layers of the application,
 * such as from the database layer to the service layer or from the service layer to the presentation layer.
 * </p>
 * <p>
 * The {@code StudioDto} class is a simple POJO (Plain Old Java Object) with properties for the ID,
 * daily rental price, and the associated address ID.
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
public class StudioDto {
    private int id;
    private double prizePerDay;
    private int addressId;
}
