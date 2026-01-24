package org.mql.exam.dao;

import java.util.List;
import java.util.Vector;

import org.mql.exam.models.Student;

public class ORM {
	
	public static List<Student> getStudent( String [][] data)
	{
		List<Student> list = new Vector<>();
		for (int i = 0; i < data.length; i++)
			list.add(getStudent(data[i]));
		return list;
	}

	private static Student getStudent(String [] student)
	{
		return new Student(atoi(student[0]), student[1], student[2]);
	}
	
	private static int atoi(String str)
	{
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			return -1;
		}
	}
}
