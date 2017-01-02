package gui;

import java.io.FileWriter;

import javax.swing.JFileChooser;

public class SaveMap {
	
	
	
	
	
	public SaveMap(String genre) {
		System.out.println(genre);
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int result = fc.showSaveDialog(null);
		
		if(result == JFileChooser.APPROVE_OPTION){
			try {
	
				FileWriter fw = new FileWriter(fc.getSelectedFile() + ".txt");
				for(int i = 0; i < Compress.compressedLog.length; i++) {
				fw.write(Compress.compressedLog[i].toString());
				}
				fw.close();
				String express = "genreName = " + "'" + genre + "'";
				getData.getInt("genreID", "genre", express);
				
				System.out.println(getData.value);
				getData.pushData("map", "saveLocation, genreID", "'" + fc.getSelectedFile().toString() + "', '" + getData.value + "'");
				System.out.println(fc.getSelectedFile().toString());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		System.out.println(genre);
	}
	

	
}
