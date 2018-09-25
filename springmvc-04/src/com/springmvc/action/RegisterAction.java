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
			Integer gender=(request.getParameter("gender").equals("��"))?1:0;
			System.out.println(id+","+pwd1+","+pwd2+","+name+","+gender);
			Student daoStu=studentDao.getById(id);//��EmptyResultDataAccessException�쳣
			System.out.println(daoStu.toString());
			
			if(daoStu!=null&&id.equals(daoStu.getId()))//�˺���ע��
			{
				modelAndView.setViewName("login");
				modelAndView.addObject("object", "���˺��ѱ�ע�ᣬ��ֱ�ӵ�¼��");
			}
			else if(id!=null
					&&pwd1!=null
					&&pwd2!=null
					&&name!=null
					&&gender!=null)//�˺�δע�ᣬid��д��ȷ�������������,�����ֶβ�Ϊ��
			{
				if(!pwd1.equals(pwd2))
				{
					modelAndView.setViewName("register");
					modelAndView.addObject("object", "�������벻һ�£����������룡");
				}
				else
				{
					studentDao.setAcount(id, name, pwd1, gender);
					modelAndView.setViewName("login");
					modelAndView.addObject("object", "�˺�ע��ɹ������¼��");
				}
			}
			else//δ��ȷ��д
			{
				modelAndView.setViewName("register");
				modelAndView.addObject("object", "����ȷ��д��");	
			}
			return modelAndView;
		}
		catch (NullPointerException e)
		{
			modelAndView.setViewName("register");
			modelAndView.addObject("object", "����ȷ��д��");
			return modelAndView;
		}	
		
	}

}
