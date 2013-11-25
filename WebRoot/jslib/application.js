function change(userSex, userCategory) {
	if (userSex == '女') {
		$("#userSex2").attr('checked', true);
		$("#userSex1").attr('checked', false);
	}
	if (userCategory == '艺体') {
		$("#op2").attr('selected', 'selected');
	}

}