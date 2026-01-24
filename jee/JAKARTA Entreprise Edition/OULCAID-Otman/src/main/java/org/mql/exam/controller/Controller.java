package org.mql.exam.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.mql.exam.actions.StudentAction;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class Controller
 */
@WebServlet({ "/Controller", "/student/*", "*.do" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StudentAction studentAction;
	private ObjectMapper mapper;

	public void init()
	{
		studentAction = new StudentAction();
		mapper = new ObjectMapper();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println(mapper.writeValueAsString(studentAction.getStudents()));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
