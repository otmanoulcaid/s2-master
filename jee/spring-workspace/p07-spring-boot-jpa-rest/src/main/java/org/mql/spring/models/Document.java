package org.mql.spring.models;

import java.util.List;
import java.util.Vector;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Documents")
public class Document {
	@Id
	private String isbn;
	private String title;
	@Column(name="Year_Published")
	private int yearPublished;
	@ManyToOne //relation many to one//@Transient
	@JoinColumn(name="Publisher_ID") //on fait la column to jointure
	private Publisher publisher;
	@ManyToMany
	@JoinTable(
		name="Document_Author",
		joinColumns = @JoinColumn(name="ISBN"), 
		inverseJoinColumns = @JoinColumn(name="Au_ID")
	)
	private  List<Author> authors;
	
	public Document() {
		authors =  new Vector<Author>();	
	}
	

	public Document(String isbn, String title, int yearPublished) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.yearPublished = yearPublished;
		authors=new Vector<Author>();
	}


	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		return "Document [isbn=" + isbn + ", title=" + title + ", yearPublished=" + yearPublished + ", publisher="
				+ publisher + ", authors=" + authors + "]";
	}
	
	
}
