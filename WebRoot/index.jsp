<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"   uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
    
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
                                            欢迎${sessionScope.userName}来到封电视台论坛！<!-- 显示管理员姓名 -->
 
              <s:a href="listAllUsers.action" >用户管理</s:a> <!-- 注意要包括冻结账户 -->
               <s:a href="" >帖子管理</s:a> <!--包括删帖，精华帖制定 -->
                <s:a href="" >发送通知</s:a> <!-- 用于向所有或个别用户发送通知消息 -->
                 <s:a href="publishTopic.jsp">发帖</s:a><!-- 管理员发帖 -->
   </body>
</html>
