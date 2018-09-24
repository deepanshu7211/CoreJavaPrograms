package com.deep.programs.thread_parallel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by desaxena on 10/21/2016.
 */
public class ThreadUtility {

    public static <T>List<Future<?>>  invokeAll(Collection<? extends Callable<? extends T>> tasks)
    {
        ExecutorService executor = Executors.newCachedThreadPool();

        List<Future<?>> futures = new ArrayList<>();
        for (Callable<?> callable : tasks) {
            futures.add(executor.submit(callable));
        }

        executor.shutdown();
        return futures;
    }
}
