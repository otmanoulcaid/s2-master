package org.mql.dp.structural.bridge;

public class RefindAbstraction extends Abstraction {

	public RefindAbstraction() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void log(String message) {
		super.log(message + ", by user (" + Thread.currentThread().getName() + ")");
	}
}
