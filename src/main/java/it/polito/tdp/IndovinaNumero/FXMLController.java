package it.polito.tdp.IndovinaNumero;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class FXMLController {
	
	int segreto;
	final int TMAX=8;
	final int NMAX =100;
	int tentativiFatti;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnNuovaPartita;

    @FXML
    private Button btnProva;

    @FXML
    private TextArea txtEsito;
    
    @FXML
    private HBox hboxTentativi;
    
    @FXML
    private ProgressBar prgTentativi;

    @FXML
    private TextField txtNumero;

    @FXML
    private TextField txtTentativi;

    @FXML
    void doNuovaPartita(ActionEvent event) {
    	
    	segreto = (int) ((Math.random() * NMAX) +1);
    	tentativiFatti=0;
    	
    	txtTentativi.setText(Integer.toString(TMAX));
    	txtEsito.clear();
    	
    	hboxTentativi.setDisable(false);
    	prgTentativi.setProgress(0);
    }

    @FXML
    void doProva(ActionEvent event) {
    	
    	String ts = txtNumero.getText();
    	int tentativo;
    	
    	try {
    	tentativo = Integer.parseInt(ts);
    	txtNumero.clear();
    	} catch (NumberFormatException e) {
    		txtEsito.setText("Devi inserire un tentativo numerico tra 1-100");
    		return;
    	}
    	
    	tentativiFatti++;
    	prgTentativi.setProgress(tentativiFatti/TMAX);
    	
    	if (tentativo==segreto) {
    		txtEsito.setText("HAI INDOVINATO CON " + tentativiFatti +" TENTATIVI");
        	hboxTentativi.setDisable(true);
    		return;
    	}
    	
    	if (tentativiFatti==TMAX) {
    		txtEsito.setText("HAI PERSO, IL SEGRETO ERA "+ segreto);
        	hboxTentativi.setDisable(true);
    		return;
    	}
    	
    	if(tentativo < segreto) {
    		txtEsito.setText("Tentativo troppo basso");
    	}
    	else {
    		txtEsito.setText("Tentativo troppo alto");
    	}

		txtTentativi.setText(Integer.toString(TMAX-tentativiFatti));
    }

    @FXML
    void initialize() {
        assert btnNuovaPartita != null : "fx:id=\"btnNuovaPartita\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnProva != null : "fx:id=\"btnProva\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtEsito != null : "fx:id=\"txtEsito\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNumero != null : "fx:id=\"txtNumero\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTentativi != null : "fx:id=\"txtTentativi\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}

