package m320_M322.webcontext.domain.authority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import m320_M322.config.generics.ExtendedEntity;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "authority")
public class Authority extends ExtendedEntity {
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    public Authority(UUID id, String name) {
        super(id);
        this.name = name;
    }
}
