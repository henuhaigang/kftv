<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>用户信息修改-开封电视台</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="style/personal.css">
	

</head>

<body>
 ${sessionScope.userName} 欢迎您 !

   <%
  	String userName = (String) session.getAttribute("userName");
	String id = (String) session.getAttribute("userID");
	if (null == userName) {
		request.setAttribute("Error",
				"请您先登录再继续操作！");
		RequestDispatcher rd = request.getRequestDispatcher("/user/userLogin.jsp");
				
		rd.forward(request, response);
	   }
     %>
<div class="content" id="content"> 
	<div class="update" id="update">
		<s:form action="updateUser">
			<s:textfield name="userName" value="%{#request.user.userName}"
				readonly="true" label=" 用户名"></s:textfield>
			<br>
			<s:password name="password" value="%{#request.user.password}"
				label=" 密码"></s:password>
			<br>
			<s:textfield name="registerDate"
				value="%{#request.user.registerDate}" readonly="true" label=" 注册日期"></s:textfield>
			<br>
			<s:textfield name="QQ" value="%{#request.user.QQ}" label="  QQ"></s:textfield>
			<br>

			<s:textfield name="Email" value="%{#request.user.Email}"
				label="   邮箱"></s:textfield>
			<br>

			<!--  <s:textfield name="sex" value="%{#request.user.sex}" label="性别"></s:textfield><br> -->
			<s:radio list="#{'0':'男','1':'女'}" name="gender"
				value="%{#request.user.sex}" />
			<s:textfield name="userPhoto" value="%{#request.user.userPhoto}"
				label=" 用户头像"></s:textfield>
			<br>

			<s:textfield name="userSignature"
				value="%{#request.user.userSignature}" label=" 用户签名"></s:textfield>
			<br>

			<s:textfield name="userScore" value="%{#request.user.userScore}"
				readonly="true" label="  用户积分"></s:textfield>
			<br>

			<s:textfield name="userLimit" value="%{#request.user.userLimit}"
				readonly="true" label="  用户权限"></s:textfield>
			<br>


			<s:hidden name="userID" value="%{#request.user.userID}"></s:hidden>


			<s:submit value="修改" />
		</s:form>
	</div>
	</div>
</body>
</html>
