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
	private int totalCount,
				pageCount,pageNum,pageSize,startPage,endPage,
				startRow, endRow, 
				nextBlock, prevBlock,blockCount,blockNum;
	private boolean existPrev,existNext;
	private String search;
	private final int BLOCK_SIZE = 5;
	@Autowired Printer p;
	@Autowired ArticlesMapper articlesMapper;
	
	@SuppressWarnings("unused")
	public void paging () {
		ISupplier <String> s = ()-> articlesMapper.countArticle();
		totalCount = Integer.parseInt(s.get());
		System.out.println("프록시 안에서 찍은 전체글 갯수: "+totalCount);
		pageCount = (totalCount % pageSize != 0) ? (totalCount / pageSize)+1 : totalCount / pageSize;
		startRow = (pageNum-1)*pageSize;
		endRow = (pageNum==pageCount) ? totalCount -1 : startRow + pageSize -1;
		blockCount = (pageCount % BLOCK_SIZE != 0) ? (pageCount / BLOCK_SIZE)+1 : pageCount / BLOCK_SIZE;
		blockNum = (pageNum - 1) / BLOCK_SIZE;
		startPage = blockNum * BLOCK_SIZE + 1;
		endPage = ((blockNum + 1) != blockCount) ? startPage + (BLOCK_SIZE -1) : pageCount;
		existPrev = blockNum != 0;
		existNext = (blockNum + 1) != blockCount;
		nextBlock = startPage + BLOCK_SIZE;
		prevBlock = startPage - BLOCK_SIZE;
		
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
