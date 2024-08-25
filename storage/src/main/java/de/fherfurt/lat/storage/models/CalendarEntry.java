package de.fherfurt.lat.storage.models;

import de.fherfurt.lat.storage.data.core.AbstractDatabaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDate;

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

    public CalendarEntry(int studioId, String startDate, String endDate, String FirstName, String LastName, String Email) {
        this.studioId = studioId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.firstName = FirstName;
        this.lastName = LastName;
        this.email = Email;
    }

    public static CalendarEntry create(int studioId, String startDate, String endDate, String FirstName, String LastName, String Email)
    {
        return new CalendarEntry(studioId, startDate, endDate, FirstName, LastName, Email);
    }
}
