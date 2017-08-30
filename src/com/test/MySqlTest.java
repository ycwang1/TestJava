package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlTest {
	static String jdbc = "com.mysql.jdbc.Driver";//������ַ
	static String url = "jdbc:mysql://localhost:3306/test";//���ӵ�ַ
	static String user = "root";//�û���
	static String pass = "ROOT";//����
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement st = null;
		try {
			//ע������
			Class.forName(jdbc);
			
			//������
			con = DriverManager.getConnection(url, user, pass);
			
			//ִ��sql
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
			
			//�ر���Դ
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
	            }// ʲô������
	            try{
	                if(con!=null) con.close();
	            }catch(SQLException se){
	                se.printStackTrace();
	            }
		}
	}

}
