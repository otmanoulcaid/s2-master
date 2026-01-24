package or.mql.dp.creational.abstract_factory;

import javax.swing.JComponent;
import javax.swing.text.JTextComponent;

public interface AbstractFactory {
	public JTextComponent createProductA(int size);
	public JComponent createProductB(String ...choices);
	public JComponent createProductC(String [][]data);
}
