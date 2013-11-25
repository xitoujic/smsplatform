<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>主页</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<script type="text/javascript" src="jslib/jquery.js"></script>
		<script type="text/javascript" src="jslib/teacherZone.js"></script>
		<link rel="stylesheet" type="text/css" href="css/zone.css">
		<link rel="stylesheet" type="text/css" href="css/teacher.css">
		<link type="text/css" href="css/header.css" rel="stylesheet" />
	</head>

	<body>
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
												Notice
											</legend>
											<div id="notice">
												<table class="sortable paginated">
													<thead id="notice">
														<tr>
															<td>
																<div style="width: 30px;" align="center">
																	<input type="radio" id="delete_all" >
																</div>
															</td>
															<td>
																<div style="width: 30px;" align="center">
																	No
																</div>
															</td>
															<td>
																<div style="width: 200px;" align="center">
																	主题
																</div>
															</td>
															<td>
																<div style="width: 530px;" align="center">
																	内容
																</div>
															</td>
															<td>
																<div style="width: 150px;" align="center">
																	时间
																</div>
															</td>
														</tr>
													</thead>
													<tbody id="notice">
														<s:iterator value="noticeDomains" var="listJavaBean"
															status="status">
															<tr>
																<td>
																	<div align="center">
																		<input type="checkbox" value="${status.count}" class="checkbox_delete" id="${listJavaBean.ndid}">
																	</div>
																</td>
																<td>
																	<div align="center">
																		<s:property value="#status.count" />
																	</div>
																</td>
																<td>
																	<div align="left">
																		<s:property value="#listJavaBean.ndtitle" />
																	</div>
																</td>
																<td>
																	<div align="left">
																		<s:property value="#listJavaBean.content" />
																	</div>
																</td>
																<td>
																	<div align="left">
																		<s:property value="#listJavaBean.time" />
																	</div>
																</td>
															</tr>
														</s:iterator>
													</tbody>
												</table>
												<input type="button" value="删除" id="delete">
												<input type="button" value="发布通告" id="insert_notice">
											</div>
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
		<a href="http://apycom.com/" />
	</body>
</html>
