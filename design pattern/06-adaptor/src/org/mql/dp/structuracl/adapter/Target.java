package org.mql.dp.structuracl.adapter;

public interface Target {
	public void log();
}



//proxy similaire a l'adapter, auf que l'adaptee n'implement pas le target et que l'adaptor fait appel exactement de l'adaptee
//tandis que le proxy et son adaptee implement le target, ainsi que le proxy ajout des traitement apart le traitement de l'adaptee