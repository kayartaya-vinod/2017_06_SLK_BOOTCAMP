<%@ include file="./header.txt"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
	<c:when test="${contact==null}">
		<div class="alert alert-danger">
			<h1>No data found for id ${param.id}</h1>
		</div>
	</c:when>
	
	<c:otherwise>
		<div class="alert alert-success">
			<h1>Contact details for id ${param.id}</h1>
		</div>
		<div class="row">
			<label class="control-label col-md-4">Name</label>
			<label class="control-label col-md-8">${contact.name }</label>
		</div>
		<div class="row">
			<label class="control-label col-md-4">City</label>
			<label class="control-label col-md-8">${contact.city }</label>
		</div>
		<div class="row">
			<label class="control-label col-md-4">Email id</label>
			<label class="control-label col-md-8">${contact.email }</label>
		</div>
		<div class="row">
			<label class="control-label col-md-4">Phone number</label>
			<label class="control-label col-md-8">${contact.phone }</label>
		</div>
		<div class="row">
			<div class="col-md-8 col-md-offset-4">
				<a href="delete-contact?id=${contact.id}" class="btn btn-danger">Delete</a>
				<a href="edit-contact?id=${contact.id}" class="btn btn-info">Edit</a>
			</div>
		</div>
	</c:otherwise>
</c:choose>

<%@ include file="./footer.txt"%>




