$(document).ready(function () {
	var theme = "";
	
	/*
	 * 短信管理
	 */
	var tabpanel = $('#tabstrip').jqxTabs({ width: '100%', height: "100%", position: 'top', theme: theme });
	$("#send").jqxButton({ width: '65', height: '25', theme: theme });
	
	/*
	 * 短信发送
	 */
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
				 + '		<input type="text" id="phoneNumberString" style="width:55%;height:30px;float:left"></input>'
				 + '		<span style="height:30px;float:left;margin-top:7px;text-align:center;font-size:12px;color:red;">号码之间请以逗号隔开！</span>'
				 + '    </div>'
				 + '	<div class="addNumDiv">'
				 + '		<span style="width:68px;height:30px;float:left;margin-top:11px;margin-left:5px;text-align:left;font-size:12px;">号码文件:</span>'
				 + '		<input type="text" id="phoneNumTextName" style="width:20%;height:30px;float:left;margin-top:5px;"></input>'
				 + '		<button id="addNumber" style="margin-top:6px;margin-left:5px;float:left;" type="button">添加号码</button>'
				 + '		<div style="float:left;width:340px;height:99%;">'
				 + '			<span style="height:30px;float:left;margin-top:5px;margin-left:5px;text-align:center;font-size:12px;color:red;">请在C盘创建一个phonenum文件夹，将号码.txt文件存到该文件下。在当前输入框输入号码文件的名称。</span>' 
				 + '		</div>'
				 + '	</div>'
				 + '	<div class="messageDiv">'
				 + '		<span style="width:85px;height:30px;float:left;margin-top:7px;text-align:center;font-size:12px;">短信内容：</span>'
				 + '		<textarea id="messageContent" style="width:75%;height:190px;float:left;resize: none;" ></textarea>'
				 + '		<span style="width:75%;float:left;margin-left:85px;color:red;font-size:12px;">短信内容<span id="contentNum">0</span>个字，短信签名<span id="signatureNum">0</span>个字。按每条70个字拆分，共<span id="messageNum">0</span>条。</span>'
				 + '	</div>'
				 + '	<div class="messageSignatureDiv">'
				 + '		<span style="width:85px;height:30px;float:left;margin-top:14px;text-align:center;font-size:12px;">短信签名：</span>'
				 + '		<input type="text" style="width:75%;height:30px;float:left;margin-top:5px;"></input>'
				 + '	</div>'
				 + '</div>';
		$(".managerRight").empty();
		$(".managerRight").html(html);
		$("#sendSure").jqxButton({ width: '60', height: '25', theme: theme });
		$("#sendCancle").jqxButton({ width: '60', height: '25', theme: theme });
		$("#addNumber").jqxButton({ width: '65', height: '25', theme: theme });
		
		var phoneString = ""; 
		var phoneNumber = [];
		
		/*
		 * 添加号码，当前仅在ie下有效
		 */
		$("#addNumber").click(function(){
			var textName = $("#phoneNumTextName").val();
			if(textName == ""){
				alert("请输入文件名称！");
			}else{
				var fso = new ActiveXObject("Scripting.FileSystemObject"); 
				try{
					var f = fso.OpenTextFile("C:/phonenum/"+textName+".txt",1); 
					while (!f.AtEndOfStream) {
						phoneString += f.ReadLine(); 
			 			if(phoneString != ""){
			 				phoneString = ","+phoneString;
			 				phoneNumber = phoneString.split(",");
			 			}else{
			 				alert("号码文件中没有号码！");
			 			}
					}
					f.Close();
				}catch(e){
					alert("文件未找到！");
				}
			}
		});
		
		// 短信发送；
		$("#sendSure").click(function(){
			var phoneNumber = $("#phoneNumberString").val();
			var messageContent = $("#messageContent").val();
			var phoneNumberString = phoneNumber+phoneString;
			if(phoneNumberString == ""){
				alert("请输入号码或选择一个号码文件！");
			}else if(messageContent == ""){
				alert("请输入短信内容！");
			}else{
				$.ajax({
					type:"post",
					url:"UsersendMsgAction",//需要用来处理ajax请求的action,excuteAjax为处理的方法名，JsonAction为action名
					data:{//设置数据源
	        			"tBdMessagesendgroup.FGroupPhones": phoneNumberString,
	        			"tBdMessagesendgroup.FGroupContent": messageContent
					},
					dataType:"json",//设置需要返回的数据类型
					success:function(data){
						debugger;
					},
					error:function(){
						alert("系统异常，请稍后重试！");
					}
				});
			}
		});
	});
	
	/*
	 * 接收短信
	 */
	$("#receive").jqxButton({ width: '60', height: '25', theme: theme });
	$("#receive").click(function(){
		var html = "接收短信";
		$(".managerRight").empty();
		$(".managerRight").html(html);
	});
	
	
	/*
	 * 已发送短信记录
	 */
	
	$("#sendedMessage").click(function(){
		
		var html = '<div id="messageGrid" style="margin-top:10px;margin-left:15px;"></div>';
		$(".managerRight").empty();
		$(".managerRight").html(html);
		
		/*
		 * 已发送短信数据源
		 */
		function loadSendedMessageSource(){
			products =
	            [
	                {
	                	messageType: '群发',
	                	sendPeople: 'test',
	                	submitType: '平台',
	                	messageState: '发送成功',
	                	phoneNumber: '100',
	                	messageDetails: '发送测试',
	                	sendTime: '2013-12-17 23:05:23'
	                },
	                {
	                	messageType: '群发',
	                	sendPeople: 'test',
	                	submitType: '平台',
	                	messageState: '发送成功',
	                	phoneNumber: '300',
	                	messageDetails: '发送测试',
	                	sendTime: '2013-12-17 21:05:23'
	                }
	            ]; 
			var source =
		    {
		        //datatype: "jsonp",
				datatype: "array",
		        datafields: [
		            { name: 'messageType' },
		            { name: 'sendPeople' },
		            { name: 'submitType'},
		            { name: 'messageState' },
		            { name: 'phoneNumber' },
		            { name: 'messageDetails' },
		            { name: 'sendTime' },
		        ],
		        localdata: products,
		        //async: false,
		        //url: "http://ws.geonames.org/searchJSON",
		        pagesize: 18,
		        pager: function (pagenum, pagesize, oldpagenum) {
		        }
		    };
			var dataAdapter = new $.jqx.dataAdapter(source);
			return dataAdapter;
		}
		
		$("#messageGrid").jqxGrid(
            {
                width: "97%",
                source: loadSendedMessageSource(),
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
                    						//+'<button id="failToSend" style="float:right;margin-top:3px;margin-right:10px;" type="button">失败重发</button>'
                    				  +'</div>');
                    toolbar.append(container);
                    $("#checkPhoneNum").jqxButton({ width: '60', height: '25', theme: theme });
                    $("#failToSend").jqxButton({ width: '60', height: '25', theme: theme });
            	}
            });
		/*
		 * 短信号码查询窗口
		 */
		$("#checkPhoneNum").click(function(){
<<<<<<< HEAD
//			var phonehtml = '<div>查询发送号码信息</div>'
//						+ '<div>'
//			    		+ '	  <div id="phoneNumGrid" style="margin-left:5px;margin-top:5px;"></div>'
//			    		+ '</div>';
			//$('#phoneNumWindow').empty();
			//$('#phoneNumWindow').html(phonehtml);
=======
>>>>>>> origin/master
 			//集团用户
			$('#phoneNumWindow').jqxWindow({
                showCollapseButton: true,
                height: 600, 
                width: 800, 
                theme: theme,
                resizable: false,
                initContent: function () {
                    $('#phoneNumWindow').jqxWindow('focus');
                }
            });
			$('#phoneNumWindow').jqxWindow('open');
			
			/*
<<<<<<< HEAD
			 * 号码查询数据源
			 */
			function loadPhoneNumInfoSource(){
=======
			 * 详细号码数据源
			 */
			function phoneNumSource(){
>>>>>>> origin/master
				products =
		            [
		                {
		                	messageType: '群发',
		                	sendPeople: 'test',
		                	submitType: '平台',
		                	messageState: '发送成功',
		                	phoneNumber: '100',
		                	messageDetails: '发送测试',
		                	sendTime: '2013-12-17 23:05:23'
		                },
		                {
		                	messageType: '群发',
		                	sendPeople: 'test',
		                	submitType: '平台',
		                	messageState: '发送成功',
		                	phoneNumber: '300',
		                	messageDetails: '发送测试',
		                	sendTime: '2013-12-17 21:05:23'
		                }
		            ]; 
				var source =
			    {
			        //datatype: "jsonp",
					datatype: "array",
			        datafields: [
			            { name: 'messageType' },
			            { name: 'sendPeople' },
			            { name: 'submitType'},
			            { name: 'messageState' },
			            { name: 'phoneNumber' },
			            { name: 'messageDetails' },
			            { name: 'sendTime' },
			        ],
			        localdata: products,
			        //async: false,
			        //url: "http://ws.geonames.org/searchJSON",
			        pagesize: 18,
			        pager: function (pagenum, pagesize, oldpagenum) {
			        }
			    };
				var dataAdapter = new $.jqx.dataAdapter(source);
				return dataAdapter;
			}
			
<<<<<<< HEAD
			
			/*
			 * 号码详细记录
			 */
			
			$("#phoneNumGrid").empty();
			$("#phoneNumGrid").jqxGrid(
	            {
	                width: "98%",
	                source: loadPhoneNumInfoSource(),
	                theme: "",
=======
			/*
			 * 号码详细信息grid
			 */
			
			$("#phoneNumGrid").jqxGrid(
	            {
	                width: "98%",
	                source: phoneNumSource(),
	                theme: theme,
>>>>>>> origin/master
	                height: "98%",
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
	                    var container = $('<span style="margin-top:10px;margin-left:10px;float:left;font-size:16px;">号码详细记录</span>'
<<<<<<< HEAD
	                    				  +'<div style="width:80px;height:32px;float:right;">'
=======
	                    				  +'<div style="width:150px;height:32px;float:right;">'
>>>>>>> origin/master
	                    						+'<button id="exportGrid" style="float:left;margin-top:3px;margin-left:10px;" type="button">记录导出</button>'
	                    						//+'<button id="failToSend" style="float:right;margin-top:3px;margin-right:10px;" type="button">失败重发</button>'
	                    				  +'</div>');
	                    toolbar.append(container);
	                    $("#exportGrid").jqxButton({ width: '60', height: '25', theme: theme });
<<<<<<< HEAD
	                    $("#exportGrid").click(function(){
	                    	 $("#phoneNumGrid").jqxGrid('exportdata', 'xls', 'jqxGrid');
	                    });
	                    //$("#failToSend").jqxButton({ width: '60', height: '25', theme: theme });
	            	}
	        });
=======
	                    //$("#failToSend").jqxButton({ width: '60', height: '25', theme: theme });
	                    $("#exportGrid").click(function () {
	                        $("#messageGrid").jqxGrid('exportdata', 'xls', 'jqxGrid');           
	                    });
	            	}
	            });
>>>>>>> origin/master
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