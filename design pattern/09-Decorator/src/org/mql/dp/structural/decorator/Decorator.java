package org.mql.dp.structural.decorator;

import javax.swing.JComponent;

public class Decorator implements Component { // tous les decorateurs ont une mere commune qui Decorator. Decorator est
											// Component
	private Component component;

	public Decorator(Component component) {
		super();
		this.component = component;
	}
	
	@Override
	public JComponent operation() {
		return component.operation();
	}
	
	
}
