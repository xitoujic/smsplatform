<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>下载申请表</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<script type="text/javascript" src="jslib/jquery1.4.4.js"></script>
		<script type="text/javascript" src="jslib/downloadApplication.js"></script>
		<link rel="stylesheet" type="text/css" href="css/zone.css">
		<link rel="stylesheet" type="text/css" href="css/student.css">
		<link rel="stylesheet" type="text/css"
			href="css/downloadApplication.css">
		<link type="text/css" href="css/header.css" rel="stylesheet" />

	</head>

	<body>
		<center>
			<div id="container">
				<div id="top_info">
					<jsp:include page="header.jsp"></jsp:include>
				</div>
				<div id="middle">
					<table id="middle_table">
						<tr>
							<td id="middle_column_right">
								<div id="right_zone_student_">

									<div class="right_zone_student right_zone_studentin">
										<div id="notice_message">
											${messageNotice}
										</div>
										<fieldset id='allNoticeShow'>
											<legend>
												Download Application
											</legend>
											<table class="sortable paginated" style="margin-top: 20px;">
												<thead id="notice">
													<tr>
														<td>
															<div style="width: 30px;" align="center">
																No
															</div>
														</td>
														<td>
															<div style="width: 200px;" align="center">
																链接
															</div>
														</td>
													</tr>
												</thead>
												<tbody id="notice">
													<tr>
														<td>
															<div align="center">
																1.
															</div>
														</td>
														<td>
															<div align="left">
																<div id="downloadApplication">
																	下载申请表
																</div>
															</div>
														</td>
													</tr>
													<tr>
														<td>
															<div align="center">
																2.
															</div>
														</td>
														<td>
															<div align="left">
																<a id="downloadApplication2"
																	href="downloadAdmissionAction">下载准考证</a>
															</div>
														</td>
													</tr>
												</tbody>
											</table>

											<div id="care">
												<div id="care_title">
													<div id="title_context">
														Attention
													</div>
													<div id="care_close">
														<img id="close_IMG" height="100%" style="cursor: pointer;"
															onclick="closeCare();" alt="close"
															src="icon/fileclose.png"></img>
													</div>
												</div>
												<div id="care_context">
													<br>
													注意！
													<br>
													下载该申请表后将无法修改、浏览您的个人信息！
													<br>
													是否继续下载？
												</div>
												<div id="care_footer">
													<div id="care_footer_yes">
														Yes
													</div>
													<div id="care_footer_no">
														No
													</div>
												</div>
											</div>

											<iframe name="download_file"
												style="height: 0px; width: 0px; display: none; background-color: rgb(74, 81, 85);"></iframe>
										</fieldset>
									</div>
							</td>
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
			<a href="http://apycom.com/" />
		</center>
	</body>
</html>
