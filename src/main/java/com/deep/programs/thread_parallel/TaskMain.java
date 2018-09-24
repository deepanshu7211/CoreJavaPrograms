package com.deep.programs.thread_parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by desaxena on 10/21/2016.
 */
public class TaskMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
    	
    	System.out.println(" Start Time :: " + System.currentTimeMillis());
    	
        ExecutorService executorService = Executors.newCachedThreadPool();
        Task1 t1 = new Task1();
        Task2 t2 = new Task2();
        Task3 t3 = new Task3();

        List<Callable<? extends  Object>> tasks = new ArrayList<>();
        tasks.add(t1);
        tasks.add(t2);
        tasks.add(t3);

        List<Future<?>> results = ThreadUtility.invokeAll(tasks);
        for(Future<?> future :  results)
        {
//            System.out.println(Thread.currentThread().getName() + " Response " + future.get());
            String result = (String)future.get();
            System.out.println("result :: " + result);
        }
        
        System.out.println(" End Time :: " + System.currentTimeMillis());
    }
}
