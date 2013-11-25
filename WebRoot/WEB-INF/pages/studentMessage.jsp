<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>学生信息</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<style type="text/css">
a#paging:link,a#paging:visited,a#paging:hover,.current,#info {
	border: 1px solid #DDD;
	background: #F2F2F2;
	display: inline-block;
	margin: 1px;
	text-decoration: none;
	font-size: 12px;
	width: 23px;
	height: 15px;
	text-align: center;
	line-height: 15px;
	color: #AAA;
	padding: 1px 2px;
}

a#paging:hover {
	border: 1px solid #E5E5E5;
	background: #F9F9F9;
}

.current {
	border: 1px solid #83E7E4;
	background: #DFF9F8;
	margin: 1px;
	color: #27CBC7;
}

#info {
	width: auto;
}
</style>
		<script type="text/javascript" src="jslib/jquery.js"></script>
		<script type="text/javascript" src="jslib/teacherZone.js"></script>
		<link rel="stylesheet" type="text/css" href="css/zone.css">
		<link rel="stylesheet" type="text/css" href="css/teacher.css">
		<link type="text/css" href="css/header.css" rel="stylesheet" />

	</head>
	<body onload="changeSetting('${category1}','${category2}','${status}')">
		<center>
			<div id="container">
				<div id="top_info">
					<jsp:include page="header2.jsp"></jsp:include>
				</div>
				<div id="middle">
					<table id="middle_table">
						<tr>
							<td id="middle_column_right">
								<div id="right_zone_student_">
									<!-- 公告  -->
									<div class="right_zone_student right_zone_studentin">
										<div id="notice_message">
											${messageNotice}
										</div>
										<fieldset id="allNoticeShow">
											<legend>
												Student Message
											</legend>

											<input type="checkbox" id="category1" name="category1"
												value="1">
											普通生 &nbsp;&nbsp;
											<input type="checkbox" id="category2" name="category2"
												value="1">
											艺体&nbsp;&nbsp;|
											<input type="radio" class="status" name="status" value="1">
											已注册&nbsp;&nbsp;
											<input type="radio" class="status" name="status" value="2">
											已登录&nbsp;&nbsp;
											<input type="radio" class="status" name="status" value="3">
											已提交信息&nbsp;&nbsp;
											<input type="radio" class="status" name="status" value="4">
											已下载申请表，等待考核&nbsp;&nbsp;
											<input type="radio" class="status" name="status" value="5">
											考核通过，等待考试&nbsp;&nbsp;
											<input type="radio" class="status" name="status" value="6">
											已下载准考证&nbsp;&nbsp;
											<input type="radio" class="status" name="status" value="7">
											已获取成绩&nbsp;&nbsp;|
											<input type="button" id="submitChoose" value="提交">
											<br>
											<hr />
											<div>
												<table style="font-size: 15px; color: white;">
													<thead>
														<tr
															style="text-align: center; color: #CACAC9; background-color: #007491;"
															height="22px">
															<td width="20px">
																<input id="getAllStudentChoose" type="checkbox"/>
															</td>
															<td width="100px">
																姓名
															</td>
															<td width="40px">
																性别
															</td>
															<td width="40px">
																类别
															</td>
															<td width="80px">
																出生日期
															</td>
															<td width="40px">
																民族
															</td>
															<td width="100px">
																审核情况
															</td>
															<td width="100px">
																用户状态
															</td>
															<td width="220px">
																操作
															</td>
															<td width="200px">
																全体操作 (已选)
															</td>
														</tr>
													</thead>
													<tbody>
														<s:iterator value="studentList" var="student"
															status="status">
															<tr style="text-align: center;" height="18px">
																<td>
																	<input type="checkbox" class="choosingAllSutudentId" id="${student.userId}" />
																</td>
																<td>
																	<s:property value="#student.userName" />
																</td>
																<td>
																	<s:property value="#student.userSex" />
																</td>
																<td>
																	<s:property value="#student.userCategory" />
																</td>
																<td>
																	<s:property value="#student.userBirthday" />
																</td>
																<td>
																	<s:property value="#student.userNation" />
																</td>
																<td>
																	<s:property value="#student.userAuditResult" />
																</td>
																<td>
																	<s:property value="#student.onStatus" />
																</td>
																<td>
																	<a class="operate"
																		style="text-decoration: underline; cursor: pointer;"
																		onclick="deletes('${student.userId}')">删除</a>|&nbsp;
																	<a class="operate"
																		href="modifyStudentAction?id=${student.userId}&pageNum=${pageNum}"
																		target="_blank">修改</a>|&nbsp;
																	<a class="operate"
																		style="text-decoration: underline; cursor: pointer;"
																		onclick="checking('${student.userId}')">审核</a>|&nbsp;
																	<a class="operate"
																		href="insertScoreAction?id=${student.userId}"
																		target="_blank">发布分数</a>|
																</td>
																<td>
																	<input type="button" style="font-size: 12px;" onclick="allChooseChecking()"
																		value="审核"></input>
																	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																	<input type="button" style="font-size: 12px;" onclick="allChooseDeleting()"
																		value="删除"></input>
																</td>
															</tr>
														</s:iterator>

													</tbody>
												</table>
											</div>
											<hr />
											<div>
												<input type="text" maxlength="20" id="searchName"
													value="输入姓名" onblur="onblurSearch()"
													onfocus="onfocusSearch()"
													style="width: 200px; background-color: #DFF9F8">
												<input type="button" onclick="searchByName()" value="搜索">
											</div>
											<div style="margin-right: 20px" align="right" id="setpage"></div>
											<script type="text/javascript">
											var totalpage, pagesize, cpage, count, curcount, outstr;
											//初始化 
											cpage = ${pageNum};
											pagesize = 10;
											outstr = "";
											
											function setTotalpages(p){
												totalpage = p;
											}
											
											setTotalpages(${items})
											
											function getPageCurrent(){
												return cpage;
											}
											
											function gotopage(target) {
												cpage = target; //把页面计数定位到第几页 
												setpage();
												$('#submitChoose').trigger("click");
											}
											
											function setpage() {
												if (totalpage <= 10) { //总页数小于十页 
													for (count = 1; count <= totalpage; count++) {
														if (count != cpage) {
															outstr = outstr
																	+ "<a id='paging' href='javascript:void(0)' onclick='gotopage("
																	+ count + ")'>" + count + "</a>";
														} else {
															outstr = outstr + "<span class='current' >" + count
																	+ "</span>";
														}
													}
												}
												if (totalpage > 10) { //总页数大于十页 
													if (parseInt((cpage - 1) / 10) == 0) {
														for (count = 1; count <= 10; count++) {
															if (count != cpage) {
																outstr = outstr
																		+ "<a id='paging' href='javascript:void(0)' onclick='gotopage("
																		+ count + ")'>" + count + "</a>";
															} else {
																outstr = outstr + "<span class='current'>" + count
																		+ "</span>";
															}
														}
														outstr = outstr
																+ "<a id='paging' href='javascript:void(0)' onclick='gotopage("
																+ count + ")'> next </a>";
													} else if (parseInt((cpage - 1) / 10) == parseInt(totalpage / 10)) {
														outstr = outstr
																+ "<a id='paging' href='javascript:void(0)' onclick='gotopage("
																+ (parseInt((cpage - 1) / 10) * 10) + ")'>previous</a>";
														for (count = parseInt(totalpage / 10) * 10 + 1; count <= totalpage; count++) {
															if (count != cpage) {
																outstr = outstr
																		+ "<a id='paging' href='javascript:void(0)' onclick='gotopage("
																		+ count + ")'>" + count + "</a>";
															} else {
																outstr = outstr + "<span class='current'>" + count
																		+ "</span>";
															}
														}
													} else {
														outstr = outstr
																+ "<a id='paging' href='javascript:void(0)' onclick='gotopage("
																+ (parseInt((cpage - 1) / 10) * 10) + ")'>prev</a>";
														for (count = parseInt((cpage - 1) / 10) * 10 + 1; count <= parseInt((cpage - 1) / 10) * 10 + 10; count++) {
															if (count != cpage) {
																outstr = outstr
																		+ "<a id='paging' href='javascript:void(0)' onclick='gotopage("
																		+ count + ")'>" + count + "</a>";
															} else {
																outstr = outstr + "<span class='current'>" + count
																		+ "</span>";
															}
														}
														outstr = outstr
																+ "<a id='paging' href='javascript:void(0)' onclick='gotopage("
																+ count + ")'> next </a>";
													}
												}
												document.getElementById("setpage").innerHTML = "<div id='setpage'><span id='info'>共"
														+ totalpage + "页|第" + cpage + "页<\/span>" + outstr + "<\/div>";
												outstr = "";
											}

											setpage(); //调用分页 
											//-->
										</script>
										</fieldset>
									</div>

								</div>
							</td>
						</tr>
						<tr>
						</tr>
					</table>
				</div>
				<div id="footer">
					<hr>
					<br>
					Copyright&copy 无锡汉方信息技术有限公司 版权所有 &nbsp;&nbsp;&nbsp;&nbsp; Wuxi
					Hanphon Information Technology Co.,Ltd
					<br>
					地址 ：无锡新区创意产业园 C321-323
				</div>
			</div>

		</center>
		${message}
		<a href="http://apycom.com/" />
	</body>
</html>
