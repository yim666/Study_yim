package com.example.study_yim.app.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
//@PropertySource(value = "classpath:application.yml")
@ConfigurationProperties(prefix = "stu") //只有容器中的bean才能使用此注解 & 使用时需要Autoried的对象才行 new的不行 & 需要@Data
public class Student {
//    @Value("${stu.name}")
    private String name;
    private Integer age;
    private String cla;
    private String teacherName;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cla='" + cla + '\'' +
                ", teacherName='" + teacherName + '\'' +
                '}';
    }
}
