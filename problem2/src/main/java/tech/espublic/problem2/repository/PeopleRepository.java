package tech.espublic.problem2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.espublic.problem2.domain.People;

import java.util.List;
import java.util.stream.Stream;

/**
 * People spring data repository
 */
@Repository
public interface PeopleRepository extends CrudRepository<People, String> {

    Stream<People> readAllBy();

    List<People> findAllByUrlIn(List<String> urlList);


}
