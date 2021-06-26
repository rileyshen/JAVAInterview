package com.exa.study.thread;

import java.util.concurrent.TimeUnit;

class MyData {

    int number = 0;

    public void addTo60() {
        this.number = 60;
    }
}

/**
 *1.prove java volatile visibility
 * 1.1 assume int number = 0;  add volatile keyword before changing value of number
 */

public class VolatileDemo {

    public static void main(String[] args) {

        MyData myData = new MyData();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName()+"\t update number"+ myData.number);
        }, "AAA").start();

        // the second main thread
        while(myData.number == 0){
            // main thread would be wait until number is not 0
        }

        System.out.println(Thread.currentThread().getName()+"\t umission is over");
    }
}
