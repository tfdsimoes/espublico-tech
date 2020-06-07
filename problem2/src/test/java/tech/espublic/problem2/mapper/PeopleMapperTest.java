package tech.espublic.problem2.mapper;

import org.junit.jupiter.api.Test;
import tech.espublic.problem2.domain.People;
import tech.espublic.problem2.restClient.resources.people.PeopleResource;
import tech.espublic.problem2.util.AuxiliarBuilderObjects;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Class that test the {@link PeopleMapper}
 */
class PeopleMapperTest {

    @Test
    void peopleResourceToPeople() {
        PeopleResource peopleResource = AuxiliarBuilderObjects.buildDefaultPeopleResource();

        People people = PeopleMapper.INSTANCE.peopleResourceToPeople(peopleResource);

        verifyPeopleResourceAgainstPeople(peopleResource, people);
    }

    @Test
    void peopleResourceListToPeopleList() {
        List<PeopleResource> peopleResourceList = new ArrayList<>();
        peopleResourceList.add(AuxiliarBuilderObjects.buildDefaultPeopleResource());
        peopleResourceList.add(AuxiliarBuilderObjects.buildDefaultPeopleResource());
        peopleResourceList.add(AuxiliarBuilderObjects.buildDefaultPeopleResource());

        List<People> peopleList = PeopleMapper.INSTANCE.peopleResourceListToPeopleList(peopleResourceList);

        for (int i = 0; i < peopleList.size(); i++) {
            verifyPeopleResourceAgainstPeople(peopleResourceList.get(i), peopleList.get(i));
        }
    }

    /**
     * Aux function to verify {@link PeopleResource} agains {@link People}
     *
     * @param peopleResource {@link PeopleResource}
     * @param people         {@link People}
     */
    private void verifyPeopleResourceAgainstPeople(PeopleResource peopleResource, People people) {

        assertNull(people.getId());

        assertEquals(people.getBirthYear(), peopleResource.getBirthYear());
        assertEquals(people.getEyeColor(), peopleResource.getEyeColor());
        assertEquals(people.getGender(), peopleResource.getGender());
        assertEquals(people.getHairColor(), peopleResource.getHairColor());
        assertEquals(people.getHeight(), peopleResource.getHeight());
        assertEquals(people.getMass(), peopleResource.getMass());
        assertEquals(people.getName(), peopleResource.getName());
        assertEquals(people.getSkinColor(), peopleResource.getSkinColor());

        assertEquals(0, people.getStarshipPeopleList().size());
        assertEquals(0, people.getFilmPeopleList().size());

    }
}
