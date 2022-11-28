package com.example.study_yim.thread.baseMethod;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 1. 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，
 * 其他线程对 “该对象” 的所有“synchronized方法”或者“synchronized代码块”的访问将被阻塞。
 *
 * 2. 当一个线程访问 “某对象” 的“synchronized方法”或者“synchronized代码块”时，
 * 其他线程仍然可以访问 “该对象” 的非同步代码块。
 * */
public class sync {
    public static void main(String[] args) {
        A a = new A();
        A b = new A();
        new Thread(()->{
           a.a();
        }).start();
        new Thread(()->{
            a.b();
        }).start();
    }
}
class A{
    Lock lock=new ReentrantLock();
    public synchronized void a(){
        System.out.println("aaa开始");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("aaa结束");
    }

    public  void b(){
        try {
            lock.lock();
            System.out.println("bbb开始");
            Thread.sleep(1000);
            System.out.println("bbb结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}