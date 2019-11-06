package com.wego.web.pxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

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
	private boolean existPrev,existNext;
	private String search;
	private final int BLOCK_SIZE = 5;
	@Autowired Printer p;
	@Autowired ArticlesMapper articlesMapper;
	
	@SuppressWarnings("unused")
	public void paging () {
		ISupplier <String> s = ()-> articlesMapper.countArticle();
		int totalCount = Integer.parseInt(s.get());
		int pageCount = (totalCount%5==0)?(totalCount/pageSize):(totalCount/pageSize)+1;
		startRow = (pageNum-1)*pageSize;
		endRow = (pageNum == pageCount) ? totalCount-1 : (pageNum*pageSize)-1 ;
		
		int blockCount = (pageCount%BLOCK_SIZE==0)?(pageCount/BLOCK_SIZE):(pageCount/BLOCK_SIZE)+1;
		int blockNum = (pageNum-1)/BLOCK_SIZE;
		int startPage = blockNum*BLOCK_SIZE+1;
		int endpage = ((blockNum+1)==blockCount)? startPage + (BLOCK_SIZE -1) : pageCount;
//		boolean existPrev = blockNum > 1 ;
		existPrev = blockNum != 0 ;
//		boolean existNext = blockNum < 1;
		existNext = (blockNum + 1)!= blockCount;
		
		
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
	public int random(int a, int b) {
//		Supplier<Integer> s = ()-> (int)(Math.random(10000)+1);
		BiFunction<Integer, Integer, Integer> f =(t,u)->(int)(Math.random()*(u-t))+t;
		return f.apply(a, b) ;
		}

}
