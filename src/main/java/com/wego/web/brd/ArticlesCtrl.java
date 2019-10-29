package com.wego.web.brd;

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
import com.wego.web.cmm.ISupplier;
import com.wego.web.utl.Printer;

@RestController
@RequestMapping("/articles")
public class ArticlesCtrl {
   private static final Logger logger = LoggerFactory.getLogger(ArticlesCtrl.class);
   @Autowired Map<String , Object> map;
   @Autowired Printer printer;
   @Autowired Articles art;
   @Autowired ArticlesMapper articlesMapper;
   @Autowired List<Articles>list;
   
   @PostMapping("/")
   public Map<?,?> write(@RequestBody Articles param){
	   printer.accept("아티클 들어옴");
	   param.setBoardType("게시판");
	   IConsumer<Articles> c = t -> articlesMapper.insertArticle(param);
	   c.accept(param);
	   map.clear();
	   map.put("msg", "SUCCESS");
	   ISupplier<String> s =() -> articlesMapper.listArticle();
		map.put("count", s.get());
		printer.accept("글쓰기 취소 : "+map.get("msg"));
	   return map;
   }
   @GetMapping("/")
   public List<Articles> list (){
	   list.clear();
	   ISupplier <List<Articles>> s = () -> articlesMapper.selectAll();
	   printer.accept("전체글 목록 \n"+s.get());
	   return s.get();
   }
   
   @GetMapping("/count")
   public Map<?,?> listArticle() {
	ISupplier<String> s =() -> articlesMapper.listArticle();
	printer.accept("총 게시글수 : "+s.get());
	map.clear();
	map.put("count", s.get());
	return map;
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