<%@page import="model.PostDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.PostBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Index</title>
    
</head>
<body>
    <% response.sendRedirect("posts?mode=home"); %>
</body>
</html>
