package org.mql.dp.structural.decorator;

import javax.swing.JComponent;
import javax.swing.JTextArea;

public class ConcreateComponent  implements Component{
	private JComponent view;
	
public ConcreateComponent() {
	view= new JTextArea(2,50);
}

public ConcreateComponent(JComponent view) {
	super();
	this.view = view;
}


	@Override
	public JComponent operation() {
		return view;
	}

}
