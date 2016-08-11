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

<title>用户登录-开封电视台</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="style/personal.css">

</head>

<body>
             
	<div class="content" id="content">
		<div id="logo" class="logo">
			<img src="image/logo2.jpg" />
		</div>
		<div class="main" id="main">

			<form action="userLogin" method="post">
				<table align="center">
				<tr><td> ${Error} </td></tr>
					<tr>
					
						<td>用户名: <input type="text" name="userName" id="userName1">
							<span id="userNameError1"></span></td>
					</tr>
					<tr>
						<td>&nbsp; 密码: <input type="password" name="password"
							id="password"> <span id="passwordError"></span></td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; <a
							href="user/register.jsp">注册用户</a> &nbsp; <input type="submit"
							value="登陆" id="loginSubmit"></td>
					</tr>
					
				</table>
			</form>

		</div>
	</div>
	<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="js/yanzheng.js"></script>
</body>
</html>
