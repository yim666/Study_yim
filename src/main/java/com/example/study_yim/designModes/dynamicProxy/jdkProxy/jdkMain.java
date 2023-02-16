package com.example.study_yim.designModes.dynamicProxy.jdkProxy;

import java.lang.reflect.Proxy;

public class jdkMain {
    public static void main(String[] args) {
        Object myclass = new Myclass();
        MyProxy myProxy = new MyProxy(myclass);
        //动态代理代理的是接口 必须指定接口
        MyInterface o = (MyInterface) Proxy.newProxyInstance(myclass.getClass().getClassLoader(), myclass.getClass().getInterfaces(),
                myProxy);
        o.testMethod();
    }
}
