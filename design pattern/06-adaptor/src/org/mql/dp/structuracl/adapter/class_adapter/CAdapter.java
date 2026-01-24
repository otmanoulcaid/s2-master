package org.mql.dp.structuracl.adapter.class_adapter;

import org.mql.dp.structuracl.adapter.C;
import org.mql.dp.structuracl.adapter.Target;

public class CAdapter extends C implements Target {
	@Override
	public void log() {
		display();
	}
}
