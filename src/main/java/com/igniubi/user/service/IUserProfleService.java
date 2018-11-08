package com.igniubi.user.service;

import com.igniubi.model.CommonRsp;
import com.igniubi.model.user.request.RegisterReq;

public interface IUserProfleService {

    CommonRsp register(RegisterReq registerReq);
}
