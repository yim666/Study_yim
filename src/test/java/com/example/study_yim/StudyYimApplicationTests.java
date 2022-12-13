package com.example.study_yim;

import com.example.study_yim.Duplicate_Interfice.Inter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class StudyYimApplicationTests {

    @Autowired
    private Inter inter;

    @Test
    void contextLoads() {
        inter.a();
    }

    @Test
    void bigDeci(){
        String reg ="^[1-9]";
        String a= "188.33";
        System.out.println("3".matches(reg));
        System.out.println(new BigDecimal(a));
        List<String> sList = Arrays.asList(new String[]{"aa", "bb", "cc"});
        List<String> collect = sList.stream().filter(s -> "a".equals(s)).collect(Collectors.toList());
        System.out.println(collect.size());
    }
    
    @Test
    void listTest(){
        List<String> a =new ArrayList();
        a.add("1");
        a.add("2");
        a.add("3");
        System.out.println(Arrays.toString(a.toArray()));
        List collect = a.stream().filter(i -> i.equals("2")).collect(Collectors.toList());
        System.out.println(collect);
    }
    
    

}
