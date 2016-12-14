package gui;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
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

		
		JLayeredPane layers = new JLayeredPane();
		layers.setPreferredSize(new Dimension(900, 507));
		 String path = "res/launcherbackground1.bmp";
	        File file = new File(path);
	        BufferedImage image = ImageIO.read(file);
	        JLabel label = new JLabel(new ImageIcon(image));
	   	 String borderpath = "res/buttonborder.png";
	        File borderFile = new File(borderpath);
	        BufferedImage imageb = ImageIO.read(borderFile);
	        JLabel border = new JLabel(new ImageIcon(imageb));
	        JLabel border1 = new JLabel(new ImageIcon(imageb));
	        JLabel border2 = new JLabel(new ImageIcon(imageb));
	        
	        label.setBounds(0,  0,  900,  507);
	        
	        JButton b=new JButton(new ImageIcon("res/new.png"));
	        JButton b2=new JButton(new ImageIcon("res/load.png"));
	        JButton b3=new JButton(new ImageIcon("res/exit.png"));
	        
	
	    border.setBounds(605, 95, 160, 60);
	    border1.setBounds(605, 185, 160, 60);
	    border2.setBounds(605, 275, 160, 60);
		b.setBounds(610,102,150, 50);  
		b2.setBounds(610,192, 150, 50);
		b3.setBounds(610, 282, 150, 50);
     
		setTitle("Fog of War");
	        
	   	setSize(900, 507);
	   	
	    layers.add(b, new Integer(2));
	    layers.add(b2, new Integer(2));
	    layers.add(b3, new Integer(2));
		layers.add(border, new Integer(3));
		layers.add(border1, new Integer(3));
		layers.add(border2, new Integer(3));
		layers.add(label,  new Integer(1));
		add(layers);
	    setUndecorated (true);
		setResizable(false);
		getContentPane().add(layers);
		
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
	            	run();
	            }
	        });
		
	}

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
	
	
}


