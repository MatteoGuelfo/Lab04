package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {

	public Studente studenteMatricola(String matricola){
		
		Studente studente ; 
		try {
			Connection conn= ConnectDB.getConnection(); 
		
			String sql = "SELECT * FROM studente WHERE matricola = ? ";
		
			PreparedStatement st1= conn.prepareStatement(sql); 
			st1.setString(1,matricola);
			ResultSet res= st1.executeQuery();
			res.first();
			
			studente = new Studente(Integer.parseInt(res.getString("matricola")),res.getString("nome"), res.getString("cognome"), res.getString("CDS"));

			st1.close();
			conn.close();
			
		} catch(SQLException e){
			throw new RuntimeException(e);
		}
		
		System.out.println(studente);
		return studente; 
		
	}
	
	public List<String> studentiCorsi(String nomeCorso){
		
		 List<String> studenti= new LinkedList<>() ; 
		
		try {
			Connection conn= ConnectDB.getConnection(); 
		
			String sql = "SELECT matricola "
					+ "FROM iscrizione i, corso c"
					+ " WHERE i.codins=c.codins AND c.nome = ?";
		
			PreparedStatement st1= conn.prepareStatement(sql); 
			st1.setString(1, nomeCorso);
			ResultSet res= st1.executeQuery();
			res.first();


			while(res.next()) {
				studenti.add(res.getString("matricola"));
				
			}
			
			st1.close();
			conn.close();
			
		} catch(SQLException e){
			throw new RuntimeException(e);
		}
		
		return studenti; 
		
	}
	
	
}
