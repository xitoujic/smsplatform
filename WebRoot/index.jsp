<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.hanphon.recruit.domain.NoticeDomain"%>
<%@page import="com.hanphon.recruit.dao.*"%>
<%@page import="com.hanphon.recruit.dao.impl.*"%>
<%@page import="java.sql.Date"%>
<script type="text/javascript">    
function changeValidateCode(obj) {    
/***
  *   获取当前的时间作为参数，无具体意义   
  *   每次请求需要一个不同的参数，否则可能会返回同样的验证码    
  *   这和浏览器的缓存机制有关系，也可以把页面设置为不缓存，这样就不用这个参数了。  
  */
var timenow = new Date().getTime();    
   
obj.src="randPic.action?d="+timenow;    
}    
</script>   

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>梅村中学自主报名系统</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<script type="text/javascript" src="jslib/jquery1.4.4.js"></script>
		<script type="text/javascript" src="jslib/index.js"></script>
		<link rel="stylesheet" type="text/css" href="css/index.css">

	</head>

	<body>
		<div id="container">
			<jsp:include page="pages/header.jsp"></jsp:include>
			<div id="context">
				<div id="notice-left">
					<div id="title">
						<div id="title_left">
							<h3 style="font: '宋体'; font-size: small; padding-left: 10px;">
								<img src="icon/point.gif">
								通告
								<span style="font-size: x-small; color: gray;"> News </span>
							</h3>
						</div>
						<div id="title_right">
							<a id="more" href="#" style="text-decoration: none;">more<img
									height='18px' style="border: 0px;" src="icon/more.png"> </a>
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
								onmouseout="onMouseOut('<%=list1.get(i).getNdid()%>');"
								onmouseover="onMouseOver('<%=list1.get(i).getNdid()%>');"
								class="news_item_a" href="noticeAction?item=<%=i%>"> <img style="border: 0px"
									src="icon/view_detail.png"> <%=date.toString() + "\t" + list1.get(i).getNdtitle()%>
							</a>
						</li>
						<%
							}
						%>
					</ul>
				</div>
				<div id="login-right">
					<table id="right">
						<tr class="row1">
							<td>
								<form id="userLoginAction" action="userLoginAction" accept-charset="UTF-8"
									method="post">
									<table class="login-context" style="margin-left: 10%;">
										<tr style="height: 30%">
											<td valign="top"><br></td><td colspan="2" style="width: 30%">
												<img height="25px" src="icon/sign-in.png">
												<span class="title">登录</span>
											</td>
										</tr>
										<tr style="height: 10%">
											<td valign="top"><br></td><td colspan="2" style="width: 70%">
												<span id="loginerror" class="warn"></span>
											<br></td>
										</tr>
										<tr style="height: 20%">
											<td valign="top"><br></td><td style="width: 30%" align="center">
												<label class="login_label">
													邮箱:
												</label>
											</td>
											<td style="width: 70%">
												<input class="login_text" id="userName" name="userName"
													type="text" maxlength="50" onblur="checkName()">
											</td>
										</tr>
										
										
										<tr style="height: 20%">
											<td valign="top"><br></td><td align="center">
												<label class="login_label">
													密码:
												</label>
											</td>
											<td>
												<input class="login_text" id="password" name="password"
													type="password" maxlength="20">
											</td>
										</tr>
										<tr style="height: 20%">
											<td valign="top"><br></td><td align="center">
												<label class="login_label">
													验证码
												</label>
											</td>
											<td>
												<input  name="code"><img src="randPic.action"  onclick="changeValidateCode(this)" title="点击图片刷新验证码"/> 
											</td>
										</tr>
										
								
										<tr style="height: 20%">
											
											<td valign="top"><br></td><td colspan="2" align="right">
												<input class="login_submit" type="submit" value="登录">
											</td>
										</tr>
									</table>
								</form>
							</td>
						</tr>
						<tr class="row2">
							<td>
								<a href="toRegisterAction" id="bottom"> 注册新账号 <img
										height='25px' style="border: 0px;" src="icon/register.png">
								</a>
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
