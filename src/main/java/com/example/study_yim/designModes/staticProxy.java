package com.example.study_yim.designModes;

//静态代理
public class staticProxy {
    interface Subject {
        void request();
    }

    static class RealSubject implements Subject {
        @Override
        public void request() {
            System.out.println("RealSubject");
        }
    }

    static class Proxy implements Subject {
        private Subject subject;

        public Proxy() {
        }
        public Proxy(Subject subject) {
            this.subject = subject;
        }

        @Override
        public void request() {
            System.out.println("Before");
            subject.request();
            System.out.println("After");
        }
    }
}

class StaticProxy {
    public static void main(String[] args) {
        staticProxy.Subject subject = new staticProxy.RealSubject();
        staticProxy.Proxy proxy = new staticProxy.Proxy(subject);
        proxy.request();
    }
}