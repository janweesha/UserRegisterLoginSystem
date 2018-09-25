package com.springmvc.dao;

import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springmvc.entity.Student;

public class StudentDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public StudentDao(){}
	public Student getById(String id)
	{
		
		String sql="select * from student where id=?";
		Student daoStu=new Student();
		try 
		{
			Map<String, Object> map=jdbcTemplate.queryForMap(sql,id);
			daoStu.setId(id);
			daoStu.setPwd((String)map.get("pwd"));
			daoStu.setName((String)map.get("name"));
			daoStu.setGender((Integer)map.get("gender"));
			return daoStu;
		} catch (EmptyResultDataAccessException e)
		{
			System.out.println("Œ¥’“µΩ∆•≈‰ID£°");
			return daoStu;
		}
	}
//	public void setAcount(String id,String pwd)
//	{
//		String sql="insert into student(id,name,pwd,gender) values(?,?)";
//		jdbcTemplate.update(sql,id,pwd);
//			
//	}
//	public void setAcount(String id,String name,String pwd)
//	{
//		String sql="insert into student(id,name,pwd,gender) values(?,?,?)";
//		jdbcTemplate.update(sql,id,name,pwd);
//			
//	}
//	public void setAcount(String id,String pwd,Integer gender)
//	{
//		String sql="insert into student(id,name,pwd,gender) values(?,?,?)";
//		jdbcTemplate.update(sql,id,pwd,gender);
//			
//	}
	public void setAcount(String id,String name,String pwd,Integer gender)
	{
		String sql="insert into student(id,name,pwd,gender) values(?,?,?,?)";
		jdbcTemplate.update(sql,id,name,pwd,gender);
			
	}
}
