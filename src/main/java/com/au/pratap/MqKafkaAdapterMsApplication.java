package com.au.pratap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

/**
 * @author Pratap
 */
@SpringBootApplication
public class MqKafkaAdapterMsApplication {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(MqKafkaAdapterMsApplication.class, args);
    }

}
