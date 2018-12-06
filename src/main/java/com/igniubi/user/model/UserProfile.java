package com.igniubi.user.model;

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

    public Integer getUid() { return uid; }

    public void setUid(Integer uid) { this.uid = uid; }

    public String getMobile() { return mobile; }

    public void setMobile(String mobile) { this.mobile = mobile; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public Integer getStatus() { return status; }

    public void setStatus(Integer status) { this.status = status; }

    public Integer getCreateTime() { return createTime; }

    public void setCreateTime(Integer createTime) { this.createTime = createTime; }

    public Integer getUpdateTime() { return updateTime; }

    public void setUpdateTime(Integer updateTime) { this.updateTime = updateTime; }
}
