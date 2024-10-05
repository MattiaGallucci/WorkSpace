<%@page import="java.util.Iterator"%>
<%@page import="model.ProdottoBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    <%
	ArrayList<ArrayList<ProdottoBean>> categorie = (ArrayList<ArrayList<ProdottoBean>>) request.getSession().getAttribute("categorie");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<ProdottoBean> collane = categorie.get(1);%>
	
	<div id="main" class="clear">
	
	<h2>Collane</h2>
	
	</div>
</body>
</html>