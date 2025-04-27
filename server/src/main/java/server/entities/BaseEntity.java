package server.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    @Id
    @SequenceGenerator(
            name = "GlobalSequence",
            sequenceName = "GlobalIdSequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GlobalSequence")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
