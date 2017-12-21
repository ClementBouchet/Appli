package com.appli.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appli.dao.DaoFactory;
import com.appli.dao.SiteDao;
import com.appli.dao.ComDao;
import com.appli.beans.Site;

public class DetailSite extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SiteDao siteDao;
    private ComDao comDao;
    
    public void init() throws ServletException{
    	DaoFactory daoFactory = DaoFactory.getInstance();
    	this.siteDao = daoFactory.getSiteDao();
    	this.comDao = daoFactory.getComDao();
    }
	
    public DetailSite() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ide = request.getParameter("site");
		int iden = Integer.parseInt(ide);
		Site site = new Site();
		site = siteDao.afficherSite(iden);
		request.setAttribute("secteurs",siteDao.recupererSecteur(iden));
		request.setAttribute("iden",iden);
		request.setAttribute("site",site);
		request.setAttribute("coms", comDao.afficherCom(site.getNom(), "site"));
		this.getServletContext().getRequestDispatcher("/detailSite.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int iden = Integer.parseInt(id);
		Site site = new Site();
		if (request.getParameter("id") != null) {
			site.setNom(request.getParameter("nom"));
			site.setLieu(request.getParameter("lieu"));
			site.setDescription(request.getParameter("description"));
			siteDao.modifierSite(iden, site);
		}
		site = siteDao.afficherSite(iden);
		request.setAttribute("secteurs",siteDao.recupererSecteur(iden));
		request.setAttribute("iden",iden);
		request.setAttribute("site",site);
		request.setAttribute("coms", comDao.afficherCom(site.getNom(), "site"));
		this.getServletContext().getRequestDispatcher("/detailSite.jsp").forward(request, response);
	}

}
