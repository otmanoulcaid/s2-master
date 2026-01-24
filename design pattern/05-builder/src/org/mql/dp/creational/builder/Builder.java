package org.mql.dp.creational.builder;

public interface Builder {
	public void init(); //step 1
	public void setRow(String ...row);//step 2
	public void filter(String keyword);//step 3
	public void construct();//step 4
	public Object getResult();//final step
}
