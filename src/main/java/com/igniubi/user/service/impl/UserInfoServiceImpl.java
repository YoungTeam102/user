package com.igniubi.user.service.impl;

import com.igniubi.mybatis.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.igniubi.user.mapper.UserInfoMapper;
import com.igniubi.user.entity.UserInfoEntity;
import com.igniubi.user.service.UserInfoService;

/**
 * 用户基本信息
 * <p>
 *
 * @author 迈克擂
 * @date 2019-01-03
 * @version 1.0.0
 */
@Service("userInfoService")
public class UserInfoServiceImpl  implements UserInfoService{

	@Autowired
	private UserInfoMapper userInfoMapper;


}
