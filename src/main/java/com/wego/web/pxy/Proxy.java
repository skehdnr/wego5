package com.wego.web.pxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.wego.web.brd.ArticlesMapper;
import com.wego.web.cmm.ISupplier;
import com.wego.web.utl.Printer;

import lombok.Data;

@Component @Data @Lazy
public class Proxy {
	private int pageNum, pageSize, startRow, endRow;
	private String search;
	private final int BOLCK_SIZE = 5;
	@Autowired Printer p;
	@Autowired ArticlesMapper articlesMapper;
	
	@SuppressWarnings("unused")
	public void paging () {
		ISupplier <String> s = ()-> articlesMapper.countArticle();
		int totalCount = Integer.parseInt(s.get());
		int pageCount = (totalCount%5==0)?(totalCount/pageSize):(totalCount/pageSize)+1;
		startRow = (pageNum-1)*pageSize;
		endRow = (pageNum == pageCount) ? totalCount-1 : (pageNum*pageSize)-1 ;
		
		int blockCount = (pageCount%BOLCK_SIZE==0)?(pageCount/BOLCK_SIZE):(pageCount/BOLCK_SIZE)+1;;
		int blockNum = (pageNum-1)/BOLCK_SIZE;
//		int startPage = (pageNum%BOLCK_SIZE==0)?blockCount+1:blockCount;
		int endpage = 0;
		boolean existPrev = false;
		boolean existNext = false;
	}
	
	public int parseInt(String param) {
		Function<String,Integer> f = s -> Integer.parseInt(s);
		return f.apply(param);
		
	}
	
	public List<?> crawl(Map<?,?> paramMap){
		String url = "http://"+paramMap.get("site")+"/";
		p.accept("넘어온 URL \n"+url);
		List<String> proxyList = new ArrayList<>();
		proxyList.clear();
		try {
			Connection.Response response = Jsoup.connect(url)
			                                    .method(Connection.Method.GET)
			                                    .execute();
			Document document = response.parse();
			String text = document.html();
			//String text = document.text();
			p.accept("크롤링한 텍스트 \n"+text);
			proxyList.add(text);
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		return proxyList;
	}
	

}
