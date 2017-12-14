package com.appli.dao;

import java.util.List;

import com.appli.beans.Utilisateur;
import com.appli.beans.Validation;

public interface UtilisateurDao {

	public List<Utilisateur> recupererUtilisateurs();
	
	public void ajouterUtilisateur(Utilisateur utilisateur);
	
	public Validation verifyConnexion(Utilisateur utilisateur);
}
