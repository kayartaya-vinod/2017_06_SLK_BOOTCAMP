<!DOCTYPE html>
<%@page import="slk.entity.Contact" %>
<%@page import="java.util.List"%>
<%@page import="slk.dao.DaoFactory"%>
<%@page import="slk.dao.ContactsDao"%>
<%!
	ContactsDao dao;

	public void jspInit(){
		try{
			dao = DaoFactory.getContactsDao("jdbc");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
%>
<%@page import="java.util.Date"%>
<html>
<head>
<%@include file="./common-head-code.txt" %>
<title>Contact list</title>
</head>
<body>
	<div class="container">
		<h1>Contact list</h1>
		<hr />
		<h3>
			As of
			<%=new Date()%>, your contact list has these data:
		</h3>
		<%
			List<Contact> list = dao.getAllContacts();
			if(list.size()>0){
				%>
				<table class="table table-striped table-bordered table-condensed table-hover">
					<thead>
						<tr>
							<td>Name</td>
							<td>Email address</td>
							<td>Phone number</td>
							<td>City</td>
						</tr>
					</thead>
					<tbody>
					<%
					for(Contact c: list){
						%>
						<tr>
							<td>
								<%= c.getGender().equalsIgnoreCase("male") ? "Mr.": "Ms." %>
								<%= c.getName() %></td>
							<td><%= c.getEmail() %></td>
							<td><%= c.getPhone() %></td>
							<td><%= c.getCity() %></td>
						</tr>
						<%
					}
					%>
					</tbody>
				</table>
				<%
			}
		%>
	</div>
	<%@ include file="./copyright.txt" %>
</body>
</html>