package org.mql.dp.structural.decorator;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Client extends JFrame {
	private static final long serialVersionUID = 1L;
	private Component component;
	
	public Client() {
		init();
		exp01();
		exp03("First Label");
//		exp02(Color.RED);
//		exp02(Color.black);
//		exp02(Color.black);
//		exp03("Second Label");
		userInterface();
	}
	
	void init() {
		component = new ConcreateComponent();
	}
	
	void userInterface() {
		JComponent view = component.operation();
		setContentPane(view);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	void exp01() {
		component = new ScrollPaneDecorator(component);
	}
	
	void exp02(Color color) {
		component = new BorderDecorator(component, color);
	}
	
	void exp03(String title) {
		component = new TitleDecorator(component, title);
	}
	
	public static void main(String[] args) {
		new Client();
	}
}