<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.khantwal.post.models.Employee"%>
<%
Employee emp = (Employee) session.getAttribute("employee");
%>
<nav
	class="navbar navbar-expand-lg navbar-dark home_navbar_custom_background">
	<a class="navbar-brand" href=""><span class="fa fa-envelope-open"></span>Corporate
		Classified</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="/">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<!-- <li class="nav-item"><a class="nav-link" href="#">Link</a></li> -->
			<!-- 			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> Dropdown </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="#">Action</a> <a
						class="dropdown-item" href="#">Another action</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">Something else here</a>
				</div></li> -->
			<!-- 		<li class="nav-item"><a class="nav-link disabled" href="#"
				tabindex="-1" aria-disabled="true">Disabled</a></li> -->
			<%
			if (emp != null) {
			%>
			<li class="nav-item"><a class="nav-link" href="#!"
				data-toggle="modal" data-target="#add-post"><span
					class="fa fa-address-card-o"></span> Add Post</a></li>

			<%
			}
			%>
		</ul>
		
		<%
		if (emp == null) {
		%>
		<ul class="navbar-nav mr-right">
			<li class="nav-item"><a class="nav-link" href="login"><span
					class="fa fa-envelope"></span> Login</a></li>
			<li class="nav-item"><a class="nav-link" href="register"><span
					class="fa fa-user-plus"></span> Register</a></li>
		</ul>
		<%
		} else {
		%>
		<ul class="navbar-nav mr-auto">
			<div class="btn-group btn-group-toggle" data-toggle="buttons">
				<!-- <div class="dropdown">
					<button class="btn btn-secondary dropdown-toggle" type="button"
						id="dropdownMenuButton" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">Category</button>
					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<a class="dropdown-item" onclick="getPosts('education')">Education</a> <a
							class="dropdown-item" onclick="getPosts('electronics')">Electronics</a>
					</div>
				</div> -->
				<label class="btn btn-secondary" onclick="getPosts('date')"> <input type="radio"
					name="options" id="option2" autocomplete="off" > Sort By
					Date
				</label> <label class="btn btn-secondary" onclick="getPosts('likes')"> <input type="radio"
					name="options" id="option3" autocomplete="off" > Soft By
					Likes
				</label>
			</div>
		</ul>
		
		<ul class="navbar-nav mr-right">
			<li class="nav-item"><a class="nav-link" href="#!"
				data-toggle="modal" data-target="#profile-modal"><span
					class="fa fa-user-circle"></span> <%=emp.getName()%></a></li>
		</ul>
		<ul class="navbar-nav mr-right">
			<li class="nav-item"><a class="nav-link" href="logout"><span
					class="fa fa-envelope-open"></span> Logout</a></li>
		</ul>


		<!-- Modal -->
		<div class="modal fade" id="profile-modal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<div class="container text-center">
							<h5 class="modal-title" id="exampleModalLabel"><%=emp.getName()%></h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
					</div>
					<div class="modal-body">
						<div class="container text-center">
							<div id="profile-details">
								<table class="table">
									<tbody>
										<tr>
											<th scope="row">Name</th>
											<td><%=emp.getName()%></td>
										</tr>
										<tr>
											<th scope="row">Email</th>
											<td><%=emp.getEmail()%></td>
										</tr>
										<tr>
											<th scope="row">Phone No.</th>
											<td><%=emp.getPh()%></td>
										</tr>
										<tr>
											<th scope="row">Points</th>
											<td>${points }</td>
										</tr>
									</tbody>
								</table>
							</div>

							<div id="profile-edit" style="display: none;">
								<h3 class="mt-2">EDIT PROFILE</h3>
								<form action="update" method="post">
									<table class="table">
										<tr>
											<td>Name :</td>
											<td><input type="text" class="form-control" name="name"
												value="<%=emp.getName()%>"></td>
										</tr>
										<tr>
											<td>Email :</td>
											<td><input type="email" class="form-control"
												name="email" value="<%=emp.getEmail()%>"></td>
										</tr>
										<tr>
											<td>Phone number :</td>
											<td><input type="text" class="form-control" name="ph"
												value="<%=emp.getPh()%>"></td>
										</tr>
										<tr>
											<td>Password :</td>
											<td><input type="password" class="form-control"
												name="password" value="<%=emp.getPassword()%>"></td>
										</tr>
									</table>
									<input type="submit" class="btn btn-primary" value="Save" />
								</form>
							</div>

						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button id="edit-profile-btn" type="button"
							class="btn btn-primary">Edit</button>
					</div>
				</div>
			</div>
		</div>

		<!--  Modal for add post -->
		<div class="modal fade" id="add-post" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<div class="container text-center">
							<h5 class="modal-title" id="exampleModalLabel"><%=emp.getName()%></h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
					</div>
					<div class="modal-body text-center">
						<form action="savePost" method="post" id="add-post-form">

							<div class="form-group">
								<input name="title" type="text" placeholder="Enter Post Title"
									class="form-control" />
							</div>
							<div class="form-group">
								<textarea name="content" rows="5"
									placeholder="Enter your Content" class="form-control"></textarea>
							</div>
							<div class="form-group">
								<select class="form-control" name="offerCategory">
									<option selected disabled>----Select Category----</option>
									<core:forEach items="${categories}" var="category">
										<option value="${category.getOfferCategoryId()}">${category.getCategoryType()}</option>
									</core:forEach>
								</select>
							</div>
							<!-- <div class="form-group">
								<label for="thumbnail">Select Your Thumbnail</label> <input
									id="thumbnail" type="file" class="form-control" name="thumbnail"/>
							</div> -->
							<div class="container">
								<input type="submit" class="btn btn-primary" value="Post" />
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>

		<%
		}
		%>


		<!-- <form class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" type="search"
				placeholder="Search" aria-label="Search">
			<button class="btn btn-outline-dark my-2 my-sm-0" type="submit">Search</button>
		</form> -->
	</div>
</nav>


