package org.mql.dp.creational.builder;

import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

public class ConcreteBuilder1 implements Builder {
	private List<DesignPattern> patterns;
	private String row [];
	
	public ConcreteBuilder1() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		patterns = new Vector<>();
	}

	@Override
	public void setRow(String... row) {
		this.row = row; 
		
	}

	@Override
	public void filter(String keyword) {
		keyword = keyword.toLowerCase();
		if (row[2].toLowerCase().contains(keyword))
		{
			patterns.add(new DesignPattern(Integer.parseInt(row[0]), row[1], row[2], row[3]));
		}
		
	}

	@Override
	public void construct() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getResult() {
		return patterns;
	}
	
	
}
