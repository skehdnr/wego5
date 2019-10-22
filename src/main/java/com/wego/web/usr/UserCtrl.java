package com.wego.web.usr;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wego.web.utl.Printer;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/users")
@Log4j
public class UserCtrl {
	private static final Logger logger = LoggerFactory.getLogger(UserCtrl.class);
	@Autowired Map<String, Object>map;	
	@Autowired User user;
	@Autowired Printer printer;
	
	@PostMapping("/")
	public Map<?,?> join(@RequestBody User param) {
		logger.info("AJAX 가 보낸 아이디와 비밀번호 {}",param.getUid()+","+param.getPwd()+","+param.getUname());	
		printer.accept("람다 프린터가 출력한 값"+param.getUid()+","+param.getPwd()+","+param.getUname());
		Map<String,Object> map = new HashMap<>();
		map.put("uid", param.getUid());
		map.put("pwd", param.getPwd());
		map.put("uname", param.getUname());
		map.put("birth", param.getBirth());
		map.put("gender", param.getGender());
		map.put("pettype", param.getPettype());
		map.put("tel", param.getTel());
		logger.info("MAP에 담긴 아이디와 비번{}",map.get("uid")+","+map.get("pwd")+","+map.get("uname"));
		return map;
	}
	@PostMapping("/login")
	public User login (@RequestBody User param){
		logger.info("AJAX 로그인 후 아이디 비밀번호{}",param.getUid()+","+param.getPwd()+","+param.getUname());
		user.setUid(param.getUid());
		user.setPwd(param.getPwd());
		user.setUname(param.getUname());
		logger.info("user 에 담긴 사용자 정보 {}",user.toString());
		return user;
		
	}

}
