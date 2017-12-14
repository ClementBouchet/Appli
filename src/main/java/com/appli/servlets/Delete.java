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

public class Delete extends HttpServlet {
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
       
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ide = request.getParameter("site");
		String id = request.getParameter("secteur");
		String ID = request.getParameter("voie");
		if (ide != null) {
		int iden = Integer.parseInt(ide);
		siteDao.supprimerSite(iden);}
		else if(id != null){
			int iden = Integer.parseInt(id);
			secteurDao.supprimerSecteur(iden);
		}
		else if(ID != null){
			int iden = Integer.parseInt(ID);
			voieDao.supprimerVoie(iden);
		}
		this.getServletContext().getRequestDispatcher("/delete.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
