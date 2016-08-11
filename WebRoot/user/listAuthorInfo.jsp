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

<title>个人空间—开封电视台</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="style/space.css">


</head>

<body>
	<div class="content" id="content">
		<div id="logo" class="logo">
			<img src="image/spacetitle.jpg" alt="space" />
		</div>


		<div id="leftziliao" class="leftziliao">
			<div id="person">
				<h2>个人资料</h2>
				<div id="logo" class="logo" align="center">
					<img src="image/guest.jpg" alt="头像" width="107" height="120" />
				</div>
				<div class="listName">
					<s:property value="#request.user.userName" />
				</div>
			</div>
			<div id="tongji">
				<h2>统计信息</h2>

				<div class="infoList">
					<div>
						性别：
						<s:if test="#request.user.sex==0">男</s:if>
						<s:else>女</s:else>
					</div>
					<div>
						注册日期：
						<s:property value="#request.user.registerDate" />
					</div>
					<div>
						用户签名：
						<s:property value="#request.user.userSignature" />
					</div>
					<div>
						用户积分：
						<s:property value="#request.user.userScore" />
					</div>
					<div>
						主题数：
						<s:property value="#request.user.userScore" />
					</div>
				</div>
			</div>
			<div id="jilu">
				<h2>记录信息</h2>

				<div class="listhot"></div>
			</div>

		</div>



		<div id="rightziliao" class="leftziliao">

			<div id="activities">
				<h2>个人动态</h2>

				<div class="newActive">
					<table cellspacing="0" width="743" border="1">
						<s:iterator value="#request.newList" id="topics">
							<tr>
								<td><s:a
										href="getAuthorSingleTopic.action?topicID=%{#topics.topicID}&&authorID=%{#request.authorID}&&userName=%{#request.userName}&&userID=%{#request.userID}">
										<s:property value="title" />
									</s:a>
								</td>
								<td><s:property value="publishDate" />
								</td>
							</tr>
						</s:iterator>

					</table>

				</div>
			</div>



			<div id="authorTopics">
				<h2>作者帖子</h2>

				<div class="authorTopic">
					<table border="1" width="743" cellspacing="0">
						<s:iterator value="#request.list" id="topics">
							<tr>
								<td><s:a
										href="getAuthorSingleTopic.action?topicID=%{#topics.topicID}&&authorID=%{#request.authorID}&&userName=%{#request.userName}&&userID=%{#request.userID}">
										<s:property value="title" />
									</s:a>
								</td>
								<td><s:property value="publishDate" />
								</td>
							</tr>
						</s:iterator>
						<tr>
							<td colspan="2" align="right"><s:a
									href="getAuthorInfo.action?authorID=%{#request.authorID}&&userName=%{#request.userName}&&flag=0&&pageNow=1">首页</s:a>
								<s:a
									href="getAuthorInfo.action?authorID=%{#request.authorID}&&userName=%{#request.userName}&&flag=0&&pageNow=%{#request.PageNow-1}">上一页</s:a>
								<s:a
									href="getAuthorInfo.action?authorID=%{#request.authorID}&&userName=%{#request.userName}&&flag=0&&pageNow=%{#request.PageNow+1}">下一页</s:a>
							</td>
						</tr>
					</table>
				</div>
			</div>


			<div id="liuyan">
				<h2>留言板</h2>
				<table cellspacing="0" width="743" border="1">
					<s:iterator value="#request.listMessage" id="message">
						<tr>
							<td><s:property value="content" /></td>

							<td><s:property value="publishDate" /></td>
						</tr>
					</s:iterator>
				</table>
				<s:form action="getAuthorInfo">
					<s:textarea name="content" id="content"></s:textarea>
					<s:hidden name="authorID" value="%{#request.user.userID}"></s:hidden>
					<s:hidden name="userID" value="%{#request.userID}"></s:hidden>
					<s:hidden name="userName" value="%{#request.user.userName}"></s:hidden>
					<s:hidden name="pageNow" value="1"></s:hidden>
					<s:hidden name="flag" value="1"></s:hidden>
					<input type="submit" value="提交">
				</s:form>

			</div>

		</div>


























	</div>






</body>
</html>
