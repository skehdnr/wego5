package com.wego.web.aop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TxService {
	@Autowired TxMapper mapper;
	@Autowired Proxy pxy;
//	@Autowired List<String> TxServicelist;
	
	
	@SuppressWarnings("unchecked")
	public List<?> crawling(Map<?,?> paramMap){
		System.out.println("Tx 맵퍼 들어옴");
		List<String> TxServicelist = new ArrayList<>();
		TxServicelist.clear();
		TxServicelist = (List<String>) pxy.crawl(paramMap);
		return TxServicelist;
		
	}

}
