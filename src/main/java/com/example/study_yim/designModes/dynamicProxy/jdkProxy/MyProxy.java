package com.example.study_yim.designModes.dynamicProxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyProxy implements InvocationHandler {
    private Object target;

    public MyProxy(Object target){
        this.target=target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before Invoke");
        Object result = method.invoke(target, args);
        System.out.println("after Invoke");
        return result;
    }
}
