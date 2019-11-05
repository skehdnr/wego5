package com.wego.web.brd;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wego.web.pxy.Proxy;


@Repository
public interface ArticlesMapper {
	public void insertArticle (Articles articles);
	public String listArticle ();
	public String countArticle();
	public List<Articles> selectAll(Proxy pxy);
	public void deleteArticle(Articles param);
	public void updateArticle(Articles param);

}
