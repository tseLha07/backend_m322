package m320_M322.webcontext.domain.role;


import jakarta.persistence.*;
import m320_M322.config.generics.ExtendedEntity;
import m320_M322.webcontext.domain.authority.Authority;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;

@Entity
@Table(name = "role")
public class Role extends ExtendedEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_authority", joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Authority> authorities;

    public Role() {
        super();
    }

    public String getName() {
        return name;
    }

    public Role setName(String name) {
        this.name = name;
        return this;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public Role setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
        return this;
    }

    @Override
    public String toString() {
        return getName();
    }
}
