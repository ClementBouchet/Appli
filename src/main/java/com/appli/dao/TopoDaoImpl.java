package com.appli.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.appli.beans.Topo;

public class TopoDaoImpl implements TopoDao{
	
	DaoFactory daoFactory;
	
	Connection connexion;
	private String comSQL;
	
	TopoDaoImpl(DaoFactory daoFactory){
		this.daoFactory = daoFactory;
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
		statement = connexion.prepareStatement("SELECT id, nom, auteur FROM Topo WHERE auteur = ?;");
		statement.setString(1, user);
		
		resultat = statement.executeQuery();
		
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

}
