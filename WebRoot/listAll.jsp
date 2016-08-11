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

<title>My JSP 'listAll.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="style/a.css"/>
<script type="text/javascript">
	
	function del()
	{
		if(confirm("确定删除吗？"))
		{
			return true;	
		}
		
		return false;
	}
	
	
	</script>

  </head>
  





</head>

<body>
	<!-- 注册成功！如果不能跳转请点击 -->
	显示帖子列表
	<s:a href="showTopic.action">这里</s:a>
	手动跳转!

	<table width="80%" align="center" >

		<tr>

			<th>用户名</th>
			<th>密码</th>
			<th>注册日期</th>
			<th>QQ号</th>
			
			<th>邮箱</th>
			<th>性别</th>
			
			<th>用户图片</th>
			<th>用户签名</th>
			<th>用户积分</th>
			<th>用户权限</th>
			<th>操作</th>

		</tr>
		<!-- 不加id也能显示，id是为了方便超链接 -->
		<!--value是指要迭代的目标。 request.list是指获得请求的list，即PersonAction的list；id属性是指标识当前正在迭代的对象，此属性主要使用在超链接获得id属性方便修改 -->
		<s:iterator value="#request.list" id="user">

			<tr>

				<td><s:property value="userName" /></td>

				<td><s:property value="password" /></td>
				
				<td><s:property value="registerDate" /></td>
				
				<td><s:property value="QQ" /></td>
				<td><s:property value="Email" /></td>
				 <td><s:property value="sex" /></td> 
				
				<%-- <s:property list="#{'1':'先生','0':'女士'}" name="gender" value="sex"/> --%>
				
				<td><s:property value="userPhoto" /></td>
				<td><s:property value="userSignature" /></td>
				<td><s:property value="userScore" /></td>
				<td><s:property value="userLimit" /></td>
				<td><s:a href="deleteUser.action?userID=%{#user.userID}" onclick="return del();">删除</s:a>|<s:a href="getSingleUser.action?userID=%{#user.userID}">信息修改</s:a>|<s:a  href="listAll.jsp">冻结账户</s:a></td>
			</tr>

		</s:iterator>

		<s:form action="showTopic">
         
         <s:submit   value="显示所有的帖子"  />
         </s:form> 
</body>
</html>
