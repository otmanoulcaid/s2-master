package org.mql.biblio.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.runtime.ObjectMethods;
import java.util.List;

import org.mql.biblio.models.Author;
import org.mql.biblio.web.actions.AuthorAction;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//	@WebServlet({ "/Controller", "/biblio/*", "*.do" }) // url patterns ( configuration par annotation )
//	main servlet that acts as front controller 
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ObjectMapper mapper; //jackson
	private AuthorAction authorAction;
	
//	si on veut figer les prefix et suffix 
//	private String prefix = "/views/"; 
//	private String suffix = ".jsp";
	private String prefix;
	private String suffix;


//	préferable de travailler dans la methode init au lieu de constructeur
//	because init is called after servlet is fully configured , while constructor is called before configuration of servlet which is bad
	public void init() throws ServletException {
		authorAction = new AuthorAction();
		prefix = getServletConfig().getInitParameter("prefix");
		suffix = getServletConfig().getInitParameter("suffix");
		System.out.println("prefix =" + prefix);
		System.out.println("suffix =" + suffix);

		mapper = new ObjectMapper();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//	techniquement on peut tout faire en une servlet , acceder bd... etc mais il faut pas bien sur
//	ce quil faut faire cest tout simplement accees a ..

//	ici on est en train de faire la mauvaise facon , car les vues sert à ca
//	et ici on est censé de seulement envoyer à la vue le modèle de données
//	PrintWriter out = response.getWriter();
//	out.println("<h1>Servlet Response : " + request.getRequestURI() + "</h1>");

		// we extract the request uri
		String uri = request.getRequestURI();
		if (uri.contains("/api/")) {
			configCorsPolicy(response);
			PrintWriter out = response.getWriter();
			if (uri.endsWith("/authors")) {
				List<Author> authors = authorAction.authorsList();
				String json = mapper.writeValueAsString(authors);
				out.println(json);
			}

		}
		else {
//			déterminer quelle methode daction à executer sur quel objet daction
//			par defaut une vue d'erreur
			String view = "error";
			Model model = new Model(); // model to pass data to the view

			// routing the request based on that uri
			if (uri.endsWith("/authors-list")) {
				view = authorAction.authorsList(model);
			} else {
				// unknown routes to show error page
				model.add("message", "Service est non disponible");
				request.setAttribute("error", new Error(101, "Service non disponible ", uri));
			}
			request.setAttribute("model", model);
			// forwarding to the appropriate jsp view
			request.getRequestDispatcher(prefix + view + suffix).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void configCorsPolicy(HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*"); 
		response.addHeader("Access-Control-Allow-Methods", "*"); 
		response.addHeader("Access-Control-Allow-Headers", "*"); 
	}

}
