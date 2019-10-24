package com.wego.web.usr;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wego.web.cmm.IConsumer;
import com.wego.web.cmm.IFunction;
import com.wego.web.utl.Printer;

@RestController
@RequestMapping("/users")

public class UserCtrl {
	private static final Logger logger = LoggerFactory.getLogger(UserCtrl.class);
	@Autowired Map<String, Object>map;	
	@Autowired User user;
	@Autowired Printer printer;
	@Autowired UserMapper userMapper;
	
	@PostMapping("/")
	public String join(@RequestBody User param) {
		logger.info("AJAX 가 보낸 아이디와 비밀번호 {}",param.getUid()+","+param.getPwd()+","+param.getUname());	
		IConsumer<User> c = o-> userMapper.insertUser(param);
		c.accept(param);
		return "SUCCESS"; 
	}
	@PostMapping("/{uid}")
    public User login(@PathVariable String uid , @RequestBody User param) {
	   IFunction<User,User> f = t -> userMapper.selectByIdPw(param);
       return f.apply(param);
    }
	@GetMapping("/{uid}")
	public User selectByIdPw(@PathVariable String uid , @RequestBody User param) {
		IFunction<User,User> f = t -> userMapper.selectByIdPw(param);
		return f.apply(param);
	}
	@GetMapping("/{uid}")
	public String updateUser(@PathVariable String uid , @RequestBody User param) {
		IConsumer<User> c = o-> userMapper.insertUser(param);
		c.accept(param);
		return "SUCCESS"; 
	}
	@GetMapping("/{uid}")
	public String removeUser(@PathVariable String uid , @RequestBody User param) {
		IConsumer<User> c = o-> userMapper.insertUser(param);
		c.accept(param);
		return "SUCCESS"; 
	}
	
}
