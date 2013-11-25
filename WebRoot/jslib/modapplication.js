function change(userSex, userCategory) {
	if (userSex == '女') {
		$("#userSex2").attr('checked', true);
		$("#userSex1").attr('checked', false);
	}
	if (userCategory == '艺体') {
		$("#op2").attr('selected', 'selected');
	}

}

function deletes(id,pageNum){
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