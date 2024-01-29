package m320_M322.webcontext.domain.movie;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import m320_M322.config.generics.ExtendedEntity;

import java.time.LocalDate;

@Entity
@Table(name = "movies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Movie extends ExtendedEntity {


    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "genre")
    private String genre;

    @NotNull
    @Column(name = "cast")
    private String cast;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @NotNull
    @Column(name = "summary")
    private String summary;

    @NotNull
    @Column(name = "image")
    private String imageURL;

}
