<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<title>Home</title>

</head>
<body>


	<!--  navbar  -->
	<%@include file="home_navbar.jsp"%>
	





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

	
	<script>
	
	
	function addCategory(category){
		event.preventDefault();
		
		console.log(category)
		/* $(element).tab('show'); */
		$.ajax({
			url : "addCategory",	
			type : "POST",
			data : {category:category},
			success : function(data, textStatus, jqHXR) {
				console.log("Success !")
				 swal("Category has been added", {
					      icon: "success",
					    });
			},
			error : function(jqXHR, textStatus, errorThrown) {
				console.log("Fail !")
				console.log(jqXHR)
			},
			processData : true
		});
		
		
		
	}
	
	function getPosts(sortBy){
		console.log("getposts")
		/* $(element).tab('show'); */
		$("#loader").show();
		$.ajax({
			url : "getOffers",	
			type : "GET",
			data : {sortBy:sortBy},
			success : function(data, textStatus, jqHXR) {
				console.log("Success !")
				$("#loader").hide();
				$("#posts").html(data);
			},
			error : function(jqXHR, textStatus, errorThrown) {
				$("#loader").hide();
				console.log("Fail !")
				console.log(jqXHR)
			},
			processData : true
		});
		
		
		
	}
	
	function addEngagement(employeeId , offerId , owner){
		console.log("addEngagement "+offerId+" "+employeeId)
		/* $(element).tab('show'); */
		
		if(employeeId != owner){
			$.ajax({
				url : "addEngagement",	
				type : "POST",
				data : {employeeId : employeeId , offerId : offerId},
				success : function(data, textStatus, jqHXR) {
					console.log("Success Engagement !")
				},
				error : function(jqXHR, textStatus, errorThrown) {
					console.log("Fail Engagement !")
					console.log(jqXHR)
				},
				processData : true
			});	
		}
		
	}
	
	function updateLikes(employeeId , offerId, owner , temp){
		console.log("updateLikes "+offerId+" "+employeeId+" "+owner)
		/* $(element).tab('show'); */
		 if(owner != employeeId){
			 $.ajax({
					url : "updateLikes",	
					type : "POST",
					data : {employeeId : employeeId , offerId : offerId},
					success : function(data, textStatus, jqHXR) {
						console.log("Success Engagement !" + data)
						if(data === "Saved"){
							let c = $(temp).html();
							c++;
							$(temp).html(c);
						}else{
							let c = $(temp).html();
							if(c!=0){
								c--;
							}
							$(temp).html(c);
						}
						
					},
					error : function(jqXHR, textStatus, errorThrown) {
						console.log("Fail Engagement !")
						console.log(jqXHR)
					},
					processData : true
				});	
		 }	  
		
	}
	
	
		/* $(document).ready(function() {

			getPosts("all");
			let editStatus = false;
			

			$('#edit-profile-btn').click(function() {
				if (editStatus == false) {
					$('#profile-details').hide();
					$('#profile-edit').show();
					$('#edit-profile-btn').text("Back");
					editStatus = true;
				} else {
					$('#profile-details').show();
					$('#profile-edit').hide();
					$('#edit-profile-btn').text("Edit");
					editStatus = false;
				}
			});

			
			$("#categoryform").on("submit", function(event) {
				event.preventDefault();
				console.log("category add is triggered")
				
				console.log(this)
				let form = new FormData(this);

				swal({
					  title: "Are you sure?",
					  text: "Do you want to post this offer ?",
					  icon: "warning",
					  buttons: true,
					  dangerMode: false,
					})
					.then((willDelete) => {
					  if (willDelete) {
						  console.log("sending data")
							$.ajax({
								url : "savePost",
								type : "POST",
								data : form,
								success : function(data, textStatus, jqHXR) {
									console.log("Success !")
									
									console.log(data)
								},
								error : function(jqXHR, textStatus, errorThrown) {
									console.log("Fail !")
									console.log(jqXHR)
								},
								processData : false,
								contentType : false
							});
							
					    swal("Your post has been added!", {
					      icon: "success",
					    }).then(function() {
					        window.location = "/";
					    });
					    }
					  });
					}); 
				 
				
			});*/
	</script>
</body>
</html>