$(document).ready(function () {
	var theme = "";
	//var theme = getDemoTheme();
	//短信管理
	var tabpanel = $('#tabstrip').jqxTabs({ width: '100%', height: "100%", position: 'top', theme: theme });
	$("#send").jqxButton({ width: '65', height: '25', theme: theme });
	$("#send").click(function(){
		var html = '<div class="sendrightTop">'
				 + '	<div style="width:210px;height:40px;">'
				 + '		<button id="sendSure" class="k-button k-i-editor" style="width:60px;height:30px;margin-top:10px;margin-left:20px;" type="button">发送</button>'
				 + '		<button id="sendCancle" class="k-button k-i-cancle" style="width:60px;height:30px;margin-top:10px;" type="button">取消</button>'
				 + '	</div>'
				 + '</div>'
				 + '<div class="sendrightBottom">'
				 + '	<div class="receivePeopleDiv">'
				 + '		<span style="width:85px;height:30px;float:left;margin-top:7px;text-align:center;font-size:12px;">接收人：</span>'
				 + '		<input type="text" style="width:75%;height:30px;float:left"></input>'
				 + '    </div>'
				 + '	<div class="addNumDiv">'
				 + '		<button id="addNumber" class="k-button k-i-cancle" style="width:80px;height:30px;margin-left:5px;margin-top:5px;float:left;font-size:12px;" type="button">添加号码</button>'
				 + '	</div>'
				 + '	<div class="messageDiv">'
				 + '		<span style="width:85px;height:30px;float:left;margin-top:7px;text-align:center;font-size:12px;">短信内容：</span>'
				 + '		<textarea style="width:75%;height:190px;float:left;resize: none;" ></textarea>'
				 + '		<span style="width:75%;float:left;margin-left:85px;color:red;font-size:12px;">短信内容<span id="contentNum">0</span>个字，短信签名<span id="signatureNum">0</span>个字。按每条70个字拆分，共<span id="messageNum">0</span>条。</span>'
				 + '	</div>'
				 + '	<div class="messageSignatureDiv">'
				 + '		<span style="width:85px;height:30px;float:left;margin-top:14px;text-align:center;font-size:12px;">短信签名：</span>'
				 + '		<input type="text" style="width:75%;height:30px;float:left;margin-top:5px;"></input>'
				 + '	</div>'
				 + '</div>'
		$(".managerRight").empty();
		$(".managerRight").html(html);
		$("#sendSure").jqxButton({ width: '60', height: '25', theme: theme });
		$("#sendCancle").jqxButton({ width: '60', height: '25', theme: theme });
		$("#addNumber").jqxButton({ width: '65', height: '25', theme: theme });
	});
	$("#receive").jqxButton({ width: '60', height: '25', theme: theme });
	$("#receive").click(function(){
		var html = "接收短信";
		$(".managerRight").empty();
		$(".managerRight").html(html);
	});
	
	$("#sendedMessage").click(function(){
		var html = '<div id="messageGrid" style="margin-top:10px;margin-left:15px;"></div>';
		$(".managerRight").empty();
		$(".managerRight").html(html);
		var source =
	    {
	        datatype: "jsonp",
	        datafields: [
	            { name: 'messageType' },
	            { name: 'sendPeople' },
	            { name: 'submitType', type: 'float' },
	            { name: 'messageState' },
	            { name: 'phoneNumber' }
	        ],
	        async: false,
	        url: "http://ws.geonames.org/searchJSON",
	        pagesize: 18,
	        pager: function (pagenum, pagesize, oldpagenum) {
	        },
	        data: {
	            featureClass: "P",
	            style: "full",
	            maxRows: 20
	        }
	    };
		var dataAdapter = new $.jqx.dataAdapter(source,
	            {
	                formatData: function (data) {
	                    data.name_startsWith = $("#searchField").val();
	                    return data;
	                }
	            }
	        );
		$("#messageGrid").jqxGrid(
	            {
	                width: "97%",
	                source: dataAdapter,
	                theme: theme,
	                height: "97%",
	                pageable: true,
	                sortable: true,
	                columns: [
	                    { text: '短信类型', datafield: 'messageType', width: 80 },
	                    { text: '发送人', datafield: 'sendPeople', width: 150 },
	                    { text: '提交方式', datafield: 'submitType', width: 100 },
	                    { text: '短信状态', datafield: 'messageState', width: 80 },
	                    { text: '号码个数', datafield: 'phoneNumber', minwidth: 80 },
	                    { text: '短信内容', datafield: 'messageDetails', width: 380 },
	                    { text: '发送时间', datafield: 'sendTime', minwidth: 120 }
	                ],
	                showtoolbar: true,
	                rendertoolbar: function (toolbar) {
		            	var me = this;
	                    var container = $('<span style="margin-top:10px;margin-left:10px;float:left;font-size:16px;">短信发送历史记录</span>'
	                    				  +'<div style="width:150px;height:32px;float:right;">'
	                    						+'<button id="checkPhoneNum" style="float:left;margin-top:3px;margin-left:10px;" type="button">查询号码</button>'
	                    						+'<button id="failToSend" style="float:right;margin-top:3px;margin-right:10px;" type="button">失败重发</button>'
	                    				  +'</div>');
	                    toolbar.append(container);
	                    $("#checkPhoneNum").jqxButton({ width: '60', height: '25', theme: theme });
	                    $("#failToSend").jqxButton({ width: '60', height: '25', theme: theme });
	            	}
	            });
	});
	
	
	//消费/充值记录
	//充值记录
	$("#rechargeDetails").click(function(){
		var html = '<div id="rechargeGrid" style="margin-top:10px;margin-left:15px;"></div>';
		$(".rechargeAndconsumeRight").empty();
		$(".rechargeAndconsumeRight").html(html);
		var source =
	    {
	        datatype: "jsonp",
	        datafields: [
	            { name: 'messageType' },
	            { name: 'sendPeople' },
	            { name: 'submitType', type: 'float' },
	            { name: 'messageState' },
	            { name: 'phoneNumber' }
	        ],
	        async: false,
	        url: "http://ws.geonames.org/searchJSON",
	        pagesize: 18,
	        pager: function (pagenum, pagesize, oldpagenum) {
	        },
	        data: {
	            featureClass: "P",
	            style: "full",
	            maxRows: 20
	        }
	    };
		var dataAdapter = new $.jqx.dataAdapter(source,
	            {
	                formatData: function (data) {
	                    data.name_startsWith = $("#searchField").val();
	                    return data;
	                }
	            }
	        );
		$("#rechargeGrid").jqxGrid(
	            {
	                width: "97%",
	                source: dataAdapter,
	                theme: theme,
	                height: "97%",
	                pageable: true,
	                sortable: true,
	                columns: [
	                    { text: '充值用户', datafield: 'rechargeUser', width: 80 },
	                    { text: '充值前金额', datafield: 'beforeMoney', width: 150 },
	                    { text: '充值金额', datafield: 'rechargeMoney', width: 100 },
	                    { text: '条数', datafield: 'rechargeNumber', width: 80 },
	                    { text: '充值后金额', datafield: 'afterMoney', minwidth: 150 },
	                    { text: '备注', datafield: 'messageDetails', width: 350 },
	                    { text: '操作时间', datafield: 'sendTime', minwidth: 120 }
	                ],
	                showtoolbar: true,
	                rendertoolbar: function (toolbar) {
		            	var me = this;
	                    var container = $('<span style="margin-top:10px;margin-left:10px;float:left;font-size:16px;">充值记录</span>'
	                    				  +'<div style="width:150px;height:32px;float:right;">'
	                    						+'<button id="exportRechargeData" style="float:right;margin-top:3px;margin-right:10px;" type="button">数据导出</button>'
	                    				  +'</div>');
	                    toolbar.append(container);
	                    $("#exportRechargeData").jqxButton({ width: '60', height: '25', theme: theme });
	            	}
	            });
	});
	
	//消费记录
	$("#consumeDetails").click(function(){
		var html = '<div id="consumeGrid" style="margin-top:10px;margin-left:15px;"></div>';
		$(".rechargeAndconsumeRight").empty();
		$(".rechargeAndconsumeRight").html(html);
		var source =
	    {
	        datatype: "jsonp",
	        datafields: [
	            { name: 'messageType' },
	            { name: 'sendPeople' },
	            { name: 'submitType', type: 'float' },
	            { name: 'messageState' },
	            { name: 'phoneNumber' }
	        ],
	        async: false,
	        url: "http://ws.geonames.org/searchJSON",
	        pagesize: 18,
	        pager: function (pagenum, pagesize, oldpagenum) {
	        },
	        data: {
	            featureClass: "P",
	            style: "full",
	            maxRows: 20
	        }
	    };
		var dataAdapter = new $.jqx.dataAdapter(source,
	            {
	                formatData: function (data) {
	                    data.name_startsWith = $("#searchField").val();
	                    return data;
	                }
	            }
	        );
		$("#consumeGrid").jqxGrid(
	            {
	                width: "97%",
	                source: dataAdapter,
	                theme: theme,
	                height: "97%",
	                pageable: true,
	                sortable: true,
	                columns: [
	                    { text: '消费用户', datafield: 'rechargeUser', width: 80 },
	                    { text: '消费前金额', datafield: 'beforeMoney', width: 150 },
	                    { text: '消费金额', datafield: 'rechargeMoney', width: 100 },
	                    { text: '条数', datafield: 'rechargeNumber', width: 80 },
	                    { text: '消费后金额', datafield: 'afterMoney', minwidth: 150 },
	                    { text: '备注', datafield: 'messageDetails', width: 350 },
	                    { text: '操作时间', datafield: 'sendTime', minwidth: 120 }
	                ],
	                showtoolbar: true,
	                rendertoolbar: function (toolbar) {
		            	var me = this;
	                    var container = $('<span style="margin-top:10px;margin-left:10px;float:left;font-size:16px;">消费记录</span>'
	                    				  +'<div style="width:150px;height:32px;float:right;">'
	                    						+'<button id="exportConsumeData" style="float:right;margin-top:3px;margin-right:10px;" type="button">数据导出</button>'
	                    				  +'</div>');
	                    toolbar.append(container);
	                    $("#exportConsumeData").jqxButton({ width: '60', height: '25', theme: theme });
	            	}
	            });
	});
	//用户管理
	//集团用户管理
	function getAllUserDate(){
		//debugger;
		var source =
	    {
	        datatype: "json",
	        datafields: [
	            { name: 'messageType' },
	            { name: 'sendPeople' },
	            { name: 'submitType', type: 'float' },
	            { name: 'messageState' },
	            { name: 'phoneNumber' }
	        ],
	        async: false,
	        url: "AdminfindAllUserAction",
	        pagesize: 18,
	        pager: function (pagenum, pagesize, oldpagenum) {
	        },
	        beforeprocessing: function (data) {
                debugger;
                source.totalrecords = data.length;
                return data;
            },
	        data: {
	            featureClass: "P",
	            style: "full",
	            maxRows: 20
	        }
	    };
		var dataAdapter = new $.jqx.dataAdapter(source,
	            {
	                formatData: function (data) {
	                    data.name_startsWith = $("#searchField").val();
	                    return data;
	                }
	            }
	        );
		return dataAdapter;
	};
	$("#companyUserManager").click(function(){
		//集团用户管理
		var html = '<div id="commonUserGrid" style="margin-top:10px;margin-left:15px;"></div>';
		$(".userManagerRight").empty();
		$(".userManagerRight").html(html);
		
		$("#commonUserGrid").jqxGrid(
	            {
	                width: "97%",
	                source: getAllUserDate(),
	                theme: theme,
	                height: "97%",
	                pageable: true,
	                sortable: true,
	                columns: [
	                    { text: '用户名', datafield: 'userName', width: 80 },
	                    { text: '用户姓名', datafield: 'userFullName', width: 150 },
	                    { text: '性别', datafield: 'userSex', width: 50 },
	                    { text: '手机号码', datafield: 'userPhoneNum', width: 150 },
	                    { text: '用户类型', datafield: 'userRole', minwidth: 50 },
	                    { text: '行业类型', datafield: 'companyType', width: 80 },
	                    { text: '审核信息', datafield: 'checkStatus', minwidth: 50 },
	                    { text: '激活状态', datafield: 'activateType', minwidth: 60 },
	                    { text: '扣量比', datafield: 'deductScale', minwidth: 80 }
	                ],
	                showtoolbar: true,
	                rendertoolbar: function (toolbar) {
		            	var me = this;
	                    var container = $('<span style="margin-top:10px;margin-left:10px;float:left;font-size:16px;">集团用户信息</span>'
	                    				  +'<div style="width:150px;height:32px;float:right;">'
	                    				  		+'<button id="companyConfig" style="float:right;margin-top:3px;margin-right:10px;" type="button">配置</button>'
	                    						+'<button id="addCompanyUser" style="float:right;margin-top:3px;margin-right:10px;" type="button">开户</button>'
	                    				  +'</div>');
	                    toolbar.append(container);
	                    $("#addCompanyUser").jqxButton({ width: '60', height: '25', theme: theme });
	                    $("#companyConfig").jqxButton({ width: '60', height: '25', theme: theme });
	            	}
	            });
		//集团开户
		var theme = getDemoTheme();
		$("#addCompanyUser").click(function(){
			
			//集团用户
			$('#newComUserWindow').jqxWindow({
                showCollapseButton: true,
                height: 210, 
                width: 400, 
                theme: theme,
                resizable: false,
                initContent: function () {
                    $('#newComUserWindow').jqxWindow('focus');
                }
            });
			$('#newComUserWindow').jqxWindow('open');
			var userType = [
                                     "管理员",
                                     "普通用户"
                                     ];
            $("#newUserRole").jqxDropDownList({ source: userType, selectedIndex: 1, width: '240', height: '28',dropDownHeight:60, theme: theme });
            
            $("#newSure").jqxButton({ width: '60', height: '25', theme: theme });
            $("#newCancle").jqxButton({ width: '60', height: '25', theme: theme });
            
            $("#newSure").click(function(){
            	var newUserNameString = $("#newUserName").val();
            	var newPasswordString = $("#newPassword").val();
            	var newTypeString = $('#newUserRole')[0].textContent;
            	var patrn=/^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){4,19}$/; 
            	var pswPartn = /^(\w){6,20}$/; 
            	if (!patrn.exec(newUserNameString)) {
            		alert("请输入字母与数字的组合！");
            	}else if(!patrn.exec(newPasswordString)){
            		alert("请输入6-20个字母、数字、下划线");
            	}else{
            		$.ajax({
    					type:"post",
    					url:"AddUserAction",//需要用来处理ajax请求的action,excuteAjax为处理的方法名，JsonAction为action名
    					data:{//设置数据源
                			F_UserName: newUserNameString,
    						F_Password: newPasswordString,
    						F_type: newTypeString
    					},
    					dataType:"json",//设置需要返回的数据类型
    					success:function(data){
    						var res = eval("("+data+")")
    						if(res.result == "-1"){
    							alert("用户已存在！");
    						}else if(res.result == "1"){
    							alert("用户添加失败！请稍后重试！");
    						}else if(res.result == "0"){
    							alert("开户成功！");
    							$('#newComUserWindow').jqxWindow('close');
    						}
    					},
    					error:function(){
    						alert("系统异常，请稍后重试！");
    					}
    				});
            	}
            	
            });
            $("#newCancle").click(function(){
            	$('#newComUserWindow').jqxWindow('close');
            });
		});
		//集团用户配置
		$("#companyConfig").click(function(){
			$("#configSure").jqxButton({ width: '60', height: '25', theme: theme });
            $("#configCancle").jqxButton({ width: '60', height: '25', theme: theme });
            var checkStatusSource = [
                                     "审核",
                                     "不审核"
                                     ];
            $("#configCheckStatus").jqxDropDownList({ source: checkStatusSource, selectedIndex: 1, width: '200', height: '28',dropDownHeight:60, theme: theme });
            var UrgentSource = [
                                     "加急",
                                     "不加急"
                                     ];
            $("#configUserUrgent").jqxDropDownList({ source: UrgentSource, selectedIndex: 1, width: '200', height: '28',dropDownHeight:60, theme: theme });
            var ActivateSource = [
                                "激活",
                                "不激活"
                                ];
            $("#configActivateStatus").jqxDropDownList({ source: ActivateSource, selectedIndex: 1, width: '200', height: '28',dropDownHeight:60, theme: theme });
            $("#configDeductScale").jqxNumberInput({ width: '180px', height: '28px', theme: theme, spinButtons: true, min:0, max:100 });
            
            $("#configCancle").click(function(){
            	$('#cfgComUserWindow').jqxWindow('close');
            });
			//集团用户
			$('#cfgComUserWindow').jqxWindow({
                showCollapseButton: true,
                height: 250, 
                width: 400, 
                theme: theme,
                resizable: false,
                initContent: function () {
                    $('#cfgComUserWindow').jqxWindow('focus');
                }
            });
			$('#cfgComUserWindow').jqxWindow('open');
		});
	});
	//普通用户管理
	$("#commonUserManager").click(function(){
		//普通用户管理
		var html = '<div id="commonUserGrid" style="margin-top:10px;margin-left:15px;"></div>';
		$(".userManagerRight").empty();
		$(".userManagerRight").html(html);
		var source =
	    {
	        datatype: "jsonp",
	        datafields: [
	            { name: 'messageType' },
	            { name: 'sendPeople' },
	            { name: 'submitType', type: 'float' },
	            { name: 'messageState' },
	            { name: 'phoneNumber' }
	        ],
	        async: false,
	        url: "http://ws.geonames.org/searchJSON",
	        pagesize: 18,
	        pager: function (pagenum, pagesize, oldpagenum) {
	        },
	        data: {
	            featureClass: "P",
	            style: "full",
	            maxRows: 20
	        }
	    };
		var dataAdapter = new $.jqx.dataAdapter(source,
	            {
	                formatData: function (data) {
	                    data.name_startsWith = $("#searchField").val();
	                    return data;
	                }
	            }
	        );
		$("#commonUserGrid").jqxGrid(
	            {
	                width: "97%",
	                source: dataAdapter,
	                theme: theme,
	                height: "97%",
	                pageable: true,
	                sortable: true,
	                columns: [
	                    { text: '用户名', datafield: 'userName', width: 80 },
	                    { text: '用户姓名', datafield: 'userFullName', width: 150 },
	                    { text: '性别', datafield: 'userSex', width: 50 },
	                    { text: '手机号码', datafield: 'userPhoneNum', width: 150 },
	                    { text: '用户类型', datafield: 'userRole', minwidth: 50 },
	                    { text: '行业类型', datafield: 'companyType', width: 80 },
	                    { text: '审核信息', datafield: 'checkStatus', minwidth: 50 },
	                    { text: '激活状态', datafield: 'activateType', minwidth: 60 },
	                    { text: '扣量比', datafield: 'deductScale', minwidth: 80 }
	                ],
	                showtoolbar: true,
	                rendertoolbar: function (toolbar) {
		            	var me = this;
	                    var container = $('<span style="margin-top:10px;margin-left:10px;float:left;font-size:16px;">普通用户信息</span>'
	                    				  +'<div style="width:150px;height:32px;float:right;">'
	                    				  		+'<button id="config" style="float:right;margin-top:3px;margin-right:10px;" type="button">配置</button>'
	                    						+'<button id="addCommunUser" style="float:right;margin-top:3px;margin-right:10px;" type="button">开户</button>'
	                    				  +'</div>');
	                    toolbar.append(container);
	                    $("#addCommunUser").jqxButton({ width: '60', height: '25', theme: theme });
	                    $("#config").jqxButton({ width: '60', height: '25', theme: theme });
	            	}
	            });
	});
	
	
	//日志信息
	$("#userRechargeLog").click(function(){
		debugger;
		$.ajax({
			type:"get",
			url:"LoglogAction",
			dataType:"json",//设置需要返回的数据类型
			success:function(data){
				debugger;
				var result = eval("("+data+")");
				alert("正常，请稍后重试！");
			},
			error:function(){
				alert("系统异常，请稍后重试！");
			}
		});
	});
	
	
	//个人信息
	$("#personInfoDetails").click(function(){
		var personInfohtml = '<div class="personeInfoDiv">'
				 + '	<span class="personHead"><B>基本信息</B></span>'
				 + '		<div class="personInfoColumn">'
				 + '			<div class="personInfoLeft">'
				 + '				<span style="float:left;text-align:right;width:100%;margin-top:5px;">用户名:</span>'
				 + '			</div>'
				 + '			<div class="personInfoRight">'
				 + '				<input type="text" style="width:100%;height:28px;float:left;margin-left:10px;"></input>'
				 + '			</div>'
				 + '		</div>'
				 + '		<div class="personInfoColumn">'
				 + '			<div class="personInfoLeft">'
				 + '				<span style="float:left;text-align:right;width:100%;margin-top:5px;">用户姓名:</span>'
				 + '			</div>'
				 + '			<div class="personInfoRight">'
				 + '				<input type="text" style="width:100%;height:28px;float:left;margin-left:10px;"></input>'
				 + '			</div>'
				 + '		</div>'
				 + '		<div class="personInfoColumn">'
				 + '			<div class="personInfoLeft">'
				 + '				<span style="float:left;text-align:right;width:100%;margin-top:5px;">手机号码:</span>'
				 + '			</div>'
				 + '			<div class="personInfoRight">'
				 + '				<input type="text" style="width:100%;height:28px;float:left;margin-left:10px;"></input>'
				 + '			</div>'
				 + '		</div>'
				 + '		<div class="personInfoColumn">'
				 + '			<div class="personInfoLeft">'
				 + '				<span style="float:left;text-align:right;width:100%;margin-top:5px;">性&nbsp;&nbsp;别:</span>'
				 + '			</div>'
				 + '			<div class="personInfoRight">'
				 + '				<input type="text" style="width:100%;height:28px;float:left;margin-left:10px;"></input>'
				 + '			</div>'
				 + '		</div>'
				 + '		<div class="personInfoColumn">'
				 + '			<div class="personInfoLeft">'
				 + '				<span style="float:left;text-align:right;width:100%;margin-top:5px;">角&nbsp;&nbsp;色:</span>'
				 + '			</div>'
				 + '			<div class="personInfoRight">'
				 + '				<input type="text" style="width:100%;height:28px;float:left;margin-left:10px;"></input>'
				 + '			</div>'
				 + '		</div>'
				 + '		<div class="personInfoColumn">'
				 + '			<div class="personInfoLeft">'
				 + '				<span style="float:left;text-align:right;width:100%;margin-top:5px;">剩余条数:</span>'
				 + '			</div>'
				 + '			<div class="personInfoRight">'
				 + '				<input type="text" style="width:100%;height:28px;float:left;margin-left:10px;"></input>'
				 + '			</div>'
				 + '		</div>'
				 + '	</div>'
				 + '	<div class="personeInfoDiv">'
				 + '		<span class="personHead"><B>基本参数</B></span>'
				 + '		<div class="personInfoColumn">'
				 + '			<div class="personInfoLeft">'
				 + '				<span style="float:left;text-align:right;width:100%;margin-top:5px;">行业类型:</span>'
				 + '			</div>'
				 + '			<div class="personInfoRight">'
				 + '				<input type="text" style="width:100%;height:28px;float:left;margin-left:10px;"></input>'
				 + '			</div>'
				 + '		</div>'
				 + '		<div class="personInfoColumn">'
				 + '			<div class="personInfoLeft">'
				 + '				<span style="float:left;text-align:right;width:100%;margin-top:5px;">是否审核:</span>'
				 + '			</div>'
				 + '			<div class="personInfoRight">'
				 + '				<input type="text" style="width:100%;height:28px;float:left;margin-left:10px;"></input>'
				 + '			</div>'
				 + '		</div>'
				 + '		<div class="personInfoColumn">'
				 + '			<div class="personInfoLeft">'
				 + '				<span style="float:left;text-align:right;width:100%;margin-top:5px;">用户类型:</span>'
				 + '			</div>'
				 + '			<div class="personInfoRight">'
				 + '				<input type="text" style="width:100%;height:28px;float:left;margin-left:10px;"></input>'
				 + '			</div>'
				 + '		</div>'
				 + '		<div class="personInfoColumn">'
				 + '			<div class="personInfoLeft">'
				 + '				<span style="float:left;text-align:right;width:100%;margin-top:5px;">客户签名:</span>'
				 + '			</div>'
				 + '			<div class="personInfoRight">'
				 + '				<input type="text" style="width:100%;height:28px;float:left;margin-left:10px;"></input>'
				 + '			</div>'
				 + '		</div>'
				 + '		<div class="personInfoColumn">'
				 + '			<div class="personInfoLeft">'
				 + '				<span style="float:left;text-align:right;width:100%;margin-top:5px;">签名标识:</span>'
				 + '			</div>'
				 + '			<div class="personInfoRight">'
				 + '				<input type="text" style="width:100%;height:28px;float:left;margin-left:10px;"></input>'
				 + '			</div>'
				 + '		</div>'
				 + '	</div>'
				 + '	<div class="personeInfoDiv">'
				 + '		<span class="personHead"><B>短信相关信息</B></span>'
				 + '		<div class="personInfoColumn">'
				 + '			<div class="personInfoLeft">'
				 + '				<span style="float:left;text-align:right;width:100%;margin-top:5px;">是否加急:</span>'
				 + '			</div>'
				 + '			<div class="personInfoRight">'
				 + '				<input type="text" style="width:100%;height:28px;float:left;margin-left:10px;"></input>'
				 + '			</div>'
				 + '		</div>'
				 + '	<div class="personInfoColumn">'
				 + '			<div class="personInfoLeft">'
				 + '				<span style="float:left;text-align:right;width:100%;margin-top:5px;">用户子号:</span>'
				 + '			</div>'
				 + '			<div class="personInfoRight">'
				 + '				<input type="text" style="width:100%;height:28px;float:left;margin-left:10px;"></input>'
				 + '			</div>'
				 + '		</div>'
				 + '	</div>'
				 + '	<div class="personeInfoDiv">'
				 + '		<span class="personHead"><B>密码修改</B></span>'
				 + '		<div class="personInfoColumn">'
				 + '			<div class="personInfoLeft">'
				 + '				<span style="float:left;text-align:right;width:100%;margin-top:5px;">原密码:</span>'
				 + '			</div>'
				 + '			<div class="personInfoRight">'
				 + '				<input type="password" style="width:100%;height:28px;float:left;margin-left:10px;"></input>'
				 + '			</div>'
				 + '		</div>'
				 + '		<div class="personInfoColumn">'
				 + '			<div class="personInfoLeft">'
				 + '				<span style="float:left;text-align:right;width:100%;margin-top:5px;">新密码:</span>'
				 + '			</div>'
				 + '			<div class="personInfoRight">'
				 + '				<input type="password" style="width:100%;height:28px;float:left;margin-left:10px;"></input>'
				 + '			</div>'
				 + '		</div>'
				 + '		<div class="personInfoColumn">'
				 + '			<div class="personInfoLeft">'
				 + '				<span style="float:left;text-align:right;width:100%;margin-top:5px;">确认密码:</span>'
				 + '			</div>'
				 + '			<div class="personInfoRight">'
				 + '				<input type="password" style="width:100%;height:28px;float:left;margin-left:10px;"></input>'
				 + '			</div>'
				 + '		</div>'
				 + '	</div>'
		$(".personeInfoRight").empty();
		$(".personeInfoRight").html(personInfohtml);
	});
})