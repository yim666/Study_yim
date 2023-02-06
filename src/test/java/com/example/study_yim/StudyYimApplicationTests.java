package com.example.study_yim;

import com.example.study_yim.Duplicate_Interfice.Inter;
import com.example.study_yim.app.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
class StudyYimApplicationTests {

    @Autowired
    private Inter inter;

    @Autowired
    private Student st;
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
        a.add(0,"1");
//        a.add("2");
//        a.add("3");
        System.out.println(Arrays.toString(a.toArray()));
        List collect = a.stream().filter(i -> i.equals("2")).collect(Collectors.toList());
        System.out.println(new ArrayList(){{add("adad");}});
    }

    @Test
    void localTest(){
        Date date1 = new Date();
        System.out.println(date1);
//        Locale.setDefault(Locale.US);
        Locale aDefault = Locale.getDefault();
        Date date = new Date();
        System.out.println(aDefault);
    }

    @Test
    void stu(){
        int[] a = new int[10];
        a[0]=1;
        System.out.println(a[1]);
    }

    @Test
    void mapTest(){
        HashMap<String, Object> m = new HashMap<>();
        m.put("a","aaaa");
        m.put("b",111);
        System.out.println((String) m.get("a")+10);
    }
    


}
