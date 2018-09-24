package com.deep.programs.thread;

/**
 * Created by deepanshu.saxena on 04/02/16.
 */
public class OddEven {
    private int number;

    public static void main(String[] args) {
        OddEven oddEven = new OddEven();
        OddEven oddEven1 = new OddEven();
        Thread t1 = new Thread(new Odd(oddEven), "odd");
        Thread t2 = new Thread(new Even(oddEven), "even");
        t2.start();
        t1.start();

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

class Odd implements Runnable {
    OddEven odd;

    public Odd(OddEven odd) {
        this.odd = odd;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (odd) {
            for (int i = 1; i <= 10; i = i + 2) {
                System.out.println(name + " " + i);
                odd.notify();
                try {
                    odd.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

class Even implements Runnable {

    OddEven even;

    public Even(OddEven even) {
        this.even = even;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (even) {
            for (int i = 2; i <= 10; i = i + 2) {
                try {
                    even.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + " " + i);
                even.notify();
            }
        }
    }
}