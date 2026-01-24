package or.mql.dp.creational.abstract_factory;

import java.awt.ActiveEvent;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class KnownUses extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private LookAndFeelInfo [] lafs;

	public KnownUses() {
		lookAndFeels();
		userInterface();
	}
	
	private void lookAndFeels()
	{
		lafs = UIManager.getInstalledLookAndFeels();
		for (LookAndFeelInfo laf : lafs)
		{
			System.out.println(laf.getName() + " : " + laf.getClassName());
		}
	}
	
	public void userInterface()
	{
		JComponent [] cs = {
			new JLabel("nom du look and feel"), new JTextField(20), new JButton("valider")
		};
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		for (JComponent c : cs)
			p1.add(c);

		getContentPane().add("North", p1);
		JPanel p2 = new JPanel();
		ButtonGroup g = new ButtonGroup();

		for (LookAndFeelInfo laf : lafs)
		{
			JRadioButton btn  = new JRadioButton(laf.getName());
			btn.setName(laf.getClassName());
			p2.add(btn);
			g.add(btn);
			btn.addActionListener(this);
		}

		getContentPane().add("South", p2);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void changeLookAndFeel(String factoryName)
	{
		try {
			UIManager.setLookAndFeel(factoryName);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JRadioButton btn = (JRadioButton)e.getSource();
		changeLookAndFeel(btn.getName());
	}

	public static void main(String[] args) {
		new KnownUses();
	}
}
