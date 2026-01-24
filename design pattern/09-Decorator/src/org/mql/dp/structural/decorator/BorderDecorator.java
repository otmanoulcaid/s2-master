package org.mql.dp.structural.decorator;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class BorderDecorator extends Decorator{
	private Color color;
public BorderDecorator(Component component , Color color) {
	super(component);
	this.color=color;
}
@Override
public JComponent operation() {
	return addedBehavior(super.operation());
}

public JComponent addedBehavior(JComponent view) {
	JPanel container= new JPanel(new BorderLayout());
	container.add("Center",view);
	container.add(view);
	Border border= new LineBorder(color); // Border= interface mere
	border= new CompoundBorder(new EmptyBorder(10,10,10,10),new CompoundBorder(border, new EmptyBorder(10,10,10,10))); // unite remarquable 2 est border
	container.setBorder(border);
	return container;
}
}
