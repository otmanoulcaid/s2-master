package org.mql.dp.creational.builder;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConcreteBuilder2 implements Builder{

	private JTable result;
	private DefaultTableModel model;
	private String [] titles = {
			"id", "name", "Category", "Intent"
	};
	private  String row [];
	
	public ConcreteBuilder2() {
		model = new DefaultTableModel(titles, 0);
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRow(String... row) {
		this.row = row;
	}

	@Override
	public void filter(String keyword) {
		keyword = keyword.toLowerCase();
		if (row[3].toLowerCase().contains(keyword))
		{
			model.addRow(row);
		}
	}

	@Override
	public void construct() {
		result = new JTable();
		
	}

	@Override
	public Object getResult() {
		return result;
	}

}
