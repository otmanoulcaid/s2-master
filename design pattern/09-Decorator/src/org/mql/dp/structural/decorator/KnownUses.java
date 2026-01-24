package org.mql.dp.structural.decorator;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.ObjectOutputStream;
import java.io.Reader;

public class KnownUses {
	public KnownUses() {
		// TODO Auto-generated constructor stub
	}
	
	void useCase1() {// concrreteCompoenent
		 try {
		Reader reader= new FileReader("...");//classe mere abstraite

		//lire le fhcier d'entree ligne par ligne
		BufferedReader d1= new BufferedReader(reader);
		d1.readLine(); //addBehavior
		LineNumberReader d2=new LineNumberReader(d1);
		d2.getLineNumber();// retourne le numero de la ligne //
		
		
		new ObjectOutputStream(new FileOutputStream(""));// derocator
		//outputsream = component
		
		 }
		 catch(Exception e) {
			 
		 }
	
	}
	public static void main(String[] args) {

	}
}
