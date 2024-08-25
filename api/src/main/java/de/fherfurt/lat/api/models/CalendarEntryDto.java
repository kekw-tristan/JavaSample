package de.fherfurt.lat.api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) class for representing a calendar entry.
 * <p>
 * This class is used to transfer calendar entry data between different layers of the application,
 * such as from the database layer to the service layer or from the service layer to the presentation layer.
 * </p>
 * <p>
 * The {@code CalendarEntryDto} class is a simple POJO (Plain Old Java Object) with properties for
 * the ID, studio ID, start date, end date, and the details of the person who made the entry (first name,
 * last name, and email).
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
public class CalendarEntryDto {
    private int id;
    private int studioId;
    private String startDate;
    private String endDate;
    private String firstName;
    private String lastName;
    private String email;
}
