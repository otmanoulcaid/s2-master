<%@page import="org.mql.spring.models.Author"%>
<%@page import="java.util.List"%>
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
		List<Author> authors = (List<Author>) request.getAttribute("authors");
	%>

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
	</table>
</body>
</html>