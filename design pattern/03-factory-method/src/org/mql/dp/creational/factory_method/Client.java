package org.mql.dp.creational.factory_method;

import javax.swing.JFrame;

public class Client extends JFrame {

	private static final long serialVersionUID = 1L;
	private Creator creator;
	
	public static void main(String[] args) {
		new Client();
	}
	
	public void exp1()
	{
		creator = new ButtonCreator("salam", "kalam", "3alam");
	}
	public void exp2()
	{
		creator = new CheckBoxCreator("salam", "kalam", "3alam");
	}
	public void exp3()
	{
		creator = new RadioButtonCreator("salam", "kalam", "3alam");
		creator.group();
	}
	
	public void config()
	{
		setContentPane(creator);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public Client() {
		super("Factory Method Pattern");
		exp2();
		config();
	}
}
