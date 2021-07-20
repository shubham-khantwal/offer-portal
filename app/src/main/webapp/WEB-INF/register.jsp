<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<title>Register Here</title>
<style>
.clip {
	clip-path: polygon(50% 0%, 82% 0, 100% 0, 100% 77%, 68% 100%, 32% 100%, 0 78%, 0 0,
		20% 0);
}
</style>
</head>
<body>
	<%@include file="home_navbar.jsp"%>
	<main class="home_navbar_custom_background p-4 clip">
		<div class="container">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-header text-center bg-dark text-white">
						<span class="fa fa-3x fa-user-circle"></span><br>Register
						Here
					</div>
					<div class="card-body">
						<form id="reg-form" action="registerEmployee" method="post">
							<div class="mb-3">
								<label for="name" class="form-label">User Name </label> <input
									type="text" name="name" class="form-control" id="name" required/>
							</div>
							<div class="mb-3">
								<label for="email" class="form-label">Email address</label> <input
									type="email" name="email" class="form-control" id="email"
									aria-describedby="emailHelp" required/>
								<div id="emailHelp" class="form-text">We'll never share
									your email with anyone else.</div>
							</div>
							<div class="mb-3">
								<label for="password" class="form-label">Password</label> <input
									type="password" name="password" class="form-control"
									id="password" required/>
							</div>
							<div class="mb-3">
								<label for="ph" class="form-label">Ph. No. </label> <input
									type="text" name="ph" class="form-control" id="ph" required/>
							</div>
							<div class="mb-3 form-check">
								<input type="checkbox" class="form-check-input" id="check"
									name="check" required/> <label class="form-check-label"
									for="exampleCheck1">agree terms and conditions</label>
							</div>
							<br>
							<div class="container text-center" id="loader"
								style="display: none;">
								<span class="fa fa-refresh fa-spin fa-4x"></span>
								<h4>Please wait...</h4>
							</div>
							<input id="submit-btn" type="submit" class="btn btn-primary"
								value="Register" />
						</form>

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
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>

	<script src="js/script.js" type="text/javascript"></script>
	<script>
		$(document).ready(function(){
			console.log("document is loaded...")
/* 			if($('#check').is(":checked")){
				console.log("checked")
			}else{
				console.log("not checked")
			} */
			$('#reg-form').on('submit',function(event){
				event.preventDefault();
				
				let form = new FormData(this);
				
				$("#submit-btn").hide();
				$("#loader").show();
				$.ajax({
					url: "registerEmployee",
					type:"post",
					data:form,
					success: function(data , textStatus , jqXHR){
						console.log(data)
						$("#loader").hide();
						$("#submit-btn").show();
						/* if(data.trim() === "Registered"){ */
						if(data.trim() === "Registered"){
							swal("You are registered!", "Click Ok to go to login page", "success")
							.then(()=>{
								window.location="login";
							});
						}else{
							console.log("inside else")
							swal(data);
						}

					},
					error: function(jqXHR , textStatus , errorThrown){
						console.log("inside error")
						console.log(jqXHR)
						$("#loader").hide();
						$("#submit-btn").show();
					},
					processData: false,
					contentType : false
					
				});
				
			});
		})
	</script>
</body>
</html>