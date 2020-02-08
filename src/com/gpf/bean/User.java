package com.gpf.bean;

public class User
{
	private int idname;
	private String uname;
	private String gender;
	private int age;
	private String major;
	private int type;
	private String upass;
	public int getIdname()
	{
		return idname;
	}
	public void setIdname(int idname)
	{
		this.idname = idname;
	}
	public String getUname()
	{
		return uname;
	}
	public void setUname(String uname)
	{
		this.uname = uname;
	}
	
	public String getGender()
	{
		return gender;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public String getMajor()
	{
		return major;
	}
	public void setMajor(String major)
	{
		this.major = major;
	}
	public int getType()
	{
		return type;
	}
	public void setType(int type)
	{
		this.type = type;
	}
	public String getUpass()
	{
		return upass;
	}
	public void setUpass(String upass)
	{
		this.upass = upass;
	}
	
	public User()
	{
		super();
	}
	
	public User(int idname, String upass)
	{
		super();
		this.idname = idname;
		this.upass = upass;
	}
	public User(int idname, String upass,int type)
	{
		super();
		this.idname = idname;
		this.type = type;
		this.upass = upass;
	}
	
	public User(int idname, String uname, String major, String upass)
	{
		super();
		this.idname = idname;
		this.uname = uname;
		this.major = major;
		this.upass = upass;
	}
	public User(int idname, String uname, String gender, int age, String major, String upass)
	{
		super();
		this.idname = idname;
		this.uname = uname;
		this.gender = gender;
		this.age = age;
		this.major = major;
		this.upass = upass;
	}
	
	public User(int idname, String uname, String gender, int age, String major, String upass,int type)
	{
		super();
		this.idname = idname;
		this.uname = uname;
		this.gender = gender;
		this.age = age;
		this.major = major;
		this.type = type;
		this.upass = upass;
	}


	
	
	
}
