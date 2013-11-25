<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.hanphon.recruit.domain.NoticeDomain"%>
<%@page import="com.hanphon.recruit.dao.*"%>
<%@page import="com.hanphon.recruit.dao.impl.*"%>
<%@page import="java.sql.Date"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>注册页面</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<script type="text/javascript" src="../jslib/jquery1.4.4.js"></script>
		<script type="text/javascript" src="../jslib/index.js"></script>
		<link rel="stylesheet" type="text/css" href="../css/index.css">
	</head>

	<body>
		<div id="container">
			<jsp:include page="header1.jsp"></jsp:include>
			<div id="context">
				<div id="notice-left">
					<div id="title">
						<div id="title_left">
							<h3 style="font: '宋体'; font-size: small; padding-left: 10px;">
								<img src="../icon/point.gif">
								通告
								<span style="font-size: x-small; color: gray;"> News </span>
							</h3>
						</div>
						<div id="title_right">
							<a id="more" href="#" style="text-decoration: none;">more<img
									height='18px' style="border: 0px;" src="../icon/more.png">
							</a>
						</div>
					</div>
					<ul>
						<%
							NoticeDao dao = new NoticeDaoHibernateImpl();
							List<NoticeDomain> list1 = dao.getAll();
							int a = list1.size();
							StringBuffer buffer = new StringBuffer("");

							if (a > 8) {
								a = 8;
							}

							for (int i = 0; i < a; i++) {
								Date date = new Date(list1.get(i).getTime().getTime());
						%>
						<li class="news_item">
							<a id="<%=list1.get(i).getNdid()%>"
								href="noticeAction?item=<%=i%>"
								onmouseout="onMouseOut('<%=list1.get(i).getNdid()%>');"
								onmouseover="onMouseOver('<%=list1.get(i).getNdid()%>');"
								class="news_item_a" > <img style="border: 0px"
									src="../icon/view_detail.png"> <%=date.toString() + "\t" + list1.get(i).getNdtitle()%>
							</a>
						</li>
						<%
							}
						%>
					</ul>
				</div>
				<div id="login-right">
					<table id="register-context"
						style="margin-left: 10%; margin-top: 5%;">
						<tr id="row1" height="20%">
							<td colspan="3" style="width: 30%">
								<img height="25px" src="../icon/register_title.png">
								<span class="title">注册</span>
							</td>
						</tr>
						<tr id="row2" height="20%">
							<td style="width: 20%" align="center">
								<label class="login_label">
									邮箱:
								</label>
							</td>
							<td style="width: 40%">
								<input class="login_text" id="emailAddress" name="emailAddress"
									type="text" maxlength="50" onblur="emailAddress()">
							</td>
							<td>
								<span id="warn1" class="warn"></span>
							</td>
						</tr>
						<tr id="row2" height="20%">
							<td style="width: 20%" align="center">
								<label class="login_label">
									密码:
								</label>
							</td>
							<td style="width: 40%">
								<input class="login_text" id="password1" name="password1"
									type="password" maxlength="50" onblur="checkPassword1()">
							</td>
							<td>
								<span id="warn2" class="warn"></span>
							</td>
						</tr>
						<tr id="row2" height="20%">
							<td style="width: 20%" align="center">
								<label class="login_label">
									确认密码:
								</label>
							</td>
							<td style="width: 40%">
								<input class="login_text" id="passwordConfirm"
									name="passwordConfirm" type="password" maxlength="50"
									onblur="checkPasswordConfirm()">
							</td>
							<td>
								<span id="warn3" class="warn"></span>
							</td>
						</tr>
						<tr id="row2" height="20%">
							<td colspan="2" align="right">
								<input class="register_submit" onclick="RegisterClick()"
									type="button" value="注册">
							</td>
							<td>
								<span id="warn4" class="warn"></span>
							</td>
						</tr>
					</table>
				</div>
			</div>
			<div id="footer">
				<hr>
				<br>
				Copyright&copy 无锡汉方信息技术有限公司 版权所有
				<br>
				Wuxi Hanphon Information Technology Co.,Ltd All rights reserved.
				<br>
				地址 ：无锡新区创意产业园 C321-323
			</div>
		</div>
	</body>
</html>
