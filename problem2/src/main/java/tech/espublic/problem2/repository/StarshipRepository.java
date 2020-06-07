package tech.espublic.problem2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.espublic.problem2.domain.Starship;

import java.util.List;

/**
 * Starship spring data repository
 */
@Repository
public interface StarshipRepository extends CrudRepository<Starship, String> {

    List<Starship> findAllByUrlIn(List<String> urlList);
}
