package com.hellokoding.springboot.DB;

public class ConnectDB {
	public String name="root";
	public String pass="12345678";
	//String sql = String.format(
	  //      "jdbc:mysql://google/%s?cloudSqlInstance=%s&"
	    //        + "socketFactory=com.google.cloud.sql.mysql.SocketFactory", "ád","instance contneasdasd");
	String sql ="jdbc:mysql://localhost:3306/ckeditor1";
public String getSql()
{
	return sql;
}
public String getName()
{
	return name;
}
public String getPass()
{
	return pass;
}
}