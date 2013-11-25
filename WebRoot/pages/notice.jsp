<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.hanphon.recruit.domain.NoticeDomain"%>
<%@page import="com.hanphon.recruit.dao.*"%>
<%@page import="com.hanphon.recruit.dao.impl.*"%>
<%@page import="java.sql.Date"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>通告</title>

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
								class="news_item_a"> <img style="border: 0px"
									src="../icon/view_detail.png"> <%=date.toString() + "\t" + list1.get(i).getNdtitle()%>
							</a>
						</li>
						<%
							}
						%>
					</ul>
				</div>
				<%
					int index = (Integer) request.getSession().getAttribute("item");
					Date date1 = new Date(list1.get(index).getTime().getTime());
				%>
				<div id="login-right">
					<table
						style="height: 80%; width: 70%; margin-top: 5%; margin-left: 10%; font-size: small; border-top: 1px solid; border-bottom: 1px solid; border-color: blue;">
						<tr>
							<td
								style="height: 20%; width: 30%; border-top: 1px solid; border-color: blue;"><%=date1%>
							</td>
							<td
								style="text-align: center; width: 70%; border-top: 1px solid; border-color: blue;"><%=list1.get(index).getNdtitle()%></td>
						</tr>
						<tr>
							<td colspan="2"
								style="height: 80%; overflow-y: atuo; border-top: 1px solid; border-bottom: 1px solid; border-color: blue;"><%=list1.get(index).getContent()%></td>
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
