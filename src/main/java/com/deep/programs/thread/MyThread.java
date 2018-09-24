package com.deep.programs.thread;

/**
 * Created by deepanshu.saxena on 01/02/16.
 */
public class MyThread implements Runnable {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread(), "t1");
        Thread t2 = new Thread(new MyThread(), "t2");
        Thread t3 = new Thread(new MyThread(), "t3");
        System.out.println(" " + t1.getState());
        int[] arr = new int[10];
        System.out.println(int[].class.getSuperclass());
        Thread t = new Thread(new Runnable() {
            public void run() {
                throw new RuntimeException();
            }
        });
        t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("exception " + e + " from thread " + t);
            }
        });
        t.start();


//        Thread t4=new T();
//        t4.start();
//        System.out.println("state :: " + t4.getState());
//
//        t4.run();
//        try {
//            t1.start();
//            t1.run();
//            t1.join();
//            t2.start();
//            t2.join();
//            t3.start();
//            t3.join();

//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println(" All thread exciting... ");
    }

    @Override
    public void run() {
        System.out.println(" Thread Name started :: " + Thread.currentThread().getName());
        try {

            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" Thread Name completed :: " + Thread.currentThread().getName());


    }
}


class T extends Thread {
    @Override
    public synchronized void start() {
//        super.start();
        System.out.println(" over ride start method ");
        run();
    }

    @Override
    public void run() {
        System.out.println(" Thread Name started in T :: " + Thread.currentThread().getName());
    }
}