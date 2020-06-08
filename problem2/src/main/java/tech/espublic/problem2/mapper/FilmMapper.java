package tech.espublic.problem2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tech.espublic.problem2.domain.Film;
import tech.espublic.problem2.restClient.resources.film.FilmResource;

import java.util.List;

import static org.mapstruct.NullValueCheckStrategy.ON_IMPLICIT_CONVERSION;

/**
 * Interface responsible to map {@link FilmResource} to {@link Film}
 */
@Mapper(nullValueCheckStrategy = ON_IMPLICIT_CONVERSION)
public interface FilmMapper {

    FilmMapper INSTANCE = Mappers.getMapper(FilmMapper.class);

    @Mapping( target = "id", ignore = true)
    @Mapping( target = "filmStarshipList", ignore = true)
    @Mapping( target = "filmPeople", ignore = true)
    Film filmResourceToFilm(FilmResource filmResource);

    List<Film> filmResourceListToFilmList(List<FilmResource> filmResourceList);
}
