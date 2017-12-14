package com.appli.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appli.dao.DaoFactory;
import com.appli.dao.SiteDao;
import com.appli.beans.Site;

public class AddSite extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SiteDao siteDao;
    
    
    public void init() throws ServletException {
    	DaoFactory daoFactory = DaoFactory.getInstance();
    	this.siteDao = daoFactory.getSiteDao();
    }
    public AddSite() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("sites",siteDao.recupererSite());
		this.getServletContext().getRequestDispatcher("/addsite.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Site site = new Site();
		site.setNom(request.getParameter("nom"));
		site.setLieu(request.getParameter("lieu"));
		site.setDescription(request.getParameter("description"));

		siteDao.ajouterSite(site);
		request.setAttribute("sites",siteDao.recupererSite());
		
		this.getServletContext().getRequestDispatcher("/addsite.jsp").forward(request, response);
	}

}
