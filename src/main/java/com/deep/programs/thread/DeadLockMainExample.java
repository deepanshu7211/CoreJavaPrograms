package com.deep.programs.thread;

public class DeadLockMainExample {
	public static void main(String[] args) {
		try {
			System.out.println(" Entring into DeadLock State ");
			Thread.currentThread().join();
			System.out.println(" This statement will never execute ");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
