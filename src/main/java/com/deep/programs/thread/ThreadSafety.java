package com.deep.programs.thread;

/**
 * Created by deepanshu.saxena on 04/12/15.
 */

public class ThreadSafety {

    public static void main(String[] args) throws InterruptedException {
        Process process = new Process();
        Thread t1 = new Thread(process, "t1");
        Thread t2 = new Thread(process, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(" count :: " + process.getCount());
    }

}


class Process implements Runnable {

    private int count = 0;

    @Override
    public void run() {

        // synchronized (Process)
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                doSomething();
                count++;
            }
        }
    }

    public int getCount() {
        return count;
    }


    private void doSomething() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
