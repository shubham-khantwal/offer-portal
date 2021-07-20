<%@page import="com.khantwal.post.models.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
Employee emp = (Employee) session.getAttribute("employee");
%>
<div class="row mb-2">
	<c:forEach items="${off}" var="offer">
		<div class="col-md-4 mb-2 ">
			<div class="card card-inverse card-primary text-center">
				<img class="card-img-top" src="" alt="Card image cap">
				<div class="card-block .text-truncate">
					<b class="card-title">${offer.getTitle() }</b>
					<p class="card-text">${offer.getContent() }</p>
				</div>
				<div class="card-footer">
					<a class="btn btn-primary text-white"><i
						class="fa fa-thumbs-o-up" title="click to like"
						onclick="updateLikes(<%=emp.getEmployeeId() %>,${offer.getOfferId()}, ${offer.getEmployeeId() },this)">${offer.getLikes()}</i></a>
					<a class="btn btn-secondary text-white"
						title="click to read more about the offer" data-toggle="modal"
						data-target="#show-user-post"
						onclick="getPost(${offer.getOfferId()} , this)">Read More</a> <a
						class="btn btn-primary text-white"
						onclick="addEngagement(<%=emp.getEmployeeId() %>,${offer.getOfferId()} , ${offer.getEmployeeId() })"
						title="Engage with the owner"><i class="fa fa-address-card-o"></i></a>
				</div>
			</div>
		</div>
	</c:forEach>
</div>