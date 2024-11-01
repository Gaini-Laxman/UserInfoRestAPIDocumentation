package com.javafullstackguru.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javafullstackguru.entity.UserInfo;
import com.javafullstackguru.exception.UserInfoNotFoundException;
import com.javafullstackguru.repository.UserInfoRepository;



@Service
public class UserInfoServiceImpl implements UserInfoService {
	
	
	@Autowired
	private UserInfoRepository userInfoRepository;

	@Override
	public UserInfo createUserInfo(UserInfo userInfo) {
		
		return userInfoRepository.save(userInfo);
	}

	@Override
	public UserInfo getUserInfoById(Integer id) {
	Optional<UserInfo> userInfo	= userInfoRepository.findById(id);
	if(userInfo.isPresent()) {
		return userInfo.get();
	}else {
		throw new UserInfoNotFoundException("not found with id : " + id);
	}
	}

	@Override
	public List<UserInfo> getAllUserInfo() {
		
		return userInfoRepository.findAll();
	}

	@Override
	public UserInfo updateUserInfo(Integer id, UserInfo userInfo) {
		var existUserInfo = getUserInfoById(id);
		existUserInfo.setName(userInfo.getName());
		existUserInfo.setEmail(userInfo.getEmail());
		existUserInfo.setDept(userInfo.getDept());
		
		
		return userInfoRepository.save(existUserInfo);
	}

	@Override
	public UserInfo deleteUserInfo(Integer id) {
		var existUserInfo = getUserInfoById(id);
		return userInfoRepository.save(existUserInfo);
	}
	
	

	
}
