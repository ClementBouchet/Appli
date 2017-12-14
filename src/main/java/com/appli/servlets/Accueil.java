package com.appli.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Accueil() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String utilisateur = request.getParameter("utilisateur");
		request.setAttribute("message", "EL Evaluated");
		request.setAttribute("utilisateur", utilisateur);
		HttpSession session = request.getSession();
		session.getAttribute("utilisateur");
		this.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
