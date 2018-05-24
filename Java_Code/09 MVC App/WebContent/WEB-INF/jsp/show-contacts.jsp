<%@ include file="./header.txt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>List of all contacts</h1>

<table class="table table-striped table-bordered table-condensed table-hover">
	<thead>
		<tr>
			<th>Name</th>
			<th>City</th>
			<th>Email id</th>
			<th>Phone number</th>
		</tr>
	</thead>
	<tbody>
		<%-- loop thru the list of contacts available in the request scope
		and print a <tr> for each one of them --%>
		<c:forEach items="${contacts}" var="c">
			<tr>
				<td>
					<a href="./view-contact?id=${c.id}">
					${c.gender == "Male" ? "Mr." : "Ms."}
					${c.name}
					</a>
				</td>
				<td>${c.city}</td>
				<td>${c.email}</td>
				<td>${c.phone}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="./footer.txt"%>











