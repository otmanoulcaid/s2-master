package org.mql.dp.structural.composite;

import org.mql.dp.structural.composite.factory.Factory;

public class Leaf extends Component {

	public Leaf(String name) {
		super(name);
	}

	@Override
	public void operation() {
		System.out.println(" - " + getName());
	}

	@Override
	public Object construct() {
		return factory.createComposite(this);
	}

	@Override
	public void setFactory(Factory factory) {
		super.factory = factory;
	}
}
