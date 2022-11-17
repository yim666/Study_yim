package com.example.study_yim.thread.baseMethod;

//守护线程
public class daemon {
    public static void main(String[] args) {
        Thread rose = new Thread() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("rose:let me go!!");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                }
                System.out.println("rose:啊啊啊啊啊啊啊AAAAAAAAAAAaaaaaaa......结束");
                System.out.println("噗通!");
            }
        };

        Thread b = new Thread() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("bbb!!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
                System.out.println("bbb结束咯");
            }
        };

        rose.start();

        //若b设为守护线程,则主线程结束后 不管b是否执行完毕 都要结束
//        b.setDaemon(true);
        b.start();
        System.out.println("主线程结束，非守护线程继续，守护线程结束");
    }
}
