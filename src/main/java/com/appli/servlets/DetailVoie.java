package com.appli.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appli.dao.ComDao;
import com.appli.dao.DaoFactory;
import com.appli.dao.VoieDao;
import com.appli.beans.Voie;

public class DetailVoie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VoieDao voieDao;
	private ComDao comDao;
	
	public void init() throws ServletException {
    	DaoFactory daoFactory = DaoFactory.getInstance();
    	this.comDao = daoFactory.getComDao();
    	this.voieDao = daoFactory.getVoieDao();
    }
       
    public DetailVoie() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ide = request.getParameter("voie");
		int iden = Integer.parseInt(ide);
		Voie voie = new Voie();
		voie = voieDao.afficherVoie(iden);
		request.setAttribute("iden",iden);
		request.setAttribute("voie",voie);
		request.setAttribute("nom", voie.getNom());
		request.setAttribute("coms", comDao.afficherCom(voie.getNom(), "voie"));
		this.getServletContext().getRequestDispatcher("/detailVoie.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ide = request.getParameter("id");
		int iden = Integer.parseInt(ide);
		Voie voie = new Voie();
		if (request.getParameter("id") != null) {
			voie.setNom(request.getParameter("nom"));
			voie.setSecteur(request.getParameter("secteur"));
			voie.setLongueur(Long.parseLong(request.getParameter("longueur")));
			voie.setCotation(request.getParameter("cotation"));
			voieDao.modifierVoie(iden, voie);
		}
		voie = voieDao.afficherVoie(iden);
		request.setAttribute("iden",iden);
		request.setAttribute("voie",voie);
		request.setAttribute("nom", voie.getNom());
		request.setAttribute("coms", comDao.afficherCom(voie.getNom(), "voie"));
		this.getServletContext().getRequestDispatcher("/detailVoie.jsp").forward(request, response);
	}

}
