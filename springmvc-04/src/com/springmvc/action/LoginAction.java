package com.springmvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.springmvc.dao.StudentDao;
import com.springmvc.entity.Student;

public class LoginAction extends AbstractController{//spring的Action类是单例模式
	private ApplicationContext ac=new ClassPathXmlApplicationContext("/bean.xml");
	
	private Student loginStu;
	private StudentDao studentDao;

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public LoginAction(){}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) 
					throws Exception
					{
		ModelAndView modelAndView=new ModelAndView();
		
		//从配置文件中注入StudentDao实例
		studentDao=(StudentDao)ac.getBean("studentDao");
		
		//将login.jsp中输入 的Id和pwd数据封装到Student对象
		loginStu=new Student(request.getParameter("id"),request.getParameter("pwd"));
		//loginStu(222015602063002,123456)
		System.out.println("\nloginStu:"+loginStu.getId()+","+loginStu.getPwd()+"\n");
		Student daoStu=studentDao.getById(loginStu.getId()); 
		if(daoStu.equals(loginStu))
		{
			modelAndView.setViewName("success");
			modelAndView.addObject("object", "登陆成功！");
		}else
		{
			modelAndView.setViewName("login");
			 if(daoStu.onlyIdEquals(loginStu))
			 {
				 modelAndView.addObject("object", "密码不正确！");
			 }else
			 {
				 modelAndView.addObject("object", "账号不存在！");
			 }
		}
		return modelAndView;
	}

}
