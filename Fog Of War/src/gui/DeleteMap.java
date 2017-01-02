package gui;

import java.io.File;

public class DeleteMap {

	public DeleteMap(String val) {
		getData.removeData("map", "saveLocation", val);
		File f = new File(val + ".txt");
		System.out.println(val);
		f.delete();
	}
}
