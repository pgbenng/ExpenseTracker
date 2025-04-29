package server.entity;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {
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
}
