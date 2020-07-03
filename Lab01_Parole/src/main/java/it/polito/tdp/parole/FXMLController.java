package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    @FXML 
    private Button btnCancella;
    
    @FXML
    private TextArea txtPerformance;

    @FXML
    void doInsert(ActionEvent event) {
    	String parola = txtParola.getText();
    	double inizio = System.nanoTime();
    	elenco.addParola(parola);
    	double fine = System.nanoTime();
    	txtResult.clear();
    	String result = "";
    	for(String s : elenco.getElenco())
    		result += s + "\n";
    	txtResult.setText(result);
    	txtPerformance.clear();
    	txtPerformance.setText("Tempo impiegato: " + ((fine-inizio)/1e9) + " secondi.");
    }

    @FXML
    void doReset(ActionEvent event) {
    	double inizio = System.nanoTime();
    	elenco.reset();
    	double fine = System.nanoTime();
    	txtResult.clear();
    	txtPerformance.clear();
    	txtPerformance.setText("Tempo impiegato: " + ((fine-inizio)/1e9) + " secondi.");
    }

    @FXML
    void doCancella() {
    	String selected = txtResult.getSelectedText();
    	double inizio = System.nanoTime();
    	elenco.cancella(selected);
    	double fine = System.nanoTime();
    	txtResult.clear();
    	String result = "";
    	for(String s : elenco.getElenco())
    		result += s + "\n";
    	txtResult.setText(result);
    	txtPerformance.clear();
    	txtPerformance.setText("Tempo impiegato: " + ((fine-inizio)/1e9) + " secondi.");
    }
    
    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
