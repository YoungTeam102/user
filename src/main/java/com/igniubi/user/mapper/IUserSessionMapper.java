package com.igniubi.user.mapper;

import com.igniubi.common.page.PagerInfo;
import com.igniubi.user.model.UserSession;
import com.igniubi.mybatis.mapper.BaseMapper;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserSessionMapper extends BaseMapper<Integer, UserSession> {

    void insertUserSession(UserSession session);

    Integer selectUid(@Param("sessionKey") String sessonKey);

    /**
     * 查询所有记录
     * @return
     */
    List<UserSession> listAllUserSession();
}
