package com.appli.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appli.dao.UtilisateurDao;
import com.appli.beans.Utilisateur;
import com.appli.dao.DaoFactory;

public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UtilisateurDao utilisateurDao;
	
    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.utilisateurDao = daoFactory.getUtilisateurDao();
    }
    
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		this.getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur utilisateur = new Utilisateur();
		
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		utilisateur.setIdentifiant(request.getParameter("identifiant"));
		utilisateur.setPassword(password);		
		request.setAttribute("utilisateur", utilisateur);
		request.setAttribute("password", password);
		request.setAttribute("password2", password2);
		
		if (utilisateurDao.recupererUtilisateurs(utilisateur).equals("not ok")) {
			utilisateur.setErreur("Cet identifiant est déjà pris, veuillez en choisir un autre svp");
		}
		else if ( !password.equals(password2)) {
			utilisateur.setErreur("Desole "+utilisateur.getIdentifiant()+", la confirmation de votre mot de passe est incorrecte");
		}
		else{
			utilisateurDao.ajouterUtilisateur(utilisateur);
		}
		
		this.getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);
	}

}
