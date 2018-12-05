package com.igniubi.model;

import lombok.Data;

@Data
public class UserProfile {

    private Integer uid;

    private String mobile;

    private String password;

    private String email;

    private Integer status;

    private Integer createTime;

    private Integer updateTime;
}
