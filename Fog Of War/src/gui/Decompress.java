package gui;

import java.io.IOException;

public class Decompress {
	
	public Decompress(String comp) {
		String[] decompressed = new String[comp.length()];
		for(int i = 0; i < comp.length()-2; i++) {
			System.out.println(comp.charAt(i));
			switch (Character.toString(comp.charAt(i))) {
			case "1": decompressed[i] = "res/grass.png";
			System.out.println("WOWEE");
			break;
			case "2":  decompressed[i] = "res/dirt.png";
			break;
			case "3":  decompressed[i] = "res/water.png";
			break;
			case "4":  decompressed[i] = "res/stone.png";
			break;
			case "5":  decompressed[i] = "res/pebbles.png";
			break;
			case "6":  decompressed[i] = "res/mountain.png";
			break;
			case "7":  decompressed[i] = "res/forest.png"; 
			break;
			case "8":  decompressed[i] = "res/sand.png";
			break;
			case "9":  decompressed[i] = "res/bridgeendgrass.png";
			break;
			case "a":  decompressed[i] = "res/bridgegrass.png";
			break;
			case "b":  decompressed[i] = "res/bridgestartgrass.png";
			break;
			default: System.out.println("Not a falid vile?");
			
			}
		}
		try {
			boolean newMap = false;
			new Interface(decompressed, newMap);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
