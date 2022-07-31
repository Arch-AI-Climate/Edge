package com.iotinfra.edge.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.stream.messaging.Processor;

/**
 *  Configuration for the Spring Cloud Stream library
 */
@Configuration
@EnableBinding(Processor.class)
public class SpringCloudStreamConfig {

}
