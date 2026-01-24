package org.mql.spring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity					//la premiere etape pour utilise la data-jpa
@Table(name="Authors")//presiser le nom du table
public class Author {
	
	//@Value("200")
	@Id
	@Column(name = "Au_ID")
	private int id;
	@Column(name = "Author")
	private String name;
	@Column(name="Year_Born")
	private int yearBorn;
	
	public Author() {
	}
	
	public Author(int id, String name, int yearBorn) {
		super();
		this.id = id;
		this.name = name;
		this.yearBorn = yearBorn;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYearBorn() {
		return yearBorn;
	}
	public void setYearBorn(int yearBorn) {
		this.yearBorn = yearBorn;
	}
	@Override
	public String toString() {
		return " Author = [id=" + id + ", name=" + name + ", yearBorn=" + yearBorn + "]\n";
	}
	

}
