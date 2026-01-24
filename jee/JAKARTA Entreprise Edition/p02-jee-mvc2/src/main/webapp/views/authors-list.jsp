<%@page import="org.mql.biblio.models.Author"%>
<%@page import="java.util.List"%>
<%@page import="org.mql.biblio.web.Model"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/styles.css" />
</head>
<body>
	<!-- Scriptlet used to execute java inside jsp -->
	<%
	Model model = (Model) request.getAttribute("model");
	List<Author> authors = (List<Author>) model.get("authors");
	String message = (String) model.get("message");
	%>
	<h1>
		<!-- tag d'expression used to output dynamic content like variables -->
		<%=message%>
	</h1>
	<table class="data-table">
		<tr>
			<th>id</th>
			<th>nom</th>
			<th>année</th>
		</tr>
		<%
		for (Author a : authors) {
		%>
		<tr>
			<td><%=a.getId()%></td>
			<td><%=a.getName()%></td>
			<td><%=a.getYearBorn() %></td>
		</tr>
		<%
		}
		%>
		<!-- tag de déclaration -->
		<%!void p1() {
		}%>
	</table>
</body>
</html>