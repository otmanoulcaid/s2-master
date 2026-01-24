package org.mql.dp.creational.factory_method;

import javax.swing.AbstractButton;
import javax.swing.JRadioButton;

public class RadioButtonCreator extends Creator {

	private static final long serialVersionUID = 1L;

	public RadioButtonCreator(String... labels) {
		super(labels);
		// TODO Auto-generated constructor stub
	}

	@Override
	public AbstractButton factoryMethod(String label) {
		return new JRadioButton(label);
	}
	
}
