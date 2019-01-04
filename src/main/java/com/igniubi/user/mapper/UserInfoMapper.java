package com.igniubi.user.mapper;

import com.igniubi.mybatis.mapper.BaseMapper;
import com.igniubi.user.entity.UserInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户基本信息
 * <p>
 * 
 * @author 迈克擂
 * @date 2019-01-03
 * @version 1.0.0
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<Long, UserInfoEntity> {
	
}
