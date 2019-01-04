package com.igniubi.user.controller;

import com.igniubi.common.exceptions.IGNBException;
import com.igniubi.model.dtos.common.ResultDTO;
import com.igniubi.user.business.UserBusinessService;
import com.igniubi.user.model.UserProfileDTO;
import com.igniubi.user.utils.groups.LoginGroup;
import com.igniubi.user.utils.groups.RegisterGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户账号相关操作
 * 业务逻辑均放在business,此处只定义接口调用。
 * <p>
 *
 * @author 徐擂
 * @version 1.0.0
 * @date 2019-1-4
 */
@RestController
@RequestMapping("/userProfile")
public class UserProfileController {

    @Autowired
    private UserBusinessService userBusinessService;

    /**
     * 会员注册
     * <p>
     *
     * @param userProfileDTO
     * @return
     * @throws IGNBException
     * @author 徐擂
     * @date  2019-1-4
     */
    @PostMapping("/registerUser")
    public ResultDTO registerUser(@RequestBody @Validated(RegisterGroup.class) UserProfileDTO userProfileDTO) throws IGNBException {
        return userBusinessService.registerUser(userProfileDTO);
    }

    /**
     * 会员登陆
     * <p>
     *
     * @param userProfileDTO
     * @return
     * @throws IGNBException
     * @author 徐擂
     * @date  2019-1-4
     */
    @PostMapping("/doLogin")
    public ResultDTO doLogin(@RequestBody @Validated(LoginGroup.class) UserProfileDTO userProfileDTO) throws IGNBException {
        return userBusinessService.doLogin(userProfileDTO);
    }

}
