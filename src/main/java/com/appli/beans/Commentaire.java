package com.appli.beans;

public class Commentaire extends Infopost{

	String typeObjet;  //Com de site ou secteur, ou etc
	String nomObjet;   //Nom de l'objet
	int idObjet;
	
	public String getTypeObjet() {
		return typeObjet;
	}
	public void setTypeObjet(String typeObjet) {
		this.typeObjet = typeObjet;
	}
	public String getNomObjet() {
		return nomObjet;
	}
	public void setNomObjet(String nomObjet) {
		this.nomObjet = nomObjet;
	}
	public int getIdObjet() {
		return idObjet;
	}
	public void setIdObjet(int idObjet) {
		this.idObjet = idObjet;
	}
	
}
