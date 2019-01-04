package com.igniubi.user.business.impl;
import java.util.Date;
import java.util.UUID;

import com.igniubi.common.exceptions.IGNBException;
import com.igniubi.model.dtos.common.ResultDTO;
import com.igniubi.model.enums.common.RedisKeyEnum;
import com.igniubi.model.enums.common.ResultEnum;
import com.igniubi.model.user.constants.UserConstant;
import com.igniubi.model.user.enums.UserExceptionEnum;
import com.igniubi.redis.operations.RedisValueOperations;
import com.igniubi.redis.util.RedisKeyBuilder;
import com.igniubi.user.business.UserBusinessService;
import com.igniubi.user.entity.UserInfoEntity;
import com.igniubi.user.entity.UserProfileEntity;
import com.igniubi.user.entity.UserSessionEntity;
import com.igniubi.user.mapper.UserInfoMapper;
import com.igniubi.user.mapper.UserProfileMapper;
import com.igniubi.user.model.UserProfileDTO;
import com.igniubi.user.service.UserInfoService;
import com.igniubi.user.service.UserProfileService;
import com.igniubi.user.service.UserSessionService;
import com.igniubi.user.utils.PasswordUtil;
import com.igniubi.user.utils.PhoneUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 会员业务接口
 * <p>
 *
 * @author 徐擂
 * @version 1.0.0
 * @date 2019-1-4
 */
@Service("userBusinessService")
public class UserBusinessServiceImpl implements UserBusinessService {

    @Autowired
    private UserProfileMapper userProfileMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserProfileService userProfileService;
    @Autowired
    private UserSessionService userSessionService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private RedisValueOperations redisTemplate;

    /**
     * 会员注册
     * <p>
     *
     * @param userProfileDTO
     * @return
     * @throws IGNBException
     * @author  徐擂
     * @date    2019-1-4
     */
    @Override
    public ResultDTO registerUser(UserProfileDTO userProfileDTO) throws IGNBException {
        // 1.判断账户是否存在
        UserProfileEntity userProfileEntity = userProfileService.getByPhoneNo(userProfileDTO.getPhoneNo());
        if (userProfileEntity != null) {
            throw new IGNBException(UserExceptionEnum.USER_ALREADY_EXIST.getCode(), UserExceptionEnum.USER_ALREADY_EXIST.getMessage());
        }

        // 2.验证数据格式
        if (!PhoneUtil.mobileVerify(userProfileDTO.getPhoneNo())) {
            throw new IGNBException(UserExceptionEnum.PHONE_FORMAT_ERROR.getCode(), UserExceptionEnum.PHONE_FORMAT_ERROR.getMessage());
        }

        // 3.加密注册
        BeanUtils.copyProperties(userProfileDTO, userProfileEntity = new UserProfileEntity());
        userProfileEntity.setPassword(PasswordUtil.makePass(userProfileEntity.getPassword()));
        userProfileMapper.save(userProfileEntity);

        // 4.生成用户基本信息
        userProfileEntity = userProfileService.getByPhoneNo(userProfileDTO.getPhoneNo());
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setUserId(userProfileEntity.getId());
        userInfoEntity.setRealName(UserConstant.USER_DEFAULT_REAL_NAME);
        userInfoEntity.setNickName(UserConstant.USER_DEFAULT_NICK_NAME);
        userInfoEntity.setMotto(UserConstant.USER_DEFAULT_MOTTO);
        userInfoEntity.setAge(UserConstant.USER_DEFAULT_AGE);
        userInfoEntity.setGender(UserConstant.USER_DEFAULT_GENDER);
        userInfoMapper.save(userInfoEntity);

        return new ResultDTO();
    }

    /**
     * 会员登陆
     * <p>
     *
     * @param userProfileDTO
     * @return
     * @throws IGNBException
     * @author  徐擂
     * @date    2019-1-4
     */
    @Override
    public ResultDTO doLogin(UserProfileDTO userProfileDTO) throws IGNBException{
        // 判断用户是否存在、校验密码
        UserProfileEntity userProfileEntity = userProfileService.getByPhoneNo(userProfileDTO.getPhoneNo());
        if (userProfileEntity == null || !PasswordUtil.validate(userProfileDTO.getPassword(),userProfileEntity.getPassword())) {
            return new ResultDTO(UserExceptionEnum.USER_INFO_INCORRECT.getCode(),UserExceptionEnum.USER_INFO_INCORRECT.getMessage());
        }

        // 生成token
        String token = generateToken();
        // 组装redis-key
        RedisKeyBuilder redisKeyBuilder = RedisKeyBuilder.newInstance().appendFixed(RedisKeyEnum.USER_SESSION.getCacheKey()).appendVar(token);
        redisTemplate.set(redisKeyBuilder, userProfileEntity, RedisKeyEnum.USER_SESSION.getCacheTime(), RedisKeyEnum.USER_SESSION.getTimeUnit());

        // 保存会话信息
        Integer channel = userProfileDTO.getChannel();
        UserSessionEntity userSessionEntity = userSessionService.getUserSessionByChannel(userProfileEntity.getId(), channel);
        if (userSessionEntity == null) {
            userSessionEntity = new UserSessionEntity();
            userSessionEntity.setUserId(userProfileEntity.getId());
            userSessionEntity.setSessionKey(token);
            userSessionEntity.setChannel(channel);
            userSessionEntity.setExpireTime((int) RedisKeyEnum.USER_SESSION.getTimeUnit().toSeconds(RedisKeyEnum.USER_SESSION.getCacheTime()));
            userSessionService.save(userSessionEntity);
        } else {
            userSessionEntity.setLastTime(null);
            userSessionEntity.setSessionKey(token);
            userSessionService.update(userSessionEntity);
        }
        return new ResultDTO(token);
    }

    private String generateToken(){ return UUID.randomUUID().toString();    }
}
