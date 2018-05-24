<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Table for an input number</title>
</head>
<body>
	<h1>Table for an input number</h1>
	<hr />
	<form>
		<input type="text" name="num" placeholder="Enter a number: ">
	</form>
	
	<%!
	int num;
	
	static {
		System.out.println(">> From inside of table.jsp's static block...");
	}
	
	public void jspInit(){
		System.out.println("From inside of table.jsp's jspInit() function...");
	}
	%>
	<%

	
		String input = request.getParameter("num");
		if (input != null) {
			int num = Integer.parseInt(input);
			out.println("<h3>Table for " + num + "</h3>");
			
			for (int i = 1; i <= 10; i++) {
				String str = String.format("%d X %d = %d<br />", num, i, num * i);
				out.println(str);
			}
		}
	%>
</body>
</html>







