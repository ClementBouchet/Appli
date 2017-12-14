package com.appli.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.appli.beans.Recherche;
import com.appli.beans.Secteur;

public interface SecteurDao {
	
	
	public Recherche rechercheSecteur(HttpServletRequest request);
	
	public Secteur afficherSecteur(int id);
	
	public void supprimerSecteur(int id);
	
	public List<Secteur> recupererSecteur();
	
	public void ajouterSecteur(Secteur secteur);
	
	public void modifierSecteur(int id, Secteur secteur);
	
	
}
