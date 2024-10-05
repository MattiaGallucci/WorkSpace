<%@ page language="java" contentType="text/html; charset=UTF-8"
    info="simple jsp examples" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>JSP Scriptlet</title>
</head>
<body>
<h3>JSP Scriptlet</h3>
<ul>
	<li>Current time: <%= new java.util.Date() %>
	<li>Server: <%=application.getServerInfo() %>
	<li>Application name: <%=application.getContextPath() %>
	<li>Session Id: <%=session.getId() %>
	<% String param = request.getParameter("testParam"); 
	if(param != null) { %>
	<li>The <code>testParam</code> form parameter:
		<%=request.getParameter("testParam") %>
	<% } else { %>
	<li>No form parameter	
	<% } %>	
	<li>Info: <%=this.getServletInfo() %>
</ul>
</body>
</html>


