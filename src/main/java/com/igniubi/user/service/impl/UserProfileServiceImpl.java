package com.igniubi.user.service.impl;

import com.igniubi.model.CommonRsp;
import com.igniubi.model.user.request.RegisterReq;
import com.igniubi.user.dao.IUserProfileDao;
import com.igniubi.user.dao.IUserSessionDao;
import com.igniubi.user.model.UserProfile;
import com.igniubi.user.service.IUserProfleService;
import com.igniubi.user.utils.DateUtil;
import com.igniubi.user.utils.PasswordUtil;
import com.igniubi.user.utils.PhoneUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserProfileServiceImpl implements IUserProfleService {

    private final Logger logger = LoggerFactory.getLogger(UserProfileServiceImpl.class);

    @Autowired
    IUserProfileDao userProfileDao;


    @Override
    public CommonRsp register(RegisterReq registerReq) {
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
}
