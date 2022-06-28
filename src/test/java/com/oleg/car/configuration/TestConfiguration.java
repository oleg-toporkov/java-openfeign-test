package com.oleg.car.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@EnableFeignClients(basePackages = {"com.oleg.car.api"})
@EnableAutoConfiguration
@PropertySource("classpath:/application.properties")
@Configuration
@ComponentScan(basePackages = {"com.oleg.car"})
public class TestConfiguration {
}
