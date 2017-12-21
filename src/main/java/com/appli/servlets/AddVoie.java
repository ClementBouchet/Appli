package com.appli.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appli.dao.DaoFactory;
import com.appli.dao.SecteurDao;
import com.appli.dao.VoieDao;
import com.appli.beans.Voie;

public class AddVoie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SecteurDao secteurDao;
	private VoieDao voieDao;
	
	public void init() throws ServletException {
    	DaoFactory daoFactory = DaoFactory.getInstance();
    	this.secteurDao = daoFactory.getSecteurDao();
    	this.voieDao = daoFactory.getVoieDao();
    }

    public AddVoie() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("voies",voieDao.recupererVoie());
		request.setAttribute("secteurs",secteurDao.recupererSecteur());
		this.getServletContext().getRequestDispatcher("/addvoie.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Voie voie = new Voie();
		voie.setNom(request.getParameter("nom"));
		voie.setSecteur(request.getParameter("secteur"));
		voie.setLongueur(Long.parseLong(request.getParameter("longueur")));
		voie.setCotation(request.getParameter("cotation"));
		
		voieDao.ajouterVoie(voie);		
		request.setAttribute("voies",voieDao.recupererVoie());
		request.setAttribute("message", "Voie ajoutée!");
		request.setAttribute("secteurs",secteurDao.recupererSecteur());
		
		this.getServletContext().getRequestDispatcher("/addvoie.jsp").forward(request, response);
	}

}
