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
public class Task2 implements Callable<String> {
    @Override
    public String call() throws Exception {
        List<SubTask2_1> subTask2 = new ArrayList<>();

        List<Future<String>> subFutureList = new ArrayList<>();
        SubTask2_1 subTask2_1 = new SubTask2_1();
        SubTask2_1 subTask2_2 = new SubTask2_1();

        subTask2.add(subTask2_1);
        subTask2.add(subTask2_2);


        ExecutorService executorService = Executors.newCachedThreadPool();
        subFutureList = executorService.invokeAll(subTask2);

        for (Future<String> future :  subFutureList)
        {
            System.out.println( "Task2 SubTask Response.. " + future.get() + "Thread Name  " + Thread.currentThread().getName());
        }

        executorService.shutdown();

        return "Task2";
    }
}
