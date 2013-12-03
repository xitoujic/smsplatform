$(document).ready(function () {
	$("#loginSure").click(function(){
		
		var UserName = $("#userName").val();
		var Password = $("#password").val();
		debugger;
		$.ajax({
			type:"post",
			url:"LoginAction",//需要用来处理ajax请求的action,excuteAjax为处理的方法名，JsonAction为action名
			data:{//设置数据源
				userName: UserName,
				password: Password
			},
			dataType:"json",//设置需要返回的数据类型
			success:function(data){
				debugger;
				var result = eval("("+data+")");
				alert("正常，请稍后重试！");
			},
			error:function(){
				alert("系统异常，请稍后重试！");
				window.location.href="admin.jsp"
			}
		});
	});
})