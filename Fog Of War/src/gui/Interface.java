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
	  
	String imgURLer = "C:\\Users\\MikeDesktop\\Desktop\\Launcher\\src\\res\\dirt.png";
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
String paths = "C:\\Users\\MikeDesktop\\Desktop\\Jpanelthing\\src\\res\\bg.png";
File files = new File(paths);
BufferedImage images = ImageIO.read(files);
JLabel labels = new JLabel(new ImageIcon(images));

for (int i = 10; i < 650; i+= 64 )
{
    for (int j = 10; j < 650; j+= 64)
    {
  	  
  	  
  		 String path = "C:\\Users\\MikeDesktop\\Desktop\\Launcher\\src\\res\\grass.png";
	        File file = new File(path);
	        BufferedImage image = ImageIO.read(file);
	        JLabel label = new JLabel(new ImageIcon(image));
	        label.setBounds(i,  j,  64,  64);
	        
	        label.addMouseListener(new MouseAdapter() {
  	        //override the method
	        	public void mousePressed(MouseEvent arg0) {
	        		
        				System.out.println("WORKS");
        				
        				ImageIcon iconer = new ImageIcon(imgURLer);
        				label.setIcon(iconer);
        				
	        	}
	        });
  	    
  	    add(label);
    }
}

///////////////// texture selection area ////////////////////////////////////////////////

	 String path = "C:\\Users\\MikeDesktop\\Desktop\\Launcher\\src\\res\\grass.png";
	 File file = new File(path);
	 BufferedImage image = ImageIO.read(file);
	 JLabel texture1 = new JLabel(new ImageIcon(image));
	 texture1.setBounds(704, 10, 64, 64);
	 
	 String path2 = "C:\\Users\\MikeDesktop\\Desktop\\Launcher\\src\\res\\water.png";
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
        			 imgURLer = "C:\\Users\\MikeDesktop\\Desktop\\Launcher\\src\\res\\grass.png";
        			
        				
        				
	        	}
	        });
	    texture2.addMouseListener(new MouseAdapter() {
  	        //override the method
	        	public void mousePressed(MouseEvent arg0) {
	        		
        				System.out.println("WORKS");
        			 imgURLer = "C:\\Users\\MikeDesktop\\Desktop\\Launcher\\src\\res\\water.png";
        			
        				
        				
	        	}
	        });
/////////////////////////////////////////////////////////////////////////////////////////
	 setResizable(false);
	 getContentPane().add(labels);
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	 pack();
	
	 setVisible(true);
	 setLocationRelativeTo(null);
}






}
