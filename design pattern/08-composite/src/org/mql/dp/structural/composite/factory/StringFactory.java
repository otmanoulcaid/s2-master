package org.mql.dp.structural.composite.factory;

import org.mql.dp.structural.composite.Component;
import org.mql.dp.structural.composite.Leaf;

//A(B(E, F), C, D)

public class StringFactory implements Factory {

	public StringFactory() {

	}

	@Override
	public Object createLeaf(Leaf leaf) {
		return leaf.getName();
	}

	@Override
	public Object createComposite(Component composite) {
		StringBuffer sb = new StringBuffer(composite.getName() + "(");
		int n = composite.size();
		if (n > 0)
			for (int i = 0; i < n; i++)
				sb.append(composite.get(i).construct());
		return sb + ")";
	}

}
