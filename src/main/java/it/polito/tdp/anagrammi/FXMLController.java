package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.Model.Anagramma;
import it.polito.tdp.anagrammi.Model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.*;

public class FXMLController {
	
	Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCalcolaAnagrammi;

    @FXML
    private Button btnReset;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    private TextField txtParola;

    @FXML
    void doCalcolaAnagrammi(ActionEvent event) {

    	txtCorretti.clear();
    	txtErrati.clear();
    	
    	String word = this.txtParola.getText().toLowerCase();
    	
    	
    	List<Anagramma> lista = model.trovaAnagrammi(word);
    	
    	for(Anagramma a : lista) {
    		
    		if(a.isCorrect()) {
    			txtCorretti.appendText(a.getParola() + "\n");
    		} else {
    			txtErrati.appendText(a.getParola() + "\n");
    		}
    	}
    	
    }

    @FXML
    void doReset(ActionEvent event) {

    	this.txtParola.clear();
    	this.txtCorretti.clear();
    	this.txtErrati.clear();
    	
    }

    @FXML
    void initialize() {
        assert btnCalcolaAnagrammi != null : "fx:id=\"btnCalcolaAnagrammi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel() {
		// TODO Auto-generated method stub
		this.model = new Model();
		
	}

	
}
