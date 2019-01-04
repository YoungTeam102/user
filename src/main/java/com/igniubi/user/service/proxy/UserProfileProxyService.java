package com.igniubi.user.service.proxy;

import com.igniubi.model.enums.common.RedisKeyEnum;
import com.igniubi.redis.operations.RedisValueOperations;
import com.igniubi.redis.util.RedisKeyBuilder;
import com.igniubi.redis.util.RedisOperationsUtil;
import com.igniubi.user.entity.UserProfileEntity;
import com.igniubi.user.mapper.UserInfoMapper;
import com.igniubi.user.mapper.UserProfileMapper;
import com.igniubi.user.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 用户基本信息
 * <p>
 *
 * @author 迈克擂
 * @date 2019-01-03
 * @version 1.0.0
 */
@Component
public class UserProfileProxyService implements UserInfoService{

	private final Logger logger = LoggerFactory.getLogger(UserProfileProxyService.class);

	@Autowired
	private UserProfileMapper userProfileMapper;

	@Autowired
	private RedisValueOperations redisTemplate;

	public UserProfileEntity getUserProfile(long uid){
		UserProfileEntity entity = null;
		try{
			 entity = RedisOperationsUtil.cacheObtain(redisTemplate, RedisKeyEnum.USER_PROFILE, uid,
					() ->userProfileMapper.get(uid), UserProfileEntity.class);
		}catch (Exception e){
			logger.warn("getUserProfile error , uid is {}, e is {}",uid, e);
		}

		return entity;
	}
}
