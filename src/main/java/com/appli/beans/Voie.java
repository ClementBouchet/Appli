package com.appli.beans;

public class Voie extends Secteur{

	private String cotation;
	private long longueur;
	private String secteur;
	private int nbrAncrage;
	private String ancrage;
	
	
	public int getNbrAncrage() {
		return nbrAncrage;
	}
	public void setNbrAncrage(int nbrAncrage) {
		this.nbrAncrage = nbrAncrage;
	}
	public String getAncrage() {
		return ancrage;
	}
	public void setAncrage(String ancrage) {
		this.ancrage = ancrage;
	}
	public String getCotation() {
		return cotation;
	}
	public void setCotation(String cotation) {
		this.cotation = cotation;
	}
	public long getLongueur() {
		return longueur;
	}
	public void setLongueur(long longueur) {
		this.longueur = longueur;
	}
	public String getSecteur() {
		return secteur;
	}
	public void setSecteur(String secteur) {
		this.secteur = secteur;
	}

	
	
}
