<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,com.objis.demomaven.Formation "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Démo JPA dans application web Servlet/JSP</title>
</head>
<body>
	<form method="POST" action="FormationServlet">
		Thème Formation: <input type="text" name="themeFormation" /> <input
			type="submit" value="Ajouter" />
	</form>

	<hr>
	<ol>
		<%
			@SuppressWarnings("unchecked")
			List<Formation> formations = (List<Formation>) request.getAttribute("listeDesFormations");
			if (formations != null) {
                for (Formation formation : formations) {
            %>
                <li><%=formation.getTheme()%></li>
            <%
                    }
                }
            %>

	</ol>
	<hr>
</body>
</html>