package com.appli.beans;

public class Site extends Infopost{

	protected String lieu;
	private int nbrVoies;
	private int nbrSecteurs;
	protected String rocher;
	private Voie voie;
	private String acces;
	protected String region;
	private String secteur;
	private int num;


	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getSecteur() {
		return secteur;
	}
	public void setSecteur(String secteur) {
		this.secteur = secteur;
	}
	public int getNbrSecteurs() {
		return nbrSecteurs;
	}
	public void setNbrSecteurs(int nbrSecteurs) {
		this.nbrSecteurs = nbrSecteurs;
	}
	public String getAcces() {
		return acces;
	}
	public void setAcces(String acces) {
		this.acces = acces;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public int getNbrVoies() {
		return nbrVoies;
	}
	public void setNbrVoies(int nbrVoies) {
		this.nbrVoies = nbrVoies;
	}
	public String getRocher() {
		return rocher;
	}
	public void setRocher(String rocher) {
		this.rocher = rocher;
	}
	public Voie getVoie() {
		return voie;
	}
	public void setVoie(Voie voie) {
		this.voie = voie;
	}
}
