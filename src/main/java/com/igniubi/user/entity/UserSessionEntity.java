package com.igniubi.user.entity;

import com.igniubi.mybatis.entity.BaseEntity;

import java.util.Date;


/**
 * 用户session信息
 * <p>
 *
 * @author 迈克擂
 * @date 2019-01-03
 * @version 1.0.0
 */
public class UserSessionEntity extends BaseEntity {
	
	/**
	 * id
 	 */
	private Long id;
	/**
	 * 用户id
 	 */
	private Long userId;
	/**
	 * session Key
 	 */
	private String sessionKey;
	/**
	 * 操作渠道 0:PC 1:Andriod 2:IOS 3:H5 4:小程序
 	 */
	private Integer channel;
	/**
	 * 失效时长,默认半小时
 	 */
	private Integer expireTime;
	/**
	 * 最后登陆时间
 	 */
	private Date lastTime;
	/**
	 * 创建时间
 	 */
	private Date createTime;

	public UserSessionEntity(){}

	public UserSessionEntity(Long userId, Integer channel) {
		this.userId = userId;
		this.channel = channel;
	}

	public void setId(Long id) { this.id = id; }

	public Long getId() {  return id;  }

	public void setUserId(Long userId) { this.userId = userId; }

	public Long getUserId() {  return userId;  }

	public void setSessionKey(String sessionKey) { this.sessionKey = sessionKey; }

	public String getSessionKey() {  return sessionKey;  }

	public void setChannel(Integer channel) { this.channel = channel; }

	public Integer getChannel() {  return channel;  }

	public void setExpireTime(Integer expireTime) { this.expireTime = expireTime; }

	public Integer getExpireTime() {  return expireTime;  }

	public void setLastTime(Date lastTime) { this.lastTime = lastTime; }

	public Date getLastTime() {  return lastTime;  }

	public void setCreateTime(Date createTime) { this.createTime = createTime; }

	public Date getCreateTime() {  return createTime;  }
}
