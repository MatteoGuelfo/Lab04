package it.polito.tdp.lab04.model;

import java.util.LinkedList;
import java.util.List;
import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	CorsoDAO corsoDao ;
	StudenteDAO studenteDao;
	
	
	
	public Model() {
		super();
		this.corsoDao = new CorsoDAO();
		this.studenteDao = new StudenteDAO();
	}



	public List<String> getNomiCorsi(){
		
		List<String> ritorno = new LinkedList<>(); 
		
		for(Corso cs: corsoDao.elencoCorsi()) {
			ritorno.add(cs.getNome());
		}
		
		ritorno.add("Nessun corso");
		return ritorno;
	}
	
	public String getNomeStudente(String matricola) {
		return studenteDao.studenteMatricola(matricola).getNome();
	}

	public String getCognomeStudente(String matricola) {
		return studenteDao.studenteMatricola(matricola).getCognome();
	}
	
	public List<String> getStudentiCorso(String nomeCorso){
		List<String> studenti= new LinkedList<>(); 
		
		for(String s: studenteDao.studentiCorsi(nomeCorso)) {
			studenti.add(studenteDao.studenteMatricola(s).toString());
		}
		
		return studenti;			
	}
	
	public List<String> getElencoCorsiMatricola(String matricola){
		List<String> corsi = new LinkedList<>(); 
		
		for(Corso c : corsoDao.elencoCorsiMatricola(matricola)) {
			corsi.add(c.toString());
			
		}
		if(corsoDao.elencoCorsiMatricola(matricola).size()==0) {
			return null;
		}
		
		return corsi;
	}
}
