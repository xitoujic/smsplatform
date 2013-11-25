var pagesnow = 0;

$(document)
		.ready(
				function() {
					$('table.paginated')
							.each(
									function() {
										var currentPage = 0;
										var numPerPage = 10;

										var $table = $('table.paginated');
										$table
												.bind(
														'repaginate',
														function() {
															var value1 = $table
																	.find(
																			'tbody tr')
																	.show();
															value1
																	.lt(
																			currentPage
																					* numPerPage)
																	.hide()
																	.end()
																	.gt(
																			(currentPage + 1)
																					* numPerPage
																					- 1)
																	.hide()
																	.end();
														});

										var numRows = $table.find('tbody tr').length;
										var numPages = Math.ceil(numRows
												/ numPerPage);

										var $pager = $('<div class="pager"></div>');
										for ( var page = 0; page < numPages; page++) {
											$(
													'<span class="page-number">' + (page + 1) + '</span>')
													.bind(
															'click',
															{
																'newPage' : page
															},
															function(event) {
																currentPage = event.data['newPage'];
																pagesnow = currentPage;
																$table
																		.trigger('repaginate');
																$(this)
																		.addClass(
																				'active')
																		.siblings()
																		.removeClass(
																				'active');
															}).appendTo($pager)
													.addClass('clickable');
										}
										$pager.find('span.page-number:first')
												.addClass('active');
										$pager.insertBefore($table);
										$('<br>').insertBefore($table);

										$table.trigger('repaginate');
									});
				});

$(document)
		.ready(
				function() {
					$("#delete").click(function() {
						$(".checkbox_delete").each(function() {
							if (this.checked == true) {
								var id = this.id;
								$.ajax( {
									url : 'deleteNoticeAction.action',
									type : 'post',
									data : {
										id : id
									},
									dataType : "xml",
									error : callback,
									success : callback
								});
							}
						});
					});

					$("#delete_all")
							.toggle(
									function() {
										this.checked = true;
										$(".checkbox_delete")
												.each(
														function() {
															if ($(this).val() > pagesnow * 10
																	&& $(this)
																			.val() < (pagesnow + 1) * 10 + 1) {
																this.checked = true;
															}
														});
									},
									function() {
										this.checked = false;
										$(".checkbox_delete")
												.each(
														function() {
															if ($(this).val() > pagesnow * 10
																	&& $(this)
																			.val() < (pagesnow + 1) * 10 + 1) {
																this.checked = false;
															}
														});
									});
				});

function callback(data) {
	var jqueryObj = $(data);
	var message = jqueryObj.children();
	var text = message.text();
	if (text == "ERROR") {
		alert('删除失败');
	}
	if (text == "SUCCESS") {
		alert('删除成功');
		location.reload();// 重新装载页面
	}
}

$(document).ready(function() {
	$("#getAllStudentChoose").toggle(
		function(){
				this.checked=true;
			$(".choosingAllSutudentId").each(function(){
				$(this).attr("checked",true);
			});
		},
		function(){
			this.checked=false;
			$(".choosingAllSutudentId").each(function(){
				$(this).attr("checked",false);
			});
		}
	);
	
	$("#notice tbody tr").hover(function() {
		$(this).addClass('highlight');
	}, function() {
		$(this).removeClass('highlight');
	});

	$("#insert_notice").click(function() {
		location.href = "toInertNoticeAction.action";
	});

	$("#notice_title").blur(function() {
		if ($(this).val() == "") {
			alert("主题不能为空");
			return false;
		}
		return true;
	});

	$("#publish_notice").click(function() {
		if ($("#notice_title").trigger("blur") == false) {
			return false;
		}
		var title = $("#notice_title").val();
		var context = $("#notice_context").val();

		if (title != "") {
			$.ajax( {
				url : 'insertNoticeAction.action',
				type : 'post',
				dataType : "xml",
				data : {
					'noticeDomainPublish.ndtitle' : title,
					'noticeDomainPublish.content' : context
				},
				error : callback2,
				success : callback2
			});
		}
	});

});

function callback2(data) {
	var jqueryObj = $(data);
	var message = jqueryObj.children();
	var text = message.text();
	if (text == "ERROR") {
		alert('发布失败');
	}
	if (text == "SUCCESS") {
		alert('发布成功');
	}
}

function deletes(id){
	var pageNum = getPageCurrent();
	location.href = "deleteStudentMessgeAction?id="+id+"&pageNum="+pageNum;
}

function checking(id){
	$.ajax({
		url:'checkingAction',
		type : 'post',
		dataType : "xml",
		data:{'id':id},
		error : function callback3(data){
			var jqueryObj = $(data);
			var message = jqueryObj.children();
			var text = message.text();
			if (text == "ERROR") {
				alert('审核失败');
			}
			if (text == "SUCCESS") {
				alert('审核成功');
				location.reload();// 重新装载页面
			}
		},
		success : function callback3(data){
			var jqueryObj = $(data);
			var message = jqueryObj.children();
			var text = message.text();
			if (text == "ERROR") {
				alert('审核失败');
			}
			if (text == "SUCCESS") {
				alert('审核成功');
				location.reload();// 重新装载页面
			}
		}
	});
	
}

$(document).ready(function() {
	$('#submitChoose').click(function(){
		var category1 = "";
		var category2 = ""; 
		var status = "";
		var pageNum = getPageCurrent();
		
		if($('#category1').attr('checked')== true) {
			category1 = $('#category1').val();
		}
		
		if($('#category2').attr('checked')== true) {
			category2 = $('#category2').val();
		}
		
		$(".status").each(function(){
			if(this.checked == true) {
				status = $(this).val();
			}
		});
		
		window.location = "toStudentMessageAction?category1="+category1+"&category2="+category2+"&status="+status+"&pageNum="+pageNum;
	
	});
});

function changeSetting(category1,category2,status){
	
	if(category1 == "1") {
		$("#category1").attr("checked",true);
	}
	
	if(category2 == "1") {
		$("#category2").attr("checked",true);
	}
	
	$(".status").each(function(){
		if($(this).val() == status) {
			this.checked = true;
		}
	});
}

function onfocusSearch() {
	$("#searchName").val(""); 
}

function onblurSearch() {
	if($("#searchName").val() == "") {
		$("#searchName").val("输入姓名");
	}
}

function searchByName() {
	var userName = $("#searchName").val();
	var pageNum = getPageCurrent();
	if(userName != "" || userName != "输入姓名") {
		$.ajax({
			url:'searchStudentByNameAction',
			type:'post',
			dataType : "xml",
			data:{
				'userName': userName,
				'pageNum': pageNum
			},
			error : callbackSearchByName,
			success : callbackSearchByName
		});
	}
}

function callbackSearchByName(data) {
	var jquery  = $(data);
	var message = jquery.children();
	var text = message.text();
	if(text == "ERROR") {
		alert("没有找到该学生");
		$("#searchName").val("输入姓名");
	}
	if(text == "SUCCESS") {
		window.open("modifyStudentAction",'_blank');
	}
}

function allChooseChecking() {
	$(".choosingAllSutudentId").each(function(){
		if(this.checked == true) {
			checking2(this.id);
		}
	});
}

function allChooseDeleting() {
	var pageNum = getPageCurrent();
	$(".choosingAllSutudentId").each(function(){	
		if(this.checked == true) {
			deletes2(this.id,pageNum);
		}
	});
}

function deletes2(id,pageNum){
	//location.href = "deleteStudentMessgeAction?id="+id+"&pageNum="+pageNum;
}


function checking2(id){
	$.ajax({
		url:'checkingAction',
		type : 'post',
		dataType : "xml",
		data:{'id':id},
		error : function callback3(data){
			var jqueryObj = $(data);
			var message = jqueryObj.children();
			var text = message.text();
			if (text == "ERROR") {
				alert('审核失败');
			}
			if (text == "SUCCESS") {
				location.reload();// 重新装载页面
			}
		},
		success : function callback3(data){
			var jqueryObj = $(data);
			var message = jqueryObj.children();
			var text = message.text();
			if (text == "ERROR") {
				alert('审核失败');
			}
			if (text == "SUCCESS") {
				location.reload();// 重新装载页面
			}
		}
	});
	
}
