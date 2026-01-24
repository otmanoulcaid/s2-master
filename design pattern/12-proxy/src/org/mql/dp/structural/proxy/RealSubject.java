package org.mql.dp.structural.proxy;

import java.util.LinkedList;
import java.util.List;

public class RealSubject implements Subject {

	List<String> data;
	
	public RealSubject() {
		data = new LinkedList<String>();
	}
	
	@Override
	public void insert(String item) {
		
	}

	@Override
	public void update(int index, String item) {
		data.add(item);
	}

	@Override
	public String delete(int index) {
		return null;
	}

	@Override
	public List<String> selectAll() {
		return data;
	}

	@Override
	public String select(int index) {
		return data.get(index);
	}

	@Override
	public int size() {
		data.size();
		return 0;
	}
	
	

}
