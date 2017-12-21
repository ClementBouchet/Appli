package com.appli.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.appli.beans.Recherche;
import com.appli.beans.Secteur;
import com.appli.beans.Voie;
import com.appli.dao.DaoFactory;

public class SecteurDaoImpl implements SecteurDao{
	
	DaoFactory daoFactory;
	
	SecteurDaoImpl(DaoFactory daoFactory){
		this.daoFactory = daoFactory;
	}
	
	private Connection connexion = null;
	private String result;
	private String critere;
	private String comSQL;

	public Recherche rechercheSecteur(HttpServletRequest request) {
		Recherche recherche = new Recherche();
		List<Secteur> secteurs = new ArrayList<Secteur>();
		
		PreparedStatement statement = null;
		ResultSet resultat = null;
		result = request.getParameter("recherche");
		critere = request.getParameter("critere1");
		if (result.contains("\'")){
			result=result.replace("\'", "\'\'");			
		}
		if (critere != "")
			comSQL = "SELECT * FROM Secteur INNER JOIN Site ON Site.id = Secteur.site_id WHERE Secteur.nom LIKE '%"+result+"%' AND Site.lieu LIKE '%"+critere+"%';" ;
		else
			comSQL = "SELECT * FROM Secteur WHERE nom LIKE '%"+result+"%' OR site LIKE '%"+result+"%';";
		
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement(comSQL);
			//statement.setString(1, result);
			//statement.setString(2, result);
			resultat = statement.executeQuery();
			
			while (resultat.next()) {
				String nom = resultat.getString("nom");
				String site = resultat.getString("site");
				int id = resultat.getInt("id");
				Secteur secteur = new Secteur();
				secteur.setNom(nom);
				secteur.setSite(site);
				secteur.setNum(id);
				
				secteurs.add(secteur);
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
		
		String page = request.getParameter("pageSe");		
		int j = 1;
		if ( page != null) {
			int y = Integer.parseInt(page);
			j = y;}
		int i = 5 * (j - 1);
		int h = secteurs.size();
		int k = 0;
		if (h%5 != 0) {
			k = (int)((h/5)+1);}
		else {
			k = (int)(h/5);
		}
		int b = 1;
		List<Secteur> secteursPage = new ArrayList<Secteur>();
		List<Integer> nbrPages = new ArrayList<Integer>();
		
		while ( b < (k + 1)) {
			nbrPages.add(b);
			b++;
		}
		
		while ( i < (5 * j) && i < h) {
			secteursPage.add(secteurs.get(i));
			
			i++;
		}
		recherche.setNbrPages(nbrPages);
		recherche.setSecteurs(secteursPage);
		
		return recherche;
		
	}
	
	public Secteur afficherSecteur(int id) {
		
		//Affiche les informations dans la page de d�tail
 		Secteur secteur = new Secteur();
		
		PreparedStatement statement = null;
		ResultSet resultat = null;
		
		String comSQL = "SELECT id, nom, site, rocher FROM Secteur WHERE id=?;";
		
		try {
			
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement(comSQL);
			statement.setInt(1, id);
			resultat = statement.executeQuery();
			while (resultat.next()) {
				String nom = resultat.getString("nom");
				String site = resultat.getString("site");
				String rocher = resultat.getString("rocher");
				secteur.setNom(nom);
				secteur.setSite(site);
				secteur.setRocher(rocher);
				secteur.setNum(id);
			}
				
				
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return secteur;
	}

	public void supprimerSecteur(int id) {
		//Pour supprimer un secteur de la base de donn�es
		
		
		try {
			connexion = daoFactory.getConnection();
			PreparedStatement preparedStatement = connexion.prepareStatement("DELETE FROM Secteur WHERE id=?;");
			preparedStatement.setInt(1, id);
						
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Secteur> recupererSecteur(){
		//Affiche tous les secteurs de la base de donn�es dans la page pour ajouter des secteurs
		List<Secteur> secteurs = new ArrayList<Secteur>();
		
		Statement statement = null;
		ResultSet resultat = null;
		
		
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT id, nom, site FROM Secteur;");
			
			while(resultat.next()) {
				String nom = resultat.getString("nom");
				String site = resultat.getString("site");
				int id = resultat.getInt("id");
				
				Secteur secteur = new Secteur();
				secteur.setNom(nom);
				secteur.setSite(site);
				secteur.setNum(id);
				
				secteurs.add(secteur);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return secteurs;
	}

	public void ajouterSecteur(Secteur secteur) {
		//Permet d'ajouter un nouveau secteur dans la base de donn�es
		
		String comSQL = "INSERT INTO Secteur(nom,site,rocher,site_id) "
				+ "SELECT ?,?,?, id FROM Site WHERE nom = ?;";
		try {
			connexion = daoFactory.getConnection();
			PreparedStatement preparedStatement = connexion.prepareStatement(comSQL);
			preparedStatement.setString(1, secteur.getNom());
			preparedStatement.setString(2, secteur.getSite());
			preparedStatement.setString(3, secteur.getRocher());
			preparedStatement.setString(4, secteur.getSite());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void modifierSecteur(int id, Secteur secteur) {
		
		PreparedStatement statement = null;
		
		String comSQL = "UPDATE Secteur SET nom=?, site =?, rocher=? WHERE id=?;";
		
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement(comSQL);
			statement.setString(1, secteur.getNom());
			statement.setString(2, secteur.getSite());
			statement.setString(3, secteur.getRocher());
			statement.setInt(4, id);
			statement.executeUpdate();
				
				
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Voie> recupererVoie(int ide){
		//Affiche toutes les voies de la base de donn�es dans la page pour ajouter des voies
		List<Voie> voies = new ArrayList<Voie>();
		
		Statement statement = null;
		ResultSet resultat = null;
		
		
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT id, nom, longueur, secteur, cotation FROM Voie WHERE secteur_id ="+ide+";");
			
			while(resultat.next()) {
				String nom = resultat.getString("nom");
				String secteur = resultat.getString("secteur");
				long longueur = resultat.getLong("longueur");
				int id = resultat.getInt("id");
				String cotation = resultat.getString("cotation");
				
				Voie voie = new Voie();
				
				voie.setNom(nom);
				voie.setSecteur(secteur);
				voie.setLongueur(longueur);
				voie.setNum(id);
				voie.setCotation(cotation);
				
				voies.add(voie);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return voies;
		
	}
	
	
}

	
	
	