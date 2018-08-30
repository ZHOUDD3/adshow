package com.adshow.mqtt.core;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface DeviceCmdHandler {
    @AliasFor("model")
    String[] value() default {};

    @AliasFor("value")
    String[] model() default {};

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface CmdHandler {
        @AliasFor("code")
        int[] value() default {};

        @AliasFor("value")
        int[] code() default {};

        int[] type() default {};
    }
}