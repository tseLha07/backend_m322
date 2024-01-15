package m320_M322.webcontext.domain.genre;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Generated(GenerationTime.ALWAYS)
    @Column(name = "id")
    private String id;

    @Getter
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;

    public Genre(String name){
        this.name = name;
    }

    public Genre() {}
}
