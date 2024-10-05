<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<title>JSP Error</title>
</head>
<body>
<h3> Error</h3>
<% if(exception != null) { %>
<p>An exception was raised: <%= exception.toString() %></p>
<p>Exception message is: <%= exception.getMessage() %></p>
<br>
<% 
	  StackTraceElement[] st = exception.getStackTrace();
	  for(StackTraceElement e: st){
		  out.println(e.toString());
	  }
	  
  }
%>
</body>
</html>


