package it.polito.tdp.lab04.model;

public class Corso {
	
	private String codice; 
	private int crediti; 
	private String nome; 
	private int pd;
	
	
	public Corso(String codice, int crediti, String nome, int pd) {
		
		super();
		this.codice = codice;
		this.crediti = crediti;
		this.nome = nome;
		this.pd = pd;
	}


	public String getCodice() {
		return codice;
	}


	public int getCrediti() {
		return crediti;
	}


	public String getNome() {
		return nome;
	}


	public int getPd() {
		return pd;
	} 
	
	
	

}
