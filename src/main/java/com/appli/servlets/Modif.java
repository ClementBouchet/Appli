package com.appli.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appli.dao.DaoFactory;
import com.appli.dao.SecteurDao;
import com.appli.dao.SiteDao;
import com.appli.dao.VoieDao;
import com.appli.beans.Voie;
import com.appli.beans.Secteur;
import com.appli.beans.Site;

public class Modif extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SiteDao siteDao;
	private SecteurDao secteurDao;
	private VoieDao voieDao;
	
	public void init() throws ServletException {
    	DaoFactory daoFactory = DaoFactory.getInstance();
    	this.siteDao = daoFactory.getSiteDao();
    	this.secteurDao = daoFactory.getSecteurDao();
    	this.voieDao = daoFactory.getVoieDao();
    }
    public Modif() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ide = request.getParameter("site");
		String id = request.getParameter("secteur");
		String ID = request.getParameter("voie");
		String type = null;
		if (ide != null) {
			int iden = Integer.parseInt(ide);
			Site site = new Site();
			site = siteDao.afficherSite(iden);
			//request.setAttribute("secteurs",siteBdd.recupererSecteur(iden));
			//pour l'instant on n'ajoute pas les secteurs à partir de cette page, il faut en créer un nouveau
			request.setAttribute("iden",iden);
			request.setAttribute("site",site);
			type = "site";
			request.setAttribute("type",type);
		}	
		else if(id != null){
			int iden = Integer.parseInt(id);
			Secteur secteur = new Secteur();
			secteur = secteurDao.afficherSecteur(iden);
			request.setAttribute("sites",siteDao.recupererSite());
			request.setAttribute("iden",iden);
			request.setAttribute("secteur",secteur);
			type = "secteur";
			request.setAttribute("type",type);
		}
		else if(ID != null){
			int iden = Integer.parseInt(ID);
			Voie voie = new Voie();
			voie = voieDao.afficherVoie(iden);
			request.setAttribute("secteurs",voieDao.recupererSecteur());

			request.setAttribute("iden",iden);
			request.setAttribute("voie",voie);
			type = "voie";
			request.setAttribute("type",type);
		}
		this.getServletContext().getRequestDispatcher("/modif.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
