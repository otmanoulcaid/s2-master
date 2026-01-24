package org.mql.java.models;

import java.time.LocalTime;
import java.util.Date;

public class Email {
	
	private String from;
	private String to;
	private String object;
	private String content;
	private LocalTime  time;
	private Date date;
	
	public Email() {
		// TODO Auto-generated constructor stub
	}

	public Email(String from, String to, String object, String content,  Date date,LocalTime  time) {
		super();
		this.from = from;
		this.to = to;
		this.object = object;
		this.content = content;
		this.time = time;
		this.date = date;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalTime  getTime() {
		return time;
	}

	public void setTime(LocalTime  time) {
		this.time = time;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Email [from=" + from + ", to=" + to + ", object=" + object + ", content=" + content + ", time=" + time
				+ ", date=" + date + "]";
	}
	
}
