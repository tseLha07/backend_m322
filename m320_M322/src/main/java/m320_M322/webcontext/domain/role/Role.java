package m320_M322.webcontext.domain.role;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import m320_M322.config.generics.ExtendedEntity;
import m320_M322.webcontext.domain.authority.Authority;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "role")
public class Role extends ExtendedEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_authority", joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Authority> authorities;

    public Role(UUID id, String name, Set<Authority> authorities){
        super(id);
        this.name = name;
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return getName();
    }

}
