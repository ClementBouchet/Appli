package com.appli.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.appli.dao.ComDao;
import com.appli.dao.DaoFactory;
import com.appli.beans.Commentaire;
import com.appli.beans.Utilisateur;

public class AddCom extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ComDao comDao;
    
    public void init() throws ServletException{
    	DaoFactory daoFactory = DaoFactory.getInstance();
    	this.comDao = daoFactory.getComDao();
    }
    
    public AddCom() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession session = request.getSession();
		
		Commentaire com = new Commentaire();
		Utilisateur utilisateur = new Utilisateur();
		utilisateur = (Utilisateur)session.getAttribute("utilisateur");
		if (utilisateur != null) {
			com.setAuteur(utilisateur.getIdentifiant());
		
		
			com.setDescription(request.getParameter("description"));
			com.setTypeObjet(request.getParameter("type_objet"));
			com.setNomObjet(request.getParameter("nom_objet"));
			request.setAttribute("com", com);
		
			comDao.ajouterCom(com);
		
			if (request.getParameter("type_objet").equals("site")) {
				response.sendRedirect(request.getContextPath() + "/detailSite?site=" + request.getParameter("id_objet"));
			}
			else if (request.getParameter("type_objet").equals("secteur")) {
				response.sendRedirect(request.getContextPath() + "/detailSecteur?secteur=" + request.getParameter("id_objet"));
			}
			else if (request.getParameter("type_objet").equals("voie")) {
				response.sendRedirect(request.getContextPath() + "/detailVoie?voie=" + request.getParameter("id_objet"));
			}
		
		}
		else {
			this.getServletContext().getRequestDispatcher("/acces_public.jsp").forward(request, response);
		}
	}

}
