package com.deep.exception;

/**
 * Created by deepanshu.saxena on 22/07/16.
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        TestException testException = new TestException();
        try {
            testException.testException();
        } catch (MyException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}


class MyException extends Exception {
    public MyException(String message) {
//        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }


}

class TestException {
    public void testException() throws MyException {
        throw new MyException("Test Exception... ");
    }
}