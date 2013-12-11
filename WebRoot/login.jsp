<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
	<head>
		<title>移动短信平台</title>
		<!-- 系统文件引用 -->
		<script type="text/javascript" src="scripts/jquery-1.8.2.js"></script>
		<link rel="stylesheet" href="lib/login.css" type="text/css" />
		<script type="text/javascript" src="Script/login.js"></script>
	</head>

	<body>
	<div class="loginMain">
	<div class="loginHead">
		<span style="width: 100%;font-size: 60px;text-align:center;float: left;color: white;margin-top:10px;">无锡盈瑞传媒</span>
	</div>
	<div class="loginBottom">
		<form action="LoginAction" method="post">
				<div class="loginColumn">
					<span style="width:85px;height:30px;float:left;text-align:center;color:white;margin-top:5px;">用户名:</span>
					<input type="text" id="userName" name="userName" maxlength="20" style="width: 210px;margin-left:10px;height:30px;">	
				</div>
				<div class="loginColumn">
					<span style="width:85px;height:30px;float:left;text-align:center;color:white;margin-top:5px;">密&nbsp;&nbsp;码:</span>
					<input type="password" id="password" name="password" style="width: 210px;margin-left:10px;height:30px;">	
				</div>
				<div class="loginButton">
					<input type="submit" value=" 登录 " id="submit" style="width:60px;height:30px;">
					<button id="loginCancel" style="width:60px;height:30px;">取消</button>
				</div>
		</form>		
	</div>
	</div>
		<!--<div class="loginMain">
			<div class="loginHead">
				<span style="width: 100%;font-size: 60px;text-align:center;float: left;color: white;margin-top:10px;">无锡盈瑞传媒</span>
			</div>
			<div class="loginBottom">
				<div class="loginColumn">
					<span style="width:85px;height:30px;float:left;text-align:center;color:white;margin-top:5px;">用户名:</span>
					<input id="userName" type="text" style="width: 210px;margin-left:10px;height:30px;"></input>
				</div>
				<div class="loginColumn">
					<span style="width:85px;height:30px;float:left;text-align:center;color:white;margin-top:5px;">密&nbsp;&nbsp;码:</span>
					<input id="password" type="password" style="width: 210px;margin-left:10px;height:30px;"></input>
				</div>
				<div class="loginColumn">
					<span style="width:85px;height:30px;float:left;text-align:center;color:white;margin-top:5px;">验证码:</span>
					<input type="text" style="width: 110px;margin-left:10px;height:30px;"></input>
				</div>
				<div class="loginButton">
					<button id="loginSure" style="width:60px;height:30px;">确定</button>
					<button id="loginCancel" style="width:60px;height:30px;">取消</button>
				</div>
			</div>
		</div>
	--></body>
</html>
