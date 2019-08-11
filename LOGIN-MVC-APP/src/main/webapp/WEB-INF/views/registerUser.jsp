<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#reg_form").validate({
			errorClass : 'errors',
			rules : {
				userName : {
					required : true
				},
				password : {
					required : true
				},
				email : {
					required : true,
					email : true
				},
				gender : {
					required : true
				},
				phno : {
					required : true,
					minLength : 10,
					maxLength : 10,
					number : true
				}

			},
			messages : {
				userName : {
					required : "Please enter Username"
				},
				password : {
					required : "Please enter Password"
				},
				email : {
					required : "Please enter Valid Email"
				},
				gender : {
					required : "Please Select Gender"
				},
				phno : {
					required : "Please enter valid Mobile Number"
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


<style type="text/css">
table {
	display: table;
	border-collapse: separate;
	border-spacing: 2px;
	border-color: gray;
}
td {
	font-family: sans-serif;
	font-size: medium;
}
</style>
</head>
<body>
	<h2 style="color: green;" align="center">${regSucc}</h2>
	<h2 style="color: red;" align="center">${regFail}</h2>
	<form:form action="registerProcess.action" method="POST"
		modelAttribute="user" id="reg_form">

		<div align="center">
			<h3>REGISTER HERE</h3>
			<table>
			<tr><td colspan="2">Already Registered <a href="login.action" >LOGIN HERE</a></td>
			</tr>
				<tr>
					<td><label hidden="true">User Id</label></td>
					<td><form:hidden path="userId" id="userId"/></td>
				</tr>
				<tr>
					<td><label>User Name</label></td>
					<td><form:input path="userName" id="userName"/></td>
				</tr>
				<tr>
					<td><label>Password</label></td>
					<td><form:password path="password" id="password"/></td>
				</tr>
				<tr>
					<td><label>Email</label></td>
					<td><form:input path="email" id="email"/></td>
				</tr>
				<tr>
					<td><label>Gender</label></td>
					<td><form:radiobuttons path="gender" items="${genders}" id="gender"/></td>
					
				</tr>
				<tr>
					<td><label>Phone Number</label></td>
					<td><form:input path="phno" id="phno"/></td>
				</tr>
				<tr>
					<td align="right"><input type="reset" value="RESET" /></td>
					<td align="left"><input type="submit" value="REGISTER" /></td>
				</tr>
			</table>

		</div>
	</form:form>

</body>
</html>