package com.igniubi.service;

import com.igniubi.model.CommonRsp;
import com.igniubi.model.UserProfile;
import com.igniubi.model.user.request.RegisterReqBO;
import com.igniubi.model.user.request.UserProfileReqBO;

public interface IUserProfleService {

    CommonRsp register(RegisterReqBO registerReq);

    UserProfile getUserProfile(UserProfileReqBO userProfileReqBO);
}
