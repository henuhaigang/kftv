/**
   所有的验证框的验证 函数
 */

var flag=true;

$(document).ready(function() {

	$("#userName").blur(showUnameTipBlur);
	$("#userName1").blur(showUnameTipBlur);
	$("#password").blur(showPasswordTipBlur);
	$("#email").blur(checkEmail);
	$("#registerSubmit").click(registerCheck);
	$("#loginSubmit").click(loginCheck);
});
//提交验证

//判断用户名是否为空
function showUnameTipBlur() {
	
	
	$("#userNameError").html("");
	if ($.trim($("#userName").val()) == "") {
		$("#userNameError").html("<font color='red'> 用户名不能为空! </font>");
		flag = false;
		return flag;
	    } else{

				$.post(
						"checkUserExsit",
						{
							userName : $("#userName").val()
						},

						function(data) {

							if (data.isUserNameUsed == "yes") {

								$("#userNameError")
										.html(
												"<font color='red'>  用户名已经被注册，请重新选择一个！ </font>");
								flag = false;
								

							} else if (data.isUserNameUsed == "no") {
								$("#userNameError").html(
										"<font color='green'>  可以注册！ </font>");
								flag = true;
								
							}

						}, "json");
				
				return flag;	
	}
	
	
}


//判断密码是否为空
function showPasswordTipBlur() {
	
	$("#passwordError").html("");
	if ($.trim($("#password").val()) == ""){
		$("#passwordError").html("<font color='red'> 密码不能为空! </font>");
	flag = false;
	return flag;
	}else{
		
		
		flag=true;
		return flag;
	}
	

}

//验证邮箱
function checkEmail() {
	
	var pattern = /^[a-z0-9][a-z0-9_\-\.]*[a-z0-9]*\@[a-z0-9_\-]+(\.[a-z0-9]{2,5}){1,}$/i;
	$("#emailError").html("");
	if ($.trim($("#email").val()) == '') {

		$("#emailError").html("<font color='red'> 请输入邮箱! </font>");
		flag = false;
	} else if (!pattern.test($.trim($("#email").val()))) {
		$("#emailError").html("<font color='red'> 邮箱格式错误，请重新输入! </font>");
		flag = false;
	}
	return flag;
}
function UnameTipBlur() {
	
	$("#userNameError").html("");
	if ($.trim($("#userName1").val()) == "") {
		$("#userNameError1").html("<font color='red'> 用户名不能为空! </font>");
		flag = false;
	}else{
		flag=true;
	}
	
	return flag;
}

function registerCheck() {
	var flag1 = showUnameTipBlur();
	var flag2 = showPasswordTipBlur();
	var flag3 = checkEmail();

	if (flag1 == false || flag2 == false || flag3 == false) {
		flag = false;
		return flag;
		alert("注册失败");
	}else{
		flag=true;
		alert("注册成功！");
		return flag;
	}

}
function loginCheck() {
	var flag1 = UnameTipBlur();
	var flag2 = showPasswordTipBlur();
	
	
	if (flag1 == false || flag2 == false) {
		flag = false;
		return flag;
	}else{
		flag=true;
		
		return flag;
	}

}
