package com.wego.web.adm;

import org.slf4j.LoggerFactory;

import java.util.Map;

import org.slf4j.Logger;
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
import com.wego.web.utl.Printer;
@RestController
@RequestMapping("/admins")
public class AdminCtrl {
	private static final Logger logger = LoggerFactory.getLogger(AdminCtrl.class);
	@Autowired Map<String, Object>map;
	@Autowired Printer printer;
	@Autowired Admin admin;
	@Autowired AdminMapper adminmapper;
	
	@PostMapping("/")
	public Map<?,?> regiter (@RequestBody Admin param){
		IConsumer<Admin> p = o -> adminmapper.insertAdmin(param); 
		p.accept(param);
		map.clear();
		map.put("msg", "SUCCESS");
		return map;
	}
	@PostMapping("/{eid}")
	public String access(@PathVariable String eid, @RequestBody Admin param) {
		IFunction<Admin, Admin> f = t -> adminmapper.selectByIdPw(param);
		printer.accept("관리자로그인 들어옴, 아이디 : "+eid);
		return (f.apply(param)!=null)? "SUCCESS":"FAIL";
		
	}
	@GetMapping("/{eid}")
	public Admin selectByIdPw(@PathVariable String eid, @RequestBody Admin param) {
		return param;
		
	}
	@PutMapping("/{eid}")
	public Admin updateAdmin(@PathVariable String eid, @RequestBody Admin param) {
		return param;
		
	}
	@DeleteMapping("/{eid}")
	public Admin removeAdmin(@PathVariable String eid, @RequestBody Admin param) {
		return param;
		
	}
	
	
	
	
	
}
