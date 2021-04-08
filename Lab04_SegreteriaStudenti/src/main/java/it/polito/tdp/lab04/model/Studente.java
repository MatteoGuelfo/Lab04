package it.polito.tdp.lab04.model;

public class Studente {
	
	private int matricola; 
	private String nome; 
	private String cognome; 
	private String cds;
	
	
	public Studente(int matricola, String nome, String cognome, String cds) {
		super();
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.cds = cds;
	}


	public int getMatricola() {
		return matricola;
	}


	public String getNome() {
		return nome;
	}


	public String getCognome() {
		return cognome;
	}


	public String getCds() {
		return cds;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(); 
		sb.append(String.format("%-8d", matricola)); 
		sb.append(String.format("%-30s", nome));
		sb.append(String.format("%-30s", cognome ));
		sb.append(String.format("%-8s", cds));
		
		return sb.toString();
	} 
	
	
	
	

}
