<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
	<head>
		<title>移动短信平台</title>
		<!-- 库文件引用 -->
		<script type="text/javascript" src="scripts/jquery-1.8.2.js"></script>
		<script type="text/javascript" src="jqwidgets/scripts/gettheme.js"></script>
	    <link rel="stylesheet" href="jqwidgets/jqwidgets/styles/jqx.base.css" type="text/css" />
	    <script type="text/javascript" src="jqwidgets/scripts/jquery-2.0.3.js"></script>
	    <script type="text/javascript" src="jqwidgets/jqwidgets/jqxcore.js"></script>
	    <script type="text/javascript" src="jqwidgets/jqwidgets/jqxtabs.js"></script>
	    <script type="text/javascript" src="jqwidgets/jqwidgets/jqxwindow.js"></script>
	    <script type="text/javascript" src="jqwidgets/jqwidgets/jqxbuttons.js"></script>
	    <script type="text/javascript" src="jqwidgets/jqwidgets/jqxbuttongroup.js"></script>
	    <script type="text/javascript" src="jqwidgets/jqwidgets/jqxradiobutton.js"></script>
	    <script type="text/javascript" src="jqwidgets/jqwidgets/jqxdata.js"></script> 
		<script type="text/javascript" src="jqwidgets/jqwidgets/jqxscrollbar.js"></script>
		<script type="text/javascript" src="jqwidgets/jqwidgets/jqxlistbox.js"></script>
		<script type="text/javascript" src="jqwidgets/jqwidgets/jqxdropdownlist.js"></script>
		<script type="text/javascript" src="jqwidgets/jqwidgets/jqxmenu.js"></script>
		<script type="text/javascript" src="jqwidgets/jqwidgets/jqxnumberinput.js"></script>
		<script type="text/javascript" src="jqwidgets/jqwidgets/jqxgrid.js"></script>
		<script type="text/javascript" src="jqwidgets/jqwidgets/jqxgrid.pager.js"></script>
		<script type="text/javascript" src="jqwidgets/jqwidgets/jqxgrid.sort.js"></script>
		<script type="text/javascript" src="jqwidgets/jqwidgets/jqxgrid.filter.js"></script>
		<script type="text/javascript" src="jqwidgets/jqwidgets/jqxgrid.columnsresize.js"></script>
		<script type="text/javascript" src="jqwidgets/jqwidgets/jqxgrid.selection.js"></script>
		<!-- 系统文件引用 -->
		<link rel="stylesheet" href="lib/admin.css" type="text/css" />
		<script type="text/javascript" src="Script/admin.js"></script>
	</head>

	<body>
		<div class="top">
			<h1>
				<img style="width:150px;height:34px;" src="resources/images/logo_m.png"></img>
			</h1>
			<ul>
               	<li class="UserName">
                    <a href="javascript:void(0)">
                        <span>无锡盈瑞传媒</span>
                    </a>
                </li>
                <li>|</li>
                <li><a href="javascript:parent.window.location.href='index'">首页</a></li>
                <li>|</li>
                <li><a href="javascript:void(0)" id="message">消息</a></li>
                <li>|</li>
                <li><a href="nosession-action-out">退出</a></li>
                <li>|</li>
                <li><a href="javascript:void(0)">帮助</a></li>
             </ul>
		</div>
		<div class="main">
			<div id="tabstrip">
                <ul>
                    <li class="k-state-active" style="background-color: #F5F5F5;">
                 		 短信管理
                    </li>
                    <li>
                                                                 短信安全
                    </li>
                    <li>
                                                                 充值/消费记录
                    </li>
                    <li>
                                                                 用户管理
                    </li>
                    <li>
                                                                 日志查询
                    </li>
                    <li>
                                                                 个人资料管理
                    </li>
                </ul>
                <div class="tabmain">
                	<div class="managerLeft">
                		<div style="width:210px;height:50px;border-bottom:2px solid #EBEBEB;">
                			<button id="receive" class="k-button" style="margin-top:10px;margin-left:20px;" type="button">接收短信</button>
                			<button id="send" class="k-button" style="margin-top:10px;" type="button">发送短信</button>
                		</div>
                		<div style="width:210px;margin-top:10px;height:80%;">
                			<div class="navSpanDiv"><span id="sendedMessage" class="navSpan">已发短信</span></div>
                			<div class="navSpanDiv"><span id="waitMessage" class="navSpan">待发短信</span></div>
                			<div class="navSpanDiv"><span id="receiveMessage" class="navSpan">接收短信</span></div>
                			<div class="navSpanDiv"><span id="timingMessage" class="navSpan">定时短信</span></div>
                			<div class="navSpanDiv"><span id="histroyMessage" class="navSpan">历史记录</span></div>
                			<div class="navSpanDiv"><span id="usefulExpression" class="navSpan">常用短语</span></div>
                		</div>
                	</div>
                	<div class="managerRight">
                	</div>
                </div>
                <div class="tabmain">
                	<div style="width:200px;height:98%;margin-top:5px;border:1px solid black;"></div>
                </div>
                <div class="tabmain">
                	<div class="rechargeAndconsumeLeft">
                		<div style="width:210px;margin-top:10px;height:80%;">
                			<div class="navSpanDiv"><span id="rechargeDetails" class="navSpan">充值记录</span></div>
                			<div class="navSpanDiv"><span id="consumeDetails" class="navSpan">消费记录</span></div>
                			<div class="navSpanDiv"><span id="archiveDetails" class="navSpan">归档记录</span></div>
                			<div class="navSpanDiv"><span id="unreturnDetails" class="navSpan">未返还记录</span></div>
                		</div>
                	</div>
                	<div class="rechargeAndconsumeRight">
                	</div>
                </div>
                <div class="tabmain">
                	<div class="userManagerLeft">
                		<div style="width:210px;margin-top:10px;height:80%;">
                			<div class="navSpanDiv"><span id="companyUserManager" class="navSpan">集团用户管理</span></div>
                			<div class="navSpanDiv"><span id="commonUserManager" class="navSpan">普通用户管理</span></div>
                		</div>
                	</div>
                	<div class="userManagerRight">
                	</div>
                	<div id="newComUserWindow" style="display:none">
                		<div>新增用户</div>
                		<div id="windowBody">
                			<div class="newUserColumn">
                				<div class="columnLeft">
                					<span style="float:left;width:80px;font-size:16px;text-align:center;margin-top: 5px;">用户名:</span>
                				</div>
                				<div class="columnRight">
                					<input id="newUserName" type="text" style="width:100%;height:28px;float:left;"></input>
                				</div>
                			</div>
                			<div class="newUserColumn">
                				<div class="columnLeft">
                					<span style="float:left;width:80px;font-size:16px;text-align:center;margin-top: 5px;">初始密码:</span>
                				</div>
                				<div class="columnRight">
                					<input id="newPassword" type="password" style="width:100%;height:28px;float:left;"></input>
                				</div>
                			</div>
                			<div class="newUserColumn">
                				<div class="columnLeft">
                					<span style="float:left;width:80px;font-size:16px;text-align:center;margin-top: 5px;">用户类型:</span>
                				</div>
                				<div class="columnRight">
                					<input id="newUserRole" type="password" style="width:100%;height:28px;float:left;"></input>
                				</div>
                			</div>
                			<div class="newUserColumn">
                				<button id="newCancle" style="float:right;margin-top:3px;margin-right:40px;" type="button">取消</button>
	                    		<button id="newSure" style="float:right;margin-top:3px;margin-right:10px;" type="button">确定</button>
                			</div>
                		</div>
                	</div>
                	<div id="cfgComUserWindow" style="display:none">
                		<div>用户配置</div>
                		<div id="windowBody">
                			<div class="newUserColumn">
                				<div class="columnLeft">
                					<span style="float:left;width:80px;font-size:16px;text-align:center;margin-top: 5px;">审核信息:</span>
                				</div>
                				<div class="columnRight">
                					<div id="configCheckStatus"></div>
                				</div>
                			</div>
                			<div class="newUserColumn">
                				<div class="columnLeft">
                					<span style="float:left;width:80px;font-size:16px;text-align:center;margin-top: 5px;">是否加急:</span>
                				</div>
                				<div class="columnRight">
                					<div id="configUserUrgent"></div>
                				</div>
                			</div>
                			<div class="newUserColumn">
                				<div class="columnLeft">
                					<span style="float:left;width:80px;font-size:16px;text-align:center;margin-top: 5px;">激活状态:</span>
                				</div>
                				<div class="columnRight">
                					<div id="configActivateStatus"></div>
                				</div>
                			</div>
                			<div class="newUserColumn">
                				<div class="columnLeft">
                					<span style="float:left;width:80px;font-size:16px;text-align:center;margin-top: 5px;">扣量比例:</span>
                				</div>
                				<div class="columnRight">
                					<div id="configDeductScale"></div><span style="float:right;width:20px;margin-right:35px;font-size:26px;margin-top: -33px;">%</span>
                				</div>
                			</div>
                			<div class="newUserColumn">
                				<button id="configCancle" style="float:right;margin-top:3px;margin-right:40px;" type="button">取消</button>
	                    		<button id="configSure" style="float:right;margin-top:3px;margin-right:10px;" type="button">确定</button>
                			</div>
                		</div>
                	</div>
                </div>
                <div class="tabmain">
                	<div class="logInfoLeft">
                		<div style="width:210px;margin-top:10px;height:80%;">
                			<div class="navSpanDiv"><span id="userRechargeLog" class="navSpan">用户充值记录</span></div>
                			<div class="navSpanDiv"><span id="userConsumpteLog" class="navSpan">用户消费记录</span></div>
                			<div class="navSpanDiv"><span id="userInfoUpdateLog" class="navSpan">用户信息修改记录</span></div>
                		</div>
                	</div>
                	<div class="logInfoRight">
                	</div>
                </div>
                <div class="tabmain">
                	<div class="personeInfoLeft">
                		<div style="width:210px;margin-top:10px;height:80%;">
                			<div class="navSpanDiv"><span id="personInfoDetails" class="navSpan">个人信息</span></div>
                			<div class="navSpanDiv"><span id="parameterSet" class="navSpan">短信参数设置</span></div>
                			<div class="navSpanDiv"><span id="addressBook" class="navSpan">通讯录</span></div>
                			<div class="navSpanDiv"><span id="messageManage" class="navSpan">消息管理</span></div>
                		</div>
                	</div>
                	<div class="personeInfoRight">
                	</div>
                </div>
            </div>
		</div>
	</body>
</html>
