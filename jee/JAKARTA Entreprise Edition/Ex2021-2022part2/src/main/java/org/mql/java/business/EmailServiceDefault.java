package org.mql.java.business;

import java.util.List;

import org.mql.java.dao.EmailDao;
import org.mql.java.models.Email;

public class EmailServiceDefault implements EmailService{
	private EmailDao emailDao;
	
	public EmailServiceDefault(EmailDao emailDao) {
		this.emailDao=emailDao;
	}

	@Override
	public List<Email> emails() {
		// TODO Auto-generated method stub
		return emailDao.selectAll();
	}
	

}
