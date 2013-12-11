<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
	<head>
		<title>移动短信平台</title>
		<!-- 系统文件引用 -->
		<script type="text/javascript" src="scripts/jquery-1.8.2.js"></script>
		<link rel="stylesheet" href="lib/writeInfo.css" type="text/css" />
	</head>

	<body>
	<div class="writeMain">
		<div class="infoHead">
			<span style="width: 100%;font-size: 60px;text-align:center;float: left;color: white;margin-top:10px;">个人信息完善</span>
		</div>
		<div class="infoBottom">
			<form action="UserwriteInfoAction" method="post">
					<div class="infoColumn">
						<span style="width:85px;height:30px;float:left;text-align:center;color:white;margin-top:5px;">用户全名:</span>
						<input type="text" id="tBdUser.FUserFullName" name="tBdUser.FUserFullName" style="width: 210px;margin-left:10px;height:30px;">	
					</div>
					<div class="infoColumn">
						<span style="width:85px;height:30px;float:left;text-align:center;color:white;margin-top:5px;">电话号码:</span>
						<input type="text" id="tBdUser.FPhoneNumber" name="tBdUser.FPhoneNumber" style="width: 210px;margin-left:10px;height:30px;">	
					</div>
					<div class="infoColumn">
						<span style="width:85px;height:30px;float:left;text-align:center;color:white;margin-top:5px;">邮箱:</span>
						<input type="text" id="tBdUser.FEmail" name="tBdUser.FEmail" style="width: 210px;margin-left:10px;height:30px;">	
					</div>
					<div class="infoButton">
						<input type="submit" value=" 提交  " id="submit" style="width:60px;height:30px;">
						<button id="loginCancel" style="width:60px;height:30px;">取消</button>
					</div>
			</form>		
		</div>
	</div>
	</body>
</html>
