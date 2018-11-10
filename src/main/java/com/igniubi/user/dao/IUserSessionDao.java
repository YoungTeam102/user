package com.igniubi.user.dao;

import com.igniubi.user.model.UserSession;
import org.apache.ibatis.annotations.Param;

public interface IUserSessionDao {

    void insertUserSession(UserSession session);

    Integer selectUid(@Param("sessionKey") String sessonKey);
}
