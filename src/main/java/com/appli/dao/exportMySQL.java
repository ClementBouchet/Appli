package com.appli.dao;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class exportMySQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String filename =
	            "C:\\Users\\Clément\\eclipse-workspace\\myjdbcfilesecteur.csv";
	        try {
	            FileWriter fw = new FileWriter(filename);
	            Class.forName("com.mysql.jdbc.Driver").newInstance();
	            Connection conn = DriverManager.getConnection(
	            		"jdbc:mysql://localhost:3306/javaee", "root", "dolphin"
	            );
	            String query = "select * from secteur";
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(query);
	            while (rs.next()) {
	                fw.append(rs.getString(1));
	                fw.append(',');
	                fw.append(rs.getString(2));
	                fw.append(',');
	                fw.append(rs.getString(3));
	                fw.append(',');
	                fw.append(rs.getString(4));
	                fw.append(',');
	                fw.append(rs.getString(5));
	                fw.append('\n');
	            }
	            fw.flush();
	            fw.close();
	            conn.close();
	            System.out.println("CSV File is created successfully.");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	
		
	}


