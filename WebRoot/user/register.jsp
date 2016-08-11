<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  prefix="s"   uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册-开封电视台</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="style/personal.css">
	 <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="js/yanzheng.js"></script>
  </head>
  
  <body>
  <div class="content" id="content">
  <div> <img alt="logo" src="image/registerlogo.jpg"> </div>
  <div class="main" id="main">
  <s:form  action="registerUser">
  <table   align="center">
  <tr>
  <td>
    用户名：<input type="text"  name="userName" id="userName">
    
    <span id="userNameError"></span>
    </td>
    </tr>
    <tr>
    <td>&nbsp; 
    密码：<input type="password" name="password" id="password"  >
    
    <span id="passwordError"></span>
    </td>
    </tr>
   <tr>
    <td>&nbsp; 签名: <input type="text"   name="userSignature" id="userSignature" >
    </td>
    </tr>
    <tr>
    <td>&nbsp; &nbsp; QQ: <input type="text"   name="QQ" id="QQ" >
    </td>
    </tr>
    <tr>
    <td>&nbsp; 邮箱：<input type="text"  name="Email"   id="email">
    
    <span id="emailError"></span>
    </td>
    </tr>
    <tr>
    <td>&nbsp; 
 性别：<input  type="radio"  name="sex" value="0">男&nbsp; &nbsp; 
 <input checked="checked" type="radio" name="sex" value="1">女
 
 
 
 <%-- <s:radio  name="sex"  list="#{'0':'男','1':'女'}" label="性别"  value="0"></s:radio> --%>
   </td>
   </tr>
   <tr>
   <td>
   <input type="hidden"   name="userLimit"   value="0">
   </td>
   </tr>
   <tr>
   <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;
   <input type="submit" value="注册" id="registerSubmit">已有账户<a href="user/userLogin.jsp">登录</a>
   </td>
   </tr>
  
   </table>
    
    </s:form>
    </div>
    
	
    </div>
  </body>
</html>
