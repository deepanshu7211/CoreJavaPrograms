package com.deep.programs.thread_parallel;

import java.util.concurrent.Callable;

/**
 * Created by desaxena on 10/21/2016.
 */
public class SubTask3_1 implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "subtask3_1" + "Thread Name  " + Thread.currentThread().getName();
    }
}
