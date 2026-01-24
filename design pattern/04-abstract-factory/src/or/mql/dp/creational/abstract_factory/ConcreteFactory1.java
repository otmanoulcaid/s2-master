package or.mql.dp.creational.abstract_factory;

import java.util.Arrays;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class ConcreteFactory1 implements AbstractFactory {
	public ConcreteFactory1() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public JTextComponent createProductA(int size) {
		return new JTextField(size);
	}

	@Override
	public JComponent createProductB(String... choices) {
		return new JComboBox<String>(choices);
	}

	@Override
	public JComponent createProductC(String[][] data) {
		String [] rows = Arrays.stream(data)
				.map(row -> String.join(", ", row))
				.toArray(String[]::new);
		return new JList<String>(rows);
	}
}
