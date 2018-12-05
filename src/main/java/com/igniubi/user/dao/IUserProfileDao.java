package com.igniubi.user.dao;

import com.igniubi.user.model.UserProfile;
import org.apache.ibatis.annotations.Param;

public interface IUserProfileDao {

    void insertUser(UserProfile profile);

    UserProfile selectUserByMobile(@Param("mobile")String mobile);

    UserProfile selectUserByPrimary(@Param("uid")Integer uid);
}
