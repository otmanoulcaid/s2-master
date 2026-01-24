package org.mql.java.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.mql.java.web.actions.EmailAction;


public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmailAction emailAction;
	
	private String prefix;
	private String suffix;
	public void init() throws ServletException {
		emailAction=new EmailAction();
		prefix=getServletConfig().getInitParameter("prefix");
		suffix=getServletConfig().getInitParameter("suffix");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String uri = request.getRequestURI();
			String view = "error";
			Model model = new Model(); 

			if (uri.endsWith("/emails-list")) {				
				model.add("message", "liste des emails");
				view = emailAction.emailsList(model);
			} else {
				
				model.add("message", "Service est non disponible");
				request.setAttribute("error", new Error(101, "Service non disponible ", uri));
			}
			request.setAttribute("model", model);
			System.out.println(model);
		
request.getRequestDispatcher(prefix + view + suffix).forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
