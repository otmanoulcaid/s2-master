package org.mql.dp.structural.proxy;

import java.util.Arrays;
import java.util.List;

public class LogProxy implements Subject {
	private Subject subject;

	public LogProxy(Subject subject) {
		super();
		this.subject = subject;
	}

	public void insert(String item) {
		subject.insert(item);
		log(item);
	}

	public void update(int index, String item) {
		subject.update(index, item);
		log(item);
	}

	public String delete(int index) {
		log("salam");
		return subject.delete(index);
	}

	public List<String> selectAll() {
		return subject.selectAll();
	}

	public String select(int index) {
		return subject.select(index);
	}

	public int size() {
		return subject.size();
	}

	public int hashCode() {
		return subject.hashCode();
	}

	public boolean equals(Object obj) {
		return subject.equals(obj);
	}

	public String toString() {
		return subject.toString();
	}

	public void log(String action, Object ...data)
	{
		System.out.println("### Action '" + action + "' on data : " + Arrays.toString(data)
		+ ", by Client '" +  Thread.currentThread().getName() + "'");
	}
}
