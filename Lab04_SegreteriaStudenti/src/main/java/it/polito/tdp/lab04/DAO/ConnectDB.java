package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	
	private static String jdbcURL = "jdbc:mysql://localhost/iscritticorsi?user=root&password=258383";
	
	public static Connection getConnection() {
		Connection connection= null;
		try {
			connection= DriverManager.getConnection(jdbcURL);
			
		}catch(SQLException e) {
			System.out.print("Errore apertura database" + e );
		}
		return connection;
		 
	}
}
