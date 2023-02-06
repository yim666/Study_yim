package com.example.study_yim.reflection_api;

import com.example.study_yim.reflection_api.po.Users;

import java.lang.reflect.Field;

public class type {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException {
        //判断class类型是否相同
        String a ="aaa";
        System.out.println(a.getClass() == Class.forName("java.lang.String"));
        System.out.println(a.getClass() ==String.class);
        Integer b=0;
        System.out.println(b.getClass() == Integer.class);
        Users user = new Users();
        user.setName("yh");
        user.setAge("19");
        user.setClassRoom("1");
        Field[] fields = user.getClass().getDeclaredFields();
        for(Field f:fields){
            f.setAccessible(true); //开启后可以获取对象私有属性的值
            System.out.println("获取类的字段名"+f.getName());
            System.out.println("获取当前对象当前字段的值"+f.get(user));
        }
    }
}
