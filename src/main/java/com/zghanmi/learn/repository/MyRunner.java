package com.zghanmi.learn.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.zghanmi.learn.entity.ThemeParkRide;

@Component
public class MyRunner implements CommandLineRunner {


    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    private ThemeParkRideRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        repository.save(new ThemeParkRide("Rollercoaster", "Train ride that speeds you along.", 5, 3));
        repository.save(new ThemeParkRide("Log flume", "Boat ride with plenty of splashes.", 3, 2));
        repository.save(new ThemeParkRide("Teacups", "Spinning ride in a giant tea-cup.", 2, 4));
        
        repository.findAll().forEach((themePark) -> {
            logger.info("{}", themePark);
        });
    }

}
