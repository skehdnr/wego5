package com.wego.web.brd;

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
import com.wego.web.utl.Printer;

@RestController
@RequestMapping("/articles")
public class ArticlesCtrl {
	private static final Logger logger = LoggerFactory.getLogger(ArticlesCtrl.class);
	@Autowired Map<String,Object>map;
	@Autowired Articles articles;
	@Autowired Printer printer;
	@Autowired ArticlesMapper articlesMapper;
	
	
	@PostMapping("/")
	public Map<?,?> write(@RequestBody Articles param) {
		IConsumer<Articles> c = t -> articlesMapper.insert(param);
		c.accept(param);
		map.clear();
		map.put("msg", "SUCCESS");
		return map;
	}
	@GetMapping("/")
	public Articles read(@RequestBody Articles param) {
		return param;
		
	}
	@PutMapping("/")
	public Articles update(@PathVariable Articles param) {
		return param;
		
	}
	@DeleteMapping("/")
	public Articles delete(@PathVariable Articles param) {
		return param;
		
	}
}
