<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-light bg-light">
	<form class="form-inline">
		<button class="btn btn-outline-success" type="button" data-toggle="modal" data-target="#addOfferId">
			</button>
		&nbsp;&nbsp;&nbsp;
		<button class="btn btn-outline-secondary" type="button"
			data-toggle="modal" data-target="#addCategory"></button>
	</form>
	<span>ADMIN</span>
</nav>

<div class="modal fade" id="addOfferId" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Add Offer Id</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form id="categoryform" onsubmit="addCategory(category)"  method="post">
					<div class="row">
						<div class="col">
							<input type="text" name="category" class="form-control" placeholder="add offer id">
						</div>
					</div>
					<br>
					<input type="submit" class="btn btn-primary mb-2" value="Update"/>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>


<div class="modal fade" id="addCategory" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Add Category</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form id="categoryform" onsubmit="addCategory(category)" action="addCategory" method="post">
					<div class="row">
						<div class="col">
							<input type="text" name="category" class="form-control" placeholder="write new category">
						</div>
					</div>
					<br>
					<input type="submit" class="btn btn-primary mb-2" value="Add"/>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>