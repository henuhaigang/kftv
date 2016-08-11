<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>出错啦！</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
      <meta http-equiv="Refresh" content="5;url=user/userLogin.jsp" >
  </head>
  
  <body>
  <h3>
   <div align="center"> 
                                        您输入的账号或密码有误，请重新输入 。<Br/>
              本页面将在5秒后自动跳转到登录页面，若没有跳转，请点击<a href="user/userLogin.jsp">这里</a>。
    </div>
    </h3>
  </body>
</html>
