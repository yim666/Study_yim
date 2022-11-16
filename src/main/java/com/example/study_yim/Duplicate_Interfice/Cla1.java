package com.example.study_yim.Duplicate_Interfice;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class Cla1 implements Inter{
    @Override
    public void a() {
        System.out.println("111aaa");
    }

    @Override
    public void b() {
        System.out.println("111bbb");
    }
}
