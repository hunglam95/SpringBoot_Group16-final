package com.hellokoding.springboot.DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class GetDB{
	public String getDB(){
		String sr="";
		ConnectDB cdbstr = new ConnectDB();
		try{
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		Connection cnt=null;
		Statement sm=null;
		ResultSet rs;
		try{
			//cnt=DriverManager.getConnection("jdbc:mysql://localhost:3306/ckeditor","root","12345678");
			cnt=(Connection)DriverManager.getConnection(cdbstr.getSql(),cdbstr.getName(),cdbstr.getPass());
			sm=(Statement)cnt.createStatement();
			rs=sm.executeQuery("SELECT * FROM content");
			if(rs.next())
				sr=rs.getString("content");
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally
		{
			try{
				cnt.close();
				sm.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return sr;
	}
	public boolean Update(String content){
		ConnectDB cdbstr = new ConnectDB();
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		Connection cnt=null;
		Statement sm=null;
		try{
			cnt=DriverManager.getConnection(cdbstr.getSql(),cdbstr.getName(),cdbstr.getPass());
			sm=cnt.createStatement();
			String sql = "UPDATE content SET content ='"+content+"'";
			System.out.println(sql);
			PreparedStatement pstm =(PreparedStatement)cnt.prepareStatement(sql);
			return pstm.executeUpdate()>0;
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				cnt.close();
				sm.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		return false;
	}
}