package com.igniubi.user.common;

import java.util.concurrent.TimeUnit;

public enum  RedisKeyEnum {

    USER_SESSION("igniubi:sessionKey:",3L,TimeUnit.HOURS)
    ;

    RedisKeyEnum(String cacheKey, long cacheTime, TimeUnit timeUnit) {
        this.cacheKey = cacheKey;
        this.cacheTime = cacheTime;
        this.timeUnit = timeUnit;
    }

    private String cacheKey;

    private long cacheTime;

    private TimeUnit timeUnit;

    public String getCacheKey() {
        return cacheKey;
    }

    public void setCacheKey(String cacheKey) {
        this.cacheKey = cacheKey;
    }

    public long getCacheTime() {
        return cacheTime;
    }

    public void setCacheTime(long cacheTime) {
        this.cacheTime = cacheTime;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }
}
