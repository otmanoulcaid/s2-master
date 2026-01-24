package org.mql.dp.creational.factory_method;

import java.util.Hashtable;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;

abstract public class Creator extends JPanel{
	
	private Hashtable<String , AbstractButton>  products = new Hashtable<>();

	private static final long serialVersionUID = 1L;

	public Creator(String ...labels) {
		for  (String label : labels)
		{
			AbstractButton b = factoryMethod(label);
			add(b);
			products.put(label, b);
		}
	}
//
//	public void addActionListenner(String label, ActionListener action)
//	{
//		AbstractButton button = products.get(label);
//		if (button != null)
//			button.addActionListener(action);
//	}
	
	
	public void group()
	{
		ButtonGroup g = new ButtonGroup();
		int n = getComponentCount();
		
		for (int i = 0; i < n; i++)
			g.add((AbstractButton)getComponent(i));
		
	}
	
	abstract public AbstractButton factoryMethod(String label);
	
}
