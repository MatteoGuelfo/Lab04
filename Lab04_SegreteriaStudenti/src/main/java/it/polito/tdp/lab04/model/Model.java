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
	}



	public List<String> getNomiCorsi(){
		
		List<String> ritorno = new LinkedList<>(); 
		
		for(Corso cs: corsoDao.elencoCorsi()) {
			ritorno.add(cs.getNome());
		}
		
		ritorno.add("Nessun corso");
		return ritorno;
	}
	
	public String getNomeStudente(int matricola) {
		return studenteDao.studenteMatricola(matricola).getNome();
	}

	public String getCognomeStudente(int matricola) {
		return studenteDao.studenteMatricola(matricola).getCognome();
	}
}
