package de.fherfurt.lat.storage.models;

import de.fherfurt.lat.storage.data.core.AbstractDatabaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * Represents a calendar entry for a studio reservation or event.
 * <p>
 * The {@code CalendarEntry} class extends {@link AbstractDatabaseEntity} and maps to the "calendarEntry" table in the database.
 * It includes details about the studio, the start and end dates of the reservation or event, and the contact information of the person involved.
 * </p>
 */
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "calendarEntry")
public class CalendarEntry extends AbstractDatabaseEntity {

    private int studioId;
    private String startDate;
    private String endDate;
    private String firstName;
    private String lastName;
    private String email;

    /**
     * Constructs a new {@code CalendarEntry} with the specified details.
     *
     * @param studioId the ID of the studio associated with this calendar entry.
     * @param startDate the start date of the calendar entry in the format yyyy-MM-dd.
     * @param endDate the end date of the calendar entry in the format yyyy-MM-dd.
     * @param firstName the first name of the person associated with this calendar entry.
     * @param lastName the last name of the person associated with this calendar entry.
     * @param email the email address of the person associated with this calendar entry.
     */
    public CalendarEntry(int studioId, String startDate, String endDate, String firstName, String lastName, String email) {
        this.studioId = studioId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
     * Creates a new {@code CalendarEntry} instance using the provided details.
     *
     * @param studioId the ID of the studio associated with this calendar entry.
     * @param startDate the start date of the calendar entry in the format yyyy-MM-dd.
     * @param endDate the end date of the calendar entry in the format yyyy-MM-dd.
     * @param firstName the first name of the person associated with this calendar entry.
     * @param lastName the last name of the person associated with this calendar entry.
     * @param email the email address of the person associated with this calendar entry.
     * @return a new {@code CalendarEntry} instance with the specified details.
     */
    public static CalendarEntry create(int studioId, String startDate, String endDate, String firstName, String lastName, String email) {
        return new CalendarEntry(studioId, startDate, endDate, firstName, lastName, email);
    }
}