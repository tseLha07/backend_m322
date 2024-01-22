package m320_M322.webcontext.domain.movie.mapper;


import m320_M322.config.generics.ExtendedDTOMapper;
import m320_M322.webcontext.domain.movie.Movie;
import m320_M322.webcontext.domain.movie.MovieDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface MovieMapper extends ExtendedDTOMapper<Movie, MovieDTO> {
}