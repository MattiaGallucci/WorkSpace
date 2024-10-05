<%@ page language="java" import="java.util.Date, java.text.SimpleDateFormat" 
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>JSP Declarations</title>
</head>
<body>

<%! String name = "Paolo Rossi";
	double[] prices = {1.5, 76.8, 21.5};
	
	double getTotal() {
		double total = 0.0;
		for(int i=0; i <prices.length; i++)
			total += prices[i];
		return total;
	}
	
	String formattedDate(Date today) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH.mm.ss");
	    return formatter.format(today);		
	}
%>

<h3>JSP Declarations</h3>
<p>Sig. <%=name %>, </p>
<p>l'ammontare del suo acquisto &egrave;: <%=getTotal() %> euro.</p>
<p>La data di oggi &egrave;: <%=formattedDate(new Date()) %></p>
</body>
</html>

