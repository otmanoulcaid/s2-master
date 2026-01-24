package org.mql.dp.structuracl.adapter;

import org.mql.dp.structuracl.adapter.class_adapter.AAdapter;
import org.mql.dp.structuracl.adapter.class_adapter.BAdapter;
import org.mql.dp.structuracl.adapter.class_adapter.CAdapter;
import org.mql.dp.structuracl.adapter.object_adapter.AObjectAdaptor;
import org.mql.dp.structuracl.adapter.object_adapter.BObjectAdaptor;
import org.mql.dp.structuracl.adapter.object_adapter.CObjectAdaptor;

public class Examples {
	
	Client client;
	public Examples() {
		client = new Client();
		exp03();
	}
	
	public void exp01()
	{
		Object [] obj = {
				new A(),
				new B(),
				new C(),
				new A(),
				new C()
		};
		client.handle(obj);
	}
	
	public void exp02()
	{
		Target [] obj = {
				new AAdapter(),
				new BAdapter(),
				new CAdapter(),
				new AAdapter(),
				new CAdapter()
		};
		client.handle(obj);
	}
	
	public void exp03()
	{
		Target [] obj = {
				new AObjectAdaptor(new A()),
				new BObjectAdaptor(new B()),
				new CObjectAdaptor(new C()),
				new AObjectAdaptor(new A()),
				new CObjectAdaptor(new C())
		};
		client.handle(obj);
	}
	
	public static void main(String[] args) {
		new Examples();
	}
}
