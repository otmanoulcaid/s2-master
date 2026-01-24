package org.mql.dp.structural.composite;

import java.util.List;
import java.util.Vector;

import org.mql.dp.structural.composite.factory.Factory;

public class Composite extends Component{

	private List<Component> children;
	public Composite(String name) {
		super(name);
		children = new Vector<>();
	}

	@Override
	public void operation() {
		System.out.println("< " + getName() + " >");
		for (Component child : children)
			child.operation();
	}

	@Override
	public void add(Component component) {
		children.add(component);
	}

	@Override
	public Component remove(int index) {
		return children.remove(index);
	}

	@Override
	public int size() {
		return children.size();
	}

	@Override
	public Object construct() {
		return factory.createComposite(this);
	}

	@Override
	public void setFactory(Factory factory) {
		super.factory = factory;
		for(Component child : children)
			child.setFactory(factory);
	}
}
