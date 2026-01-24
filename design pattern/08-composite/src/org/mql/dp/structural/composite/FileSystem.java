package org.mql.dp.structural.composite;

import java.io.File;

public class FileSystem {
	
	private Component tree;

	public FileSystem(String folder) {
		tree = create(new File(folder));
	}
	
	private Component create(File f)
	{
		if (f.isDirectory())
		{
			Composite cmp = new Composite(f.getName());
			File [] content = f.listFiles();
			for (File file : content)
				cmp.add(create(file));
			return cmp;
		}
		else
			return new Leaf(f.getName());
	}
	
	public Component getTree()
	{
		return tree;
	}
}
