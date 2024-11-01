package com.javafullstackguru.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.javafullstackguru.entity.UserInfo;
import com.javafullstackguru.service.UserInfoService;

//sonar:sonar -Dsonar.login=admin -Dsonar.password=password
//http://localhost:9000/
//http://localhost:8085/swagger-ui/index.html

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserInfoRestController {
	
	@Autowired
	private UserInfoService userInfoService;
	
	
	@PostMapping("/userinfo")
	public ResponseEntity<UserInfo> createUserInfo(UserInfo userInfo){
		var createUserInfo = userInfoService.createUserInfo(userInfo);
     	return new ResponseEntity<>(createUserInfo, HttpStatus.CREATED);	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserInfo> getUserInfoById(@PathVariable("id") Integer id){
		var getUserInfo = userInfoService.getUserInfoById(id);
		return new ResponseEntity<>(getUserInfo, HttpStatus.OK);	
	}
	
	@GetMapping("/alluserinfo")
	public ResponseEntity<List<UserInfo>> getAllUserInfo(){
		List<UserInfo> allUserInfo = userInfoService.getAllUserInfo();
		return new ResponseEntity<>(allUserInfo, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserInfo> updateUserInfo(@PathVariable("id") Integer id, @RequestBody UserInfo userInfo){
		var updateUserInfo = userInfoService.updateUserInfo(id, userInfo);
		return new ResponseEntity<>(updateUserInfo, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<UserInfo> deleteUserInfo(@PathVariable Integer id){
		userInfoService.deleteUserInfo(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	

}
