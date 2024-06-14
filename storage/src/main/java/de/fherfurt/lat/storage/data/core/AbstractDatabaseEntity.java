package de.fherfurt.lat.storage.data.core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance( strategy =  InheritanceType.TABLE_PER_CLASS )
public abstract class AbstractDatabaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected int id;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date created;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date modified;

    @PrePersist
    public void onCreate()
    {
        this.created = new Date();
        this.modified = new Date();
    }

    @PreUpdate
    public void onUpdate()
    {
        this.modified = new Date();
    }
}
