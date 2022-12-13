package com.example.study_yim.Duplicate_Interfice;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
// 表示最优先
public class Cla2 implements Inter{
    @Override
    public void a() {
        System.out.println("222aaa");
    }

    @Override
    public void b() {
        System.out.println("222bbb");

    }
}
