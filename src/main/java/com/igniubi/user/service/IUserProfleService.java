package com.igniubi.user.service;

import com.igniubi.model.CommonRsp;
import com.igniubi.model.user.request.RegisterReqBO;
import com.igniubi.model.user.request.UserProfileReqBO;
import com.igniubi.user.model.UserProfile;

public interface IUserProfleService {

    CommonRsp register(RegisterReqBO registerReq);

    UserProfile getUserProfile(UserProfileReqBO userProfileReqBO);
}
