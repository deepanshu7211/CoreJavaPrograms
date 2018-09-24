package com.deep.programs.thread;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

/**
 * Created by deepanshu.saxena on 11/07/16.
 */
public class ThreadInvokeAll {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Callable<String>> callableSet = new ArrayList<>();

        callableSet.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return " Task 1 ";
            }
        });

        callableSet.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return " Task 2 ";
            }
        });

        callableSet.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Task 3";
            }
        });

        List<Future<String>> futureList = new ArrayList<>();

        futureList = executorService.invokeAll(callableSet);

        for (Future<String> future : futureList) {
            if (future.isDone()) {
                System.out.println(future.get());
            }
        }

        executorService.shutdown();
    }
}
