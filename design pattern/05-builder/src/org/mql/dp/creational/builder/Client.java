package org.mql.dp.creational.builder;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;

public class Client {

	public Client() {
		application1();
	}

	void application1()
	{
		Builder builder = new ConcreteBuilder1();
		Director dir = new Director(builder);
		List<DesignPattern> dps = (List<DesignPattern>) dir.build("struct");
		for (DesignPattern dp : dps)
			System.out.println(dp);
	}

	void application2()
	{
		Builder builder = new ConcreteBuilder1();
		Director dir = new Director(builder);
		JTable dps = (JTable) dir.build("struct");
		
		JFrame frame = new JFrame();
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Client();
	}
}
