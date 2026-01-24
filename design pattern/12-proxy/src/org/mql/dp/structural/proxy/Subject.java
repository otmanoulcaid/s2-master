package org.mql.dp.structural.proxy;

import java.util.List;

public interface Subject {
	public void insert(String item);
	public void update(int index, String item);
	public String delete(int index);
	public List<String> selectAll();
	public String select(int index);
	public int size();	
}
