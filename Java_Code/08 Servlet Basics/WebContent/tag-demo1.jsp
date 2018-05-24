<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://vinod.co/customtags/slk" prefix="v" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Custom Tags</title>
</head>
<body>

	<div class="container">
		<h1>JSP Custom Tags</h1>
		<hr />
		
		
		<v:today  /> <br />
		<v:today  format="dd/MM/yyyy" /> <br />
		<v:today  format="EEEE MMMM dd, yyyy" /> <br />
		<v:today  format="M/d/y h:m:s" /> <br />
		
		
	</div>

</body>
</html>






