package com.adshow.core.common.annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 限流注解
 *
 */
@Retention(RUNTIME)
@Target(METHOD)
public @interface Limiter {
    double value();
}
