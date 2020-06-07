package tech.espublic.problem2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.espublic.problem2.domain.Film;

/**
 * Film spring data repository
 */
@Repository
public interface FilmRepository extends CrudRepository<Film, String> {

}
