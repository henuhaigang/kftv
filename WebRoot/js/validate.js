  /**
                                                                           所有的验证框的验证 函数
              */
               	$(document).ready(function() {

			$("#userName").blur(showUnameTipBlur);
			$("#password").blur(showPasswordTipBlur);
			$("#email").blur(checkEmail);
            $("#registerSubmit").click(registerCheck);
            
		});
               	//提交验证
       function registerCheck() {
            $("#userName").blur(showUnameTipBlur);
			$("#password").blur(showPasswordTipBlur);
			$("#email").blur(checkEmail);
			
         }
              //判断用户名是否为空
		function showUnameTipBlur() {
			$("#userNameError").html("");
			if ($.trim($("#userName").val()) == ""){
				$("#userNameError").html("<font color='red'> 用户名不能为空! </font>");
				return false;
			}
				else{
				
				     $.post("checkUserExsit", {userName:$("#userName").val()},   

                               function (data){   

                            if(data.isUserNameUsed=="yes"){   

                     $("#userNameError").html("<font color='red'>  用户名已经被注册，请重新选择一个！ </font>");  
                     return false;

                      }else if(data.isUserNameUsed=="no"){
                      $("#userNameError").html("<font color='green'>  可以注册！ </font>"); 
                      return true;
                      }   

                         }, "json"); 
				
				}
				
		
		}

		//判断密码是否为空
		function showPasswordTipBlur() {
			$("#passwordError").html("");
			if ($.trim($("#password").val()) == "")
				$("#passwordError").html("<font color='red'> 密码不能为空! </font>");
			return false;
			
		}

		//验证邮箱
		function checkEmail() {

			var pattern = /^[a-z0-9][a-z0-9_\-\.]*[a-z0-9]*\@[a-z0-9_\-]+(\.[a-z0-9]{2,5}){1,}$/i;
			$("#emailError").html("");
			if ($.trim($("#email").val()) == '') {

				$("#emailError").html("<font color='red'> 请输入邮箱! </font>");
				return false;
			} else if (!pattern.test($.trim($("#email").val()))) {
				$("#emailError").html("<font color='red'> 邮箱格式错误，请重新输入! </font>");
				return false;
			}
			
		}
		
		