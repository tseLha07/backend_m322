package m320_M322.webcontext.domain.user;

import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Generated(GenerationTime.ALWAYS)
    @Column(name = "id")
    private String id;

    private String firstname;

    private String lastname;

    private String email;

    private String password;




}
