package org.mql.dp.creational.prototype;

public class Date implements Cloneable{
	
	private int day, month, year;
	
	public Date() {
		day = 1;
		month = 1;
		year = 1;
	}

	public Date(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}

	@Override
	public Date clone()
	{
		try {
			return (Date) super.clone();
		} catch (Exception e) {
			System.out.println("error : " + e.getMessage());
			return null;
		}
	}
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return day + "/" + month + "/" + year;
	}

	
	
}
