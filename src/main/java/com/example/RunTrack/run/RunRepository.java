package com.example.RunTrack.run;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

/**
 * @Description Interactis with Postgres database via Spring Data JDBC. Corresponding
 * Object ID field MUST be annotated. NOTE: Object Class and table names MUST be the
 * same!!!
 */
public interface RunRepository extends ListCrudRepository<Run, Integer> {

    //@Query("select * from run where location = :location")
    List<Run> findAllByLocation(String location);
}
