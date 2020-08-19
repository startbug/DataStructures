package com.ggs.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Starbug
 * @Date 2020/8/8 15:01
 */
public class Test {

//    public static volatile int a = 0;

    public static AtomicInteger a=new AtomicInteger(0);
    public static void main(String[] args) {
        Test test = new Test();
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    try {
                        System.out.println(a.incrementAndGet());
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            threads[i].start();
        }
    }
}
