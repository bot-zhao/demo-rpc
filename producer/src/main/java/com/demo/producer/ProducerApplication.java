package com.demo.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhaocc
 * @version 1.0
 * @date 2024-12-04 19:34
 */
@SpringBootApplication(scanBasePackages = {"com.demo.**"})
public class ProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }
}
