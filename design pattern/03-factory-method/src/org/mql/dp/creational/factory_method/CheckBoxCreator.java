package org.mql.dp.creational.factory_method;

import javax.swing.AbstractButton;
import javax.swing.JCheckBox;

public class CheckBoxCreator extends Creator {

	private static final long serialVersionUID = 1L;

	@Override
	public AbstractButton factoryMethod(String label) {
		return new JCheckBox(label);
	}

	public CheckBoxCreator(String... labels) {
		super(labels);
	}
	
	
}
