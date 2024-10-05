<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>AJAX Example - Home</title>
<script type="text/javascript" src="scripts/ajax.js"></script>
</head>
<body>
	<h1>Esempio AJAX</h1>

	<p>
		<a href="esci.jsp">Esci</a>
	</p>

	<div>
	    <!-- "javascript:void(0)" is used here to avoid submitting the form -->
		<form id="form" action="javascript:void(0)" method="get"> 
			<p>
				CAP: <input type="text" id="CAP" name="CAP" onchange="cercaCapoluogo()"/> 
				<input type="submit" value="Cerca Capoluogo" onclick="cercaCapoluogo()" />
			</p>
		</form>
	</div>

	<p>
		Capoluogo: <strong><span id="datiCapoluogo"></span></strong>
	</p>
	
</body>
</html>