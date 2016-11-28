package gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;



public class Launcher extends JFrame {

	public static void main(String s[]) throws IOException {
		 SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                try {
						new Launcher();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
	            }
	        });
		
 
	}
	
	public Launcher() throws IOException{

		 String path = "C:\\Users\\MikeDesktop\\Desktop\\Launcher\\src\\launcher\\launcherbackground.bmp";
	        File file = new File(path);
	        BufferedImage image = ImageIO.read(file);
	        JLabel label = new JLabel(new ImageIcon(image));
	        
	        
	        JButton b=new JButton(new ImageIcon("C:\\Users\\MikeDesktop\\Desktop\\Launcher\\src\\launcher\\new.png"));
	        JButton b2=new JButton(new ImageIcon("C:\\Users\\MikeDesktop\\Desktop\\Launcher\\src\\launcher\\load.png"));
	        JButton b3=new JButton(new ImageIcon("C:\\Users\\MikeDesktop\\Desktop\\Launcher\\src\\launcher\\exit.png"));
	        
	

		b.setBounds(610,100,150, 50);  
		b2.setBounds(610,190, 150, 50);
		b3.setBounds(610, 280, 150, 50);
     
		setTitle("Fog of War");
	        
	   	setSize(900, 507);
	    add(b);
	    add(b2);
		add(b3);
	    setUndecorated (true);
		setResizable(false);
		getContentPane().add(label);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		
		setVisible(true);
	    setLocationRelativeTo(null);
		 
		 
		 
		 
		 b3.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent e) {
	                
	               dispose(); 
	            }
	        });
		 
		 b.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent e) {
	               
	            	dispose();
	            	Interface.run();
	            }
	        });
		
	}

	
	
}


