package com.igniubi.user.entity;

import com.igniubi.mybatis.entity.BaseEntity;

import java.util.Date;


/**
 * 用户基本信息
 * <p>
 *
 * @author 迈克擂
 * @date 2019-01-03
 * @version 1.0.0
 */
public class UserInfoEntity extends BaseEntity {
	
	/**
	 * id
 	 */
	private Long id;
	/**
	 * 用户id
 	 */
	private Long userId;
	/**
	 * 用户真实姓名
 	 */
	private String realName;
	/**
	 * 用户昵称
 	 */
	private String nickName;
	/**
	 * 座右铭
 	 */
	private String motto;
	/**
	 * 年龄
 	 */
	private Integer age;
	/**
	 * 性别 男:1 女:2
 	 */
	private Integer gender;
	/**
	 * 创建时间
 	 */
	private Date createTime;
	/**
	 * 更新时间
 	 */
	private Date updateTime;


	public void setId(Long id) { this.id = id; }

	public Long getId() {  return id;  }

	public void setUserId(Long userId) { this.userId = userId; }

	public Long getUserId() {  return userId;  }

	public void setRealName(String realName) { this.realName = realName; }

	public String getRealName() {  return realName;  }

	public void setNickName(String nickName) { this.nickName = nickName; }

	public String getNickName() {  return nickName;  }

	public void setMotto(String motto) { this.motto = motto; }

	public String getMotto() {  return motto;  }

	public void setAge(Integer age) { this.age = age; }

	public Integer getAge() {  return age;  }

	public void setGender(Integer gender) { this.gender = gender; }

	public Integer getGender() {  return gender;  }

	public void setCreateTime(Date createTime) { this.createTime = createTime; }

	public Date getCreateTime() {  return createTime;  }

	public void setUpdateTime(Date updateTime) { this.updateTime = updateTime; }

	public Date getUpdateTime() {  return updateTime;  }
}
