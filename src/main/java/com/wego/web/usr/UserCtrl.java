package com.wego.web.usr;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wego.web.cmm.IConsumer;
import com.wego.web.cmm.IFunction;
import com.wego.web.cmm.IPredicate;
import com.wego.web.utl.Printer;

@RestController
@RequestMapping("/users")

public class UserCtrl {
	private static final Logger logger = LoggerFactory.getLogger(UserCtrl.class);
	@Autowired Map<String, Object>map;
	@Autowired User user;
	@Autowired Printer printer;
	@Autowired UserMapper userMapper;
	
	@GetMapping("/{uid}/exist")
	public Map<?, ?> existId(@PathVariable String uid ){
		printer.accept("exist 들어옴"+uid);
		IFunction<String,Integer> p = o -> userMapper.existId(uid);
		map.clear();
		map.put("msg", (p.apply(uid)==0)? "SUCCESS":"FAIL");
		return map;
	}
	
	@PostMapping("/")
	public Map<?,?> join(@RequestBody User param) {
		printer.accept("Join들어옴");
		IConsumer<User> c = t-> userMapper.insertUser(param);
		c.accept(param);
		map.clear();
		map.put("msg", "SUCCESS");
		return map; 
	}
	@PostMapping("/{uid}")
    public User login(@PathVariable String uid , @RequestBody User param) {
		printer.accept("login들어옴, 아이디  : "+uid);
		IFunction<User,User> f = t -> userMapper.selectByIdPw(param);
       return f.apply(param);
    }
	@GetMapping("/{uid}")
	public User selectByIdPw(@PathVariable String uid , @RequestBody User param) {
		IFunction<User,User> f = t -> userMapper.selectByIdPw(param);
		return f.apply(param);
	}
	@PutMapping("/{uid}")
	public Map<?,?> updateUser(@PathVariable String uid , @RequestBody User param) {
		IConsumer<User> c = o-> userMapper.insertUser(param);
		c.accept(param);
		map.clear();
		map.put("msg", "SUCCESS");
		return map;
	}
	@DeleteMapping("/{uid}")
	public Map<?,?> removeUser(@PathVariable String uid , @RequestBody User param) {
		IConsumer<User> c = o-> userMapper.insertUser(param);
		c.accept(param);
		map.clear();
		map.put("msg", "SUCCESS");
		return map; 
	}
	
}
