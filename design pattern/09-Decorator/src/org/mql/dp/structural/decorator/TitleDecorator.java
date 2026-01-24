package org.mql.dp.structural.decorator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitleDecorator extends Decorator {
	private String title;// addstate

	public TitleDecorator(Component component, String title) {
		super(component);
		this.title = title;
	}

	@Override
	public JComponent operation() {
		return addedBehavior(super.operation());
	}

	public JComponent addedBehavior(JComponent view)
	{
		JPanel container = new JPanel(new BorderLayout());
		container.add("Center", view);
		JLabel label = new JLabel(title);
		label.setOpaque(true);
		label.setBackground(Color.white);
		label.setBackground(Color.gray);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(new Font("Sejoe UI", Font.BOLD, 18));
		container.add("North", label);
		return container;

	}
}
