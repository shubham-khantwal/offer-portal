<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.khantwal.post.models.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="java.util.*"%>
<%
Employee empl = (Employee) session.getAttribute("employee");

if (empl != null) {
	response.sendRedirect("/profile");
}
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<title>Login</title>
<style>
.clip {
	clip-path: polygon(50% 0%, 82% 0, 100% 0, 100% 77%, 68% 100%, 32% 100%, 0 78%, 0 0,
		20% 0);
}
</style>
</head>
<body>
	<%@include file="home_navbar.jsp"%>
	<main
		class=" clip d-flex align-items-center home_navbar_custom_background"
		style="height: 80vh;">
		<div class="container">
			<div class="row">
				<div class="col-md-4 mx-auto">
					<div class="card">
						<div class="card-header bg-dark text-white text-center">
							<span class="fa fa-envelope fa-3x"></span>
							<p>Login Here</p>
						</div>
						<core:if test="${msg != null}">
							<div class="alert alert-warning alert-dismissible fade show"
								role="alert">
								${msg.getMessage()}
								<button type="button" class="close" data-dismiss="alert"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
						</core:if>
						<div class="card-body text-center">
							<form action="profile" method="post">
								<div class="mb-3">
									<label for="email" class="form-label">Email address</label> <input
										type="email" name="email" class="form-control" id="email"
										aria-describedby="emailHelp">
									<div id="emailHelp" class="form-text">We'll never share
										your email with anyone else.</div>
								</div>
								<div class="mb-3">
									<label for="password" class="form-label">Password</label> <input
										type="password" name="password" class="form-control"
										id="password">
								</div>

								<input type="submit" class="btn btn-primary"></input>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>

	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>