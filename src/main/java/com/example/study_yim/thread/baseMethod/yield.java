package com.example.study_yim.thread.baseMethod;

//yield 让出当前剩余时间片 但是再次分配到时间片还会继续执行 不会被中断 （主要作用：避免占用过多资源 给其他线程运行机会）
//sleep 一段时间内不在分配时间片 可以被中断

public class yield {
    public static void main(String[] args) {
        buy bbb = new buy();
        Thread a=   new Thread(){
            public void run(){
                for (int a =100;a>0;a--){
                    bbb.g();
                }
            }
        };


        Thread b=   new Thread(){
            public void run(){
                for (int a =100;a>0;a--){
                    bbb.g();
                }
            }
        };

        b.start();
        a.start();
    }


}
class buy{
    private Integer count =100;
    public void g(){
        if(count == 0){
            System.out.println("aaaaaaaaaaaaaaaaa");
        }
        Thread.yield();
        System.out.println(Thread.currentThread().getName() +"还有："+count--);

    }
}