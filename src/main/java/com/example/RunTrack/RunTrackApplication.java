package com.example.RunTrack;

import com.example.RunTrack.run.Location;
import com.example.RunTrack.run.Run;
import com.example.RunTrack.run.RunRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class RunTrackApplication {

	private static final Logger log = LoggerFactory.getLogger("RunTrackApplication.class");

	public static void main(String[] args) {

		SpringApplication.run(RunTrackApplication.class, args);
		log.info("App Started");
	}


//	@Bean
//	CommandLineRunner runner(RunRepository runRepository){
//		log.info("CP1");
//		return args -> {
//			Run run = new Run(10001, "Monday Test Run", LocalDateTime.now(), LocalDateTime.now(), 2, Location.OUTDOOR);
//			runRepository.create(run);
//		};
//	}

}
