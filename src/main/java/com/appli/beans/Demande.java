package com.appli.beans;

public class Demande extends Infopost{

	public String topo;
	public int id;
	public String destinataire;
	public String reponse;

	
	public String getReponse() {
		return reponse;
	}
	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	public String getTopo() {
		return topo;
	}
	public void setTopo(String topo) {
		this.topo = topo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDestinataire() {
		return destinataire;
	}
	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}
	
}
