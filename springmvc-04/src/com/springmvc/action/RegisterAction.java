package com.springmvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.springmvc.dao.StudentDao;
import com.springmvc.entity.Student;

public class RegisterAction extends AbstractController{
	private ApplicationContext ac=new ClassPathXmlApplicationContext("/bean.xml");
	private StudentDao studentDao=(StudentDao)ac.getBean("studentDao");

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView modelAndView=new ModelAndView();
		try
		{
			String id=request.getParameter("id");
			String pwd1=request.getParameter("pwd1");
			String pwd2=request.getParameter("pwd2");
			String name=request.getParameter("name");
			Integer gender=(request.getParameter("gender").equals("男"))?1:0;
			System.out.println(id+","+pwd1+","+pwd2+","+name+","+gender);
			Student daoStu=studentDao.getById(id);//抛EmptyResultDataAccessException异常
			System.out.println(daoStu.toString());
			
			if(daoStu!=null&&id.equals(daoStu.getId()))//账号已注册
			{
				modelAndView.setViewName("login");
				modelAndView.addObject("object", "该账号已被注册，请直接登录！");
			}
			else if(id!=null
					&&pwd1!=null
					&&pwd2!=null
					&&name!=null
					&&gender!=null)//账号未注册，id填写正确，两次密码相等,其他字段不为空
			{
				if(!pwd1.equals(pwd2))
				{
					modelAndView.setViewName("register");
					modelAndView.addObject("object", "两次密码不一致，请重新输入！");
				}
				else
				{
					studentDao.setAcount(id, name, pwd1, gender);
					modelAndView.setViewName("login");
					modelAndView.addObject("object", "账号注册成功，请登录！");
				}
			}
			else//未正确填写
			{
				modelAndView.setViewName("register");
				modelAndView.addObject("object", "请正确填写！");	
			}
			return modelAndView;
		}
		catch (NullPointerException e)
		{
			modelAndView.setViewName("register");
			modelAndView.addObject("object", "请正确填写！");
			return modelAndView;
		}	
		
	}

}
