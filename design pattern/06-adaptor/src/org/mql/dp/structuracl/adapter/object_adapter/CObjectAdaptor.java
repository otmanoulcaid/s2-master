package org.mql.dp.structuracl.adapter.object_adapter;

import org.mql.dp.structuracl.adapter.C;
import org.mql.dp.structuracl.adapter.Target;

public class CObjectAdaptor implements Target {
	private C adaptee;
	
	public CObjectAdaptor(C adaptee) {
		this.adaptee = adaptee;
	}

	@Override
	public void log() {
		adaptee.display();
	}
}
