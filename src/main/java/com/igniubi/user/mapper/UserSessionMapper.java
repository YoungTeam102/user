package com.igniubi.user.mapper;

import com.igniubi.mybatis.mapper.BaseMapper;
import com.igniubi.user.entity.UserSessionEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 用户session信息
 * <p>
 * 
 * @author 迈克擂
 * @date 2019-01-03
 * @version 1.0.0
 */
@Mapper
public interface UserSessionMapper extends BaseMapper<Long, UserSessionEntity> {

    /**
     * 根据条件查询
     * <p>
     *
     * @param userSessionEntity
     * @return UserSessionEntity
     * @author  徐擂
     * @date    2019-1-4
     */
    UserSessionEntity getUserSessionByParam(UserSessionEntity userSessionEntity);

}
