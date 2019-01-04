package com.igniubi.user.mapper;

import com.igniubi.mybatis.mapper.BaseMapper;
import com.igniubi.user.entity.UserProfileEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户账号信息
 * <p>
 * 
 * @author 迈克擂
 * @date 2019-01-03
 * @version 1.0.0
 */
@Mapper
public interface UserProfileMapper extends BaseMapper<Long, UserProfileEntity> {

    /**
     * 根据手机号查询
     * <p>
     *
     * @param phoneNo
     * @return UserProfileEntity
     * @author  徐擂
     * @date    2019-1-4
     */
    UserProfileEntity getByPhoneNo(String phoneNo);

}
