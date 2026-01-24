package org.mql.dp.structural.proxy;

import java.util.List;

public class SynchronizationProxy implements Subject{
	
	Subject subject;
	
	public SynchronizationProxy(Subject subject) {
		this.subject = subject;
	}

	synchronized public void insert(String item) {
		subject.insert(item);
	}

	synchronized public void update(int index, String item) {
		subject.update(index, item);
	}

	synchronized public String delete(int index) {
		return subject.delete(index);
	}

	synchronized public List<String> selectAll() {
		return subject.selectAll();
	}

	synchronized public String select(int index) {
		return subject.select(index);
	}

	synchronized public int size() {
		return subject.size();
	}

	
}
