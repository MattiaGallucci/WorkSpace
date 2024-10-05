<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>JSP Tags</title>
</head>
<body>
<%@ include file="header.jsp" %>
<h3>JSP Tags</h3>
<%! 
    long fact(long n) {
		if(n == 1) return 1;
		return n*fact(n-1);
	}
%>

<% String xStr = request.getParameter("num"); 
   if(xStr != null) {
	try {
		long x = Long.parseLong(xStr); %>
	Fattoriale: <%= x%>!= <%= fact(x)%>
		
<% } catch (NumberFormatException e) {%>
	Il paraemtro <b>num</b> non contiene un valore intero.	
<%
	}
 }
%>
<%@ include file="footer.jsp" %>
</body>
</html>


