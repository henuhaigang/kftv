<%@ page language="java" import="java.util.* ,com.forum.model.*"
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

<title>发表您的帖子</title>

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
	
	
	<%
	/* String name = (String) session.getAttribute("userName");
	String id = (String) request.getAttribute("userID");
	//out.print(name);
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

					<td>退出</td>
				</tr>
			</table>
		</div>


		<div>
			<s:form action="publishTopic">

				<s:textfield name="Title" label="帖子标题"></s:textfield>

				<!-- <s:textarea name="Content" label="帖子内容"></s:textarea> -->


				<textarea name="Content" id="myEditor">这里写你的初始化内容</textarea>
				<script type="text/javascript">
					var editor = new baidu.editor.ui.Editor({
						toolbars : [ [ 'insertimage', 'RowSpacing',
								'FontFamily', 'FontSize', 'link', 'emotion' ] ]
					});
					editor.render("myEditor");
					//1.2.4以后可以使用一下代码实例化编辑器
					//UE.getEditor('myEditor')
				</script>



				<s:hidden name="userName" value="%{#request.userName}"></s:hidden>
				<!--发表人的姓名，这种思路是正确的-->

				<s:hidden name="userID" value="%{#request.userID}">
				</s:hidden>
				<!-- 发帖人的ID号 -->

				<!-- 设计一个下拉框，下拉框对应的是是Id号 -->
				<!--根据版块类别找到版块ID从而存入数据库  -->
				<s:select name="sectionID" label="帖子类别" headerKey="0"
					headerValue="---请选择---" list="#request.listchildren"
					listKey="sectionID" listValue="sectionName" />

				<s:submit name="submit" value="发表"></s:submit>

			</s:form>
		</div>
	</div>
</body>
</html>
