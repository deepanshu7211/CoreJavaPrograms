package com.deep.programs.thread;

/**
 * Created by deepanshu.saxena on 02/04/16.
 */
public class DeadlockExample {
    public static void main(String[] args) {
        final String res1 = "abc";
        final String res2 = "def";

        Thread t1 = new Thread() {
            public void run() {
                synchronized (res1) {
                    System.out.println(" Thread 1 acquired locked resource 1 ");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (res2) {
                        System.out.println(" thread 1 locked resource 2");
                    }
                }

            }
        };

        Thread t2 = new Thread() {
            public void run() {
                synchronized (res2) {
                    System.out.println("Thread 2: locked resource 2");

                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }

                    synchronized (res1) {
                        System.out.println("Thread 2: locked resource 1");
                    }
                }
            }
        };

        t1.start();
        t2.start();
    }
}


