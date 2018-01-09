package com.appli.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
	   private String url;
	   private String username;
	   private String password;

	    DaoFactory(String url, String username, String password) {
	        this.url = url;
	        this.username = username;
	        this.password = password;
	    }

	    public static DaoFactory getInstance() {
	        try {
	            Class.forName("org.postgresql.Driver");
	        } catch (ClassNotFoundException e) {

	        }

	        DaoFactory instance = new DaoFactory(
	                "jdbc:postgresql://localhost:5432/ma_base", "postgres", "elephant");
	        return instance;
	    }

	    public Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(url, username, password);
	    }

	    // Recuperation du Dao
	    public SiteDao getSiteDao() {
	        return new SiteDaoImpl(this);
	    }
	    
	    public UtilisateurDao getUtilisateurDao() {
	        return new UtilisateurDaoImpl(this);
	    }
	    
	    public SecteurDao getSecteurDao() {
	    	return new SecteurDaoImpl(this);
	    }
	    
	    public ComDao getComDao() {
	    	return new ComDaoImpl(this);
	    }
	    
	    public VoieDao getVoieDao() {
	    	return new VoieDaoImpl(this);
	    }
	    
	    public TopoDao getTopoDao() {
	    	return new TopoDaoImpl(this);
	    }
	    
	    public DemandeDao getDemandeDao() {
	    	return new DemandeDaoImpl(this);
	    }
	}


