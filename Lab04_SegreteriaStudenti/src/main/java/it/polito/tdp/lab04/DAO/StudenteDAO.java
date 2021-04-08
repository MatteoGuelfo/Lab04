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
		
			String sql = "SELECT * FROM studente WHERE matricola = "+matricola;
		
			PreparedStatement st1= conn.prepareStatement(sql); 
			//st1.setString(1,matricola);
			ResultSet res= st1.executeQuery(sql);
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
}
