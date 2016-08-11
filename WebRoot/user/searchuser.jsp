<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'searchuser.jsp' starting page</title>
    
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
     
    <div>
   
    <ul>
     <s:iterator value="#request.listUser" id="users">
    <li>
       <s:a href="getAuthorInfo.action?authorID=%{#users.userID}&&userName=%{#request.user.userName}&&pageNow=1&&userID=%{#request.userID}&&flag=0"> <s:property value="userName"/></s:a>
    </li>
     </s:iterator>
    </ul>
  
    </div>
    
  </body>
</html>
