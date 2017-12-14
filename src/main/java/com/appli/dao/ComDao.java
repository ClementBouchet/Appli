package com.appli.dao;

import java.util.List;

import com.appli.beans.Commentaire;

public interface ComDao {
	
	public void ajouterCom(Commentaire commentaire);
	
	public List<Commentaire> afficherCom(String nomSite, String typeObjet);

}
