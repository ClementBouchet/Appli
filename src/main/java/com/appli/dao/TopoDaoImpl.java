package com.appli.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.appli.beans.Demande;
import com.appli.beans.Topo;


public class TopoDaoImpl implements TopoDao{
	
	DaoFactory daoFactory;
	
	Connection connexion;
	private String comSQL;
	private String result;
	private String critere;
	
	TopoDaoImpl(DaoFactory daoFactory){
		this.daoFactory = daoFactory;
	}
	public List<Topo> rechercheTopo(HttpServletRequest request) {
		//Affiche la liste des secteurs correspondants � la recherche
		List<Topo> topos = new ArrayList<Topo>();
		
		PreparedStatement statement = null;
		ResultSet resultat = null;
		
		result = request.getParameter("recherche");
		critere = request.getParameter("critere1");
		if (result.contains("\'")){
			result=result.replace("\'", "\'\'");			
		}
		if (critere != "")
			comSQL = "SELECT * FROM Topo WHERE nom LIKE '%"+result+"%' OR site LIKE '%"+result+"%';";
		else
			comSQL = "SELECT * FROM Topo WHERE nom LIKE '%"+result+"%' OR site LIKE '%"+result+"%';";
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
				Topo topo = new Topo();
				topo.setNom(nom);
				topo.setSite(site);
				topo.setNum(id);
				
				topos.add(topo);
			}
				
				
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return topos;
	}
	
	public Topo afficherTopo(Topo top) {
		
		Topo topo = new Topo();
		
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		comSQL = "SELECT * FROM Topo WHERE id = ?";
		
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement(comSQL);
			preparedStatement.setInt(1,top.getNum());
			result = preparedStatement.executeQuery();
			
			while (result.next()) {
				
				topo.setAuteur(result.getString("auteur"));
				topo.setNom(result.getString("nom"));
				topo.setDescription(result.getString("description"));
				topo.setEmprunteur(result.getString("emprunteur"));
				topo.setSite(result.getString("site"));
				topo.setNum(result.getInt("id"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
            // Fermeture de la connexion
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException ignore) {
            }
		}
		
		return topo;
	}

	public List<Topo> recupererTopo(){
		
		List<Topo> topos = new ArrayList<Topo>();
		
		Statement statement = null;
		ResultSet resultat = null;
		
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT id, nom, auteur FROM Topo;");
			
			while(resultat.next()) {
				String nom = resultat.getString("nom");
				String auteur = resultat.getString("auteur");
				int id = resultat.getInt("id");
				
				
				Topo topo = new Topo();
				topo.setNom(nom);
				topo.setAuteur(auteur);
				topo.setNum(id);
				
				topos.add(topo);
				
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
		
		return topos;
		
	}

	public List<Topo> recupererTopoUser(String user){
	
	List<Topo> topos = new ArrayList<Topo>();
	
	PreparedStatement statement = null;
	ResultSet resultat = null;
	
	
	try {
		connexion = daoFactory.getConnection();
		statement = connexion.prepareStatement("SELECT id, nom, auteur, pret FROM Topo WHERE auteur = ?;");
		statement.setString(1, user);
		
		resultat = statement.executeQuery();
		
		while(resultat.next()) {
			String nom = resultat.getString("nom");
			String auteur = resultat.getString("auteur");
			int id = resultat.getInt("id");
			String pret = resultat.getString("pret");
			
			Topo topo = new Topo();
			topo.setNom(nom);
			topo.setAuteur(auteur);
			topo.setNum(id);
			if (pret != null){
			topo.setPret(pret);
			}
			else
				topo.setPret("non");
			topos.add(topo);
			
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
	
	return topos;
	
}

	public void ajouterTopo(Topo topo) {
	

	PreparedStatement preparedStatement = null;
			
	comSQL = "INSERT INTO Topo(nom,auteur,description,site) VALUES(?,?,?,?);";
	
	try {
		connexion = daoFactory.getConnection();
		preparedStatement = connexion.prepareStatement(comSQL);
		preparedStatement.setString(1, topo.getNom());
		preparedStatement.setString(2, topo.getAuteur());
		preparedStatement.setString(3, topo.getDescription());
		preparedStatement.setString(4, topo.getSite());
		preparedStatement.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
        // Fermeture de la connexion
        try {
            if (preparedStatement != null)
                preparedStatement.close();
            if (connexion != null)
                connexion.close();
        } catch (SQLException ignore) {
        }
    }
}

	public void supprimerTopo(int id) {
		//Pour supprimer un secteur de la base de donn�es
		
		try {
			connexion = daoFactory.getConnection();
			PreparedStatement preparedStatement = connexion.prepareStatement("DELETE FROM Topo WHERE id=?;");
			preparedStatement.setInt(1, id);
						
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public void preterTopo(Topo topo, String reponse) {
		
		PreparedStatement statement = null;

		String comSQL = "UPDATE Topo SET pret = ? WHERE nom=?;";
		
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement(comSQL);
			statement.setString(1, reponse);
			statement.setString(2, topo.getNom());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

}
