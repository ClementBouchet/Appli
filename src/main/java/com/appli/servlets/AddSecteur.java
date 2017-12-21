package com.appli.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appli.dao.DaoFactory;
import com.appli.dao.SecteurDao;
import com.appli.dao.SiteDao;
import com.appli.beans.Secteur;

public class AddSecteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SecteurDao secteurDao;
    private SiteDao siteDao;
    
    public void init() throws ServletException {
    	DaoFactory daoFactory = DaoFactory.getInstance();
    	this.secteurDao = daoFactory.getSecteurDao();
    	this.siteDao = daoFactory.getSiteDao();
    }
 
    public AddSecteur() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("secteurs",secteurDao.recupererSecteur());
		request.setAttribute("sites",siteDao.recupererSite());
		this.getServletContext().getRequestDispatcher("/addsecteur.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Secteur secteur = new Secteur();
		secteur.setNom(request.getParameter("nom"));
		secteur.setRocher(request.getParameter("rocher"));
		secteur.setSite(request.getParameter("site"));
		secteurDao.ajouterSecteur(secteur);		
		request.setAttribute("secteurs",secteurDao.recupererSecteur());
		request.setAttribute("message", "Secteur ajouté!");
		request.setAttribute("sites",siteDao.recupererSite());
		
		this.getServletContext().getRequestDispatcher("/addsecteur.jsp").forward(request, response);
	}

}
