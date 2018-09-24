package com.deep.programs.thread;

/**
 * Created by deepanshu.saxena on 02/02/16.
 */

public class Message {
    private String msg;

    public Message(String msg) {
        this.msg = msg;
    }

    public static void main(String[] args) {
        Message msg = new Message("process it");
        Thread waiter = new Thread(new Waiter(msg), "waiter");
        Thread notifier = new Thread(new Notifier(msg), "notifer");

        waiter.start();
        notifier.start();

    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

class Waiter implements Runnable {
    Message msg;

    public Waiter(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        System.out.println("Waiter Thread " + Thread.currentThread().getName() + " state " + Thread.currentThread().getState());
        synchronized (msg) {
            System.out.println("Waiting to get notified.. ");
            try {
                msg.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "  Waiter get notified... " + msg.getMsg());
        }

    }
}

class Notifier implements Runnable {
    Message msg;

    public Notifier(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + "  started ");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (msg) {
            msg.setMsg("Notifier work done... ");
            msg.notify();
        }
    }
}
