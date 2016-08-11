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

<title>我的所有帖子</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="style/usernav.css">
<%
  	String userName = (String) session.getAttribute("userName");
	String id = (String) session.getAttribute("userID");
	if (null == userName) {
		request.setAttribute("Error",
				"请您先登录再继续操作！");
		RequestDispatcher rd = request.getRequestDispatcher("/user/userLogin.jsp");
				
		rd.forward(request, response);
	}
	//request.setAttribute("userName", name);
	//request.setAttribut e("userID", id);
%>
</head>

<body>

      
       
	<%
	//原先属性的获得
		/* String name = (String) request.getAttribute("userName");
		String id = (String) request.getAttribute("userID");
		out.print(name + "==");
		out.print(id);
		request.setAttribute("userName", name);
		request.setAttribute("userID", id); */
	%>

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

					<td><a href="user/logout.jsp">退出</a></td>
				</tr>
			</table>
		</div>

		<div class="content-main" id="content-main">
			<div class="content-button">
				<input type="button" name="publishTopic" value="发表帖子">
			</div>
			<div>
			<table align="center" border="1" cellspacing="0">
				<s:iterator value="#request.list" id="topic">
                    <s:if test="isVerify==1">
					<tr height="30">
						<td width="800px"><s:a
								href="getMySingleTopic.action?topicID=%{#topic.topicID}&&userID=%{#request.userID}&&userName=%{#request.userName}">
								<s:property value="title" />
							</s:a></td>

						<!--  <td width="500px"><s:property value="Content" /></td> -->
						<td width="200px"><s:a
								href="removeTopic.action?topicID=%{#topic.topicID}&&userID=%{#request.userID}&&userName=%{#request.userName}">删除</s:a>
						</td>

					</tr>
                   </s:if>
				</s:iterator>
				<tr>
				<td  colspan="2" align="right">
				<s:a href="pageSort.action?userID=%{#request.userID}&&userName=%{#request.userName}&&pageNow=1">首页</s:a>
				<s:a href="pageSort.action?userID=%{#request.userID}&&userName=%{#request.userName}&&pageNow=%{#request.PageNow-1}">上一页</s:a>
				<s:a href="pageSort.action?userID=%{#request.userID}&&userName=%{#request.userName}&&pageNow=%{#request.PageNow+1}">下一页</s:a>
				</td>
				</tr>
			</table>
		</div>
	</div>
</div>

</body>

</html>