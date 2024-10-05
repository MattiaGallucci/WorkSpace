<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tracking</title>
</head>
<body>
<h2>Tracking user behaviour</h2>
Logs:
<ol>
<%
	List<String> logs = (List<String>)request.getAttribute("logs");
	if(logs != null) {
		for(String s: logs) {
%>
		<li><%=s%></li>
<% 			
		}
	}
%>
</ol>
<br>
<a href="http://www.google.com/search?q=Google+tutorial+create+link">
   Google tutorial create link (direct)</a>
<br>
<a href="Tracking?url=http://www.google.com/search&q=Google+servlet+jsp">
   Google servlet jsp (tracking)</a>
<br>
<a href="Tracking?url=http://www.google.com/search">
   Google (tracking)</a>
<br>
<a href="Tracking?url=http://www.unisa.it">
   Unisa (tracking)</a>
<br>
<a href="Tracking">
   Refresh</a>
</body>
</html>