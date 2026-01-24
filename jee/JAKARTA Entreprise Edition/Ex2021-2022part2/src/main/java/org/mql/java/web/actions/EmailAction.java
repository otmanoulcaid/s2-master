package org.mql.java.web.actions;



import java.util.List;

import org.mql.java.business.EmailService;
import org.mql.java.config.ApplicationContext;
import org.mql.java.models.Email;
import org.mql.java.web.Model;

public class EmailAction {
	private EmailService service;
	public EmailAction() {
		service=ApplicationContext.getService();
	}
	public String emailsList(Model model) {
		List<Email> emails=service.emails();
		System.out.println(emails);
		model.add("emails", emails);
		return "emails-list";
	}

}
