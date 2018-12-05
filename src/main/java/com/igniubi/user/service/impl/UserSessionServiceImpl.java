package com.igniubi.user.service.impl;


import com.igniubi.redis.util.RedisKeyBuilder;
import com.igniubi.redis.util.RedisUtil;
import com.igniubi.model.common.RedisKeyEnum;
import com.igniubi.user.dao.IUserSessionDao;
import com.igniubi.user.service.IUserSessionService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSessionServiceImpl implements IUserSessionService {

    private final Logger logger = LoggerFactory.getLogger(UserSessionServiceImpl.class);

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private IUserSessionDao userSessionDao;

    @Override
    public Integer getUid(String sessionKey) {
        logger.info(" UserSessionServiceImpl getUid , sessionKey is {}", sessionKey);
        if(StringUtils.isBlank(sessionKey)){
            return null;
        }
        RedisKeyBuilder keyBuilder = RedisKeyBuilder.newInstance().appendFixed(RedisKeyEnum.USER_SESSION.getCacheKey()).appendFixed(sessionKey);
        Integer uid = redisUtil.get(keyBuilder, Integer.class);
        if(uid != null){
            return uid;
        }

        uid = userSessionDao.selectUid(sessionKey);
        if(uid != null){
            redisUtil.set(keyBuilder, uid,RedisKeyEnum.USER_SESSION.getCacheTime(), RedisKeyEnum.USER_SESSION.getTimeUnit() );
        }
        logger.info(" UserSessionServiceImpl getUid success , sessionKey is {}, uid is {}", sessionKey, uid);
        return uid;
    }
}
