package com.example.study_yim.reflection_api;

public class type {
    public static void main(String[] args) throws ClassNotFoundException {
        //判断class类型是否相同
        String a ="aaa";
        System.out.println(a.getClass() == Class.forName("java.lang.String"));
        System.out.println(a.getClass() ==String.class);
        Integer b=0;
        System.out.println(b.getClass() == Integer.class);
    }
}
