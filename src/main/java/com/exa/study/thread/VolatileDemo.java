package com.exa.study.thread;

import java.util.concurrent.TimeUnit;

class MyData {

    volatile int number = 0;

    public void addTo60() {
        this.number = 60;
    }

    public void addPlusPlus() {
        number++;
    }
}

/**
 *1.prove java volatile visibility
 * 1.1 assume int number = 0;  add volatile keyword before changing value of number
 * 1.2 add volatile keyword to ensure visibility
 *
 *2.This update of a volatile variable is non-atomic
 *  2.1 atomic :
 *      An atomic operation is one that cannot be interrupted by the thread
 *      method was executed successfully or failure
 *  2.2 cannot ≠ atomic :
 */

public class VolatileDemo {

    public static void main(String[] args) {

        MyData myData = new MyData();

        for (int i = 0; i < 20; i++) {

            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData.addPlusPlus();
                }
            }, String.valueOf(i)).start();
        }

        // after Calculating(20 Threads), use main thread to get the finial result
        while (Thread.activeCount() > 2) { // main thread and GC thread at backstage, wait util calculating
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "\t final number value: " + myData.number);

    }

    // volatile guarantees visibility of changes to variables across threads
    public static void seeByVolatile() {
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

        System.out.println(Thread.currentThread().getName()+"\t mission is over, main get number vlaue:" +myData.number);
    }
}
