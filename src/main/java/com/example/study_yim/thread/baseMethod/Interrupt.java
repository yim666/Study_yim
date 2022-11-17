package com.example.study_yim.thread.baseMethod;

//interupt 中断线程阻塞  通过中断异常逃离阻塞； 实际是发送一个异常信号给阻塞的位置  使线程逃离阻塞
public class Interrupt {
    public static void main(String[] args) {

     Thread a=   new Thread(){
          public void run(){
              System.out.println("aaa开始");
              try {
                  Thread.sleep(99999);
                  System.out.println("aaaaaaa");
              } catch (InterruptedException e) {
                  System.out.println("aaa，，，sleep中断");
              }
              System.out.println("aaa结束");
          }
        };


        Thread b=   new Thread(){
            public void run(){
                System.out.println("bbb开始");
                try {
                    Thread.sleep(9);
                } catch (InterruptedException e) {
                    System.out.println("sleep中断bb");
                }
                System.out.println("bbb正常结束 打断a");
                a.interrupt();
            }
        };

        b.start();
        a.start();

    }
}
