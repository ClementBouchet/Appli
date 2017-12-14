package com.appli.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.appli.beans.Recherche;
import com.appli.beans.Secteur;
import com.appli.beans.Site;

public interface SiteDao {
	
	
	public Recherche rechercheSite(HttpServletRequest request); 
	
 	public Site afficherSite(int id);	
 	
 	public void modifierSite(int id, Site site);
	
 	public void supprimerSite(int id);
	
	public List<Site> recupererSite();
	
	public void ajouterSite(Site site);

	public List<Secteur> recupererSecteur(int ide);
	
}