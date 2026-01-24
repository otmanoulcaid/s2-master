package org.mql.java.dao;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.mql.java.models.Email;
import org.mql.jdbc.Database;


public class EmailDaoImplementation implements EmailDao{
	
	private Database dataBase;
	private String tablename="email";
	
	public EmailDaoImplementation(Database database) {
		this.dataBase=database;
	}

	@Override
	public List<Email> selectAll() {
		String[][] data=dataBase.select(tablename);
		System.out.println(data[0].length);
		List<Email> emails=new Vector<Email>();
		

		for(int row=0 ; row < data.length ; row++) {
			try
			{
				  LocalTime time = LocalTime.parse(data[row][6]); 
				Date date=new SimpleDateFormat("yyyy-mm-dd").parse(data[row][5]);
				Email email=new Email(data[row][1], data[row][2], data[row][3], data[row][4], date,time);
				emails.add(email);
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return emails;
		
	
	}
	

}
