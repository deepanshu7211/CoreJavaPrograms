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
public class Task3 implements Callable<String> {
    @Override
    public String call() throws Exception {
        List<SubTask3_1> subTask3 = new ArrayList<>();

        List<Future<String>> subFutureList = new ArrayList<>();
        SubTask3_1 subTask3_1 = new SubTask3_1();
        SubTask3_1 subTask3_2 = new SubTask3_1();

        subTask3.add(subTask3_1);
        subTask3.add(subTask3_2);


        ExecutorService executorService = Executors.newCachedThreadPool();
        subFutureList = executorService.invokeAll(subTask3);

        for (Future<String> future :  subFutureList)
        {
            System.out.println( "Task3  SubTask Response.. " + future.get() + "Thread Name  " + Thread.currentThread().getName());
        }

        executorService.shutdown();

        return "Task3";
    }
}
