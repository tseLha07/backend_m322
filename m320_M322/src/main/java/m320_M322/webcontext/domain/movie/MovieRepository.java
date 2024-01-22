package m320_M322.webcontext.domain.movie;

import m320_M322.config.generics.ExtendedJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends ExtendedJpaRepository<Movie> {
}
