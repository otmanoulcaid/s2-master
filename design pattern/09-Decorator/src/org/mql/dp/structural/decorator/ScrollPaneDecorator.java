package org.mql.dp.structural.decorator;

import javax.swing.JComponent;
import javax.swing.JScrollPane;

public class ScrollPaneDecorator extends Decorator{
	public ScrollPaneDecorator(Component component) {
		super(component);
	}
	
	@Override
	public JComponent operation() {
		return addedBehavior(super.operation());
	}
	
	public JComponent addedBehavior(JComponent view) {
		return new JScrollPane(view, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	}
}
