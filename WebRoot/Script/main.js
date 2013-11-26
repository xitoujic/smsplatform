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