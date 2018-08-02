package com.adshow.core.errors;

import lombok.Data;

/**
 *
 */
@Data
public class AuthenticationException extends RuntimeException {

    private String msg;

    public AuthenticationException(String msg){
        super(msg);
        this.msg = msg;
    }
}
