package com.wego.web.aop;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wego.web.utl.Printer;

@RestController
@Transactional
@RequestMapping("/tx")
public class TxController {
	@Autowired Printer printer;
	@Autowired TxService txservice;
//	@Autowired HashMap<String, String> map;
	
	@GetMapping("/crawling/{site}/{srch}")
	public void bringUrl(@PathVariable String site,
			@PathVariable String srch){
		printer.accept(site+",srch"+srch);
		HashMap<String, String> map = new HashMap<>();
		map.clear();
		map.put("site", site);
		map.put("srch", srch);
		txservice.crawling(map);
	}

}
