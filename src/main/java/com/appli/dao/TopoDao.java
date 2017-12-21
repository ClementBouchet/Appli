package com.appli.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.appli.beans.Topo;

public interface TopoDao {
	
	public Topo afficherTopo(Topo top);
	
	public List<Topo> recupererTopo();
	
	public List<Topo> recupererTopoUser(String user);
	
	public void ajouterTopo(Topo topo);
	
	public void supprimerTopo(int id);
	
	public List<Topo> rechercheTopo(HttpServletRequest request);
	
	public void preterTopo(Topo topo, String reponse);

}
