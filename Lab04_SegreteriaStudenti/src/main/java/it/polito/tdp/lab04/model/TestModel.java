package it.polito.tdp.lab04.model;

import it.polito.tdp.lab04.DAO.StudenteDAO;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();
		
		StudenteDAO  stud= new StudenteDAO();
		
		stud.studenteMatricola("159818");

	}

}
