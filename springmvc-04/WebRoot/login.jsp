<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生登录页面</title>
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
    <form action="${pageContext.request.contextPath}/login.action" method="POST">
    <table border="0" align="center">
    <tr>
    	<th>账号：</th>
    	<td><input name="id" type="text" value="222015602063002"/></td>
    </tr>
    <tr>
    	<th>密码：</th>
    	<td><input name="pwd" type="password" value="123456"/></td>
    </tr>
    <tr>
    	<td colspan="2" align="center"><input type="submit" value="登  录"/></td>
    </tr>
    </table>
    </form>
  </body>
</html>
