package com.appli.dao;

import java.util.List;

import com.appli.beans.Topo;

public interface TopoDao {
	
	public Topo afficherTopo(Topo top);
	
	public List<Topo> recupererTopo();
	
	public List<Topo> recupererTopoUser(String user);
	
	public void ajouterTopo(Topo topo);

}
