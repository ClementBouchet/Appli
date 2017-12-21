package com.appli.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.appli.dao.SiteDao;
import com.appli.dao.TopoDao;
import com.appli.beans.Topo;
import com.appli.beans.Utilisateur;
import com.appli.dao.DaoFactory;

public class AddTopo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SiteDao siteDao;   
	private TopoDao topoDao; 
	
	
    public AddTopo() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.siteDao = daoFactory.getSiteDao();
        this.topoDao = daoFactory.getTopoDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("topos", topoDao.recupererTopo());
		request.setAttribute("sites", siteDao.recupererSite());
		
		this.getServletContext().getRequestDispatcher("/addtopo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Topo topo = new Topo();
		
		HttpSession session = request.getSession();
		Utilisateur utilisateur = new Utilisateur();
		utilisateur = ((Utilisateur)session.getAttribute("utilisateur"));
		String auteur = utilisateur.getIdentifiant();
		
		
		topo.setNom(request.getParameter("nom"));
		topo.setAuteur(auteur);
		topo.setDescription(request.getParameter("description"));
		topo.setSite(request.getParameter("site"));
		topoDao.ajouterTopo(topo);
		request.setAttribute("topo", topo);
		request.setAttribute("message", "Topo ajouté!");
		request.setAttribute("topos", topoDao.recupererTopo());
		request.setAttribute("sites", siteDao.recupererSite());
		this.getServletContext().getRequestDispatcher("/addtopo.jsp").forward(request, response);
	}

}
