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

<title>导航页面-开封电视台</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="style/usernav.css">

</head>

<body>
	
	<div class="content" id="content">

		<div id="logo" class="logo">
			<img src="image/logo2.jpg" />
		</div>
	welcome ${sessionScope.userName}!
    <s:a href="achieveSection.action">首页</s:a>

	<s:a href="publichSwitch.action">发帖</s:a>
	

		<div id="nav" class="nav">
			<table id="content_nav">
				<tr>
					<td><s:a href="achieveSection.action">首页</s:a></td>
					<td>文化</td>
					<td>旅游</td>
					<td>餐饮</td>
					<td>房产</td>
					<td>汽车</td>
					<td></td>
					<td></td>
					<td></td>
					<td><a href="user/userLogin.jsp">登录</a></td>
					<td><a href="user/register.jsp">注册</a></td>
				</tr>
			</table>
		</div>

		<div>${userName}欢迎您！</div>
		<div>
		<form action="search.action" method="post">
		<table>
	        <tr><td>
			<input type="text" name="searchText">
			</td><td>
			
				<select name="Item" id="type">
					<option value="0">帖子</option>
					<option value="1">用户</option>
					
				</select>
				</td><td>
				
				 <input type=submit value="搜索" />
				 </td>
				</table>
			</form>




		</div>
		<div class="content-new" id="content-new">
			<div id="advertise">
				<h2>广告</h2>
				<div>
					<img alt="guangao" src="image/guanggao.jpg" width="248"
						height="223">
				</div>




			</div>
			<div id="rank">
				<h2>热帖</h2>
				<div class="listnum">
					<ol style="width:15;margin:2;padding:0;">
						<li><span class="top3" style="13;">1</span>
						</li>
						<li><span class="top3">2</span>
						</li>
						<li><span class="top3">3</span>
						</li>
						<li><span class="top10">4</span>
						</li>
						<li><span class="top10">5</span>
						</li>
						<li><span class="top10">6</span>
						</li>
						<li><span class="top10">7</span>
						</li>
						<li><span class="top10">8</span>
						</li>
						<li><span class="top10">9</span>
						</li>
						<li><span class="top10">10</span>
						</li>

					</ol>
				</div>
				<div class="listhot">
					<ul style="margin:0;padding:0;">
						<s:iterator value="#request.hotList" id="hot">
							<li><s:a href="getSingleTopic.action?topicID=%{#hot.topicID}" width="150">
									<s:property value="title" />
								</s:a><span class="clicknum"><s:property value="clickCount" />
							</span>
							</li>
						</s:iterator>
					</ul>
				</div>
			</div>

			<div id="newTopic">
				<h2>最新热帖</h2>
				<div class="listnum">
					<ol style="width:15;margin:2;padding:0;">
						<li><span class="top3" style="13;">1</span>
						</li>
						<li><span class="top3">2</span>
						</li>
						<li><span class="top3">3</span>
						</li>
						<li><span class="top10">4</span>
						</li>
						<li><span class="top10">5</span>
						</li>
						<li><span class="top10">6</span>
						</li>
						<li><span class="top10">7</span>
						</li>
						<li><span class="top10">8</span>
						</li>
						<li><span class="top10">9</span>
						</li>
						<li><span class="top10">10</span>
						</li>

					</ol>
				</div>
				<div class="listhot">
					<ol style="margin:0;padding:0;">
						<s:iterator value="#request.newHotList" id="newhot">
							<li><s:a href="getSingleTopic.action?topicID=%{#newhot.topicID}">
									<s:property value="title" />
								</s:a><span class="clicknum"><s:property value="publishDate" />
							</span>
							</li>
						</s:iterator>
					</ol>
				</div>
			</div>

			<div id="notice">
				<h2>论坛公告</h2>
				<div class="listNotice">
					<ul style="margin:0;padding:0;">
						<s:iterator value="#request.noticelist" id="notices">
							<li><s:a href="#" style="width:150px">
									<s:property value="content" />
								</s:a><span class="clicknum"><s:property value="publishDate" />
							</span>
							</li>
						</s:iterator>
					</ul>
				</div>

			</div>



		</div>

		<div class="content-main" id="content-main">
			<table width="1000px" align="center" border="1" cellpadding="0"
				cellspacing="0">
				<s:iterator value="#request.listParent" id="section">


					<tr style="background-color:#E9E9E9">

						<td>≡<s:property value="sectionName" />≡</td>
						<td><s:property value="sectionIntro" /></td>
					</tr>


					<!--被嵌套的表  -->

					<tr>

						<s:iterator value="#request.listchildren" id="section1">
							<s:if test="parentSectionID==#section.sectionID">
								<tr height="50">


									<td><s:a
											href="childrenPageSort.action?sectionID=%{#section1.sectionID}&pageNow=1">
											<s:property value="sectionName" />
										</s:a></td>
									<td><s:property value="sectionIntro" /></td>

								</tr>
							</s:if>
						</s:iterator>

					</tr>
				</s:iterator>

			</table>

		</div>
		<div>
			<img src="image/advertise.jpg" alt="广告" width="1000">



		</div>
		<div class="frienfLink" id="frienfLink">
			<table border="1" cellspacing="0">
				<tr>
					<td>友情链接</td>
				</tr>
				<tr>
					<td>
						<ul class="x mbm cl">
							<li><a href="http://www.kf.cn/" target="_blank" title="开封网">开封网</a>
							</li>
							<li><a href="http://www.zzbbs.com/" target="_blank"
								title="郑州论坛">郑州论坛</a></li>
							<li><a href="http://www.chtongxu.gov.cn/bbs/"
								target="_blank" title="通许论坛">通许论坛</a></li>
							<li><a href="http://www.lksq.net" target="_blank"
								title="兰考社区">兰考社区</a></li>
							<li><a href="http://www.qixianwang.com/" target="_blank"
								title="杞县网">杞县网</a></li>
							<li><a href="http://bbs.zmd5.com " target="_blank"
								title="驻马店论坛">驻马店论坛</a></li>
							<li><a href="http://kf.zhongyuan.com " target="_blank"
								title="中原开封人才网">中原开封人才网</a></li>
							<li><a href="http://jy302.com " target="_blank" title="江油论坛">江油论坛</a>
							</li>
							<li><a href="http://bbs.0751.cc " target="_blank"
								title="韶关论坛">韶关论坛</a></li>
							<li><a href="http://bbs.0769ok.com " target="_blank"
								title="东莞论坛">东莞论坛</a></li>
							<li><a href="http://www.kfpkw.com" target="_blank"
								title="开封拼客网">开封拼客网</a></li>
							<li><a href="http://www.kfsy.cn " target="_blank"
								title="宋韵论坛">宋韵论坛</a></li>
							<li><a href="http://zj0759.com " target="_blank"
								title="湛江论坛">湛江论坛</a></li>
							<li><a href="http://kfxhbook.com " target="_blank"
								title="开封市新华书店">开封市新华书店</a></li>
							<li><a href="http://duocai18.com " target="_blank"
								title="郴州论坛">郴州论坛</a></li>
							<li><a href="http://hao0378.com " target="_blank"
								title="开封网址导航">开封网址导航</a></li>
							<li><a href="http://baiduhao.net" target="_blank"
								title="开封网址导航">开封网址导航</a></li>
							<li><a href="http://bbs.jyrb.cn " target="_blank"
								title="济源社区">济源社区</a></li>
							<li><a href="http://bbs.lkntv.cn " target="_blank"
								title="焦桐社区">焦桐社区</a></li>
							<li><a href="http://bbs.neihuang.cc " target="_blank"
								title="内黄论坛">内黄论坛</a></li>
							<li><a href="http://www.dachengdu.net " target="_blank"
								title="大成都社区">大成都社区</a></li>
							<li><a href="http://kaifeng.tianqi.com " target="_blank"
								title="开封天气预报">开封天气预报</a></li>
							<li><a href="http://5huang.com" target="_blank"
								title="开封五黄电影">开封五黄电影</a></li>
							<li><a href="http://kaifeng.dafengso.com " target="_blank"
								title="开封招聘">开封招聘</a></li>
							<li><a href="http://kfhao.com " target="_blank"
								title="开封好店网">开封好店网</a></li>
							<li><a href="http://hxl18.com " target="_blank" title="宋城论坛">宋城论坛</a>
							</li>
							<li><a href="http://bbs.sycsh.com/forum.php" target="_blank"
								title="三叶草论坛">三叶草论坛</a></li>
							<li><a href="http://www.beijingcx.com" target="_blank"
								title="北京城乡论坛">北京城乡论坛</a></li>
							<li><a href="http://www.lankaowang.com/" target="_blank"
								title="兰考网">兰考网</a></li>
							<li><a href="http://kfxysy.kf.cn" target="_blank"
								title="开封兴银实业">开封兴银实业</a></li>
							<li><a href="http://www.475500.net/" target="_blank"
								title="尉氏生活网">尉氏生活网</a></li>
							<li><a href="http://jq.zxdyw.com/ " target="_blank"
								title="酒泉装修网">酒泉装修网</a></li>
							<li><a href="http://www.jiaoling.cc/" target="_blank"
								title="蕉岭热线">蕉岭热线</a></li>
							<li><a
								href="http://s.click.taobao.com/t?e=zGU34CA7K%2BPkqB05%2Bm7rfGKZd2WSU5PGV8RjIjTeYKwtcPFd0CHuCi6s6mOAPd0ecrZHQfFubbRejWdKWFd7AOw%2BRC4bt3qG0%2BG7wNoHq6gN4M0UTQkAmwTpTue390upvC4wL%2BA%3D"
								target="_blank" title="凡客诚品">凡客诚品</a></li>
							<li><a
								href="http://s.click.taobao.com/t?e=zGU34CA7K%2BPkqB07S4%2FK0CFcRfH0GoT805sipKvL3inOsGexA56W%2FPfYoWwxyf5NSIDEeYkF7W%2Bk1wH%2F4lfCFYTRERd%2BlCwuMW1DtjUhK9U8MQ%3D%3D"
								target="_blank" title="金士顿TF卡">金士顿TF卡</a></li>
							<li><a href="http://cloud.workercn.cn" target="_blank"
								title="中工云信">中工云信</a></li>
							<li><a href="http://www.lfshfww.com " target="_blank"
								title="雷锋生活服务网">雷锋生活服务网</a></li>
							<li><a href="http://www.kfpolice.com" target="_blank"
								title="开封交警信息网">开封交警信息网</a></li>
							<li><a href="http://www.xytch.com" target="_blank"
								title="襄阳论坛">襄阳论坛</a></li>
						</ul></td>
				</tr>
			</table>
		</div>
		<div class="footer" id="footer">
			<div>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="">举报删帖</a>|<a href="">手机版</a>|<a href="" title="开封网联系方式"
					target="_blank">联系我们</a>
			</div>
			<div class="comiis_Copyright">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				Copyright &copy; 2008-2012 <a href="http://club.kf.cn"
					target="_blank">开封电视台 </a>(http://club.kf.cn) 版权所有 All Rights
				Reserved.<br />

				<!---*感谢您对开封电视台的支持，谢谢!*--->
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="http://bbs.kftv.cn" target="_blank">豫ICP备05000882号</a>
				&nbsp;&nbsp;<span id="tcss"></span>
			</div>

		</div>


	</div>
</body>
</html>
