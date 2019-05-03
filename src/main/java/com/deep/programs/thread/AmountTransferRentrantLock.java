package com.deep.programs.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class AmountTransferRentrantLock {

	 public static void main(String[] args) {
	        Account from = new Account();
	        from.setBalance(20000);
	        from.setName(" Deepanshu ");
	        Account to = new Account();
	        to.setName(" Sangeeta ");
	        to.setBalance(10000);

	        AccountTransfer transfer = new AccountTransfer();
	        Runnable a = new Runnable(){
	            public void run()
	            {
	                try {
	                    Thread.sleep(1000);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	                transfer.transfer(from, to, 200);
	                System.out.println(Thread.currentThread().getName() +" says :: Transfer successfull");
	            }
	        };
	        Runnable b = new Runnable(){
	            public void run()
	            {
	                try {
	                    Thread.sleep(1000);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	                transfer.transfer(to, from, 1000);
	                System.out.println(Thread.currentThread().getName() +" says :: Transfer successfull");
	            }
	        };

	        ExecutorService service = Executors.newFixedThreadPool(2);
	        service.submit(a);
	        service.submit(b);

	        service.shutdown();


	    }
	}



	class AccountTransfer {
	    private ReentrantLock lock = new ReentrantLock();

	    public void transfer(Account from,Account to, int amount)
	    {
	        boolean transfer =false;
	        try {
	            if (lock.tryLock()) {
	                System.out.println(Thread.currentThread().getName() + " says accuire lock");
	                boolean debitFlag = from.debit(amount);
	                if (debitFlag) {
	                    to.credit(amount);
	                }
	                System.out.println(Thread.currentThread().getName() + " :: " + from.getName() + " says :: now balance is " + from.getBalance());
	                System.out.println(Thread.currentThread().getName() + " :: " + to.getName() + " says :: now balance is " + to.getBalance());
	                transfer = true;
	            } else {
	                System.out.println(Thread.currentThread().getName() + " says fail to accuire both lock Try again");
	                transfer(from, to, amount);//try again
	            }
	        }catch (Exception e){
	            e.printStackTrace();

	        }
	        finally {
	            if(transfer){
	                lock.unlock();
	            }
	        }
	    }
	}


	class Account{
	    private String name;
	    private int balance;

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public int getBalance() {
	        return balance;
	    }

	    public void setBalance(int balance) {
	        this.balance = balance;
	    }

	    public boolean debit(int amount)
	    {
	        if(amount > balance)
	        {
	            System.out.println(Thread.currentThread().getName() + " :: " +name + " says ::"+ amount + " grater than current balance" );
	            return false;
	        }
	        balance = balance -amount;
	        System.out.println(Thread.currentThread().getName() + " :: " + name + " says ::"+ amount + " Debited Success Fully" );
	        return true;
	    }
	    public void credit(int amount)
	    {
	        balance = balance+amount;
	        System.out.println(Thread.currentThread().getName() + " :: " + name + " says ::"+ amount + " Credited Success Fully" );
	    }
	}
