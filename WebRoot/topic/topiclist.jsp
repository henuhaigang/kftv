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

<title>所有帖子-开封电视台</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="style/usernav.css">
</head>

<body>
 ${sessionScope.userName} 欢迎您 !
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
					<td>登录</td>
					<td>注册</td>
				</tr>
			</table>
		</div>
   
	welcome ${sessionScope.userName} !
	<%
 
    String name=(String)request.getAttribute("userName");
    String id=(String)request.getAttribute("userID");
  
  /* String Pagenow=(String)request.getAttribute("pageNow");
  int pageNow=Integer.parseInt(Pagenow);
  request.setAttribute("pageNow",pageNow); */
    request.setAttribute("userName", name);
    request.setAttribute("userID", id);
     %>
	<table width="1000" align="center" border="1" cellspacing="0">
		<tr>
			<!-- <th>帖子ID</th> -->
			<th>帖子标题</th>
			<th>帖子内容</th>
			<th>发表时间</th>
		</tr>
		<s:iterator value="#request.list" id="topiclist">
			<!-- 显示一系列的帖子列表，然后加上超链接显示个人的帖子 -->
			<tr height="30">

				<td><s:a
						href="getSingleTopic.action?topicID=%{#topiclist.topicID}&&userID=%{#request.userID}&&userName=%{#request.userName}">
						<s:property value="title" />
					</s:a>
				</td>

				<td><s:a
						href="getSingleTopic.action?topicID=%{#topiclist.topicID}&&userID=%{#request.userID}&&userName=%{#request.userName}">
						<s:property value="content" escapeHtml="false" />
					</s:a></td>

				<td><s:property value="publishDate" /></td>

			</tr>
			
		</s:iterator>
		      <tr>
				<td  colspan="3" align="right">
				<s:a href="allPageSort.action?pageNow=1">首页</s:a>
				<s:a href="allPageSort.action?pageNow=%{#request.PageNow-1}">上一页</s:a>
				<s:a href="allPageSort.action?pageNow=%{#request.PageNow+1}">下一页</s:a>
				</td>
				</tr>
		
	</table>
	<s:a
			href="publichSwitch.action?userID=%{#request.userID}&&userName=%{#request.userName}"> 发表帖子 </s:a>
</div>

</body>
</html>
