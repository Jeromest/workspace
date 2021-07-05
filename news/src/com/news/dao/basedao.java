package com.news.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class basedao {
	Connection connection=null;
	PreparedStatement pStatement=null;
	ResultSet rSet=null;
	public boolean getConnection() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/cms?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT&allowPublicKeyRetrieval=true";
			connection=DriverManager.getConnection(url,"root","123456");			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			return false;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public int executeUpdate(String sql,Object[] params) {
		int updateRow=0;
		if(getConnection()){
			try {
				pStatement=connection.prepareStatement(sql);
				for(int i=0;i<params.length;i++){
					pStatement.setObject(i+1,params[i]);
				}
				updateRow=pStatement.executeUpdate();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}return updateRow;
	}
	public ResultSet executeSQL(String sql,Object[] params) {
		int updateRow=0;
		if(getConnection()){
			try {
				pStatement=connection.prepareStatement(sql);
				for(int i=0;i<params.length;i++){
					pStatement.setObject(i+1,params[i]);
				}
				rSet=pStatement.executeQuery();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}return rSet;
	}
	public boolean closeResource() {
		try{
			if(rSet!=null)
				rSet.close();
			if(pStatement!=null)
				pStatement.close();
			if(connection!=null)
				connection.close();
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}


}
