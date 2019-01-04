package com.igniubi.user.service;

import com.igniubi.mybatis.service.BaseService;
import com.igniubi.user.entity.UserProfileEntity;
import com.igniubi.user.entity.UserSessionEntity;


/**
 * 用户session信息
 * <p>
 * 
 * @author 迈克擂
 * @date 2019-01-03
 * @version 1.0.0
 */
public interface UserSessionService extends BaseService<Long, UserSessionEntity> {

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
    UserSessionEntity getUserSessionByChannel(Long userId, Integer channel);

}
