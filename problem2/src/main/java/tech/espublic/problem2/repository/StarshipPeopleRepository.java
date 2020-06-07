package tech.espublic.problem2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.espublic.problem2.domain.StarshipPeople;

/**
 * Starship People spring data repository
 */
@Repository
public interface StarshipPeopleRepository extends CrudRepository<StarshipPeople, String> {
}
