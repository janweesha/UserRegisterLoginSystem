<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生注册页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  	<center><font color="BLUE">${requestScope.object}</font></center>
    <form action="${pageContext.request.contextPath}/register.action" method="POST">
    <table border="0" align="center">
    <tr>
    	<th align="right">请填写账号：</th>
    	<td><input name="id" type="text" value="222015602063005"/></td>
    </tr>
    <tr>
    	<th align="right">请填写姓名：</th>
    	<td><input name="name" type="text" value="Tom"/></td>
    </tr>
    <tr>
    	<th align="right">输入密码：</th>
    	<td><input name="pwd1" type="password" value="144438"/></td>
    </tr>
    <tr>
    	<th align="right">确认密码：</th>
    	<td><input name="pwd2" type="password" value="144438"/></td>
    </tr>
    <tr>
    	<th align="right">选择性别：</th>
    	<td><input name="gender" type="radio" value="男"/>男
    		<input name="gender" type="radio" value="女"/>女</td>
    </tr>
    <tr>
    	<td colspan="2" align="center"><input type="submit" value="登  录"/></td>
    </tr>
    </table>
    </form>
  </body>
</html>
