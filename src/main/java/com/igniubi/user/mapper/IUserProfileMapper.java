package com.igniubi.user.mapper;

import com.igniubi.user.model.UserProfile;
import org.apache.ibatis.annotations.Param;

public interface IUserProfileMapper {

    void insertUser(UserProfile profile);

    UserProfile selectUserByMobile(@Param("mobile")String mobile);

    UserProfile selectUserByPrimary(@Param("uid")Integer uid);
}
