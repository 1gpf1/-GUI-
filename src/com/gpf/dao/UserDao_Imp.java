package com.gpf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gpf.bean.User;
import com.gpf.jdbc.JDBCUtils;

public class UserDao_Imp implements UserDao
{

	private static final String SQL_USER_LOGIN = "SELECT type FROM Stu WHERE IdName=? AND upass=? ";
	private static final String SQL_USER_INSERT = "INSERT INTO Stu VALUES(?,?,?,?,?,?,2)";
	private static final String SQL_USER_DELETE = "DELETE FROM Stu WHERE IdName=? AND uname=?";
	private static final String SQL_USER_UPDATE = "UPDATE Stu SET upass=?,Major=? WHERE IdName=? AND uname=?";
	private static final String SQL_USER_SELECT ="SELECT * FROM Stu WHERE IdName=? AND uname=?";

	/**
	 *实现登录方法
	 */
	@Override
	public int login(User user)
	{
		PreparedStatement prepareStatement=null;
		ResultSet result=null;
//		连接数据库,创建连接对象
		Connection conn = JDBCUtils.getConnection();
//		创建编译环境
		try
		{
			prepareStatement = conn.prepareStatement(SQL_USER_LOGIN);
//			设置sql语句中的参数
			prepareStatement.setLong(1, user.getIdname());
			prepareStatement.setString(2, user.getUpass());
//			执行语句
			result = prepareStatement.executeQuery();
			while (result.next())
			{
				int type = result.getInt("type");
				return type;
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.close(conn,prepareStatement, result);
		}
		return -1;
	}

	/**
	 *实现添加的方法
	 */
	@Override
	public boolean insert(User user)
	{
		PreparedStatement prepareStatement=null;
//		连接数据库,创建连接对象
		Connection conn = JDBCUtils.getConnection();
//		创建编译环境
		try
		{
			prepareStatement = conn.prepareStatement(SQL_USER_INSERT);
//			设置sql语句中的参数
			prepareStatement.setInt(1, user.getIdname());
			prepareStatement.setString(2, user.getUname());
			prepareStatement.setString(3, user.getGender());
			prepareStatement.setInt(4, user.getAge());
			prepareStatement.setString(5, user.getMajor());
			prepareStatement.setString(6, user.getUpass());
//			执行语句
			int flog = prepareStatement.executeUpdate();
			return flog>0?true:false;
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.close(conn,prepareStatement,null);
		}
		return false;
	}

	/**
	 *实现删除的方法
	 */
	@Override
	public boolean delete(String uname, int idname)
	{
		PreparedStatement prepareStatement=null;
//		连接数据库,创建连接对象
		Connection conn = JDBCUtils.getConnection();
//		创建编译环境
		try
		{
			prepareStatement = conn.prepareStatement(SQL_USER_DELETE);
//			设置sql语句中的参数
			prepareStatement.setInt(1, idname);
			prepareStatement.setString(2, uname);
//			执行语句
			int flog = prepareStatement.executeUpdate();
			return flog>0?true:false;
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.close(conn,prepareStatement,null);
		}
		return false;
	}

	/**
	 *实现修改的方法
	 */
	@Override
	public boolean update(User user)
	{
		PreparedStatement prepareStatement=null;
//		连接数据库,创建连接对象
		Connection conn = JDBCUtils.getConnection();
//		创建编译环境
		try
		{
			prepareStatement = conn.prepareStatement(SQL_USER_UPDATE);
//			设置sql语句中的参数
			prepareStatement.setString(1, user.getUpass());
			prepareStatement.setString(2, user.getMajor());
			prepareStatement.setInt(3, user.getIdname());
			prepareStatement.setString(4, user.getUname());
//			执行语句
			int flog = prepareStatement.executeUpdate();
			return flog>0?true:false;
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.close(conn,prepareStatement,null);
		}
		return false;
	}

	/**
	 *实现查找的方法
	 */
	@Override
	public User select(String uname, int idname)
	{
		PreparedStatement prepareStatement=null;
		ResultSet result=null;
//		连接数据库,创建连接对象
		Connection conn = JDBCUtils.getConnection();
//		创建编译环境
		try
		{
			prepareStatement = conn.prepareStatement(SQL_USER_SELECT);
//			设置sql语句中的参数
			prepareStatement.setInt(1, idname);
			prepareStatement.setString(2, uname);
//			执行语句
			result = prepareStatement.executeQuery();
			while(result.next()) 
			{
				int idname1=result.getInt("IdName");
				String name=result.getString("uname");
				String gender=result.getString("Gender");
				int age=result.getInt("Age");
				String major=result.getString("Major");
				String password=result.getString("upass");
				int type =result.getInt("type");
				
			return new User(idname1,name,gender,age,major,password,type);
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.close(conn,prepareStatement,result);
		}
		return null ;
	}

}
