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
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
	<!-- Scriptlet =>comme si on est dans la methode do get , et on acces a un objet d'etats == utilise dans le cas ou on besoin de code java -->
	<%
	//import espace pour importer Model
	//Tag de scriptlet Permet d’exécuter du code Java dans la JSP (ex. boucles, conditions).

		Model model=(Model)request.getAttribute("model");
		List<Author> authors= (List<Author>)model.get("authors");
		String message = (String)model.get("message");
	
	%>
	<h1><%= message %></h1><!-- Tag d'expression -->
	<table>
		<tr><th>Id</th><th>nom</th><th>Annee</th>
	<%
		for(Author a : authors){
			
	%>
	<!-- une expression => recoit evalue et affihe -->
		<tr>
			<td><%= a.getId() %></td>
			<td><%= a.getName() %></td>
			<td><%= a.getYearBorn() %></td>
			
		</tr>
	<%
		}
	%>
	<!--tag de declaration , tout ce qui est defini dans la tag de declation est definit comme vecteur ou propriete de la classe -->
	<%! 
		void p1(){}  
	%> 
	</table>
</body>
</html>