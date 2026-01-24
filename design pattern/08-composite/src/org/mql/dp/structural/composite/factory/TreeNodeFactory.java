package org.mql.dp.structural.composite.factory;

import javax.swing.tree.DefaultMutableTreeNode;

import org.mql.dp.structural.composite.Component;
import org.mql.dp.structural.composite.Leaf;

public class TreeNodeFactory implements Factory {

	public TreeNodeFactory() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Object createLeaf(Leaf leaf) {
		return new DefaultMutableTreeNode(leaf.getName());
	}

	@Override
	public Object createComposite(Component composite) {
		DefaultMutableTreeNode model = new DefaultMutableTreeNode(composite.getName());
		for (int i = 0; i < composite.size(); i++)
			model.add((DefaultMutableTreeNode)composite.get(i).construct());;
		return model;
	}
}
