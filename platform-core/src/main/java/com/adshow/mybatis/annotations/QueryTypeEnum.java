package com.adshow.mybatis.annotations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum QueryTypeEnum {

    LIKE("like"),
    EQ("equal"),
    LE("lessOrEqual"),
    LT("less"),
    GT("greater"),
    GE("greaterOrEqual"),
    BETWEEN("between");

    private final String value;
    private final static Map<String, QueryTypeEnum> CONSTANTS = new HashMap<String, QueryTypeEnum>();

    static {
        for (QueryTypeEnum c : values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    private QueryTypeEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @JsonValue
    public String value() {
        return this.value;
    }

    @JsonCreator
    public static QueryTypeEnum fromValue(String value) {
        QueryTypeEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
