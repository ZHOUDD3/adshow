package com.adshow.core.common.entity;

import ch.qos.logback.classic.Logger;

/**
 * View Model object for storing a Logback logger.
 */
public class LoggerConfig {

    private String name;

    private String level;

    public LoggerConfig(Logger logger) {
        this.name = logger.getName();
        this.level = logger.getEffectiveLevel().toString();
    }

    public LoggerConfig() {
        // Empty public constructor used by Jackson.
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "LoggerConfig{" +
            "name='" + name + '\'' +
            ", level='" + level + '\'' +
            '}';
    }
}
