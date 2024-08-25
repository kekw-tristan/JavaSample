package de.fherfurt.lat.storage.models;

import de.fherfurt.lat.storage.data.core.AbstractDatabaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "studios")
public class Studio extends AbstractDatabaseEntity
{
    private double prizePerDay;
    private int addressId;

    public Studio(double prizePerDay, int addressId)
    {
        this.prizePerDay = prizePerDay;
        this.addressId = addressId;
    }

    public static Studio create(double prizePerDay, int addressId) {
        return new Studio(prizePerDay, addressId);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return Objects.equals(prizePerDay, ((Studio) obj).prizePerDay) && Objects.equals(addressId, ((Studio) obj).addressId);
    }
}
