package models.dto;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    private Long id;

    private String role;

    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;


    //constructors
    public Role() {};

    public Role(Long id, String name) {
        this.id = id;
        this.role = name;
    }

    //@Override methods

    @Override
    public String getAuthority() {
        return role;
    }
}
