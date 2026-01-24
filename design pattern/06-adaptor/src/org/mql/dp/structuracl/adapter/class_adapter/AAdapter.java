package org.mql.dp.structuracl.adapter.class_adapter;

import org.mql.dp.structuracl.adapter.A;
import org.mql.dp.structuracl.adapter.Target;

public class AAdapter extends A implements Target {
	@Override
	public void log() {
		print();
	}
}
