<%@page import="com.khantwal.post.models.Employee"%>
<%
Employee emp = (Employee) session.getAttribute("employee");
%>
<div class="modal-header">
	<div class="container text-center">
		<h5 class="modal-title" id="ModalLabelForUser">${off.getTitle() }</h5>
		<button type="button" class="close" data-dismiss="modal"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	</div>
</div>
<div class="modal-body text-center" id="ModalLabelBodyForUser">
	${off.getContent() }</div>
<div class="modal-footer" id="ModalLabelFooterForUser">
	<a class="btn btn-primary text-white"><i class="fa fa-thumbs-o-up"
		title="click to like" onclick="updateLikes(<%=emp.getEmployeeId() %>,${off.getOfferId()}, ${off.getEmployeeId() },this)">${off.getLikes() }</i></a>
	<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
</div>