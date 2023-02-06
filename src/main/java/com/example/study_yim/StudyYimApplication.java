package com.example.study_yim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages="com.example.study_yim.ServletFiliter")
public class StudyYimApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyYimApplication.class, args);
    }

}
