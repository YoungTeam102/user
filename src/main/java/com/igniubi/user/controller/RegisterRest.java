package com.igniubi.user.controller;

import com.igniubi.model.CommonRsp;
import com.igniubi.model.user.request.RegisterReqBO;
import com.igniubi.user.service.IUserProfleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registerRest")
public class RegisterRest {
    private final Logger logger = LoggerFactory.getLogger(RegisterRest.class);

    @Autowired
    private IUserProfleService userProfleService;

    @RequestMapping("/register")
    @ResponseBody
        public CommonRsp register(@RequestBody RegisterReqBO registerReq){
        logger.info("register req is {}", registerReq);
        return userProfleService.register(registerReq);
    }

    @RequestMapping("/asynTest")
    public CommonRsp asynTest(@RequestBody RegisterReqBO registerReq){
        logger.info("register req is {}", registerReq);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CommonRsp();
    }
}
