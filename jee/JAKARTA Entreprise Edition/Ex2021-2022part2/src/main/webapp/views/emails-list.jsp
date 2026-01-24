<%@page import="org.mql.java.models.Email"%>
<%@page import="java.util.List"%>
<%@page import="org.mql.java.web.Model"%>
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
	<%
		Model model = (Model) request.getAttribute("model");
		List<Email> emails = (List<Email>) model.get("emails");
		String message = (String) model.get("message");
	%>
	
		<h1>
		<!-- tag d'expression used to output dynamic content like variables -->
		<%=message%>
		</h1>
		<table class="data-table">
		<tr>
			<th>from</th>
			<th>to</th>
			<th>object</th>
			<th>content</th>
			<th>time</th>
			<th>date</th>
		</tr>
		<%
		for (Email e : emails) {
		%>
		<tr>
			<td><%=e.getFrom()%></td>
			<td><%=e.getTo()%></td>
			<td><%=e.getObject()%></td>
			<td><%=e.getContent()%></td>
			<td><%=e.getTime()%></td>
			<td><%=e.getDate()%></td>
			
			
			
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>