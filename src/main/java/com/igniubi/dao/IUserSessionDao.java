package com.igniubi.dao;

import com.igniubi.model.UserSession;
import org.apache.ibatis.annotations.Param;

public interface IUserSessionDao {

    void insertUserSession(UserSession session);

    Integer selectUid(@Param("sessionKey") String sessonKey);
}
