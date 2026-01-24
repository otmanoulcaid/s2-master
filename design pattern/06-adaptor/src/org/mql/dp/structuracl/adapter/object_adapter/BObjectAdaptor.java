package org.mql.dp.structuracl.adapter.object_adapter;

import org.mql.dp.structuracl.adapter.B;
import org.mql.dp.structuracl.adapter.Target;

public class BObjectAdaptor implements Target {
	private B adaptee;
	
	public BObjectAdaptor(B adaptee) {
		this.adaptee = adaptee;
	}

	@Override
	public void log() {
		adaptee.log();
	}
}
