package ru.max.projects.testmetricsproject.controller;

import io.micrometer.core.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.max.projects.testmetricsproject.Scheduler;
import ru.max.projects.testmetricsproject.TestMetricsProjectApplication;

import java.util.Random;


@RestController
public class LogController {

    @Autowired
    private Scheduler scheduler;

    final static Logger logger = LoggerFactory.getLogger(TestMetricsProjectApplication.class);

    @GetMapping("/something")
    public ResponseEntity<String> createLogs() {
        logger.warn("Just Checking");
        return ResponseEntity.ok().body("All ok");
    }

    @GetMapping("/input1")
//    @Timed("input1")
    public ResponseEntity<String> input1() throws IllegalAccessException, InterruptedException {
        int random = getRandom(0, 3);

        Thread.sleep(random * 1000);

        return ResponseEntity.ok().body("okay");
    }



    private int getRandom(int start, int end) throws IllegalAccessException {
        if (start >= end) {
            throw new IllegalAccessException("max mast be greater than min");
        }

        Random r = new Random();
        return r.nextInt((end - start) + 1) + start;
    }
}
