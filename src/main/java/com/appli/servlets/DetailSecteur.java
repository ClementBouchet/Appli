package com.appli.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appli.beans.Secteur;
import com.appli.dao.ComDao;
import com.appli.dao.DaoFactory;
import com.appli.dao.SecteurDao;


public class DetailSecteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SecteurDao secteurDao;
    private ComDao comDao;
    
    public void init() throws ServletException{
    	DaoFactory daoFactory = DaoFactory.getInstance();
    	this.secteurDao = daoFactory.getSecteurDao();
    	this.comDao = daoFactory.getComDao();
    }
    
    public DetailSecteur() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ide = request.getParameter("secteur");
		int iden = Integer.parseInt(ide);
		Secteur secteur = new Secteur();
		secteur = secteurDao.afficherSecteur(iden);
		request.setAttribute("iden",iden);
		request.setAttribute("secteur",secteur);
		request.setAttribute("coms", comDao.afficherCom(secteur.getNom(), "secteur"));
		this.getServletContext().getRequestDispatcher("/detailSecteur.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
