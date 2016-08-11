<%@ page language="java" import="java.util.* , com.forum.model.*"
	pageEncoding="UTF-8"%>
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

<title><s:property value="#request.topic.title" />-开封电视台论坛</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


<link rel="stylesheet" type="text/css" href="style/usernav.css">

<script type="text/javascript" src="./ueditor/editor_config.js"></script>
<script type="text/javascript" src="./ueditor/editor_all.js"></script>
<link rel="stylesheet" type="text/css"
	href="./ueditor/themes/default/ueditor.css" />
	
	
</head>

<body>

<%



/* String userName = (String) session.getAttribute("userName");
	String id = (String) session.getAttribute("userID"); */
 %>
	<%
		 String userName = (String) request.getAttribute("userName"); //.getParameter("userName");

       String userID = (String) request.getAttribute("userID");
		request.setAttribute("userName", userName);
        request.setAttribute("userID", userID);
		out.print(userName); 
		out.print(userID);  
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
					<td>登录</td>
					<td>注册</td>
				</tr>
			</table>
		</div>

		<div></div>
	<table width="1000" align="center" border="1" cellspacing="0">
		<tr>
			<!-- <th>帖子ID</th> -->
			<th>发表人</th>
			<th>帖子标题</th>
			<th>帖子内容</th>

			<th>发表时间</th>
		</tr>
		<!-- 显示一系列的帖子，然后加上超链接显示个人的帖子 -->
		<tr style="height:100px">
			<td>
			<!-- 得到用户信息 -->
			<s:a href="getAuthorInfo.action?authorID=%{#request.authorID}&&userName=%{#request.user.userName}&&pageNow=1&&userID=%{#request.userID}&&flag=0" ><s:property value="#request.user.userName" /></s:a>
			</td>
			
			
			<!-- 得到发帖用户信息 -->
			
			<td><s:property value="#request.topic.title" />
			</td>

			<td  height="200"><s:property value="#request.topic.content"
					escapeHtml="false" />&nbsp; &nbsp; &nbsp; &nbsp;</td>


			<td><s:property value="#request.topic.publishDate" />
			</td>
		</tr>

		<!--得到所有的回帖  -->


		<s:iterator value="#request.list" id="replyTopics">

			<tr>
			
                  <!-- 得到回帖用户信息 -->
                <!--   需要改 -->
				<td><s:a href="getAuthorInfo.action?authorID=%{#replyTopics[1].userID}&&userName=%{##replyTopics[1].userName}&&pageNow=1&&userID=%{#request.userID}&&flag=0"><s:property value="#replyTopics[1].userName" /></s:a>
				</td>
				<td><s:property value="#request.topic.title" />
				</td>
				<td height="200"><s:property value="#replyTopics[0].content" escapeHtml="false" />
				</td>

				<td><s:property value="#replyTopics[0].publishDate" />
				</td>

			</tr>
		</s:iterator>

	</table>

	<s:form action="replyTopic">
        <div  id="forbin">

		回帖：<textarea name="content" id="myEditor">这里写你的初始化内容</textarea>
		</div>
				<script type="text/javascript">
				
						var editor = new baidu.editor.ui.Editor({
						toolbars : [ [ 'insertimage', 'RowSpacing',
								'FontFamily', 'FontSize', 'link', 'emotion' ] ]
					});
					editor.render("myEditor");
					//1.2.4以后可以使用一下代码实例化编辑器
					//UE.getEditor('myEditor')
					
				</script>

		<!--回复内容  -->
		<s:hidden name="topicID" value="%{#request.topic.topicID}"></s:hidden>
		<!-- 要回复的帖子的ID -->

		<s:hidden name="userName" value="%{#request.userName}"></s:hidden>
		<s:hidden name="userID" value="%{#request.userID}"></s:hidden>
		<!--回帖人的姓名 ,即要得到当前用户名 ,注意和帖子表的姓名别弄混了-->
		<!--  <s:hidden name="_rUserID"  value="%{#request.userID}"></s:hidden> -->
		<!-- 回帖人的ID -->

		<!-- <s:a href="replyTopic.action?topicID=%{#request.topicID}">回帖</s:a> -->
		<s:submit id="submit" value="提交评论" onClick="hh()" ></s:submit>

	</s:form>
	</div>
	
</body>
</html>
