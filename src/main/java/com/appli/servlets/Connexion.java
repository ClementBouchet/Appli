package com.appli.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.appli.dao.DaoFactory;
import com.appli.dao.UtilisateurDao;
import com.appli.beans.Utilisateur;
import com.appli.beans.Validation;

public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UtilisateurDao utilisateurDao;
    
    public void init() throws ServletException{
    	DaoFactory daoFactory = DaoFactory.getInstance();
    	this.utilisateurDao = daoFactory.getUtilisateurDao();
    }
    public Connexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/connexion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setIdentifiant(request.getParameter("identifiant"));
		utilisateur.setPassword(request.getParameter("password"));
		
		Validation validation = new Validation();
		validation = utilisateurDao.verifyConnexion(utilisateur);
		request.setAttribute("validation", validation);
		request.setAttribute("utilisateur", utilisateur);
		
		HttpSession session = request.getSession();
		
		if (validation.getIdent() == "ok" && validation.getPass() == "ok") {
			session.setAttribute("utilisateur", utilisateur);
		}
		else {
			session.setAttribute("utilisateur", null);
		}
		
		this.getServletContext().getRequestDispatcher("/connexion.jsp").forward(request, response);;
	}

}
