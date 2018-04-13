
package it.polito.tdp.anagrammi.controller;

import javafx.scene.control.Label;
import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import it.polito.tdp.lab05.model.Model;
import javafx.beans.binding.Bindings;
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
    private Label numErrati;
    
    @FXML
    private Label numCorretti;


    @FXML
    void btnCalcola(ActionEvent event) {
    	String anagramma=txtAnagramma.getText();
    	List<String> anagrammi=model.trovaAnagrammi(anagramma);
    	List<String> anagrammiC=model.anagrammiCorretti(anagrammi);
    	List<String> anagrammiE=model.anagrammiErrati(anagrammi);
    	for(String c:anagrammiC)
    		txtCorretti.appendText(c+"\n");
    	for(String e:anagrammiE)
    		txtErrati.appendText(e+"\n");
    	
    }

    @FXML
    void btnReset(ActionEvent event) {
    	txtCorretti.clear();
    	txtErrati.clear();

    }

    @FXML
    void initialize() {
        assert txtAnagramma != null : "fx:id=\"txtAnagramma\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert numCorretti != null : "fx:id=\"numCorretti\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert numErrati != null : "fx:id=\"numErrati\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
    
    public void setModel(Model model) {
		this.model=model;
		numCorretti.textProperty().bind(Bindings.convert(model.NcorrProperty()));
		numErrati.textProperty().bind(Bindings.convert(model.NerrProperty()));
		return;
	}
}

