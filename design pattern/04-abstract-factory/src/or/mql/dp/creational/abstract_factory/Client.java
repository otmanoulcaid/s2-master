package or.mql.dp.creational.abstract_factory;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Client {
	AbstractFactory factory;
	private String data [][] = {
			{"01", "Sigleton", "creational"},
			{"05", "builder", "creational"},
			{"07", "bridge", "Structural"},
			{"12", "proxy", "Structural"},
			{"13", "chain of responsibility", "Behavioral"},
	};
	
public Client(AbstractFactory factory) {
		this.factory = factory;
		createComplexObject();
	}
	
	public void createComplexObject() {
		JPanel content = new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		JPanel p1 = createPanel("design pattern name", factory.createProductA(20));
		JPanel p2 = createPanel("category", factory.createProductB("creational", "Structural", "Behavioral"));
		JComponent p3 = factory.createProductC(data);
		content.add(p1);
		content.add(p2);
		content.add(new JScrollPane(p3));

		JFrame f = new JFrame("Abstract Factory pattern");
		f.setContentPane(content);
		f.setSize(800, 500);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
	
	private JPanel createPanel(String label, JComponent component)
	{
		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p.add(new JLabel(label + " : "));
		p.add(component);
		return p;
	}
	
	public static void main(String[] args) {
//		new Client(new ConcreteFactory1());
		new Client(new ConcreteFactory2("Id", "Name", "Category"));
	}

}
