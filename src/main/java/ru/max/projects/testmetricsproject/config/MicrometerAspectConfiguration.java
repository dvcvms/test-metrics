package ru.max.projects.testmetricsproject.config;

import io.micrometer.core.aop.CountedAspect;
import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class MicrometerAspectConfiguration {

//    @Bean
//    public CountedAspect countedAspect(MeterRegistry registry) {
//        return new CountedAspect(registry);
//    }
//
//    @Bean
//    public TimedAspect timedAspect(MeterRegistry registry) {
//        return new TimedAspect(registry);
//    }
}
