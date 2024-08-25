package de.fherfurt.lat.storage.models;

import de.fherfurt.lat.storage.data.core.AbstractDatabaseEntity;
import lombok.*;

import javax.persistence.Entity;
import java.util.Objects;

/**
 * Represents a studio entity in the system.
 * <p>
 * The {@code Studio} class extends {@link AbstractDatabaseEntity} and maps to the "studios" table in the database.
 * It contains information about the studio's price per day and its associated address.
 * </p>
 */
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "studios")
public class Studio extends AbstractDatabaseEntity {

    private double prizePerDay;
    private int addressId;

    /**
     * Constructs a new {@code Studio} with the specified price per day and address ID.
     *
     * @param prizePerDay the price per day for renting the studio.
     * @param addressId the ID of the address associated with the studio.
     */
    public Studio(double prizePerDay, int addressId) {
        this.prizePerDay = prizePerDay;
        this.addressId = addressId;
    }

    /**
     * Creates a new {@code Studio} instance using the provided details.
     *
     * @param prizePerDay the price per day for renting the studio.
     * @param addressId the ID of the address associated with the studio.
     * @return a new {@code Studio} instance with the specified details.
     */
    public static Studio create(double prizePerDay, int addressId) {
        return new Studio(prizePerDay, addressId);
    }

    /**
     * Compares this studio to the specified object for equality.
     * <p>
     * Two studios are considered equal if their price per day and address ID are the same.
     * </p>
     *
     * @param obj the object to compare this studio to.
     * @return {@code true} if the specified object is equal to this studio; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Studio studio = (Studio) obj;
        return Double.compare(studio.prizePerDay, prizePerDay) == 0 &&
                addressId == studio.addressId;
    }

    /**
     * Returns a hash code value for this studio.
     * <p>
     * The hash code is computed based on the price per day and address ID of the studio.
     * </p>
     *
     * @return a hash code value for this studio.
     */
    @Override
    public int hashCode() {
        return Objects.hash(prizePerDay, addressId);
    }

    /**
     * Returns a string representation of this studio.
     * <p>
     * The string representation includes the price per day and the address ID.
     * </p>
     *
     * @return a string representation of this studio.
     */
    @Override
    public String toString() {
        return String.format("Studio{prizePerDay=%f, addressId=%d}", prizePerDay, addressId);
    }
}