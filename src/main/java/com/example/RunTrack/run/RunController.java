package com.example.RunTrack.run;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

/**
 * @Description RestController class that handles request mapping
 */
@RestController
@RequestMapping("/api/runs")    //All mapping methods in class suffix "/api/runs"
public class RunController {

    private final RunRepository runRepository;
    private static final Logger log = LoggerFactory.getLogger("RunController.class");

    @GetMapping("/home")
    String home(){
        return "HOME 4 RUNZ";
    }


    public RunController(RunRepository runRepository){
        log.info("CP2");
        this.runRepository = runRepository;
    }


    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    void create(@Valid @RequestBody Run run){  //Gets run data from request body
        runRepository.create(run);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void update(@Valid @RequestBody Run run){
        runRepository.update(run, run.id());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable int id){
        runRepository.delete(id);
    }

    @GetMapping
    List<Run> findAll(){
        return runRepository.findAll();
    }

    //PathVariable gets var from path, i.e {id}, and save in arg of SAME NAME
    @GetMapping("/{id}")
    Run findById(@PathVariable int id){
        Optional<Run> run = runRepository.findById(id);

        if(run.isEmpty()){
            throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        }
        return run.get();
    }
}
