<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">
    <link rel="stylesheet" href="/css/AdminLoginPageStyle.css">
	<title>HollyLand - Admin</title>
</head>
<body>
	<div class="container h-100">
		<div class="d-flex justify-content-center h-100">
			<div class="user_card">
				<div class="d-flex justify-content-center">
					<div class="brand_logo_container">
						<img src="/img/logo.png" height="130" width="150" alt="logo">
					</div>
				</div>
				<div class="d-flex justify-content-center form_container">
					<form:form action="/login" method="POST" modelAttribute="admin">
						<div class="input-group mb-3">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<form:input type="email" path="email" class="form-control input_user" placeholder="Email"/>
						</div>
						<div class="input-group mb-2">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<form:input type="password" path="password" class="form-control input_pass" placeholder="Password"/>
						</div>
						<div class="form-group">
							<div class="custom-control custom-checkbox">
								<input type="checkbox" name="rememberMe" class="custom-control-input" value="true" id="remember-me">
								<label class="custom-control-label" for="remember_me">Remember me</label>
							</div>
						</div>
						<div class="d-flex justify-content-center mt-3 login_container">
				 	        <input type="submit" class="btn login_btn" value="Login">
				        </div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>