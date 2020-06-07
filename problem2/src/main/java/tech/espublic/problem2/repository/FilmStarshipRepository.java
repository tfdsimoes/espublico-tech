package tech.espublic.problem2.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.espublic.problem2.domain.FilmStarship;

import java.util.List;
import java.util.Optional;

/**
 * Film Starship spring data repository
 */
@Repository
public interface FilmStarshipRepository extends CrudRepository<FilmStarship, String> {

    @Query("SELECT COUNT(fs.id) as counter, fs.starship.id as starshipId FROM FilmStarship fs WHERE fs.film.id IN ?1 GROUP BY fs.starship ORDER BY counter DESC")
    List<FilmStarshipCounter> getStarshipWithMoreAppearsBasedOnFilm(List<String> filmIdList);

    interface FilmStarshipCounter {
        Integer getCounter();

        String getStarshipId();
    }
}
