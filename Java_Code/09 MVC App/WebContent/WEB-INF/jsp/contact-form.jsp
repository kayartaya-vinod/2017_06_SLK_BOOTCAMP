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
			<h1>${title}</h1>
		</div>
		<form action="save-contact" method="POST" class="form-horizontal">
		<input type="hidden" name="mode" value="${mode}">
		<c:choose>
			<c:when test="${mode=='add'}">
				<div class="form-group">
					<label class="control-label col-md-4">Id</label>
					<div class="col-md-5">
						<input type="text" class="form-control" name="id" >
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<input type="hidden" name="id" value="${contact.id }">
			</c:otherwise>
		</c:choose>
		
		<div class="form-group">
			<label class="control-label col-md-4">Gender</label>
			<div class="col-md-5">
				<div class="radio pull-left">
					<label>
					<input type="radio" name="gender" id="male"
						value="Male" ${contact.gender=="Male"?"checked":""} >
					Male</label>
				
					<label>
					<input type="radio" name="gender" 
						value="Female" ${contact.gender=="Female"?"checked":""} >
					Female</label>
				</div>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-4">Name</label>
			<div class="col-md-5">
				<input type="text" class="form-control" name="name" 
					value="${contact.name }">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-4">City</label>
			<div class="col-md-5">
				<input type="text" class="form-control" name="city" 
					value="${contact.city }">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-4">Email id</label>
			<div class="col-md-5">
				<input type="text" class="form-control" name="email" 
					value="${contact.email }">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-4">Phone number</label>
			<div class="col-md-5">
				<input type="text" class="form-control" name="phone" 
					value="${contact.phone }">
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-8 col-md-offset-4">
				<button type="submit" class="btn btn-success">Save</button>
				<a href="javascript:history.go(-1)" class="btn btn-default">Cancel</a>
			</div>
		</div>
		</form>
	</c:otherwise>
</c:choose>

<%@ include file="./footer.txt"%>