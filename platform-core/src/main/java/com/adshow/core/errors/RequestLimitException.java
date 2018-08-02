package com.adshow.core.errors;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class RequestLimitException extends AbstractThrowableProblem {

    private static final URI TYPE = URI.create("https://www.adshow.com/too-many-request");


    public RequestLimitException(String message) {
        super(TYPE, "too-many-request", Status.TOO_MANY_REQUESTS, message);
    }

}
