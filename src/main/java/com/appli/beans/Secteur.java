package com.appli.beans;

public class Secteur extends Site{
	
	private Voie voie;
	private int nbrVoies;
	protected String site;
	
	
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public Voie getVoie() {
		return voie;
	}
	public void setVoie(Voie voie) {
		this.voie = voie;
	}
	public int getNbrVoies() {
		return nbrVoies;
	}
	public void setNbrVoies(int nbrVoies) {
		this.nbrVoies = nbrVoies;
	}
	
	

}
