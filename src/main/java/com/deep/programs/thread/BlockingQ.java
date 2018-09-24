package com.deep.programs.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by deepanshu.saxena on 04/02/16.
 */
public class BlockingQ {
	public static void main(String[] args) {
		BlockingQueue<Msg> queue = new ArrayBlockingQueue<>(5);
		Thread prod = new Thread(new Prod(queue));
		Thread cons = new Thread(new Cons(queue));
		prod.start();
		cons.start();

	}

}

class Msg {
	private String msg;

	public Msg(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}

class Prod implements Runnable {

	private BlockingQueue<Msg> queue;

	public Prod(BlockingQueue<Msg> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			Msg msg = new Msg(" " + i);
			try {
				Thread.sleep(i);
				queue.put(msg);
				System.out.println("Produced :: " + msg.getMsg());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		Msg msg = new Msg("exit");
		try {
			queue.put(msg);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Cons implements Runnable {

	private BlockingQueue<Msg> queue;

	public Cons(BlockingQueue<Msg> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Msg msg;

		try {

			while ((msg = queue.take()).getMsg() != "exit") {
				msg = queue.take();
				Thread.sleep(10);
				System.out.println("Consumed :: " + msg.getMsg());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}