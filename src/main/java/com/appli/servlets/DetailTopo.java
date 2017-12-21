package com.appli.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.appli.dao.DaoFactory;
import com.appli.dao.DemandeDao;
import com.appli.dao.TopoDao;
import com.appli.beans.Topo;
import com.appli.beans.Utilisateur;


public class DetailTopo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TopoDao topoDao;
    private DemandeDao demandeDao;
    
    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.topoDao = daoFactory.getTopoDao();
        this.demandeDao = daoFactory.getDemandeDao();
    }

    public DetailTopo() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Topo topo = new Topo();
		topo.setNum(Integer.parseInt(request.getParameter("topo")));
		topo = topoDao.afficherTopo(topo);
		request.setAttribute("topo", topo);
		
		this.getServletContext().getRequestDispatcher("/detailTopo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Topo topo = new Topo();
		int id = Integer.parseInt(request.getParameter("id"));
		topo.setNum(id);
		topo = topoDao.afficherTopo(topo);
		request.setAttribute("topo", topo);
		request.setAttribute("id", id);
		request.setAttribute("confirmation", "yes");
		Utilisateur user = new Utilisateur();
		HttpSession session = request.getSession();
		user = (Utilisateur) session.getAttribute("utilisateur");
		demandeDao.ajouterDemande(user, topo);
		this.getServletContext().getRequestDispatcher("/detailTopo.jsp").forward(request, response);
	}

}
