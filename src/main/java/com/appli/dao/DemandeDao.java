package com.appli.dao;

import java.util.List;

import com.appli.beans.Demande;
import com.appli.beans.Topo;
import com.appli.beans.Utilisateur;

public interface DemandeDao {
	
	public void ajouterDemande(Utilisateur user, Topo topo);
	public List<Demande> afficherDemandeInt(Utilisateur user);
	public List<Demande> afficherDemandeEx(Utilisateur user);
	public void repondreDemande(Demande demande, String reponse);

}
