package com.deep.programs.thread_parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by desaxena on 10/21/2016.
 */
public class Task1 implements Callable<String> {
    @Override
    public String call() throws Exception {
        List<SubTask1_1> subTask1 = new ArrayList<>();
        List<Future<String>> subFutureList = new ArrayList<>();
        SubTask1_1 subTask1_1 = new SubTask1_1();
        SubTask1_1 subTask1_2 = new SubTask1_1();

        subTask1.add(subTask1_1);
        subTask1.add(subTask1_2);


        ExecutorService executorService = Executors.newCachedThreadPool();
        subFutureList = executorService.invokeAll(subTask1);

        for (Future<String> future :  subFutureList)
        {
            System.out.println( "Task1 SubTask Response.. " + future.get() + "Thread Name  " + Thread.currentThread().getName());
        }

        executorService.shutdown();
        return "Task1";
    }
}
