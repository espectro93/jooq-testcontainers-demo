package com.espectro93.jooqdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class JooqDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JooqDemoApplication.class, args);
    }

}
