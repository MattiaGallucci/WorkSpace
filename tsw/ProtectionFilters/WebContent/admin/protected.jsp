<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pagina Riservata all'Amministratore</title>
</head>

<body>
<h1>Benvenuto nella Pagina Riservata all'Amministratore</h1>

<p>
Congratulazioni! <br> Questa pagina è accessibile all'amministratore soltanto (non all'utente).
</p>

<p>
<a href="<%=request.getContextPath()%>/common/Logout">Logout</a>
</p>

</body>
</html>

