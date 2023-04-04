package it.polito.tdp.anagrammi.DAO;

import java.sql.*;

public class ConnectDB {

	static private final String jdbcUrl = "jdbc:mysql://localhost/dizionario?user=root&password=root";
	
	
	public static Connection getConnection() {
		
		try {
			Connection connection = DriverManager.getConnection(jdbcUrl);
			
			return connection;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("Errore connessione DB!");
			
			throw new RuntimeException("Cannot get a connection " + jdbcUrl, e);
		}
		
	}
	
	
}
