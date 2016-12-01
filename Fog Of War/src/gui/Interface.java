package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Interface extends JFrame{
	  int q = 0;
	  boolean isdown = false;
	  String stringName;
	String imgURLer = "res/dirt.png";
public static void run() {
SwingUtilities.invokeLater(new Runnable() {
   public void run() {
       try {
				new Interface();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
   }
});
}


public Interface() throws IOException {
String paths = "res/bg.png";
File files = new File(paths);
BufferedImage images = ImageIO.read(files);
JLabel labels = new JLabel(new ImageIcon(images));

for (int i = 10; i < 650; i+= 64 )
{
    for (int j = 10; j < 650; j+= 64)
    {

  		    String path = "res/grass.png";

  	  
  	  


	        File file = new File(path);
	        BufferedImage image = ImageIO.read(file);
	        JLabel label = new JLabel(new ImageIcon(image));
	        label.setBounds(i,  j,  64,  64);
	        
	        label.addMouseListener(new MouseAdapter() {
	        	
	        	
  	        //override the method
	        	public void mousePressed(MouseEvent arg0) {
	        		
	        	       isdown = true;
	        	        System.out.println("isDown is now true");
	        	    
        			
        				ImageIcon iconer = new ImageIcon(imgURLer);
        				label.setIcon(iconer); 				
	        	}
		        public void mouseReleased(MouseEvent e) {
		         isdown = false;
		        }
		        public void mouseEntered(java.awt.event.MouseEvent evt) {
	               
	                if(isdown== true) {
			        	ImageIcon iconer = new ImageIcon(imgURLer);
						label.setIcon(iconer); 			
						System.out.println("yo yo yo i believe the image should be placed, yes? be i correct? i must be a genius!");
			        }
	            }
	        });
	      
  	    
  	    add(label);
    }
}
File countFile = new File("res/count.png");
BufferedImage imagcount = ImageIO.read(countFile);
JLabel count = new JLabel(new ImageIcon(imagcount));
count.setBounds(757,  540,  128, 64);
add(count);



	//292
	 String[] textureimg =  {"res/grass.png", "res/water.png", "res/dirt.png", "res/bridgestartgrass.png", "res/bridgeendgrass.png", "res/bridgegrass.png"};
	 for(int x = 704; x < 946; x+=84) {
		 for(int y = 10; y < 511; y+= 84) {
			 File filer = new File(textureimg[q]);
			 BufferedImage imager = ImageIO.read(filer);
			 JLabel textures = new JLabel(new ImageIcon(imager));
			 textures.setName(textureimg[q]);
			 textures.setBounds(x, y, 64, 64);
			 add(textures);
			 
			 File border = new File("res/border.png");
			 BufferedImage bordimg = ImageIO.read(border);
			 JLabel bord = new JLabel(new ImageIcon(bordimg));
			 bord.setBounds(x-3,  y-3,  70,  70);
			 add(bord);
		
			 textures.addMouseListener(new MouseAdapter() {
		  	       
			        	public void mousePressed(MouseEvent arg0) {
			        		
			        		 stringName = textures.toString();
			    			 stringName = stringName.substring(stringName.indexOf("[" ) + 1);
			    			 stringName = stringName.substring(0,  stringName.indexOf(","));
			    			 
			    			 System.out.println(stringName);
		        				System.out.println("WORKS");
		        				imgURLer = stringName;
		        		// String imgURLerTemp = textures.getIcon().toString();	
		        		//	 imgURLer = imgURLerTemp.substring(imgURLerTemp.lastIndexOf("/" ) + 1)
		        			// System.out.println(imgURLer);
			        	}
			        });
			 if(q==5) {
				 q = 0;
			 }else {
				 q++;
			 }
			 
		 }
	 }
///////////////// texture selection area ////////////////////////////////////////////////
	 /*
	 String path = "res/grass.png";
	 File file = new File(path);
	 BufferedImage image = ImageIO.read(file);
	 JLabel texture1 = new JLabel(new ImageIcon(image));
	 texture1.setBounds(704, 10, 64, 64);
	 
	 String path2 = "res/water.png";
	 File file2 = new File(path2);
	 BufferedImage image2 = ImageIO.read(file2);
	 JLabel texture2 = new JLabel(new ImageIcon(image2));
	 texture2.setBounds(778, 10, 64, 64);
	 
	 add(texture1);
	 add(texture2);
	 
	    texture1.addMouseListener(new MouseAdapter() {
  	        //override the method
	        	public void mousePressed(MouseEvent arg0) {
	        		
        				System.out.println("WORKS");

        			 imgURLer = "res/grass.png";	
	        	}
	        });
	  texture2.addMouseListener(new MouseAdapter() {
  	        //override the method
	        	public void mousePressed(MouseEvent arg0) {
	        		
        				System.out.println("WORKS");

        			 imgURLer = "res/water.png";			
        	}
	    
	        });
	        */
/////////////////////////////////////////////////////////////////////////////////////////
	 setResizable(false);
	 getContentPane().add(labels);
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	 pack();
	
	 setVisible(true);
	 setLocationRelativeTo(null);
}
}
