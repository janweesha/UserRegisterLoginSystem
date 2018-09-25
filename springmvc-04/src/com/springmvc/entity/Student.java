package com.springmvc.entity;

public class Student {
	private String id=null;
	private String name=null;
	private String pwd=null;
	private Integer gender=null;
	
	public Student() {
		this.id=null;
		this.pwd=null;
		this.name=null;
		this.gender=null;
	}
	
	public Student(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public boolean equals(Student student)
	{
		if(this.id.equals(student.id)&&this.pwd.equals(student.pwd))
		{
			return true;
		}
		else return false;
	}
	
	public boolean onlyIdEquals(Student student)
	{
		if(this.id.equals(student.id)&&(!this.pwd.equals(student.pwd)))
		{
			return true;
		}
		else return false;
	}
	
	public String toString()
	{
		return id+","+name+","+pwd+","+gender;
	}
}
