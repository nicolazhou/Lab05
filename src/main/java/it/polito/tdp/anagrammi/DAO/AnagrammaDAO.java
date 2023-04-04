package it.polito.tdp.anagrammi.DAO;

import java.util.*;
import java.sql.*;

public class AnagrammaDAO {

	
	public Set<String> getAllWords() {
		
		final String sql = "SELECT * "
				+ "FROM parola";
		
		Set<String> lista = new HashSet<>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				
				lista.add(rs.getString("nome"));
				
			}
			
			rs.close();
			st.close();
			conn.close();
			
			return lista;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Errore AnagrammaDAO!");
		}
		
		return null;
		
	}
	
	
	public boolean isCorrect(String anagramma) {
		
		final String sql = "SELECT * "
				+ "FROM parola "
				+ "WHERE nome = ?";
		
		boolean res = false;
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, anagramma);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.first()) {
				res = true;
			}
			
			rs.close();
			st.close();
			conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("Errore AnagrammaDAO!");
		}
		
		return res;
	}
	
	
}
