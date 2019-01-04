package com.igniubi.user.business;

import com.igniubi.common.exceptions.IGNBException;
import com.igniubi.model.dtos.common.ResultDTO;
import com.igniubi.user.entity.UserProfileEntity;
import com.igniubi.user.model.UserProfileDTO;

/**
 * 会员业务接口
 * <p>
 *
 * @author 徐擂
 * @version 1.0.0
 * @date 2019-1-4
 */
public interface UserBusinessService {

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
    ResultDTO registerUser(UserProfileDTO userProfileDTO) throws IGNBException;

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
    ResultDTO doLogin(UserProfileDTO userProfileDTO) throws IGNBException;

}
