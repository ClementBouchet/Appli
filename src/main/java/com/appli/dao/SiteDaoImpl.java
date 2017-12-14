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
import com.appli.beans.Site;

public class SiteDaoImpl implements SiteDao{
	
	private DaoFactory daoFactory;

    SiteDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
	
	
	private String result;
	private String critere;
	private String comSQL;
	
	
	public Recherche rechercheSite(HttpServletRequest request) {
		
		Recherche recherche = new Recherche();
		List<Site> sites = new ArrayList<Site>();
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat = null;
		
		result = request.getParameter("recherche");
		critere = request.getParameter("critere1");
		if (result.contains("\'")){
			result=result.replace("\'", "\'\'");			
		}
				
		try {
			connexion = daoFactory.getConnection();
			if (critere != "") { 
				comSQL = "SELECT * FROM Site WHERE nom LIKE '%"+result+"%' AND lieu LIKE '%"+critere+"%';";
				statement = connexion.prepareStatement(comSQL);}
			
			else {
				comSQL = "SELECT * FROM Site WHERE nom LIKE '%"+result+"%' OR lieu LIKE '%"+result+"%';";
				statement = connexion.prepareStatement(comSQL);}
			
			resultat = statement.executeQuery();
			
			while (resultat.next()) {
				String nom = resultat.getString("nom");
				String lieu = resultat.getString("lieu");
				int id = resultat.getInt("id");
				Site site = new Site();
				site.setNom(nom);
				site.setLieu(lieu);
				site.setNum(id);
				
				sites.add(site);
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
		String page = request.getParameter("pageSi");		
		int j = 1;
		if ( page != null) {
			int y = Integer.parseInt(page);
			j = y;}
		int i = 5 * (j - 1);
		int h = sites.size();
		int k = 0;
		if (h%5 != 0) {
			k = (int)((h/5)+1);}
		else {
			k = (int)(h/5);
		}
		int a = 1;
		List<Site> sitesPage = new ArrayList<Site>();
		List<Integer> nbrPages = new ArrayList<Integer>();
		
		while ( a < (k + 1)) {
			nbrPages.add(a);
			a++;
		}
		
		while ( i < (5 * j) && i < h) {
			sitesPage.add(sites.get(i));
			
			i++;
		}
		recherche.setNbrPages(nbrPages);
		recherche.setSites(sitesPage);
		return recherche;
	}
	
	
 	public Site afficherSite(int id) {
		Site site = new Site();
		Connection connexion;
		PreparedStatement statement = null;
		ResultSet resultat = null;
		
		String comSQL = "SELECT id, nom, lieu, description FROM Site WHERE id=?;";
		
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement(comSQL);
			statement.setInt(1, id);
			resultat = statement.executeQuery();
			while (resultat.next()) {
				String nom = resultat.getString("nom");
				String lieu = resultat.getString("lieu");
				String description = resultat.getString("description");
				site.setNom(nom);
				site.setLieu(lieu);
				site.setDescription(description);
				site.setNum(id);
			}
				
				
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return site;
	}
 	
	
 	public void modifierSite(int id, Site site) {
		Connection connexion;
		PreparedStatement statement = null;

		String comSQL = "UPDATE Site SET nom=?, lieu =?, description=? WHERE id=?;";
		
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement(comSQL);
			statement.setString(1, site.getNom());
			statement.setString(2, site.getLieu());
			statement.setString(3, site.getDescription());
			statement.setInt(4, id);
			statement.executeUpdate();
				
				
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	
	
 	public void supprimerSite(int id) {
		Connection connexion;
 		PreparedStatement preparedStatement = null;

		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("DELETE FROM Site WHERE id=?;");
			preparedStatement.setInt(1, id);
						
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public List<Site> recupererSite(){
		
		List<Site> sites = new ArrayList<Site>();
		Connection connexion;
		Statement statement = null;
		ResultSet resultat = null;

		
		
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT id, nom, lieu FROM Site;");
			
			while(resultat.next()) {
				String nom = resultat.getString("nom");
				String lieu = resultat.getString("lieu");
				int id = resultat.getInt("id");
				
				Site site = new Site();
				site.setNom(nom);
				site.setLieu(lieu);
				site.setNum(id);
				
				sites.add(site);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sites;
		
	}
	
	
	public void ajouterSite(Site site) {
		Connection connexion;
		PreparedStatement preparedStatement = null;
				
		String comSQL = "INSERT INTO Site(nom,lieu,description) VALUES(?,?,?);";
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement(comSQL);
			preparedStatement.setString(1, site.getNom());
			preparedStatement.setString(2, site.getLieu());
			preparedStatement.setString(3, site.getDescription());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public List<Secteur> recupererSecteur(int ide){
		//Affiche tous les secteurs du site
		List<Secteur> secteurs = new ArrayList<Secteur>();
		Connection connexion;
		Statement statement = null;
		ResultSet resultat = null;

		
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT id, nom, site FROM Secteur WHERE site_id = "+ide+";");
			
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
	

}
