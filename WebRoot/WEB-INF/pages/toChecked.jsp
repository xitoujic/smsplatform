<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>核查结果</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<link rel="stylesheet" type="text/css" href="css/zone.css">
		<link rel="stylesheet" type="text/css" href="css/student.css">
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
												Checked Result
											</legend>
											<center>
												${checkedResultDomain.userAuditResult}
											</center>
										</fieldset>
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
			<script type="text/javascript" src="jslib/jquery1.4.4.js"></script>
			<script type="text/javascript" src="jslib/header.js"></script>
			<a href="http://apycom.com/" />
		</center>
	</body>
</html>
