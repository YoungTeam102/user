package com.igniubi.user.model;

import lombok.Data;

@Data
public class UserSession {

    private Integer uid;

    private String sessionKey;

    private Integer lastTime;

    private Integer expireTime;

    public Integer getUid() { return uid; }

    public void setUid(Integer uid) { this.uid = uid; }

    public String getSessionKey() { return sessionKey; }

    public void setSessionKey(String sessionKey) { this.sessionKey = sessionKey; }

    public Integer getLastTime() { return lastTime; }

    public void setLastTime(Integer lastTime) { this.lastTime = lastTime; }

    public Integer getExpireTime() { return expireTime; }

    public void setExpireTime(Integer expireTime) { this.expireTime = expireTime; }
}
