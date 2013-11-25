<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>修改学生信息</title>

		<script type="text/javascript" src="jslib/jquery1.4.4.js"></script>
		<script type="text/javascript" src="jslib/modapplication.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/zone.css">
		<link rel="stylesheet" type="text/css" href="css/table.css">
		<link rel="stylesheet" type="text/css" href="css/student.css">
		<link type="text/css" href="css/header.css" rel="stylesheet" />
		<style type="text/css">
input,select,textarea {
	background-color: #4A6655;
	border: 0px;
	color: white;
	overflow-y: auto;
}
</style>
	</head>
	<body
		onload="change('${studentDomain.userSex}','${studentDomain.userCategory}');">

		<script type="text/javascript">
	function closeTheWindow() {
		window.close();
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
										<div style="text-align: center;">
											<a class="operate"
												style="text-decoration: underline; cursor: pointer;color: white;font-size: small;"
												onclick="deletes('${studentDomain.userId}','${pageNum}')">删除|</a>&nbsp;
											<a class="operate"
												style="text-decoration: underline; cursor: pointer;color: white;font-size: small; "
												onclick="checking('${studentDomain.userId}')">审核|</a>&nbsp;
											<a class="operate" style="color: white; font-size: small;"
												href="insertScoreAction?id=${studentDomain.userId}"
												target="_blank">发布分数|</a>
										</div>
										<fieldset id='allNoticeShow'>
											<legend>
												Application Fill
											</legend>
											<center>
												<div class="right_zone_studentin" id="application">
													<form action="updateMessageAction" method="post">
														<table id="applicationBlank">
															<thead>
																<tr>
																	<th colspan=8>
																		招生申请表
																	</th>
																</tr>
															</thead>
															<tbody>
																<tr>
																	<td>
																		<label style="width: 80px">
																			姓名*
																		</label>
																	</td>
																	<td style="width: 100px">
																		<input type="text" class="userName"
																			id="studentDomain.userName"
																			name="studentDomain.userName" maxlength="20"
																			value="${studentDomain.userName}"
																			style="width: 100px">
																	</td>
																	<td>
																		<label style="width: 90px">
																			性别*
																		</label>
																	</td>
																	<td style="width: 100px">
																		<input type="radio" id="userSex1"
																			name="studentDomain.userSex" value="男"
																			style="height: 20px" checked>
																		男&nbsp;
																		<input type="radio" id="userSex2"
																			name="studentDomain.userSex" value="女"
																			style="height: 20px">
																		女
																	</td>
																	<td style="width: 80px">
																		<label>
																			出生日期*
																		</label>
																	</td>
																	<td style="width: 100px">
																		<input type="text" class="userBirthday"
																			id="studentDomain.userBirthday"
																			name="studentDomain.userBirthday"
																			value="${studentDomain.userBirthday}" maxlength="8"
																			style="width: 100px"">
																	</td>
																	<td>
																		<label style="width: 80px">
																			民族*
																		</label>
																	</td>
																	<td style="width: 100px">
																		<input type="text" class="userNation"
																			name="studentDomain.userNation"
																			id="studentDomain.userNation" maxlength="10"
																			value="${studentDomain.userNation}"
																			style="width: 100px">
																	</td>
																</tr>
																<tr>
																	<td>
																		<label style="width: 80px">
																			报考类型
																		</label>
																	</td>
																	<td style="width: 100px">
																		<select name="studentDomain.userCategory"
																			id="studentDomain.userCategory"
																			value="${studentDomain.userCategory}"
																			style="height: 25px; width: 100px">
																			<option id="op1" value="普通">
																				普通
																			</option>
																			<option id="op2" value="艺体">
																				艺体
																			</option>
																		</select>
																		<!-- input type="text" class="userCategory" name="studentDomain.userCategory"
															id="studentDomain.userCategory" maxlength="10"
															value="${studentDomain.userCategory}" style="width: 100px" maxlength="10"-->
																	</td>
																	<td>
																		<label style="width: 80px">
																			政治面貌*
																		</label>
																	</td>
																	<td style="width: 102px">
																		<input type="text" class="userPolStatus"
																			name="studentDomain.userPolStatus"
																			id="studentDomain.userPolStatus" maxlength="10"
																			value="${studentDomain.userPolStatus}"
																			style="width: 102px">
																	</td>
																	<td>
																		<label style="width: 80px">
																			邮政编码
																		</label>
																	</td>
																	<td style="width: 100px">
																		<input type="text" id="studentDomain.userPostalCode"
																			name="studentDomain.userPostalCode" maxlength="6"
																			value="${studentDomain.userPostalCode}"
																			style="width: 100px">
																	</td>
																	<td>
																		<label style="width: 80px">
																			身份证号
																		</label>
																	</td>
																	<td style="width: 100px">
																		<input type="text" id="studentDomain.userRdcard"
																			name="studentDomain.userRdcard" maxlength="18"
																			value="${studentDomain.userRdcard}"
																			style="width: 100px">
																	</td>
																</tr>
																<tr>
																	<td>
																		<label style="width: 80px">
																			通讯地址*
																		</label>
																	</td>
																	<td style="width: 740px" colspan=7>
																		<input type="text" class="userAddress"
																			id="studentDomain.userAddress"
																			name="studentDomain.userAddress"
																			value="${studentDomain.userAddress}" maxlength="30"
																			style="width: 740px">
																	</td>
																</tr>
																<tr>
																	<td>
																		<label style="width: 90px">
																			联系人*
																		</label>
																	</td>
																	<td style="width: 294px" colspan=3>
																		<input type="text" class="linkMan"
																			name="studentDomain.linkMan"
																			id="studentDomain.linkMan" maxlength="20"
																			value="${studentDomain.linkMan}" style="width: 294px">
																	</td>
																	<td>
																		<label style="width: 80px">
																			联系电话*
																		</label>
																	</td>
																	<td style="width: 291px" colspan=3>
																		<input type="text" type="text" class="linkPhoneNum"
																			name="studentDomain.linkPhoneNum"
																			id="studentDomain.linkPhoneNum" maxlength="20"
																			value="${studentDomain.linkPhoneNum}"
																			style="width: 291px">
																	</td>
																</tr>
																<tr>
																	<td>
																		<label style="width: 80px">
																			家庭成员
																		</label>
																	</td>
																	<td>
																		<label style="width: 90px">
																			姓名
																		</label>
																	</td>
																	<td>
																		<label style="width: 90px">
																			文化程度
																		</label>
																	</td>
																	<td colspan=2>
																		<label style="width: 90px">
																			工作单位
																		</label>
																	</td>
																	<td>
																		<label style="width: 90px">
																			职务
																		</label>
																	</td>
																	<td>
																		<label style="width: 900px">
																			职位
																		</label>
																	</td>
																	<td>
																		<label style="width: 90px">
																			联系电话
																		</label>
																	</td>
																</tr>
																<tr>
																	<td>
																		<label style="width: 80px">
																			父亲*
																		</label>
																	</td>
																	<td style="width: 100px">
																		<input type="text" class="fatherName"
																			id="studentDomain.fatherName"
																			name="studentDomain.fatherName" maxlength="20"
																			value="${studentDomain.fatherName}"
																			style="width: 100px">
																	</td>
																	<td style="width: 90px">
																		<input type="text" class="fatherEducation"
																			name="studentDomain.fatherEducation"
																			id="studentDomain.fatherEducation" maxlength="20"
																			value="${studentDomain.fatherEducation}"
																			style="width: 90px">
																	</td>
																	<td style="width: 183px" colspan=2>
																		<input type="text" class="fatherWorkUnit"
																			name="studentDomain.fatherWorkUnit"
																			id="studentDomain.fatherWorkUnit" maxlength="20"
																			value="${studentDomain.fatherWorkUnit}"
																			style="width: 255px">
																	</td>
																	<td style="width: 100px">
																		<input type="text" class="fatherWrkPosition"
																			name="studentDomain.fatherWrkPosition"
																			id="studentDomain.fatherWrkPosition" maxlength="20"
																			value="${studentDomain.fatherWrkPosition}"
																			style="width: 100px">
																	</td>
																	<td style="width: 90px">
																		<input type="text" class="fatherCareer"
																			name="studentDomain.fatherCareer"
																			id="studentDomain.fatherCareer" maxlength="20"
																			value="${studentDomain.fatherCareer}"
																			style="width: 90px">
																	</td>
																	<td style="width: 100px">
																		<input type="text" class="fatherPhoneNum"
																			name="studentDomain.fatherPhoneNum"
																			id="studentDomain.fatherPhoneNum" maxlength="20"
																			value="${studentDomain.fatherPhoneNum}"
																			style="width: 100px">
																	</td>
																</tr>
																<tr>
																	<td>
																		<label style="width: 80px">
																			母亲*
																		</label>
																	</td>
																	<td style="width: 100px">
																		<input type="text" class="motherName"
																			name="studentDomain.motherName"
																			id="studentDomain.motherName" maxlength="20"
																			value="${studentDomain.motherName}"
																			style="width: 100px">
																	</td>
																	<td style="width: 90px">
																		<input type="text" class="motherEducation"
																			name="studentDomain.motherEducation"
																			id="studentDomain.motherEducation" maxlength="20"
																			value="${studentDomain.motherEducation}"
																			style="width: 90px">
																	</td>
																	<td style="width: 183px" colspan=2>
																		<input type="text" class="motherWorkUnit"
																			name="studentDomain.motherWorkUnit"
																			id="studentDomain.motherWorkUnit" maxlength="20"
																			value="${studentDomain.motherWorkUnit}"
																			style="width: 255px">
																	</td>
																	<td style="width: 100px">
																		<input type="text" class="motherWorkPosition"
																			name="studentDomain.motherWorkPosition"
																			id="studentDomain.motherWorkPosition" maxlength="20"
																			value="${studentDomain.motherWorkPosition}"
																			style="width: 100px">
																	</td>
																	<td style="width: 90px">
																		<input type="text" class="motherCareer"
																			name="studentDomain.motherCareer"
																			id="studentDomain.motherCareer" maxlength="20"
																			value="${studentDomain.motherCareer}"
																			style="width: 90px">
																	</td>
																	<td style="width: 100px">
																		<input type="text" class="motherPhoneNum"
																			name="studentDomain.motherPhoneNum"
																			id="studentDomain.motherPhoneNum" maxlength="20"
																			value="${studentDomain.motherPhoneNum}"
																			style="width: 100px">
																	</td>
																</tr>
																<tr>
																	<td>
																		<label style="width: 80px">
																			毕业中学*
																		</label>
																	</td>
																	<td style="width: 191px" colspan=2>
																		<input type="text" class="juniorSchoolName"
																			name="studentDomain.juniorSchoolName"
																			id="studentDomain.juniorSchoolName" maxlength="20"
																			value="${studentDomain.juniorSchoolName}"
																			style="width: 191px">
																	</td>
																	<td style="width: 90px">
																		<label style="width: 90px">
																			中学地址*
																		</label>
																	</td>
																	<td style="width: 180px" colspan=2>
																		<input type="text" class="juniorSchoolAddress"
																			name="studentDomain.juniorSchoolAddress"
																			id="studentDomain.juniorSchoolAddress" maxlength="50"
																			value="${studentDomain.juniorSchoolAddress}"
																			style="width: 253px">
																	</td>
																	<td style="width: 90px">
																		<label style="width: 90px">
																			联系人*
																		</label>
																	</td>
																	<td style="width: 100px">
																		<input type="text" class="juniorSchoolLinkman"
																			name="studentDomain.juniorSchoolLinkman"
																			id="studentDomain.juniorSchoolLinkman" maxlength="20"
																			value="${studentDomain.juniorSchoolLinkman}"
																			style="width: 100px">
																	</td>
																</tr>
																<tr>
																	<td>
																		<label style="width: 80px">
																			邮政编码
																		</label>
																	</td>
																	<td style="width: 191px" colspan=2>
																		<input type="text"
																			name="studentDomain.juniorSchoolPostalCode"
																			id="studentDomain.juniorSchoolPostalCode"
																			maxlength="6"
																			value="${studentDomain.juniorSchoolPostalCode}"
																			style="width: 191px">
																	</td>
																	<td style="width: 90px">
																		<label style="width: 90px">
																			联系电话*
																		</label>
																	</td>
																	<td style="width: 180px" colspan=2>
																		<input type="text" class="juniorSchoolLinkPhoneNum"
																			name="studentDomain.juniorSchoolLinkPhoneNum"
																			id="studentDomain.juniorSchoolLinkPhoneNum"
																			maxlength="20"
																			value="${studentDomain.juniorSchoolLinkPhoneNum}"
																			style="width: 253px">
																	</td>
																	<td style="width: 90px">
																		<label style="width: 90px">
																			中学传真
																		</label>
																	</td>
																	<td style="width: 100px">
																		<input type="text"
																			name="studentDomain.juniorSchoolFax"
																			id="studentDomain.juniorSchoolFax" maxlength="20"
																			value="${studentDomain.juniorSchoolFax}"
																			style="width: 100px">
																	</td>
																</tr>
																<tr>
																	<td>
																		<label style="width: 80px">
																			学期
																		</label>
																	</td>
																	<td>
																		<label style="width: 90px">
																			语文
																		</label>
																	</td>
																	<td>
																		<label style="width: 80px">
																			数学
																		</label>
																	</td>
																	<td>
																		<label style="width: 100px">
																			英语
																		</label>
																	</td>
																	<td>
																		<label style="width: 80px">
																			物理
																		</label>
																	</td>
																	<td>
																		<label style="width: 100px">
																			化学
																		</label>
																	</td>
																	<td>
																		<label style="width: 80px">
																			历史
																		</label>
																	</td>
																	<td>
																		<label style="width: 100px">
																			政治
																		</label>
																	</td>
																</tr>
																<tr>
																	<td>
																		<input type="text" id="studentDomain.testName1"
																			name="studentDomain.testName1" maxlength="20"
																			value="${studentDomain.testName1}"
																			style="width: 87px">
																	</td>
																	<td>
																		<input type="text"
																			id="studentDomain.junior2PreChinese"
																			name="studentDomain.junior2PreChinese" maxlength="3"
																			value="${studentDomain.junior2PreChinese}"
																			style="width: 100px">
																	</td>
																	<td>
																		<input type="text" id="studentDomain.junior2PreMath"
																			name="studentDomain.junior2PreMath" maxlength="3"
																			value="${studentDomain.junior2PreMath}"
																			style="width: 90px">
																	</td>
																	<td>
																		<input type="text"
																			id="studentDomain.junior2PreEnglish"
																			name="studentDomain.junior2PreEnglish" maxlength="3"
																			value="${studentDomain.junior2PreEnglish}"
																			style="width: 102px">
																	</td>
																	<td>
																		<input type="text" id="studentDomain.junior2PreHpy"
																			name="studentDomain.junior2PreHpy" maxlength="3"
																			value="${studentDomain.junior2PreHpy}"
																			style="width: 80">
																	</td>
																	<td>
																		<input type="text" id="studentDomain.junior2PreChem"
																			name="studentDomain.junior2PreChem" maxlength="3"
																			value="${studentDomain.junior2PreChem}"
																			style="width: 100px">
																	</td>
																	<td>
																		<input type="text"
																			id="studentDomain.junior2PreHistory"
																			name="studentDomain.junior2PreHistory" maxlength="3"
																			value="${studentDomain.junior2PreHistory}"
																			style="width: 90px">
																	</td>
																	<td>
																		<input type="text" id="studentDomain.junior2PrePoli"
																			name="studentDomain.junior2PrePoli" maxlength="3"
																			value="${studentDomain.junior2PrePoli}"
																			style="width: 100px">
																	</td>

																</tr>
																<tr>
																	<td>
																		<input type="text" id="studentDomain.testName2"
																			name="studentDomain.testName2" maxlength="20"
																			value="${studentDomain.testName2}"
																			style="width: 87px">
																	</td>
																	<td>
																		<input type="text"
																			id="studentDomain.junior2NextChinese"
																			name="studentDomain.junior2NextChinese" maxlength="3"
																			value="${studentDomain.junior2NextChinese}"
																			style="width: 100px">
																	</td>
																	<td>
																		<input type="text" id="studentDomain.junior2NextMath"
																			name="studentDomain.junior2NextMath" maxlength="3"
																			value="${studentDomain.junior2NextMath}"
																			style="width: 90px">
																	</td>
																	<td>
																		<input type="text"
																			id="studentDomain.junior2NextEnglish"
																			name="studentDomain.junior2NextEnglish" maxlength="3"
																			value="${studentDomain.junior2NextEnglish}"
																			style="width: 102px">
																	</td>
																	<td>
																		<input type="text" id="studentDomain.junior2NextHpy"
																			name="studentDomain.junior2NextHpy" maxlength="3"
																			value="${studentDomain.junior2NextHpy}"
																			style="width: 80">
																	</td>
																	<td>
																		<input type="text" id="studentDomain.junior2NextChem"
																			name="studentDomain.junior2NextChem" maxlength="3"
																			value="${studentDomain.junior2NextChem}"
																			style="width: 100px">
																	</td>
																	<td>
																		<input type="text"
																			id="studentDomain.junior2NextHistory"
																			name="studentDomain.junior2NextHistory" maxlength="3"
																			value="${studentDomain.junior2NextHistory}"
																			style="width: 90px">
																	</td>
																	<td>
																		<input type="text" id="studentDomain.junior2NextPoli"
																			name="studentDomain.junior2NextPoli" maxlength="3"
																			value="${studentDomain.junior2NextPoli}"
																			style="width: 100px">
																	</td>
																</tr>
																<tr>
																	<td>
																		<input type="text" id="studentDomain.testName3"
																			name="studentDomain.testName3" maxlength="20"
																			value="${studentDomain.testName3}"
																			style="width: 87px">
																	</td>
																	<td>
																		<input type="text"
																			id="studentDomain.junior3PreChinese"
																			name="studentDomain.junior3PreChinese" maxlength="3"
																			value="${studentDomain.junior3PreChinese}"
																			style="width: 100px">
																	</td>
																	<td>
																		<input type="text" id="studentDomain.junior3PreMath"
																			name="studentDomain.junior3PreMath" maxlength="3"
																			value="${studentDomain.junior3PreMath}"
																			style="width: 90px">
																	</td>
																	<td>
																		<input type="text"
																			id="studentDomain.junior3PreEnglish"
																			name="studentDomain.junior3PreEnglish" maxlength="3"
																			value="${studentDomain.junior3PreEnglish}"
																			style="width: 102px">
																	</td>
																	<td>
																		<input type="text" id="studentDomain.junior3PreHpy"
																			name="studentDomain.junior3PreHpy" maxlength="3"
																			value="${studentDomain.junior3PreHpy}"
																			style="width: 80">
																	</td>
																	<td>
																		<input type="text" id="studentDomain.junior3PreChem"
																			name="studentDomain.junior3PreChem" maxlength="3"
																			value="${studentDomain.junior3PreChem}"
																			style="width: 100px">
																	</td>
																	<td>
																		<input type="text"
																			id="studentDomain.junior3PreHistory"
																			name="studentDomain.junior3PreHistory" maxlength="3"
																			value="${studentDomain.junior3PreHistory}"
																			style="width: 90px">
																	</td>
																	<td>
																		<input type="text" id="studentDomain.junior3PrePoli"
																			name="studentDomain.junior3PrePoli" maxlength="3"
																			value="${studentDomain.junior3PrePoli}"
																			style="width: 100px">
																	</td>
																</tr>
																<tr>
																	<td>
																		<input type="text" id="studentDomain.testName4"
																			name="studentDomain.testName4" maxlength="20"
																			value="${studentDomain.testName4}"
																			style="width: 87px">
																	</td>
																	<td>
																		<input type="text"
																			id="studentDomain.junior3NextMidChinese"
																			name="studentDomain.junior3NextMidChinese"
																			maxlength="3"
																			value="${studentDomain.junior3NextMidChinese}"
																			style="width: 100px">
																	</td>
																	<td>
																		<input type="text"
																			id="studentDomain.junior3NextMidMath"
																			name="studentDomain.junior3NextMidMath" maxlength="3"
																			value="${studentDomain.junior3NextMidMath}"
																			style="width: 90px">
																	</td>
																	<td>
																		<input type="text"
																			id="studentDomain.junior3NextMidEnglish"
																			name="studentDomain.junior3NextMidEnglish"
																			maxlength="3"
																			value="${studentDomain.junior3NextMidEnglish}"
																			style="width: 102px">
																	</td>
																	<td>
																		<input type="text"
																			id="studentDomain.junior3NextMidHpy"
																			name="studentDomain.junior3NextMidHpy" maxlength="3"
																			value="${studentDomain.junior3NextMidHpy}"
																			style="width: 80">
																	</td>
																	<td>
																		<input type="text"
																			id="studentDomain.junior3NextMidChem"
																			name="studentDomain.junior3NextMidChem" maxlength="3"
																			value="${studentDomain.junior3NextMidChem}"
																			style="width: 100px">
																	</td>
																	<td>
																		<input type="text"
																			id="studentDomain.junior3NextMidHistory"
																			name="studentDomain.junior3NextMidHistory"
																			maxlength="3"
																			value="${studentDomain.junior3NextMidHistory}"
																			style="width: 90px">
																	</td>
																	<td>
																		<input type="text"
																			id="studentDomain.junior3NextMidPoli"
																			name="studentDomain.junior3NextMidPoli" maxlength="3"
																			value="${studentDomain.junior3NextMidPoli}"
																			style="width: 100px">
																	</td>
																</tr>
																<tr>
																	<td>
																		<input type="text" id="studentDomain.testName5"
																			name="studentDomain.testName5" maxlength="20"
																			value="${studentDomain.testName5}"
																			style="width: 87px">
																	</td>
																	<td>
																		<input type="text"
																			id="studentDomain.junior3Next1stShamChinese"
																			name="studentDomain.junior3Next1stShamChinese"
																			maxlength="3"
																			value="${studentDomain.junior3Next1stShamChinese}"
																			style="width: 100px">
																	</td>
																	<td>
																		<input type="text"
																			id="studentDomain.junior3Next1stShamMath"
																			name="studentDomain.junior3Next1stShamMath"
																			maxlength="3"
																			value="${studentDomain.junior3Next1stShamMath}"
																			style="width: 90px">
																	</td>
																	<td>
																		<input type="text"
																			id="studentDomain.junior3Next1stShamEnglish"
																			name="studentDomain.junior3Next1stShamEnglish"
																			maxlength="3"
																			value="${studentDomain.junior3Next1stShamEnglish}"
																			style="width: 102px">
																	</td>
																	<td>
																		<input type="text"
																			id="studentDomain.junior3Next1stShamHpy"
																			name="studentDomain.junior3Next1stShamHpy"
																			maxlength="3"
																			value="${studentDomain.junior3Next1stShamHpy}"
																			style="width: 80">
																	</td>
																	<td>
																		<input type="text"
																			id="studentDomain.junior3Next1stShamChem"
																			name="studentDomain.junior3Next1stShamChem"
																			maxlength="3"
																			value="${studentDomain.junior3Next1stShamChem}"
																			style="width: 100px">
																	</td>
																	<td>
																		<input type="text"
																			id="studentDomain.junior3Next1stShamHistory"
																			name="studentDomain.junior3Next1stShamHistory"
																			maxlength="3"
																			value="${studentDomain.junior3Next1stShamHistory}"
																			style="width: 90px">
																	</td>
																	<td>
																		<input type="text"
																			id="studentDomain.junior3Next1stShamPoli"
																			name="studentDomain.junior3Next1stShamPoli"
																			maxlength="3"
																			value="${studentDomain.junior3Next1stShamPoli}"
																			style="width: 100px">
																	</td>
																</tr>
																<tr>
																	<td colspan="2">
																		<label style="width: 80px">
																			参赛时间和地点
																		</label>
																	</td>
																	<td colspan="4">
																		<label style="width: 90px">
																			初中阶段参加的竞赛名称
																		</label>
																	</td>
																	<td>
																		<label style="width: 80px">
																			竞赛级别
																		</label>
																	</td>
																	<td>
																		<label style="width: 100px">
																			取得名次
																		</label>
																	</td>
																</tr>
																<tr style="height: 100px">
																	<td colspan="2">
																		<textarea id="studentDomain.competitionTimeAdr"
																			name="studentDomain.competitionTimeAdr"
																			maxlength="200" style="width: 188px; height: 100px">${studentDomain.competitionTimeAdr}</textarea>
																	</td>
																	<td colspan="4">
																		<textarea id="studentDomain.competitionName"
																			name="studentDomain.competitionName" maxlength="200"
																			style="width: 450px; height: 100px">${studentDomain.competitionName}</textarea>
																	</td>
																	<td>
																		<textarea id="studentDomain.competitionDegree"
																			name="studentDomain.competitionDegree"
																			maxlength="200" style="width: 90px; height: 100px">${studentDomain.competitionDegree}</textarea>
																	</td>
																	<td>
																		<textarea id="studentDomain.competitionResult"
																			name="studentDomain.competitionResult"
																			maxlength="200" style="width: 100px; height: 100px">${studentDomain.competitionResult}</textarea>
																	</td>
																</tr>
																<tr>
																	<td colspan="2">
																		<label style="width: 80px">
																			地点
																		</label>
																	</td>
																	<td colspan="4">
																		<label style="width: 90px">
																			参加或组织的社会工作或课外活动，受过何种奖励
																		</label>
																	</td>
																	<td colspan="2">
																		<label style="width: 80px">
																			本人在活动中的职务/职责
																		</label>
																	</td>
																</tr>
																<tr style="height: 100px">
																	<td colspan="2">
																		<textarea id="studentDomain.userActTime"
																			name="studentDomain.userActTime" maxlength="200"
																			style="width: 188px; height: 100px">${studentDomain.userActTime}</textarea>
																	</td>
																	<td colspan="4">
																		<textarea id="studentDomain.userActContent"
																			name="studentDomain.userActContent" maxlength="200"
																			style="width: 450px; height: 100px">${studentDomain.userActContent}</textarea>
																	</td>
																	<td colspan="2">
																		<textarea id="studentDomain.userActPosition"
																			name="studentDomain.userActPosition" maxlength="200"
																			style="width: 192px; height: 100px">${studentDomain.userActPosition}</textarea>
																	</td>
																</tr>
																<tr style="height: 100px">
																	<td colspan="2">
																		<label style="width: 180px; height: 100px">
																			有何爱好
																			<br>
																			和特长
																			<br>
																			取得何成绩
																		</label>
																	</td>
																	<td colspan="6">
																		<textarea id="studentDomain.userHobby"
																			name="studentDomain.userHobby" maxlength="200"
																			style="width: 640px; height: 100px;">${studentDomain.userHobby}</textarea>
																	</td>
																</tr>
															</tbody>
														</table>
														${message}
														<div align="center">
															<input type="submit" value=" 提   交 " id="submit">
														</div>
													</form>
												</div>
												<a onclick='closeTheWindow();'
													style="color: white; cursor: pointer; height: 30px; width: 100px; text-decoration: underline;">
													[ 关 闭 ]</a>
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
			<a href="http://apycom.com/" />
		</center>
	</body>
</html>