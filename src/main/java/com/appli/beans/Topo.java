package com.appli.beans;

public class Topo extends Infopost{
	
	public int num;
	public boolean pret;
	public String emprunteur;
	public String site;

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getEmprunteur() {
		return emprunteur;
	}

	public void setEmprunteur(String emprunteur) {
		this.emprunteur = emprunteur;
	}

	public boolean isPret() {
		return pret;
	}

	public void setPret(boolean pret) {
		this.pret = pret;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	

}
