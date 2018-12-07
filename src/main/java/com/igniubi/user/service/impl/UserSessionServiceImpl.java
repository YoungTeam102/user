package com.igniubi.user.service.impl;


import com.igniubi.common.page.PagerHelper;
import com.igniubi.common.page.PagerInfo;
import com.igniubi.user.service.IUserSessionService;
import com.igniubi.user.mapper.IUserSessionMapper;
import com.igniubi.user.model.UserSession;
import com.igniubi.model.enums.common.RedisKeyEnum;
import com.igniubi.redis.operations.RedisValueOperations;
import com.igniubi.redis.util.RedisOperationsUtil;
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
    private IUserSessionMapper userSessionMapper;

    @Override
    public Integer getUid(String sessionKey) {
        logger.info(" UserSessionServiceImpl getUid , sessionKey is {}", sessionKey);
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
        Integer uid = RedisOperationsUtil.cacheObtain(redisValueOperations, RedisKeyEnum.USER_SESSION, sessionKey, () ->userSessionMapper.selectUid(sessionKey), Integer.class);
        logger.info(" UserSessionServiceImpl getUid success , sessionKey is {}, uid is {}", sessionKey, uid);
        return uid;
    }
}
