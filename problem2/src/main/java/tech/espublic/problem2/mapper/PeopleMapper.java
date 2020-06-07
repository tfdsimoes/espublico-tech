package tech.espublic.problem2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tech.espublic.problem2.domain.People;
import tech.espublic.problem2.restClient.resources.people.PeopleResource;

import java.util.List;

import static org.mapstruct.NullValueCheckStrategy.ON_IMPLICIT_CONVERSION;

@Mapper(nullValueCheckStrategy = ON_IMPLICIT_CONVERSION)
public interface PeopleMapper {

    PeopleMapper INSTANCE = Mappers.getMapper(PeopleMapper.class);

    @Mapping( target = "id", ignore = true)
    @Mapping( target = "starshipPeopleList", ignore = true)
    @Mapping( target = "filmPeopleList", ignore = true)
    People peopleResourceToPeople(PeopleResource peopleResource);

    List<People> peopleResourceListToPeopleList(List<PeopleResource> peopleResourceList);
}
