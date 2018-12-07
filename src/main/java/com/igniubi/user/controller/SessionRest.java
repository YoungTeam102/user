package com.igniubi.user.controller;

import com.igniubi.model.dtos.user.req.SessionReqBO;
import com.igniubi.user.service.IUserSessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sessionRest")
public class SessionRest {

    private final Logger logger = LoggerFactory.getLogger(SessionRest.class);

    @Autowired
    private IUserSessionService userSessionService;

    @RequestMapping("/getUid")
    @ResponseBody
    public Integer getUid(@RequestBody SessionReqBO reqBO){
        logger.info("enter SessionRest getUid ,req is {}",reqBO);
        return userSessionService.getUid(reqBO.getSessionKey());
    }
}
