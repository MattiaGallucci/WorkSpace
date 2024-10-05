<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>JSP Call Error Page</title>
</head>
<body>
<h3>JSP Call Error Page</h3>
	<% String param = request.getParameter("testParam"); 
	   if(param.equals("PW")) { %>
			The <code>testParam</code> form parameter: <%=param %>
	<% } else { %>
			No form parameter
	<% } %>	
</body>
</html>


