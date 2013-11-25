<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>输入成绩</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="jslib/jquery1.4.4.js"></script>
		<link rel="stylesheet" type="text/css" href="css/zone.css">
		<link rel="stylesheet" type="text/css" href="css/student.css">
		<link rel="stylesheet" type="text/css" href="css/score.css">
		<link type="text/css" href="css/header.css" rel="stylesheet" />
		<style type="text/css">
input {
	background-color: #4A6655;
	border: 0px;
	color: white;
	overflow-x: hide;
}
</style>
	</head>
	<body>
		<script type="text/javascript">
	function closeTheWindow() {
		window.close();
	}

	function saveScore(id){
		$.ajax({
			url : 'saveScoreAction.action',
			type:'post',
			dataType : "xml",
			data:{
			'domain.userId' : id,
			'domain.chineseScore' : $('#chineseScore').val(),
			'domain.mathScore' : $('#mathScore').val(),
			'domain.englishScore' : $('#englishScore').val(),
			'domain.englishScore' : $('#englishScore').val(),
			'domain.chemistryScore' : $('#chemistryScore').val(),
			'domain.historyScore' : $('#historyScore').val(),
			'domain.politicsScore' : $('#politicsScore').val(),
			'domain.sumScore' : $('#sumScore').val()},
			error : callbackScore,
			success : callbackScore,
			});
	}

	function callbackScore(data){
		var jqueryObj = $(data);
		var message = jqueryObj.children();
		var text = message.text();
		if (text == "ERROR") {
			alert('公布失败');
		}
		if (text == "SUCCESS") {
			alert('公布成功');
		}
	}
</script>
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
																	<input class="reslut_input" id="chineseScore"
																		name="chineseScore" type="text">
																</td>
															</tr>
															<tr>
																<td style="width: 150px">
																	<label>
																		数学
																	</label>
																</td>
																<td style="width: 150px">
																	<input class="reslut_input" id="mathScore"
																		name="mathScore" type="text">
																</td>
															</tr>
															<tr>
																<td style="width: 150px">
																	<label>
																		英语
																	</label>
																</td>
																<td style="width: 150px">
																	<input class="reslut_input" id="englishScore"
																		name="englishScore" type="text">
																</td>
															</tr>
															<tr>
																<td style="width: 150px">
																	<label>
																		物理
																	</label>
																</td>
																<td style="width: 150px">
																	<input class="reslut_input" id="physicsScore"
																		name="physicsScore" type="text">
																</td>
															</tr>
															<tr>
																<td style="width: 150px">
																	<label>
																		化学
																	</label>
																</td>
																<td style="width: 150px">
																	<input class="reslut_input" id="chemistryScore"
																		name="chemistryScore" type="text">
																</td>
															</tr>
															<tr>
																<td style="width: 150px">
																	<label>
																		历史
																	</label>
																</td>
																<td style="width: 150px">
																	<input class="reslut_input" id="historyScore"
																		name="historyScore" type="text">
																</td>
															</tr>
															<tr>
																<td style="width: 150px">
																	<label>
																		政治
																	</label>
																</td>
																<td style="width: 150px">
																	<input class="reslut_input" id="politicsScore"
																		name="politicsScore" type="text">
																</td>
															</tr>
															<tr>
																<td style="width: 150px">
																	<label>
																		总分
																	</label>
																</td>
																<td style="width: 150px">
																	<input class="reslut_input" id="sumScore"
																		name="sumScore" type="text">
																</td>
															</tr>
														</tbody>
													</table>
													<input type="button" value="提  交"
														onclick="saveScore('${id}')"
														style="height: 30px; width: 100px; cursor: pointer; margin-top: 5px; background-color: #007593" />
													<br />
													<br />
													<a onclick='closeTheWindow();'
														style="color: white; cursor: pointer; height: 30px; width: 100px; text-decoration: underline;">
														[ 关 闭 ]</a>
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
			${message}
			<a href="http://apycom.com/" />
		</center>
	</body>
</html>