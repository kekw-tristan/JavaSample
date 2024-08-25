package de.fherfurt.lat.api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * DTO Class for Calendar entry
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
    private String FirstName;
    private String LastName;
    private String Email;
}
