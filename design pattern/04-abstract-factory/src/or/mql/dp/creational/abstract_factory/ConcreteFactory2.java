package or.mql.dp.creational.abstract_factory;

import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.text.JTextComponent;

public class ConcreteFactory2 implements AbstractFactory {
	
	private int rows = 3;
	private String []title;
	
	public ConcreteFactory2(String ...titles) {
		this.title = titles;
	}

	@Override
	public JTextComponent createProductA(int size) {
		return new JTextArea(rows, size);
	}

	@Override
	public JComponent createProductB(String... choices) {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		ButtonGroup g = new ButtonGroup();
		for (String choice : choices)
		{
			JRadioButton button = new JRadioButton(choice);
			panel.add(button);
			g.add(button);
		}
		return panel;
	}

	@Override
	public JComponent createProductC(String[][] data) {
		return new JTable(data, title);
	}

}
