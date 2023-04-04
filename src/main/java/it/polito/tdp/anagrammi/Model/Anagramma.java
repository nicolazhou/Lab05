package it.polito.tdp.anagrammi.Model;

public class Anagramma {

	private String parola;
	private boolean correct;
	
	
	public Anagramma(String parola, boolean correct) {
		this.parola = parola;
		this.correct = correct;
	}


	public String getParola() {
		return parola;
	}


	public boolean isCorrect() {
		return correct;
	}
	
	
}
