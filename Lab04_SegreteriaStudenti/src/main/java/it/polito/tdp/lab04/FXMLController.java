package it.polito.tdp.lab04;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Model model= new Model();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> comboCorsi;

    @FXML
    private Button btnCercaIscritti;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private TextField txtMatricola;

    @FXML
    private Button btnVerde;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnScrivi;

    @FXML
    private TextArea txtGrande;

    @FXML
    private Button btnReset;

    @FXML
    void doCercaCorsi(ActionEvent event) {
    	String output="";
    	
    	if(txtMatricola.getText().equals("")){
    		txtGrande.setText("Nessuna matricola inserita");
    	}else if(model.getElencoCorsiMatricola(txtMatricola.getText())==null){
    				txtGrande.setText("La matricola "+ txtMatricola.getText()+" non esiste");
    			}else {
    					for(String s: model.getElencoCorsiMatricola(txtMatricola.getText())) {
    							output+=s+"\n";
    					}
    				   txtGrande.setText(output);
    				  }
    }

    @FXML
    void doCercaIscritti(ActionEvent event) {
    	String output=""; 
    	
    	if(comboCorsi.getValue() == null) {
    		txtGrande.setText("Seleziona un corso");
    	}else if(comboCorsi.getValue().equals("Nessun corso")){
    			txtGrande.setText("Hai selezionato -Nessun corso- : non valido");
    		  }else {
    			  for(String  s: model.getStudentiCorso(comboCorsi.getValue())) {
    				  output+=s+"\n";
    			  	}
    	}
    	txtGrande.appendText(output);
    	
    }

    @FXML
    void doReset(ActionEvent event) {

    }

    @FXML
    void doWrite(ActionEvent event) {
    	if(model.studenteIscrittoCorso( txtMatricola.getText(), comboCorsi.getValue())) {
    		txtGrande.setText("Studente iscritto al corso");
    	}else {
    		txtGrande.setText("Studente non iscritto al corso");
    	}
    		

    }

    @FXML
    void onHandleCercaStudente(ActionEvent event) {
    	String matricola= txtMatricola.getText();
    	if(matricola.equals("")) {
    		txtGrande.setText("Devi inserire la matricola");
    	}else {
    		txtNome.setText(model.getNomeStudente(matricola));
    		txtCognome.setText(model.getCognomeStudente(matricola));
    	}
    }

    
    
    public void setModel(Model model) {
    	this.model=model; 
    	comboCorsi.getItems().addAll(model.getNomiCorsi());
    	txtGrande.setStyle("-fx-font-family: monospace");
    }
    
    @FXML
    void initialize() {
        assert comboCorsi != null : "fx:id=\"comboCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaIscritti != null : "fx:id=\"btnCercaIscritti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnVerde != null : "fx:id=\"btnVerde\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnScrivi != null : "fx:id=\"btnScrivi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtGrande != null : "fx:id=\"txtGrande\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}

