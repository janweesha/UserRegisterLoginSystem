package com.springmvc.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springmvc.entity.Student;

public class DaoTest {
	
	@Test
	public void test() throws Exception
	{
		ApplicationContext ac=new ClassPathXmlApplicationContext("/bean.xml");
		StudentDao studentDao=(StudentDao)ac.getBean("studentDao");
		Student student=studentDao.getById("100");
		System.out.println(student.toString());
//		studentDao.setAcount("004", "113861","Janwee", 1);
//		Student student=studentDao.getById("222015602063002");
//		System.out.println(student.getId()+","+student.getPwd()+","+student.getGender());
		
//		Student stu1=new Student("222015602063002","123456");
//		Student stu2=new Student("222015602063002","123456");
//		System.out.println(stu1.onlyIdEquals(stu2));
		
//			ApplicationContext ac=new ClassPathXmlApplicationContext("/bean.xml");
//			StudentDao studentDao = (StudentDao)ac.getBean("studentDao");
//			studentDao.setAcount("002", "113861", "одубн╟", 0);
	}
}