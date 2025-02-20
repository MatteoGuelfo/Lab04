package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class CorsoDAO {

	
		public List<Corso> elencoCorsi(){
			
			List<Corso>  corsi = new ArrayList<>();
			try {
				Connection conn= ConnectDB.getConnection();
				
				String sql= "SELECT * FROM corso";
						
				PreparedStatement st=conn.prepareStatement(sql);
				
				ResultSet res = st.executeQuery();
				
				while(res.next()) {
					Corso nome = new Corso(res.getString("codins"),Integer.parseInt(res.getString("crediti")),res.getString("nome"),Integer.parseInt(res.getString("pd")));
					corsi.add(nome);
				}
				
				st.close();
				conn.close();
			
			}catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return corsi;
		}
		
		public List<Corso> elencoCorsiMatricola(String matricola){
			
			List<Corso> corsi = new ArrayList<>();
			try {
				Connection conn= ConnectDB.getConnection();
				
				String sql= "SELECT *"
						+ " FROM iscrizione i, corso c"
						+ " WHERE i.codins=c.codins  AND  i.matricola = ?";
						
				PreparedStatement st=conn.prepareStatement(sql);
				st.setString(1, matricola);
				ResultSet res = st.executeQuery();
				
				
				
				while(res.next()) {
					Corso nome = new Corso(res.getString("codins"),Integer.parseInt(res.getString("crediti")),res.getString("nome"),Integer.parseInt(res.getString("pd")));
					corsi.add(nome);
				}
				st.close();
				conn.close();
			
			
			}catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return corsi;
		}
		
		
		
		
		

}
