package com.igniubi.user.model;

import com.igniubi.user.utils.groups.LoginGroup;
import com.igniubi.user.utils.groups.RegisterGroup;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 用户账号DTO
 * <p>
 *
 * @author 徐擂
 * @version 1.0.0
 * @date 2019-1-4
 */
public class UserProfileDTO {

    /**
     * 用户id
     */
    private Long id;
    /**
     * 邮箱号
     */
    @NotBlank(message = "邮箱号不能为空", groups = RegisterGroup.class)
    private String email;
    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空", groups = {RegisterGroup.class,LoginGroup.class})
    private String phoneNo;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空", groups = {RegisterGroup.class,LoginGroup.class})
    private String password;
    /**
     * 登陆渠道 0:PC 1:Android 2:IOS 3:H5 4:小程序
     */
    @NotNull(message = "渠道不能为空", groups = {LoginGroup.class})
    private Integer channel;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 账号状态 1:正常 2:停用 3:删除
     */
    private Integer status;

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPhoneNo() { return phoneNo; }

    public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Date getCreateTime() { return createTime; }

    public void setCreateTime(Date createTime) { this.createTime = createTime; }

    public Date getUpdateTime() { return updateTime; }

    public void setUpdateTime(Date updateTime) { this.updateTime = updateTime; }

    public Integer getStatus() { return status; }

    public void setStatus(Integer status) { this.status = status; }

    public Integer getChannel() { return channel; }

    public void setChannel(Integer channel) { this.channel = channel; }
}
