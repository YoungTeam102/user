package com.igniubi.user.controller;

import com.igniubi.common.exceptions.IGNBException;
import com.igniubi.model.dtos.common.ResultDTO;
import com.igniubi.user.model.UserProfileDTO;
import com.igniubi.user.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户信息
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
    private UserProfileService userProfileService;


    /**
     * 会员信息 根据uid
     * <p>
     *
     * @param userProfileDTO
     * @return
     * @throws IGNBException
     */
    @PostMapping("/getUserProfile")
    public ResultDTO getUserProfile(@RequestBody UserProfileDTO userProfileDTO) throws IGNBException {
        return new ResultDTO.ResultDTOBuilder().data(userProfileService.getUserProfile(userProfileDTO)).build();
    }

}
