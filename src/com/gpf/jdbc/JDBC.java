package com.gpf.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC
{

	public static void main(String[] args)
	{

		Connection conn=null;
		try
		{
//			加载MySql驱动
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("驱动加载成功");
//			连接数据库,获取连接对象
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root","root");
				System.out.println("数据库加载成功");
			
//			创建执行环境
				Statement statement = conn.createStatement();
//				执行Sql语句,得到结果集
				ResultSet result = statement.executeQuery("SELECT * FROM Stu");
				while(result.next()){
					System.out.println(result.getInt("IdName"));
					System.out.println(result.getString("uname"));
					System.out.println(result.getString("Gender"));
					
				}
			JDBCUtils.close(conn, statement, result);
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("驱动加载失败");
		}

	}


}
