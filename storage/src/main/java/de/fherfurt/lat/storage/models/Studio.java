package de.fherfurt.lat.storage.models;

import de.fherfurt.lat.storage.data.core.AbstractDatabaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "studios")
public class Studio extends AbstractDatabaseEntity
{
    private double prizePerDay;
    @ManyToOne
    private Address address;

    public Studio(double prizePerDay, Address address)
    {
        this.prizePerDay = prizePerDay;
        this.address = address;
    }

    public static Studio create(double prizePerDay, Address address) {
        return new Studio(prizePerDay, address);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return Objects.equals(prizePerDay, ((Studio) obj).prizePerDay) && Objects.equals(address, ((Studio) obj).address);
    }
}
