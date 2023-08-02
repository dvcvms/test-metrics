package ru.max.projects.testmetricsproject;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class Scheduler {
    private final AtomicInteger testGauge;
    private final Counter testCounter;

    private int privateCounterLog;

    public Scheduler(MeterRegistry meterRegistry) {
        testGauge = meterRegistry.gauge("custom_gauge", new AtomicInteger(0));
        testCounter = meterRegistry.counter("custom_counter");
    }

//    @Counted("random_method")
    @Scheduled(fixedRateString = "1000", initialDelay = 0)
    public void scheduledTask() throws IllegalAccessException {
        privateCounterLog++;
        int randomNumberInRange = getRandomNumberInRange(0, 100);
//        testGauge.set(Scheduler.getRandomNumberInRange(0, 100));

        testGauge.set(randomNumberInRange);
        testCounter.increment();

        log.info("counter: " + privateCounterLog + " | " + "randomValue: " + randomNumberInRange);
    }

    private static int getRandomNumberInRange(int min, int max) throws IllegalAccessException {
        if (min >= max) {
            throw new IllegalAccessException("max mast be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
