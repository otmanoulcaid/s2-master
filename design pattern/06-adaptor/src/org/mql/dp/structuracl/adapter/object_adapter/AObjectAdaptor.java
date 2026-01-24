package org.mql.dp.structuracl.adapter.object_adapter;

import org.mql.dp.structuracl.adapter.A;
import org.mql.dp.structuracl.adapter.Target;

public class AObjectAdaptor implements Target {
	private A adaptee;
	
	public AObjectAdaptor(A adaptee) {
		this.adaptee = adaptee;
	}

	@Override
	public void log() {
		adaptee.print();
		
	}
}
