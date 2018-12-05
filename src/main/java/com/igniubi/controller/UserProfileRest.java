package com.igniubi.controller;

import com.igniubi.model.CommonRsp;
import com.igniubi.model.UserProfile;
import com.igniubi.model.dtos.user.req.UserProfileReqBO;
import com.igniubi.service.IUserProfleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userProfileRest")
public class UserProfileRest {

    private final Logger logger = LoggerFactory.getLogger(UserProfileRest.class);

    @Autowired
    private IUserProfleService userProfleService;

    @RequestMapping("/getUserProfile")
    @ResponseBody
    public CommonRsp getUserProfile(@RequestBody UserProfileReqBO reqBO){
        logger.info("enter SessionRest getUid ,req is {}",reqBO);
        UserProfile profile = userProfleService.getUserProfile(reqBO);
        return new CommonRsp.CommonrspBuilder().data(profile).build();
    }
}
