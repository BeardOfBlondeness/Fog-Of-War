package gui;

public class Compress {




	static String[] compressedLog = new String[100];

	public Compress(String[] textureLog) {
		// TODO Auto-generated constructor stub
	
		for(int i = 0; i < textureLog.length; i++) {
			switch (textureLog[i]) {
			case "res/grass.png": compressedLog[i] = "1";
			break;
			case "res/dirt.png": compressedLog[i] = "2";
			break;
			case "res/water.png": compressedLog[i] = "3";
			break;
			case "res/stone.png": compressedLog[i] = "4";
			break;
			case "res/pebbles.png": compressedLog[i] = "5";
			break;
			case "res/mountain.png": compressedLog[i] = "6";
			break;
			case "res/forest.png": compressedLog[i] = "7"; 
			break;
			case "res/sand.png": compressedLog[i] = "8";
			break;
			case "res/bridgeendgrass.png": compressedLog[i] = "9";
			break;
			case "res/bridgegrass.png": compressedLog[i] = "a";
			break;
			case "res/bridgestartgrass.png": compressedLog[i] = "b";
			break;
			default: System.out.println("Not a falid vile?");
			
			}
		}

	}


}
