<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>JSP Expressions</title>
</head>
<body>
<h3>JSP Expressions</h3>
<ul>
	<li>Current time: <%= new java.util.Date() %>
	<li>Server: <%=application.getServerInfo() %>
	<li>Application name: <%=application.getContextPath() %>
	<li>Session Id: <%=session.getId() %>
	<li>The <code>testParam</code> form parameter:
		<%=request.getParameter("testParam") %>
</ul>
</body>
</html>


