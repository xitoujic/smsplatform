<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	</head>
	<body>

		<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

body {
	background: rgb(74, 81, 85);
}

div#menu {
	margin: 5px auto;
}
</style>

		<div id="menu">
			<ul class="menu" id="left_zone_student">
				<li class="parent left_zone_student_item">
					<a href="toZoneAction"><span>&nbsp;主&nbsp;页&nbsp;</span> </a>
				</li>
				<li>
					<a href="applicationGetAction"><span>&nbsp;基&nbsp;本&nbsp;信&nbsp;息&nbsp;填&nbsp;写&nbsp;/&nbsp;修&nbsp;改&nbsp;</span>
					</a>
				</li>
				<li>
					<a href="toDownloadAppplicationAction"><span>&nbsp;下&nbsp;载&nbsp;</span>
					</a>
				</li>
				<li>
					<a href="toCheckedAction"><span>&nbsp;审&nbsp;核&nbsp;结&nbsp;果&nbsp;</span>
					</a>
				</li>
				<li>
					<a href="toScoreAction"><span>&nbsp;查&nbsp;询&nbsp;考&nbsp;分&nbsp;</span>
					</a>
				</li>
				<li>
					<a href="#" class="parent"><span>&nbsp;帮&nbsp;助&nbsp;</span> </a>
				</li>
				<li>
					<a href="#" class="parent"><span>&nbsp;联&nbsp;系&nbsp;我&nbsp;们&nbsp;</span>
					</a>
				</li>
				<li>
					<a onclick="alert('Version 1.0 beta')" class="parent"><span>&nbsp;关&nbsp;于&nbsp;</span> </a>
				</li>
				<li>
					<a href="logoutAction"><span>&nbsp;注&nbsp;销&nbsp;</span> </a>
				</li>
			</ul>
		</div>
	</body>
</html>