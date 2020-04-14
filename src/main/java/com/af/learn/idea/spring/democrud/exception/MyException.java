package com.af.learn.idea.spring.democrud.exception;

/**
 * @author anna
 * @create 2019-12-06 16:09
 */
public class MyException extends RuntimeException {

    public MyException() {
        super("自定义异常");
    }
}
