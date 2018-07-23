package com.adshow.exception;

/**
 * @Author martin
 * @Date 2018/7/20
 */
public class ParseMediaExcepion extends RuntimeException  {

    public ParseMediaExcepion(String message) {
        super(message);
    }

    public ParseMediaExcepion(String message, Throwable cause) {
        super(message, cause);
    }

}
