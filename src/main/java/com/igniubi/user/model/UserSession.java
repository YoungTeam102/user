package com.igniubi.user.model;

import lombok.Data;

@Data
public class UserSession {
    private Integer id;

    private Integer uid;

    private String sessionKey;

    private Integer lastLoginTime;

    private Integer expireTime;
}
