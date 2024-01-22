package m320_M322.webcontext.domain.authority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import m320_M322.config.generics.ExtendedEntity;

@Entity
@Table(name = "authority")
public class Authority extends ExtendedEntity {
    @Column(name = "name", nullable = false)
    private String name;

    public Authority() {
        super();
    }

    public String getName() {
        return name;
    }

    public Authority setName(String name) {
        this.name = name;
        return this;
    }
}
