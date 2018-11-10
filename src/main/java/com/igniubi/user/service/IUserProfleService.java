package com.igniubi.user.service;

import com.igniubi.model.CommonRsp;
import com.igniubi.model.user.request.RegisterReqBO;

public interface IUserProfleService {

    CommonRsp register(RegisterReqBO registerReq);
}
