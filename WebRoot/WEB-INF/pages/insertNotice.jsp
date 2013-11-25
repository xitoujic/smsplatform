<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>发布公告</title>

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
												Publish Notice
											</legend>

											<div align="center">
												<table align="center"
													style="border-collapse: collapse; border: 4px solid; border-color: gray; margin-top: 30px; height: 300px; width: 700px">
													<tr height="30%"
														style="border-bottom: 2px solid; border-color: gray;">
														<td width="20%"
															style="border: 2px solid; border-color: gray; text-align: center; color: white;">
															主题
														</td>
														<td width="80%"
															style="border: 2px solid; border-color: gray;">
															<input type="text" maxlength="20" id="notice_title"
																style="background-color: #4A6655; height: 100%; width: 100%; color: white;">
														</td>
													</tr>
													<tr height="70%"
														style="border-bottom: 2px solid; border-color: gray;">
														<td width="20%"
															style="border: 2px solid; border-color: gray; text-align: center; color: white;">
															内容
														</td>
														<td width="80%"
															style="border: 2px solid; border-color: gray;">
															<textarea id="notice_context"
																style="overflow-y: auto; background-color: #4A6655; height: 100%; width: 100%; color: white;"></textarea>
														</td>
													</tr>
												</table>


												<div id="publishNotice" style="margin-top: 20px">
													<input type="button" style="height: 30px; width: 140px"
														value="发布" id="publish_notice">
												</div>
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
