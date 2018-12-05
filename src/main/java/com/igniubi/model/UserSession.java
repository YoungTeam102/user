package com.igniubi.model;

import lombok.Data;

@Data
public class UserSession {
    private Integer id;

    private Integer uid;

    private String sessionKey;

    private Integer lastTime;

    private Integer expireTime;
}
