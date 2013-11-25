<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>查询成绩</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/zone.css">
		<link rel="stylesheet" type="text/css" href="css/student.css">
		<link rel="stylesheet" type="text/css" href="css/score.css">
		<link type="text/css" href="css/header.css" rel="stylesheet" />
		<style type="text/css">
input {
	background-color: rgb(74, 81, 85);
	border: 0px;
	color: white;
	overflow-x: hide;
}
</style>
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
												Score Form
											</legend>
											<center>

												<div class="reslut">
													<table id="reslut">
														<thead>
															<tr>
																<th colspan=2>
																	考试成绩单
																</th>
															</tr>
														</thead>
														<tbody>
															<tr>
																<td style="width: 150px">
																	<label>
																		语文
																	</label>
																</td>
																<td style="width: 150px">
																	<input class="reslut_input"
																		id="studentDomain.chineseScore"
																		name="studentDomain.chineseScore"
																		value="${studentDomain.chineseScore}" type="text"
																		readonly="readonly">
																</td>
															</tr>
															<tr>
																<td style="width: 150px">
																	<label>
																		数学
																	</label>
																</td>
																<td style="width: 150px">
																	<input class="reslut_input"
																		id="studentDomain.mathScore"
																		name="studentDomain.mathScore"
																		value="${studentDomain.mathScore}" type="text"
																		readonly="readonly">
																</td>
															</tr>
															<tr>
																<td style="width: 150px">
																	<label>
																		英语
																	</label>
																</td>
																<td style="width: 150px">
																	<input class="reslut_input"
																		id="studentDomain.englishScore"
																		name="studentDomain.englishScore"
																		value="${studentDomain.englishScore}" type="text"
																		readonly="readonly">
																</td>
															</tr>
															<tr>
																<td style="width: 150px">
																	<label>
																		物理
																	</label>
																</td>
																<td style="width: 150px">
																	<input class="reslut_input"
																		id="studentDomain.physicsScore"
																		name="studentDomain.physicsScore"
																		value="${studentDomain.physicsScore}" type="text"
																		readonly="readonly">
																</td>
															</tr>
															<tr>
																<td style="width: 150px">
																	<label>
																		化学
																	</label>
																</td>
																<td style="width: 150px">
																	<input class="reslut_input"
																		id="studentDomain.chemistryScore"
																		name="studentDomain.chemistryScore"
																		value="${studentDomain.chemistryScore}" type="text"
																		readonly="readonly">
																</td>
															</tr>
															<tr>
																<td style="width: 150px">
																	<label>
																		历史
																	</label>
																</td>
																<td style="width: 150px">
																	<input class="reslut_input"
																		id="studentDomain.historyScore"
																		name="studentDomain.historyScore"
																		value="${studentDomain.historyScore}" type="text"
																		readonly="readonly">
																</td>
															</tr>
															<tr>
																<td style="width: 150px">
																	<label>
																		政治
																	</label>
																</td>
																<td style="width: 150px">
																	<input class="reslut_input"
																		id="studentDomain.politicsScore"
																		name="studentDomain.politicsScore"
																		value="${studentDomain.politicsScore}" type="text"
																		readonly="readonly">
																</td>
															</tr>
															<tr>
																<td style="width: 150px">
																	<label>
																		总分
																	</label>
																</td>
																<td style="width: 150px">
																	<input class="reslut_input" id="studentDomain.sumScore"
																		name="studentDomain.sumScore"
																		value="${studentDomain.sumScore}" type="text"
																		readonly="readonly">
																</td>
															</tr>
														</tbody>
													</table>
												</div>
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
			<a href="http://apycom.com/" />
		</center>
	</body>
</html>