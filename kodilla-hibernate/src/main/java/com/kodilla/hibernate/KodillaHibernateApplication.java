package com.kodilla.hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan("com.kodilla.hibernate.manytomany")
@EnableAutoConfiguration

public class KodillaHibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(KodillaHibernateApplication.class, args);
    }

}
