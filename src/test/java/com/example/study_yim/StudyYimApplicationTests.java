package com.example.study_yim;

import com.example.study_yim.Duplicate_Interfice.Inter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudyYimApplicationTests {

    @Autowired
    private Inter inter;

    @Test
    void contextLoads() {
        inter.a();
    }

}
