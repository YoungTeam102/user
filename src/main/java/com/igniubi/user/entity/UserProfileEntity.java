package com.igniubi.user.entity;

import com.igniubi.mybatis.entity.BaseEntity;

import java.util.Date;


/**
 * 用户账号信息
 * <p>
 *
 * @author 迈克擂
 * @date 2019-01-03
 * @version 1.0.0
 */
public class UserProfileEntity extends BaseEntity {
	
	/**
	 * 用户id
 	 */
	private Long id;
	/**
	 * 邮箱号
 	 */
	private String email;
	/**
	 * 手机号
 	 */
	private String phoneNo;
	/**
	 * 密码
 	 */
	private String password;
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


	public void setId(Long id) { this.id = id; }

	public Long getId() {  return id;  }

	public void setEmail(String email) { this.email = email; }

	public String getEmail() {  return email;  }

	public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }

	public String getPhoneNo() {  return phoneNo;  }

	public void setPassword(String password) { this.password = password; }

	public String getPassword() {  return password;  }

	public void setCreateTime(Date createTime) { this.createTime = createTime; }

	public Date getCreateTime() {  return createTime;  }

	public void setUpdateTime(Date updateTime) { this.updateTime = updateTime; }

	public Date getUpdateTime() {  return updateTime;  }

	public void setStatus(Integer status) { this.status = status; }

	public Integer getStatus() {  return status;  }
}
