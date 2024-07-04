package com.example.RunTrack.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.time.LocalDateTime;

/**
 * @Description Defines object equivalent of runs DB entries. Uses Spring validate
 *              annotations for validation checks
 * @param id
 * @param title
 * @param start
 * @param finish
 * @param miles
 * @param location
 */
public record Run(
        //Annotation 4 RunRepository
        @Id
        Integer id,
        @NotEmpty String title,
        LocalDateTime start,
        LocalDateTime finish,
        @Positive Integer miles,
        Location location,
        @Version
        Integer version) {

    /**
     * @Description Throws exceptions if start time exceeds finish time and vice versa
     */
    void checkTime(){
        if(start.isAfter(finish))
            throw new IllegalArgumentException("ERROR:: Start time exceeds Finish time");

        if(finish.isBefore(start))
            throw new IllegalArgumentException("ERROR:: Finish time precedes Start time");
    }
}
