package com.example.RunTrack.run;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Repository
public class JdbcClientRunRepository {

    private static final Logger log = LoggerFactory.getLogger("RunRepository.class");

    private final JdbcClient jdbcClient;

    //JdbcClient Dependency Injection
    public JdbcClientRunRepository(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }


    List<Run> findAll(){
        //Runs query, maps result to Run objects and returns in a list
        return jdbcClient.sql("select * from runs").
                query(Run.class).
                list();
    }

    public Optional<Run> findById(Integer id) {
        return jdbcClient.sql("SELECT id,title,start,finish,miles,location FROM runs WHERE id = :id" )
                .param("id", id)
                .query(Run.class)
                .optional();
    }

    public void create(Run run) {
        var updated = jdbcClient.sql("INSERT INTO runs(id,title,start,finish,miles,location) values(?,?,?,?,?,?)")
                .params(List.of(run.id(),run.title(),run.start(),run.finish(),run.miles(),run.location().toString()))
                .update();

        Assert.state(updated == 1, "Failed to create run " + run.title());
    }

    public void update(Run run, Integer id) {
        var updated = jdbcClient.sql("update runs set title = ?, start = ?, finish = ?, miles = ?, location = ? where id = ?")
                .params(List.of(run.title(),run.start(),run.finish(),run.miles(),run.location().toString(), id))
                .update();

        Assert.state(updated == 1, "Failed to update run " + run.title());
    }

    public void delete(Integer id) {
        var updated = jdbcClient.sql("delete from runs where id = :id")
                .param("id", id)
                .update();

        Assert.state(updated == 1, "Failed to delete run " + id);
    }

    public int count() {
        return jdbcClient.sql("select * from runs").query().listOfRows().size();
    }

    public void saveAll(List<Run> runs) {
        runs.stream().forEach(this::create);
    }

    public List<Run> findByLocation(String location) {
        return jdbcClient.sql("select * from runs where location = :location")
                .param("location", location)
                .query(Run.class)
                .list();
    }
}
