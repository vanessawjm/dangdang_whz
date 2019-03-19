<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="${pageContext.request.contextPath }/front/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/front/css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/front/js/jquery-1.8.3.min.js"></script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			注册步骤:
			<span class="red_bold">1.填写信息</span> > 2.验证邮箱 > 3.注册成功
		</div>
		<div class="fill_message">
			<form name="ctl00" method="post" action="${pageContext.request.contextPath }/user/regist" id="f" onsubmit="return check()">
				<h2>
					以下均为必填项&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					${message}
				</h2>
				<table class="tab_login" >
					<tr>
						<td valign="top" class="w1">
							请填写您的Email地址：
						</td>
						<td>
							<input name="user.email" onblur="checkEmail()" type="text" id="txtEmail" class="text_input"/>
								<!-- 邮箱验证 -->
								<script type="text/javascript">
									function checkEmail(){
										var email = $("#txtEmail").val();
										var reg = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");	
										if(reg.test(email)){
											$("#emailInfo").html("<font color='green'>邮箱格式正确！</font>");
											return true;
										}else{
											$("#emailInfo").html("<font color='red'>邮箱格式错误！</font>");
											return false;
										}	
									}
								</script>
							<div class="text_left" id="emailValidMsg">
								<p>
									请填写有效的Email地址，在下一步中您将用此邮箱接收验证邮件。
								</p>
								<span id="emailInfo"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置您在当当网的昵称：
						</td>
						<td>
							<input name="user.nickname" onblur="checkNickname()" type="text" id="txtNickName" class="text_input" />
								<!-- 昵称验证 -->
								<script type="text/javascript">
									function checkNickname(){
								 		var nickname = $("#txtNickName").val();
								 		var length = 0;//字符长度
								 		var charCode = -1;
										var reg = new RegExp("^[a-z0-9\u4E00-\u9FFF]+$");	//小写英文字母 数字 中文
										if(reg.test(nickname)){
											for(var i=0;i<nickname.length;i++){	
												//获取昵称字符串中的每一个字符
												charCode = nickname.charCodeAt(i);
												//判断字符是否是汉字
												if(charCode >= 0 && charCode <= 127){
													//不是汉字
													length += 1;
												}else{
													//是汉字 
													length += 2;
												} 
											}
											if(length >=4 && length <= 20){
												$("#nameInfo").html("<font color='green'>昵称长度正确！</font>");
												return true;
											}else{
												$("#nameInfo").html("<font color='red'>昵称长度错误！</font>");
												return false;
											}
											return true;
										}else{
											$("#nameInfo").html("<font color='green'>昵称格式错误！</font>");
											return false;
										}
									}
								</script>
							<div class="text_left" id="nickNameValidMsg">
								<p>
									您的昵称可以由小写英文字母、中文、数字组成，
								</p>
								<p>
									长度4－20个字符，一个汉字为两个字符。
								</p>
								<span id="nameInfo"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置密码：
						</td>
						<td>
							<input name="user.password" onblur="checkPassword()" type="password" id="txtPassword" class="text_input" />
							<script type="text/javascript">
								function checkPassword(){
									var password = $("#txtPassword").val();
									var reg = new RegExp("^[A-Za-z0-9]+$");	//小写英文字母 数字
									if(reg.test(password)){
										if(password.length >= 6 && password.length <= 20){
											$("#passwordInfo").html("<font color='green'>密码格式正确！</font>");
											return true;
										}else{
											$("#passwordInfo").html("<font color='red'>密码长度错误！</font>");	
											return false;
										}
									}else{
										$("#passwordInfo").html("<font color='red'>密码格式不正确！</font>");
										return false;
									}
								};
							</script>
							<div class="text_left" id="passwordValidMsg">
								<p>
									您的密码可以由大小写英文字母、数字组成，长度6－20位。
								</p>
								<span id="passwordInfo"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							再次输入您设置的密码：
						</td>
						<td>
							<input name="password1" onblur="checkPassword1()" type="password" id="txtRepeatPass" class="text_input"/>				
							<script type="text/javascript">
								function checkPassword1(){
									var password1 = $("#txtRepeatPass").val();
									//获取第一次输入的密码
									var password = $("#txtPassword").val();
									if(password == password1){
										$("#password1Info").html("<font color='green'>两次输入的密码一致！</font>");
										return true;
									}else{
										$("#password1Info").html("<font color='red'>两次输入的密码不一致！</font>");
										return false;
									}
								};
							</script>		
							<div class="text_left" id="repeatPassValidMsg">
								<span id="password1Info"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							验证码：
						</td>
						<td>
							<script type="text/javascript">
								function changeImage(){
									$("#imgVcode").attr({"src":"${pageContext.request.contextPath}/user/getImage?t="+Math.random()});
								}
							</script>
							<img class="yzm_img" id='imgVcode' src="${pageContext.request.contextPath }/user/getImage" onClick="changeImage()"  />
								<script type="text/javascript">
									function checkCode(){
										var code = $("#txtVerifyCode").val();											
										if(code == ""){
											$("#codeInfo").html("<font color='red'>请输入验证码！</font>");									
											return false;
										}else{
											$("#codeInfo").html("<font color='green'>验证码已输入</font>");		
											return true;
										}
									};
								</script>
							<input name="code"  onblur="checkCode()" type="text" id="txtVerifyCode" class="yzm_input"/>
							<div class="text_left t1">
								<p class="t1">
									<span id="vcodeValidMsg">请输入图片中的四个字母。</span>
									<a href="javascript:changeImage()" id="change" >看不清楚？换个图片</a>
									<br/>
									<span id="codeInfo"></span>
								</p>
							</div>
						</td>
					</tr>
				</table>
				<div class="login_in">
					<input id="btnClientRegister" class="button_1" name="submit"  type="submit" onsubmit="return check()" value="注 册"/>
					<script type="text/javascript">
						function check(){
							if(checkEmail() && checkNickname() && checkPassword() && checkPassword1() && checkCode()){
								return true;
							}else{
								return false;
							}
						}
					</script>
				</div>
			</form>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

