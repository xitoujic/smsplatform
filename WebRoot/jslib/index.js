/** 类 */
var Class = {
	create : function() {
		return function() {
			this.initialize.apply(this, arguments);
		}
	}
}

/** 菜单列表 */
var MenuList = Class.create();
MenuList.prototype = {

	/**
	 * 构造方法 id: 菜单列表 opacity: 不透明度 (0.0 - 1.0, 0.0 为全透明, 1.0 为不透明)
	 */
	initialize : function(id, opacity) {
		// 获取菜单列表
		this.obj = document.getElementById(id);
		if (!this.obj) {
			return;
		}

		// 对菜单列表内的所有菜单进行处理
		var menus = this.obj.childNodes;
		for ( var i = 0; i < menus.length; i++) {
			var menu = menus[i];
			if (menu.tagName == 'LI') {
				// 构建菜单
				new Menu(menu, opacity);
			}
		}
	}
}

/** 菜单 */
var Menu = Class.create();
Menu.prototype = {

	/**
	 * 构造方法 target: 目标菜单 opacity: 不透明度 (0.0 - 1.0, 0.0 为全透明, 1.0 为不透明)
	 */
	initialize : function(target, opacity) {
		this.util = new MenuUtil();

		// 获取目标菜单 (没多余元素)
	this.obj = this.util.cleanWhitespace(target);

	/* shade 2008/09/01 CHANGE START */
	// 定义透明度, 默认透明
	this.opacity = 0;
	this.maxopacity = opacity || 1;
	/* shade 2008/09/01 CHANGE END */

	// 获取菜单
	this.menu = this.obj.childNodes

	// 重要! 如果菜单不包含菜单项, 则不进行处理
	if (this.menu.length < 2) {
		return;
	}

	// 菜单标题和菜单体
	this.title = this.menu[0];
	this.body = this.menu[1];

	// 定义初始样式
	this.util.setStyle(this.body, 'visibility', 'hidden');
	this.util.setStyle(this.body, 'position', 'absolute');
	this.util.setStyle(this.body, 'overflow', 'hidden');
	this.util.setStyle(this.body, 'display', 'block');

	// 添加监听器
	this.addListener(this.obj, 'mouseover',
			this.util.bind(this, this.activate), false);
	this.addListener(this.obj, 'mouseout', this.util
			.bind(this, this.deactivate), false);
},

/**
 * 激活方法 当鼠标移动到菜单标题是激活
 */
activate : function() {
	// 获取当前菜单体的位置
	var pos = this.util.cumulativeOffset(this.title);
	var left = pos[0];
	var top = pos[1] + this.util.getHeight(this.title);

	// 定义激活时样式
	this.util.setStyle(this.body, 'left', left + 'px');
	this.util.setStyle(this.body, 'top', top + 'px');
	this.util.setStyle(this.body, 'visibility', 'visible');
	this.util.setStyle(this.body, 'opacity', this.opacity);
	this.util.setStyle(this.body, 'filter',
			'alpha(opacity=' + this.opacity * 100 + ')');

	/* shade 2008/09/01 ADD START */
	if (this.tid) {
		clearTimeout(this.tid);
	}
	// 不断加强菜单的不透明度
	this.tid = setInterval(this.util.bind(this, this.appear), 30);
	/* shade 2008/09/01 ADD END */
},

/**
 * 解除方法 当鼠标移动出菜单标题是激活
 */
deactivate : function() {
	/* shade 2008/09/01 ADD START */
	if (this.tid) {
		clearTimeout(this.tid);
	}
	// 不断减弱菜单的不透明度
	this.tid = setInterval(this.util.bind(this, this.fade), 30);
	/* shade 2008/09/01 ADD END */

	/* shade 2008/09/01 DELETE START */
	// 定义解除时样式
	// this.util.setStyle(this.body, 'visibility', 'hidden');
	/* shade 2008/09/01 DELETE END */
},

/* shade 2008/09/01 ADD START */
/**
 * 加强不透明度, 直到最大不透明度
 */
appear : function() {
	this.opacity += 0.1;
	if (this.opacity >= this.maxopacity) {
		this.opacity = this.maxopacity;
		// 取消循环调用
	clearTimeout(this.tid);
}
// 重新设定透明度
this.util.setStyle(this.body, 'opacity', this.opacity);
this.util.setStyle(this.body, 'filter',
		'alpha(opacity=' + this.opacity * 100 + ')');
},

/**
 * 减小不透明度, 直到完全透明隐藏菜单
 */
fade : function() {
this.opacity -= 0.1;
if (this.opacity <= 0) {
	this.opacity = 0;
	// 隐藏菜单
	this.util.setStyle(this.body, 'visibility', 'hidden');
	// 取消循环调用
	clearTimeout(this.tid);
}
// 重新设定透明度
this.util.setStyle(this.body, 'opacity', this.opacity);
this.util.setStyle(this.body, 'filter',
		'alpha(opacity=' + this.opacity * 100 + ')');
},
/* shade 2008/09/01 ADD END */

/**
 * 监听方法 element: 监听对象 name: 监听方法 observer: 执行的方法 useCapture: 浏览器调用事件的方式 (true 为
 * Capture 方式, false 为 Bubbling 方式)
 */
addListener : function(element, name, observer, useCapture) {
if (element.addEventListener) {
	element.addEventListener(name, observer, useCapture);
} else if (element.attachEvent) {
	element.attachEvent('on' + name, observer);
}
}
}

/** 一些实用的方法 */
var MenuUtil = Class.create();
MenuUtil.prototype = {
	initialize : function() {
	},

	$ : function(id) {
		return document.getElementById(id);
	},

	$A : function(iterable) {
		if (!iterable) {
			return [];
		}
		if (iterable.toArray) {
			return iterable.toArray();
		} else {
			var results = [];
			for ( var i = 0; i < iterable.length; i++) {
				results.push(iterable[i]);
			}
			return results;
		}
	},

	bind : function() {
		var array = this.$A(arguments);
		var func = array[array.length - 1];
		var _method = func, args = array, object = args.shift();
		return function() {
			return _method.apply(object, args.concat(array));
		}
	},

	getHeight : function(element) {
		return element.offsetHeight;
	},

	setStyle : function(element, key, value) {
		element.style[key] = value;
	},

	getStyle : function(element, key) {
		return element.style[key];
	},

	cleanWhitespace : function(list) {
		var node = list.firstChild;
		while (node) {
			var nextNode = node.nextSibling;
			if (node.nodeType == 3 && !/\S/.test(node.nodeValue)) {
				list.removeChild(node);
			}
			node = nextNode;
		}
		return list;
	},

	cumulativeOffset : function(element) {
		var valueT = 0, valueL = 0;
		do {
			valueT += element.offsetTop || 0;
			valueL += element.offsetLeft || 0;
			element = element.offsetParent;
		} while (element);
		return [ valueL, valueT ];
	}
}

/** 添加到页面加载事件 */
window.onload = function(e) {
	new MenuList('menus', 0.9);
}

$(document).ready(function() {
	$("#more").hover(function() {
		$("#more").css("text-decoration", "underline");
	}, function() {
		$("#more").css("text-decoration", "none");
	});

});

function onMouseOut(id) {
	$('#' + id).removeClass('highLight');
	$('#' + id).addClass('news_item_a');
}

function onMouseOver(id) {
	$('#' + id).removeClass('news_item_a');
	$('#' + id).addClass('highLight');
}

function RegisterClick() {
	$("#warn4").css("display", "none");
	$("#warn4").html("");

	var v1 = emailAddress();
	var v2 = checkPassword1();
	var v3 = checkPasswordConfirm();

	if (v1 == false || v2 == false || v3 == false) {
		return false;
	}

	var email = $('#emailAddress').val();
	var password1 = $('#password1').val();
	var password2 = $('#passwordConfirm').val();

	$.ajax( {
		url : 'registerAction.action',
		type : 'post',
		data : {
			emailAddress : email,
			password1 : password1,
			passwordConfirm : password2
		},
		dataType : "xml",
		error : callback,
		success : callback
	});

}

function callback(data) {
	var jqueryObj = $(data);
	var message = jqueryObj.children();
	var text = message.text();
	if (text == "ERROR") {
		$("#warn4").css("display", "block");
		$("#warn4").html("注册失败");
		alert('注册失败');
	}
	if (text == "SUCCESS") {
		$("#warn4").css("display", "block");
		$("#warn4").html("注册成功");
		alert('注册成功');
	}
}

function emailAddress() {
	$("#warn1").css("display", "none");
	$("#warn1").html("");

	var email = $("#emailAddress").val();

	if (email == "") {
		$("#warn1").css("display", "block");
		$("#warn1").html("邮箱不能为空");
		return false;
	}

	if (email != '' && !/.+@.+\.[a-zA-Z]{2,4}$/.test(email)) {
		$("#warn1").css("display", "block");
		var errormessage = '邮箱格式出错';
		$("#warn1").text(errormessage).insertAfter($listItem);
		return false;
	}

	return true;
}

function checkPassword1() {
	$("#warn2").css("display", "none");
	$("#warn2").html("");

	var password1 = $("#password1").val();
	if (password1 == "") {
		$("#warn2").css("display", "block");
		$("#warn2").html("密码不能为空");
		return false;
	}

	return true;
}

function checkPasswordConfirm() {
	$("#warn3").css("display", "none");
	$("#warn3").html("");
	var password1 = $("#password1").val();
	var password2 = $("#passwordConfirm").val();
	if (password2 != password1) {
		$("#warn3").css("display", "block");
		$("#warn3").html("两次输入的密码不一样");
		return false;
	}

	return true;
}

function checkName(){
	$("#loginerror").css("display", "none");
	$("#loginerror").html("");
	var email = $("#userName").val();
	if (email != '' && !/.+@.+\.[a-zA-Z]{2,4}$/.test(email)) {
		$("#loginerror").css("display", "block");
		$("#loginerror").html("邮箱格式出错");
		return false;
	}

}
