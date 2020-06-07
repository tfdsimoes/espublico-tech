package tech.espublic.problem2.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.espublic.problem2.domain.FilmPeople;

import java.util.List;

/**
 * Film People spring data repository
 */
@Repository
public interface FilmPeopleRepository extends CrudRepository<FilmPeople, String> {

    @Query("SELECT fp.people.id as id, fp.people.name as name FROM FilmPeople fp WHERE fp.film.id IN ?1")
    List<PeopleIdName> findAllPeopleByFilmIdIn(List<String> filmIdList);

    interface PeopleIdName {
        String getId();

        String getName();
    }
}
