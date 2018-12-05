package com.igniubi.service.impl;


import com.igniubi.dao.IUserSessionDao;
import com.igniubi.redis.operations.RedisValueOperations;
import com.igniubi.model.common.RedisKeyEnum;
import com.igniubi.redis.util.RedisOperationsUtil;
import com.igniubi.service.IUserSessionService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSessionServiceImpl implements IUserSessionService {

    private final Logger logger = LoggerFactory.getLogger(UserSessionServiceImpl.class);

    @Autowired
    private RedisValueOperations redisValueOperations;

    @Autowired
    private IUserSessionDao userSessionDao;

    @Override
    public Integer getUid(String sessionKey) {
        logger.info(" UserSessionServiceImpl getUid , sessionKey is {}", sessionKey);
        if(StringUtils.isBlank(sessionKey)){
            return null;
        }
//        RedisKeyBuilder keyBuilder = RedisKeyBuilder.newInstance().appendFixed(RedisKeyEnum.USER_SESSION.getCacheKey()).appendFixed(sessionKey);
//        Integer uid = redisValueOperations.get(keyBuilder, Integer.class);
//        if(uid != null){
//            return uid;
//        }
//
//        uid = userSessionDao.selectUid(sessionKey);
//        if(uid != null){
//            redisValueOperations.set(keyBuilder, uid,RedisKeyEnum.USER_SESSION.getCacheTime(), RedisKeyEnum.USER_SESSION.getTimeUnit() );
//        }
        Integer uid = RedisOperationsUtil.cacheObtain(redisValueOperations, RedisKeyEnum.USER_SESSION, sessionKey, () ->userSessionDao.selectUid(sessionKey), Integer.class);
        logger.info(" UserSessionServiceImpl getUid success , sessionKey is {}, uid is {}", sessionKey, uid);
        return uid;
    }
}
