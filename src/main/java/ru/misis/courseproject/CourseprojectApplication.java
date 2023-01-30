package ru.misis.courseproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class CourseprojectApplication {
    public static void main(String[] args) {
        SpringApplication.run(CourseprojectApplication.class, args);
    }

}
