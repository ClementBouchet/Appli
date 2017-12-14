package com.appli.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.appli.beans.Utilisateur;
import com.appli.beans.Validation;

public class UtilisateurDaoImpl implements UtilisateurDao {
	
	private DaoFactory daoFactory;
	private String comSQL;
	
	UtilisateurDaoImpl(DaoFactory daoFactory){
		this.daoFactory = daoFactory;
	}

	public List<Utilisateur> recupererUtilisateurs(){
		
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		
		Connection connexion;
		Statement statement = null;
		ResultSet resultat = null;
		
		comSQL = "SELECT identifiant, password FROM Utilisateur;";
		
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery(comSQL);
			
			while (resultat.next()) {
                String identifiant = resultat.getString("identifiant");
                String password = resultat.getString("password");
                
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setIdentifiant(identifiant);
                utilisateur.setPassword(password);
                
                utilisateurs.add(utilisateur);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return utilisateurs;
	}
	
	public void ajouterUtilisateur(Utilisateur utilisateur) {
		
		Connection connexion;
		
		
		try {
			connexion = daoFactory.getConnection();
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO Utilisateur(identifiant, password) VALUES(?, ?);");
            preparedStatement.setString(1, utilisateur.getIdentifiant());
            preparedStatement.setString(2, utilisateur.getPassword());
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public Validation verifyConnexion(Utilisateur utilisateur) {
		Validation validation = new Validation();
		
		String validId = null;
		String valid = null;
		String identifiantTry = utilisateur.getIdentifiant();
		String passwordTry = utilisateur.getPassword();
		String password = null;
		String identifiant = null;
		Connection connexion;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		comSQL = "SELECT identifiant, password FROM Utilisateur WHERE identifiant = ?;";
		
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement(comSQL);
			statement.setString(1, identifiantTry);
			result = statement.executeQuery();	
			if (result.first()) {				
				password = result.getString("password");
				identifiant = result.getString("identifiant");	
				if (identifiant.equals(identifiantTry)) {
					validId = "ok";
				
					if (password.equals(passwordTry)) {
						valid = "ok";
					}
					else {
						valid = "notok";
					}
				}
				else validId = "notok";
			}
			else {
				validId = "notok";			
			}
			validation.setIdent(validId);
			validation.setPass(valid);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return validation;
		
	}
}
