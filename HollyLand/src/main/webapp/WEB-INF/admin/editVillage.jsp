<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">
<link rel="stylesheet" href="/css/editVillage.css">
<title>Admin</title>
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
					<form:form action="/updateVillage/${village.id}" method="POST" modelAttribute="villages">
						<div class="form-group">
							<input type="text" class="form-control" id="exampleFormControlInput1" value="${village.city.name}" readonly>
						</div>
						<div class="form-group">
							<form:input type="text" path="name" class="form-control" id="exampleFormControlInput1" placeholder="Village Name"/>
						</div>
						<div class="form-group">
							<form:input type="text" path="space" class="form-control" id="exampleFormControlInput1" placeholder="Village Area"/>
						</div>
						<div class="form-group">
							<form:input type="text" path="population" class="form-control" id="exampleFormControlInput1" placeholder="Population"/>
						</div>
						<div class="form-group">
							<label for="exampleFormControlTextarea1">Description</label>
							<form:textarea path="description" class="form-control" id="exampleFormControlTextarea1" rows="3" placeholder="Description"/>
						</div>
						<div class="d-flex justify-content-center mt-3 login_container">
							<input type="submit" class="btn login_btn" value="Update">
						</div>
						<div class="ref1">
							<a href="/addImageFor/${village.id}" class="link-danger">Add images</a> <a href="/showReportsFor/${village.id}" class="link-danger">Show reports</a>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>