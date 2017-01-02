package gui;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Export {

	public Export(Component component) {

		
		    
		    JFileChooser fc = new JFileChooser();
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int result = fc.showSaveDialog(null);
			
			if(result == JFileChooser.APPROVE_OPTION){
			
					   int w = component.getWidth();
					    int h = component.getHeight();
					    BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
					    
					    
		
				 component.paint( image.getGraphics() ); // alternately use .printAll(..)
				    BufferedImage subImg = image.getSubimage(10,  10, 640,  640);
				    String imageFile = fc.getSelectedFile() + ".png";
				    File fileImage = new File(imageFile);
				
				        try {
							fileImage.createNewFile();
							  ImageIO.write(subImg, "png", fileImage);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				      
				  
				
			
			    
			    // call the Component's paint method, using
			    // the Graphics object of the image.
			    
			   
	}
}
}
