package org.mql.dp.structural.composite.factory;

import org.mql.dp.structural.composite.Component;
import org.mql.dp.structural.composite.Leaf;

public class FileCountFactory implements Factory {
	
	private String type;

	public FileCountFactory(String type) { // exp : java
		super();
		this.type = type;
	}

	@Override
	public Object createLeaf(Leaf leaf) {
		return leaf.getName().endsWith(type) ? 1 : 0 ;
	}

	@Override
	public Object createComposite(Component composite) {
		int count = 0;
		int n = composite.size();
		for (int i = 0; i < n; i++)
			count += (int) composite.get(i).construct();
		return count;
	}
}
