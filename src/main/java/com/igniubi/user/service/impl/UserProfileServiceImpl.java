package com.igniubi.user.service.impl;

import com.igniubi.mybatis.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.igniubi.user.mapper.UserProfileMapper;
import com.igniubi.user.entity.UserProfileEntity;
import com.igniubi.user.service.UserProfileService;

/**
 * 用户账号信息
 * <p>
 *
 * @author 迈克擂
 * @date 2019-01-03
 * @version 1.0.0
 */
@Service("userProfileService")
public class UserProfileServiceImpl extends BaseServiceImpl<Long, UserProfileEntity> implements UserProfileService, InitializingBean {

	@Autowired
	private UserProfileMapper userProfileMapper;

    @Override
    public void afterPropertiesSet() throws Exception {
        this.setBaseMapper(userProfileMapper);
    }

    /**
     * 根据手机号查询
     * <p>
     *
     * @param phoneNo
     * @return UserProfileEntity
     * @author  徐擂
     * @date    2019-1-4
     */
    @Override
    public UserProfileEntity getByPhoneNo(String phoneNo){
        return userProfileMapper.getByPhoneNo(phoneNo);
    }
}
