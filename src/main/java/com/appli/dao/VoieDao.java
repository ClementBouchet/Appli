package com.appli.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.appli.beans.Secteur;
import com.appli.beans.Voie;

public interface VoieDao {
	
	public List<Voie> rechercheVoie(HttpServletRequest request);
	
	public Voie afficherVoie(int id);
	
	public void supprimerVoie(int id);
	
	public List<Voie> recupererVoie();
	
	public void ajouterVoie(Voie voie);
	
	public void modifierVoie(int id, Voie voie);
	
	public List<Secteur> recupererSecteur();

}
