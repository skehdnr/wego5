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
   @Autowired Map<String , Object> map;
   @Autowired Printer printer;
   @Autowired Articles art;
   @Autowired ArticlesMapper articlesMapper;
   
   @PostMapping("/")
   public Map<?,?> write(@RequestBody Articles param){
	   printer.accept("아티클 들어옴");
	   param.setBoardType("게시판");
	   IConsumer<Articles> c = t -> articlesMapper.insertArticle(param);
	   c.accept(param);
	   map.clear();
	   map.put("msg", "SUCCESS");
	   return map;
   }
   
   @GetMapping("/{artseq}")
   public Articles read(@PathVariable String artseq, @RequestBody Articles param){
      return null;
   }
   
   @PutMapping("/{artseq}")
   public Articles update(@PathVariable String artseq, @RequestBody Articles param){
      return null;
   }
   
   @DeleteMapping("/{artseq}")
   public Map<?,?> removeArticle(@PathVariable String artseq, @RequestBody Articles param){
      return map;
   }
   
}