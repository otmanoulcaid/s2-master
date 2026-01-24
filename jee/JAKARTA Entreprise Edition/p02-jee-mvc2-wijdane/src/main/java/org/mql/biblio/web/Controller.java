package org.mql.biblio.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.mql.biblio.models.Author;
import org.mql.biblio.web.actions.AuthorAction;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class Controller
 */
//@WebServlet({ "/Controller", "/biblio/*", "*.do" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AuthorAction authorAction;

//	private String prefix = "/views/"; // views folder (dans le webapp folder)
//	private String suffix = ".jsp";
	private String prefix;
	private String suffix;
	private ObjectMapper mapper;

	public void init() throws ServletException {
		authorAction = new AuthorAction();

		prefix = getServletConfig().getInitParameter("prefix");
		suffix = getServletConfig().getInitParameter("suffix");
		System.out.println("prefix = " + prefix);
		System.out.println("suffix = " + suffix);

		mapper = new ObjectMapper();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Une servlet peut envoyer des objects de type ObjectOuputStream
		// getWriter recoit un flux textuel
//		PrintWriter out = response.getWriter();
//		out.println("<h1>Servlet Response" + request.getRequestURI() + "<h1>");
		String uri = request.getRequestURI();

		if (uri.contains("/api/")) {
			configCorsPolicy(response);
			PrintWriter out = response.getWriter();
			if (uri.endsWith("/authors")) {
				List<Author> authors = authorAction.authorList();
				String json = mapper.writeValueAsString(authors);
				// une methode qui supporte les donnees de n'importe
				// type // object to json
				out.println(json);
			}
		}
		else {
			String view = "error";
			Model model = new Model();
			// on raisonne seleon uri (raisonnemnt vue
			// on associe a une uri une action
			if (uri.endsWith("/authors-list")) {
				view = authorAction.authorsList(model);
			}
			else {

				model.add("message", "Service non disponible");
				request.setAttribute("error", new Error(101, "Service non disponible", uri));
			}
			request.setAttribute("model", model);

			request.getRequestDispatcher(prefix + view + suffix).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void configCorsPolicy(HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");// j.accepte de tous les entetes de tout monde
		response.addHeader("Access-Control-Allow-Methods", "*");
		response.addHeader("Access-Control-Allow-Headers", "*");
	}
}
