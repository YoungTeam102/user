package com.igniubi.user.controller;

import com.igniubi.common.exceptions.IGNBException;
import com.igniubi.model.dtos.common.ResultDTO;
import com.igniubi.user.business.UserBusinessService;
import com.igniubi.user.model.UserProfileDTO;
import com.igniubi.user.utils.groups.RegisterGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

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
}
