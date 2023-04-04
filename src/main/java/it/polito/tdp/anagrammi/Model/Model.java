package it.polito.tdp.anagrammi.Model;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

import java.util.*;

public class Model {

	AnagrammaDAO anagrammaDAO;
	
	
	public Model() {
		this.anagrammaDAO = new AnagrammaDAO();
	}
	
	
	public List<String> cercaAnagrammi(String parola) {
		
		List<String> risultato = new ArrayList<String>();
		
		if(parola.length() == 1) { // A : Condizione di terminazione
			
			risultato.add(parola);
			
			return risultato;
			
		} else {
			
			for(int pos = 0; pos < parola.length(); pos++) {
				
				char lettera = parola.charAt(pos);
				
				String restanti = parola.substring(0, pos) + parola.substring(pos+1);
				
				List<String> anagrammiRestanti = cercaAnagrammi(restanti);
				
				for(String sol : anagrammiRestanti) {
					
					risultato.add(lettera + sol);
					
				}
				
			}
			
		}
		
		return risultato;
	}
	
	
	public List<Anagramma> trovaAnagrammi(String parola) {
		
		List<String> anagrammi = this.cercaAnagrammi(parola);
		
		List<Anagramma> risultato = new ArrayList<Anagramma>();
		
		for(String anagramma : anagrammi) {
			
			risultato.add(new Anagramma(anagramma, this.anagrammaDAO.isCorrect(anagramma)));
			
		}
		
		return risultato;
	}
	
	
}
