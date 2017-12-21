package com.appli.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.appli.beans.Demande;
import com.appli.beans.Topo;
import com.appli.beans.Utilisateur;

public class DemandeDaoImpl implements DemandeDao{

	DaoFactory daoFactory;
	
	private Connection connexion;
	private String comSQL;
	
	DemandeDaoImpl(DaoFactory daoFactory){
		this.daoFactory = daoFactory;
	}
	
	public void ajouterDemande(Utilisateur user, Topo topo){
		
		PreparedStatement prepStatement = null;
		Demande demande = new Demande();
		demande.setAuteur(user.getIdentifiant());
		
		comSQL = "INSERT INTO Demande (auteur, destinataire, reponse, topo)"
				+ "SELECT ?,?,?,?  ;";
		
		try {
			connexion = daoFactory.getConnection();
			prepStatement = connexion.prepareStatement(comSQL);
			prepStatement.setString(1, demande.getAuteur());
			prepStatement.setString(2, topo.getAuteur());
			prepStatement.setString(3, "aucune");
			//prepStatement.setString(4, topo.getAuteur());
			prepStatement.setString(4, topo.getNom());
			prepStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
            // Fermeture de la connexion
            try {
                if (prepStatement != null)
                    prepStatement.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException ignore) {
            }
        }
		
		
	}

	public List<Demande> afficherDemandeInt(Utilisateur user) {
		List<Demande> demandes= new ArrayList<Demande>();
		
		PreparedStatement statement = null;
		ResultSet resultat = null;

		String comSQL = "SELECT id, auteur, topo, reponse FROM Demande WHERE destinataire = ?;";
		
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement(comSQL);
			statement.setString(1, user.getIdentifiant());
			resultat = statement.executeQuery();
			while (resultat.next()) {
				String auteur = resultat.getString("auteur");
				String topo = resultat.getString("topo");
				int id = resultat.getInt("id");
				String reponse = resultat.getString("reponse");
				Demande demande = new Demande();
				demande.setAuteur(auteur);
				demande.setTopo(topo);
				demande.setId(id);
				demande.setReponse(reponse);
				
				demandes.add(demande);
			}
				
				
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException ignore) {
            }
        }
		
		return demandes;
	}
	
	public List<Demande> afficherDemandeEx(Utilisateur user) {
		List<Demande> demandes= new ArrayList<Demande>();
		
		PreparedStatement statement = null;
		ResultSet resultat = null;

		String comSQL = "SELECT id, destinataire, topo, reponse FROM Demande WHERE auteur = ?;";
		
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement(comSQL);
			statement.setString(1, user.getIdentifiant());
			resultat = statement.executeQuery();
			while (resultat.next()) {
				String destinataire = resultat.getString("destinataire");
				String topo = resultat.getString("topo");
				int id = resultat.getInt("id");
				String reponse = resultat.getString("reponse");
				Demande demande = new Demande();
				demande.setDestinataire(destinataire);
				demande.setTopo(topo);
				demande.setId(id);
				demande.setReponse(reponse);
				demandes.add(demande);
			}
				
				
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException ignore) {
            }
        }
		
		return demandes;
	}
	
	public void repondreDemande(Demande demande, String reponse) {
		
		PreparedStatement statement = null;

		String comSQL = "UPDATE Demande SET reponse = ? WHERE id=?;";
		
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement(comSQL);
			statement.setString(1, reponse);
			statement.setInt(2, demande.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
