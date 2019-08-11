<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#login_form").validate({
			errorClass : 'errors',
			rules : {
				userName : {
					required : true
				},
				password : {
					required : true
				}

			},
			messages : {
				userName : {
					required : "Please enter Username"
				},
				password : {
					required : "Please enter Password"
				}
			}

		});
	})
</script>
<style type="text/css">
.errors {
	color: red;
	font-weight: bold;
}
</style>

</head>
<body>
	<div class="container" align="center">
		<h2>LOGIN</h2>
		<form:form action="loginProcess.action" method="Post"
			modelAttribute="user" id="login_form">
			<h2 style="color: red;" align="center">${loginFail}</h2>
			<table>
				<tr>
					<td>User Name :</td>
					<td><form:input path="userName" id="userName" /></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><form:password path="password" id="password" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Login" /></td>
				</tr>
				<tr>
					<td><a href="register.action">Register Here</a></td>
				</tr>
				<tr>
					<td><span class="psw">Forgot <a href="#">password?</a></span></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>