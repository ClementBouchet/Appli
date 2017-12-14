package com.appli.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appli.dao.DaoFactory;
import com.appli.dao.SecteurDao;
import com.appli.dao.SiteDao;

public class RechercheResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SiteDao siteDao;
    private SecteurDao secteurDao;
    
    public void init() throws ServletException{
    	DaoFactory daoFactory = DaoFactory.getInstance();
    	this.siteDao = daoFactory.getSiteDao();
    	this.secteurDao = daoFactory.getSecteurDao();
    }
    
    public RechercheResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("recherche");
		String pageSi = request.getParameter("pageSi");
		String critere1 = request.getParameter("critere1");
		request.setAttribute("mot", search);
		request.setAttribute("pageSi", pageSi);
		request.setAttribute("pageSe", request.getParameter("pageSe"));
		request.setAttribute("mot2", critere1);
		request.setAttribute("rechercheSe",secteurDao.rechercheSecteur(request));
		request.setAttribute("rechercheSi",siteDao.rechercheSite(request));		
		this.getServletContext().getRequestDispatcher("/rechercheResult.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("recherche");
		String critere1 = request.getParameter("critere1");;
		request.setAttribute("rechercheSe",secteurDao.rechercheSecteur(request));
		request.setAttribute("rechercheSi",siteDao.rechercheSite(request));
		request.setAttribute("mot", search);
		request.setAttribute("mot2", critere1);
		this.getServletContext().getRequestDispatcher("/rechercheResult.jsp").forward(request, response);
	}

}
