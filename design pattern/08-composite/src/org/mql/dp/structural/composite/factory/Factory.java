package org.mql.dp.structural.composite.factory;



import org.mql.dp.structural.composite.Component;
import org.mql.dp.structural.composite.Leaf;

public interface Factory {
	Object createLeaf(Leaf leaf);
	Object createComposite(Component composite);
}
