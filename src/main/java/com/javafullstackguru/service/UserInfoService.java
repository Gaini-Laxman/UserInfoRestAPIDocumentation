package com.javafullstackguru.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.javafullstackguru.entity.UserInfo;

@Service
public interface UserInfoService {
	
	UserInfo createUserInfo(UserInfo userInfo);
	
	UserInfo getUserInfoById(Integer id);
	
	List<UserInfo> getAllUserInfo();
	
	UserInfo updateUserInfo(Integer id, UserInfo userInfo);
	
	UserInfo deleteUserInfo(Integer id);

}
