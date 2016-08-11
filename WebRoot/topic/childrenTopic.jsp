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

<title><s:property value="#request.section.sectionName" />-开封电视台论坛</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="style/usernav.css">

</head>

<body>
<%
/* String userName=(String)request.getAttribute("userName");
request.setAttribute("userName",userName);
out.print(userName); */

 %>
欢迎你！${userName}
 <div class="content" id="content">
<div id="logo" class="logo">
			<img src="image/logo2.jpg" />
		</div>

		<div id="nav" class="nav">
			<table id="content_nav">
				<tr>
					<td>首页</td>
					<td>文化</td>
					<td>旅游</td>
					<td>餐饮</td>
					<td>房产</td>
					<td>汽车</td>
					<td></td>
					<td></td>
					<td></td>
					<td>个人中心</td>
					<td>更改密码</td>
					
					<td>退出</td>
				</tr>
			</table>
		</div>
		<div class="content-main" id="content-main">
		<div class="content-button"><s:a href="publichSwitch.action?userName=%{#request.userName}&&userID=%{#request.userID}">&nbsp; 发表帖子</s:a></div>
	<table width="1000" align="center" border="1" cellspacing="0">
		<s:iterator value="#request.list" id="topicCls">
			<tr height="30px">
				<td><s:a
						href="getSingleTopic.action?topicID=%{#topicCls.topicID}&userID=%{#request.userID}">
						<s:property value="title" />
					</s:a></td>
				<td><s:property value="userName" /></td>
				<td><s:property value="publishDate" /></td>
			</tr>
		</s:iterator>
		<tr>
				<td  colspan="3" align="right">
				<s:a href="childrenPageSort.action?sectionID=%{#request.sectionID}&&pageNow=1">首页</s:a>
				<s:a href="childrenPageSort.action?sectionID=%{#request.sectionID}&&pageNow=%{#request.PageNow-1}">上一页</s:a>
				<s:a href="childrenPageSort.action?sectionID=%{#request.sectionID}&&pageNow=%{#request.PageNow+1}">下一页</s:a>
				</td>
				</tr>
	</table>
	</div>
</div>
</body>
</html>
