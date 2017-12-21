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
import com.appli.beans.Demande;
import com.appli.beans.Topo;
import com.appli.beans.Utilisateur;


public class Espace_user extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TopoDao topoDao; 
    private DemandeDao demandeDao;
    
    public void init() throws ServletException{
    	DaoFactory daoFactory = DaoFactory.getInstance();
    	this.topoDao = daoFactory.getTopoDao();
    	this.demandeDao = daoFactory.getDemandeDao();
    }

    public Espace_user() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Utilisateur utilisateur = new Utilisateur();
		utilisateur = (Utilisateur)session.getAttribute("utilisateur");			
		request.setAttribute("utilisateur",utilisateur);
		request.setAttribute("topos", topoDao.recupererTopoUser(utilisateur.getIdentifiant()));
		
		request.setAttribute("demandesInt", demandeDao.afficherDemandeInt(utilisateur));
		request.setAttribute("demandesEx", demandeDao.afficherDemandeEx(utilisateur));
		
		
		this.getServletContext().getRequestDispatcher("/espace_user.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Utilisateur utilisateur = new Utilisateur();
		utilisateur = (Utilisateur)session.getAttribute("utilisateur");			
		request.setAttribute("utilisateur",utilisateur);
		String iddemande = request.getParameter("iddemande");
		String idtopo = request.getParameter("idtopo");
		String dispo = request.getParameter("dispo");
		if (iddemande != null) {
			int id = Integer.parseInt(iddemande);
			Demande demande = new Demande();
			demande.setId(id);
			demande.setTopo(request.getParameter("top"));
			demandeDao.repondreDemande(demande, request.getParameter("reponse"));
			if (request.getParameter("reponse").equals("oui")) {
				Topo topo = new Topo();
				topo.setNom(request.getParameter("top"));
				topoDao.preterTopo(topo, request.getParameter("reponse"));
			}
		}
		if(idtopo != null) {
			Topo topo = new Topo();
			topo.setNum(Integer.parseInt(idtopo));
			topoDao.preterTopo(topo, dispo);
		}
		request.setAttribute("topos", topoDao.recupererTopoUser(utilisateur.getIdentifiant()));
		
		request.setAttribute("demandesInt", demandeDao.afficherDemandeInt(utilisateur));
		request.setAttribute("demandesEx", demandeDao.afficherDemandeEx(utilisateur));
		
		
		this.getServletContext().getRequestDispatcher("/espace_user.jsp").forward(request, response);
	}

}
