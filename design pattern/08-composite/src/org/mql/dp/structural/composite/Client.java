package org.mql.dp.structural.composite;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

import org.mql.dp.structural.composite.factory.FileCountFactory;
import org.mql.dp.structural.composite.factory.TreeNodeFactory;
import org.mql.dp.structural.composite.factory.StringFactory;

public class Client {
	private Component tree;
	public Client() {
		exp02();
		useCase3();
	}
	
	void useCase1()
	{
		tree.operation();
	}

	void useCase2()
	{
		tree.setFactory(new StringFactory());
		String result = tree.construct().toString();
		System.out.println(result);
	}
	
	void useCase3()
	{
		tree.setFactory(new TreeNodeFactory());
		DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode)tree.construct();
		TreeModel model = new DefaultTreeModel(treeNode);
		JTree jTree = new JTree(model);
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		frame.setContentPane(frame);
		frame.setSize(800, 500);
		frame.setVisible(true);
	}
	
	void useCase4()
	{
		String type = ".java";
		tree.setFactory(new FileCountFactory(type));
		System.out.println("=> nombre de fichier" + "(" + type  + ") est : " + tree.construct());
	}

	void exp02()
	{
		FileSystem sys = new FileSystem("..");
		tree = sys.getTree();
	}
	
	public void exp01()
	{
		Component A, B, C, D, F, I;
		A = new Composite("A");
		B = new Composite("B");
		C = new Composite("C");
		D = new Composite("D");
		F = new Composite("F");
		I = new Composite("I");
		A.add(B);
		A.add(C);
		A.add(D);
		
		B.add(new Leaf("E"));
		B.add(F);
		
		C.add(new Leaf("H"));
		C.add(I);
		
		D.add(new Leaf("L"));
		
		F.add(new Leaf("G"));

		I.add(new Leaf("J"));
		I.add(new Leaf("K"));
		
		tree = A;
	}
	
	public static void main(String[] args) {
		new Client();
	}
}
