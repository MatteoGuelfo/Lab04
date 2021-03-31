package it.polito.tdp.lab04.model;

import java.util.LinkedList;
import java.util.List;
import it.polito.tdp.lab04.DAO.CorsoDAO;

public class Model {
	
	CorsoDAO corsoDao = new CorsoDAO();
	
	
	
	public List<String> getNomiCorsi(){
		
		List<String> ritorno = new LinkedList<>(); 
		
		for(Corso cs: corsoDao.elencoCorsi()) {
			ritorno.add(cs.getNome());
		}
		
		return ritorno;
	}

}
