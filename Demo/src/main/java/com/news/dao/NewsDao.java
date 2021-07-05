package com.news.dao;

import com.news.entity.News;

public interface NewsDao {
	public void getNewsByTitle(News news);
	public void addNews(News news);
	public void deleteNews(News news);
	public void updateNews(News news);
	public void getNewsList();

}
