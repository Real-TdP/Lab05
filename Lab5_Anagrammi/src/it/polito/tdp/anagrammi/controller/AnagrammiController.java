
package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import it.polito.tdp.lab05.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private TextField txtAnagramma;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    void btnCalcola(ActionEvent event) {
    	String anagramma=txtAnagramma.getText();
    	List<String> anagrammi=model.trovaAnagrammi(anagramma);

    }

    @FXML
    void btnReset(ActionEvent event) {
    	txtCorretti.clear();
    	txtErrati.clear();

    }

    @FXML
    void initialize() {
    	assert txtAnagramma != null : "fx:id=\"txtAnagramma\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
    
    public void setModel(Model model) {
		this.model=model;
		return;
	}
}

