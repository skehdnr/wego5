package com.wego.web.brd;

import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public interface ArticlesMapper {
	public void insertArticle (Articles articles);
	public String listArticle ();
	public List<Articles> selectAll();
	public void deleteArticle(Articles param);
	public void updateArticle(Articles param);

}
