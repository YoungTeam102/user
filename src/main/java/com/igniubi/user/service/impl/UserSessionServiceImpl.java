package com.igniubi.user.service.impl;

import com.igniubi.mybatis.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.igniubi.user.mapper.UserSessionMapper;
import com.igniubi.user.entity.UserSessionEntity;
import com.igniubi.user.service.UserSessionService;

/**
 * 用户session信息
 * <p>
 *
 * @author 迈克擂
 * @date 2019-01-03
 * @version 1.0.0
 */
@Service("userSessionService")
public class UserSessionServiceImpl implements UserSessionService{

	@Autowired
	private UserSessionMapper userSessionMapper;

    /**
     * 根据userId 和 渠道号查
     * <p>
     *
     * @param userId
     * @param channel
     * @return UserSessionEntity
     * @author  徐擂
     * @date    2019-1-4
     */
    @Override
    public UserSessionEntity getUserSessionByChannel(Long userId, Integer channel){
        return userSessionMapper.getUserSessionByParam(new UserSessionEntity(userId, channel));
    }
}
