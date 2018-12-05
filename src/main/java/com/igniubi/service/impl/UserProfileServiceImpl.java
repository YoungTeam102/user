package com.igniubi.service.impl;

import com.igniubi.dao.IUserProfileDao;
import com.igniubi.model.CommonRsp;
import com.igniubi.model.UserProfile;
import com.igniubi.model.dtos.user.req.RegisterReqBO;
import com.igniubi.model.dtos.user.req.UserProfileReqBO;
import com.igniubi.model.enums.common.RedisKeyEnum;
import com.igniubi.redis.operations.RedisValueOperations;
import com.igniubi.redis.util.RedisOperationsUtil;
import com.igniubi.service.IUserProfleService;
import com.igniubi.utils.DateUtil;
import com.igniubi.utils.PasswordUtil;
import com.igniubi.utils.PhoneUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserProfileServiceImpl implements IUserProfleService {

    private final Logger logger = LoggerFactory.getLogger(UserProfileServiceImpl.class);

    @Autowired
    IUserProfileDao userProfileDao;

    @Autowired
    RedisValueOperations valueOperations;

    @Override
    public CommonRsp register(RegisterReqBO registerReq) {
        logger.info("registerimpl register req is {}",registerReq);
        CommonRsp rsp = new CommonRsp();
        String mobile = registerReq.getMobile();
        String password = registerReq.getPassword();
        if(!PhoneUtil.areaMobileVerify(null, mobile)){
            logger.warn("mobile is illegal, mobile is {}", mobile);
            rsp.setCode(202);
            rsp.setMessage("手机号不合法");
            return rsp;
        }
        UserProfile profile = userProfileDao.selectUserByMobile(mobile);
        if(null!=profile){
            logger.warn("UserProfile has already existed, mobile is {}", mobile);
            rsp.setCode(203);
            rsp.setMessage("用户已存在");
            return rsp;
        }
        String pwd = PasswordUtil.makePass(password);
        UserProfile newprofile = new UserProfile();
        newprofile.setMobile(mobile);
        newprofile.setCreateTime(DateUtil.getCurrentTimeSeconds());
        newprofile.setStatus(1);
        newprofile.setPassword(pwd);
        userProfileDao.insertUser(newprofile);
        logger.info("registerimpl register success, req is {}",registerReq);
        return rsp;
    }

    @Override
    public UserProfile getUserProfile(UserProfileReqBO userProfileReqBO) {
        Integer uid = userProfileReqBO.getUid();
        if(uid == null || uid <1 ){
            return null;
        }
        UserProfile profile = RedisOperationsUtil.cacheObtain(valueOperations ,RedisKeyEnum.USER_PROFILE, uid, () ->userProfileDao.selectUserByPrimary(uid), UserProfile.class );
        logger.info("get profile success , profile is {}", profile);
        return profile;
    }


}
