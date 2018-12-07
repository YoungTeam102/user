package com.igniubi.user.service;

import com.igniubi.model.CommonRsp;
import com.igniubi.model.user.req.RegisterReqBO;
import com.igniubi.model.user.req.UserProfileReqBO;
import com.igniubi.user.model.UserProfile;

public interface IUserProfleService {

    CommonRsp register(RegisterReqBO registerReq);

    UserProfile getUserProfile(UserProfileReqBO userProfileReqBO);
}
