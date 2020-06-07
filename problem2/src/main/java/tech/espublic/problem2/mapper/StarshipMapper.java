package tech.espublic.problem2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tech.espublic.problem2.domain.Starship;
import tech.espublic.problem2.restClient.resources.starship.StarshipResource;

import java.util.List;

import static org.mapstruct.NullValueCheckStrategy.ON_IMPLICIT_CONVERSION;

@Mapper(nullValueCheckStrategy = ON_IMPLICIT_CONVERSION)
public interface StarshipMapper {

    StarshipMapper INSTANCE = Mappers.getMapper(StarshipMapper.class);

    @Mapping( target = "id", ignore = true)
    @Mapping( target = "starshipPeopleList", ignore = true)
    @Mapping( target = "filmStarshipList", ignore = true)
    Starship starshipResourceToStarship(StarshipResource starshipResource);

    List<Starship> starshipListResourceToStarshipList(List<StarshipResource> starshipResourceList);
}
