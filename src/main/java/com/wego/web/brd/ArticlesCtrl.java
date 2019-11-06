package com.wego.web.brd;

import java.util.Arrays;
import java.util.List;
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
import com.wego.web.cmm.ISupplier;
import com.wego.web.pxy.Proxy;
import com.wego.web.pxy.ProxyMap;
import com.wego.web.utl.Printer;

@RestController
@RequestMapping("/articles")
public class ArticlesCtrl {
   private static final Logger logger = LoggerFactory.getLogger(ArticlesCtrl.class);
   @Autowired ProxyMap map;
   @Autowired Printer printer;
   @Autowired Articles art;
   @Autowired ArticlesMapper articlesMapper;
   @Autowired List<Articles>list;
   @Autowired Proxy pxy;
   
   @PostMapping("/")
   public Map<?,?> write(@RequestBody Articles param){
	   printer.accept("아티클 들어옴");
	   param.setBoardType("게시판");
	   IConsumer<Articles> c = t -> articlesMapper.insertArticle(param);
	   c.accept(param);
	   ISupplier<String> s =() -> articlesMapper.listArticle();
		map.accept(Arrays.asList("msg","count"),Arrays.asList("SUCCESS",s.get()));
	   return map.get();
   }
   @GetMapping("/page/{pageNo}/size/{pageSize}")
   public Map<?,?> list (@PathVariable String pageNo,
		   @PathVariable String pageSize){
	   pxy.setPageNum(pxy.parseInt(pageNo));
	   pxy.setPageSize(pxy.parseInt(pageSize));
	   pxy.paging();
	   list.clear();
	   ISupplier <List<Articles>> s = () -> articlesMapper.selectAll(pxy);
	   printer.accept("해당 페이지 목록 \n"+s.get());
	   int ran = pxy.random(3, 11);
	   System.out.println("랜덤으로 나온수@@@@@@@@@@@@@@@@@@"+ran);
	   map.accept(Arrays.asList("articles","pages","pxy"),
			   Arrays.asList(s.get(),Arrays.asList(1,2,3,4,5),pxy));
	   return map.get();
   }
   
   @GetMapping("/count")
   public Map<?,?> listArticle() {
	ISupplier<String> s =() -> articlesMapper.countArticle();
	printer.accept("총 게시글수 : "+s.get());
	map.accept(Arrays.asList("count"), Arrays.asList(s.get()));
	return map.get();
   }
 
   @PutMapping("/{artseq}")
   public Articles updateArticle(@PathVariable String artseq, @RequestBody Articles param){
	   IConsumer<Articles> o = t -> articlesMapper.updateArticle(param);
	   o.accept(param);
	   art = param;
	   return art;
   }
   
   @DeleteMapping("/{artseq}")
   public Articles deleteArticle(@PathVariable String artseq, @RequestBody Articles param){
	   IConsumer<Articles> o = t -> articlesMapper.deleteArticle(param);
	  o.accept(param);
	  art = param;
	   return art;
   }
   
   
}