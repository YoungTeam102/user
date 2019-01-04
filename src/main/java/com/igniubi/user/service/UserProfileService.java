package com.igniubi.user.service;

import com.igniubi.mybatis.service.BaseService;
import com.igniubi.user.entity.UserProfileEntity;
import com.igniubi.user.model.UserProfileDTO;


/**
 * 用户账号信息
 * <p>
 * 
 * @author 迈克擂
 * @date 2019-01-03
 * @version 1.0.0
 */
public interface UserProfileService   {

    /**
     * 根据手机号查询
     * <p>
     *
     * @param phoneNo
     * @return UserProfileEntity
     * @author  徐擂
     * @date    2019-1-4
     */
    UserProfileEntity getByPhoneNo(String phoneNo);

    UserProfileEntity getUserProfile(UserProfileDTO userProfileDTO);
}
