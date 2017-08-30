package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlTest {
	static String jdbc = "com.mysql.jdbc.Driver";//驱动地址
	static String url = "jdbc:mysql://localhost:3306/test";//连接地址
	static String user = "root";//用户名
	static String pass = "ROOT";//密码
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement st = null;
		try {
			//注册驱动
			Class.forName(jdbc);
			
			//打开连接
			con = DriverManager.getConnection(url, user, pass);
			
			//执行sql
			String sql="select * from websites";
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				System.out.println("id="+rs.getString("Id"));
				System.out.println("name="+rs.getString("name"));
				System.out.println("url="+rs.getString("url"));
				System.out.println("alexa="+rs.getString("alexa"));
				System.out.println("country="+rs.getString("country"));
			}
			
			//关闭资源
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
			 try{
	            if(st!=null) st.close();
	            }catch(SQLException se2){
	            }// 什么都不做
	            try{
	                if(con!=null) con.close();
	            }catch(SQLException se){
	                se.printStackTrace();
	            }
		}
	}

}
