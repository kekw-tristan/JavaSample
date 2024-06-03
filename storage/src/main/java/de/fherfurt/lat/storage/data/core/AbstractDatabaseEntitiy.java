package de.fherfurt.lat.storage.data.core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Inheritance( strategy =  InheritanceType.TABLE_PER_CLASS )
public class AbstractDatabaseEntitiy
{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;

    @PrePersist
    public void onCreate() {
        this.created = new Date();
        this.modified = new Date();
    }

    @PreUpdate
    public void onUpdate() {
        this.modified = new Date();
    }

}
