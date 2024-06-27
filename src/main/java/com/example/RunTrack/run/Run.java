package com.example.RunTrack.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run(Integer id,
        @NotEmpty String title,
        LocalDateTime start,
        LocalDateTime finish,
        @Positive Integer miles,
        Location location) {

    void checkTime(){
        if(start.isAfter(finish))
            throw new IllegalArgumentException("ERROR:: Start time exceeds Finish time");

        if(finish.isBefore(start))
            throw new IllegalArgumentException("ERROR:: Finish time precedes Start time");
    }

//    void checkMiles(){
//        if(miles <= 0)
//            throw new IllegalArgumentException("ERROR:: Miles must be greater than 0.");
//    }
}
