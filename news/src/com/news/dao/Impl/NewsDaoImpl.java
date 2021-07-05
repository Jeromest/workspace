package com.news.dao.Impl;

import com.news.dao.NewsDao;
import com.news.dao.basedao;
import com.news.entity.News;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class NewsDaoImpl extends basedao implements NewsDao{
	public void getNewsByTitle(News news) {
		try{
			String sql="SELECT * FROM tb_news where title=?";
			Object[] params={news.getTitle()};
			ResultSet rs = executeSQL(sql,params);
			while(rs.next()) {
				int nid=rs.getInt("nid");
				String title=rs.getString("title");
				String tid=rs.getString("tid");
				String inputer=rs.getString("inputer");
				String content=rs.getString("content");
				Timestamp time=rs.getTimestamp("time");
				System.out.println(nid+"\t"+title+"\t"+tid+"\t"+inputer+"\t"+content+"\t"+time);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeResource();
		}
		
	}
	public void addNews(News news) {
		try{
			String sql="INSERT INTO tb_news(nid,title,tid,inputer,chkuser,time,content)"+"VALUES(?,?,?,?,?,?,?)";			
			Object[] params={news.getNid(),news.getTitle(),news.getTid(),news.getInputer(),news.getChkuser(),news.getTime(),news.getContent()};
			int i=executeUpdate(sql,params);
			if(i>0)
				System.out.println("Add News success!!");
		} catch (Exception e){

		} finally {
			closeResource();
		}
	}
	public void deleteNews(News news) {
		try{
			String sql="delete from tb_news where nid=?";
			Object[] params={news.getNid()};
			int i=executeUpdate(sql,params);
			if(i>0)
				System.out.println("Delete News success!!");
		}catch (Exception e){

		}finally {
			closeResource();
		}
	}
	public void updateNews(News news) {
		try{
			String sql="update tb_news set title=? where nid=?";			
			Object[] params={news.getTitle(),news.getNid()};
			int i=executeUpdate(sql,params);
			if(i>0)
				System.out.println("Update News success!!");
		}catch (Exception e){

		}finally {
			closeResource();
		}
	}

	public List<News> getNewsList() {
		try{
			String sql="SELECT * FROM tb_news";
			Object[] params={};
			ResultSet rs=executeSQL(sql,params);
			while(rs.next()) {
				int nid=rs.getInt("nid");
				String title=rs.getString("title");
				String tid=rs.getString("tid");
				String inputer=rs.getString("inputer");
				String content=rs.getString("content");
				Timestamp time=rs.getTimestamp("time");
				System.out.println(nid+"\t"+title+"\t"+tid+"\t"+inputer+"\t"+content+"\t"+time);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeResource();
		}
		return null;
	}
	public static void main(String[] args) {
		NewsDao dao=new NewsDaoImpl();
		News news=new News();
		news.setNid(10);
		news.setTitle("格格巫");
		news.setTid("t1001");
		news.setInputer("u1001");
		news.setChkuser("u1001");
		news.setTime(new Date());
		news.setContent("hehe content");
//		dao.addNews(news);
//		dao.deleteNews(news);
//		dao.updateNews(news);
		dao.getNewsList();
		dao.getNewsByTitle(news);
	}


}
