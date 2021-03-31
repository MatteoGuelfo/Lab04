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
			
			try {
				Connection conn= ConnectDB.getConnection();
				
				String sql= "SELECT * FROM corso";
						
				PreparedStatement st=conn.prepareStatement(sql);
				
				ResultSet res = st.executeQuery();
				
				List<Corso>  corsi = new ArrayList<>();
				
				while(res.next()) {
					Corso nome = new Corso(res.getString("codins"),Integer.parseInt(res.getString("crediti")),res.getString("nome"),Integer.parseInt(res.getString("pd")));
					System.out.println(nome);
					corsi.add(nome);
				}
				st.close();
				conn.close();
			return corsi;
			
			}catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		
		public List<String> elencoNomiCorso(){
			List<String> nomi= new LinkedList<>(); 
			
			for(Corso c: elencoCorsi())
				nomi.add(c.getNome());
			
			return nomi;
			
		}
}
