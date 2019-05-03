package com.deep.programs.thread;

/**
 * Created by deepanshu.saxena on 02/02/16.
 */
public class ProducerConsumer {
    int count;

    public static void main(String[] args) {
        ProducerConsumer prodCons = new ProducerConsumer();
        Thread produces = new Thread(new Producer(prodCons), "producer");
        Thread consumes = new Thread(new Consumer(prodCons), "consumer");
        consumes.start();
        produces.start();

    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

class Consumer implements Runnable {
    ProducerConsumer prodCons;


    public Consumer(ProducerConsumer prodCons) {
        this.prodCons = prodCons;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();

        System.out.println(name + "  started.. ");
        synchronized (prodCons) {
        	
            try {
            	Thread.sleep(1000);
                System.out.println(" waiting for prod");
                for (int i = 0; i < 10; i++) {
                	
                    prodCons.wait();
                    System.out.println(name + " notified and consumed :: " + prodCons.getCount());
                    prodCons.notify();


                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer implements Runnable {

    ProducerConsumer prodCons;

    public Producer(ProducerConsumer prodCons) {
        this.prodCons = prodCons;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " Producer started ");

        synchronized (prodCons) {
            for (int i = 0; i < 10; i++) {

                prodCons.setCount(i);
                System.out.println(name + "  Produced :: " + prodCons.getCount());

                prodCons.notify();

                try {
                    prodCons.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}


