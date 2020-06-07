package tech.espublic.problem2.mapper;

import org.junit.jupiter.api.Test;
import tech.espublic.problem2.domain.Starship;
import tech.espublic.problem2.restClient.resources.starship.StarshipResource;
import tech.espublic.problem2.util.AuxiliarBuilderObjects;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Class to test {@link StarshipMapper}
 */
class StarshipMapperTest {

    @Test
    void starshipResourceToStarship() {
        StarshipResource starshipResource = AuxiliarBuilderObjects.buildDefaultStarshipResource();

        Starship starship = StarshipMapper.INSTANCE.starshipResourceToStarship(starshipResource);

        verifyStarshipResourceAgainstStarship(starshipResource, starship);
    }

    @Test
    void starshipListResourceToStarshipList() {
        List<StarshipResource> starshipResourceList = new ArrayList<>();
        starshipResourceList.add(AuxiliarBuilderObjects.buildDefaultStarshipResource());
        starshipResourceList.add(AuxiliarBuilderObjects.buildDefaultStarshipResource());
        starshipResourceList.add(AuxiliarBuilderObjects.buildDefaultStarshipResource());

        List<Starship> starshipList = StarshipMapper.INSTANCE.starshipListResourceToStarshipList(starshipResourceList);

        for (int i = 0; i < starshipList.size(); i++) {
            verifyStarshipResourceAgainstStarship(starshipResourceList.get(i), starshipList.get(i));
        }
    }

    /**
     * Aux function to verify {@link StarshipResource} agains {@link Starship}
     *
     * @param starshipResource {@link StarshipResource}
     * @param starship         {@link Starship}
     */
    private void verifyStarshipResourceAgainstStarship(StarshipResource starshipResource, Starship starship) {
        assertNull(starship.getId());

        assertEquals(starship.getCargoCapacity(), starshipResource.getCargoCapacity());
        assertEquals(starship.getConsumables(), starshipResource.getConsumables());
        assertEquals(starship.getCostInCredits(), starshipResource.getCostInCredits());
        assertEquals(starship.getCrew(), starshipResource.getCrew());
        assertEquals(starship.getHyperdriveRating(), starshipResource.getHyperdriveRating());
        assertEquals(starship.getLength(), starshipResource.getLength());
        assertEquals(starship.getManufacturer(), starshipResource.getManufacturer());
        assertEquals(starship.getMaxAtmospheringSpeed(), starshipResource.getMaxAtmospheringSpeed());
        assertEquals(starship.getMGLT(), starshipResource.getMGLT());
        assertEquals(starship.getModel(), starshipResource.getModel());
        assertEquals(starship.getName(), starshipResource.getName());
        assertEquals(starship.getPassengers(), starshipResource.getPassengers());
        assertEquals(starship.getStarshipClass(), starshipResource.getStarshipClass());

        assertEquals(0, starship.getStarshipPeopleList().size());
        assertEquals(0, starship.getFilmStarshipList().size());
    }


}
