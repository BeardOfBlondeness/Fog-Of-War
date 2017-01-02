package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MapType extends JFrame {

	
	public MapType() throws IOException { 

		
		JLabel bg = new JLabel(new ImageIcon(ImageIO.read(new File("res/mapType.png"))));
		JButton town = new JButton(new ImageIcon(ImageIO.read(new File("res/town.png"))));
		JButton city = new JButton(new ImageIcon(ImageIO.read(new File("res/city.png"))));
		JButton landscape = new JButton(new ImageIcon(ImageIO.read(new File("res/landscape.png"))));
		JButton dungeon = new JButton(new ImageIcon(ImageIO.read(new File("res/dungeon.png"))));
		JButton back = new JButton(new ImageIcon(ImageIO.read(new File("res/back.png"))));
		JButton info = new JButton(new ImageIcon(ImageIO.read(new File("res/info.png"))));
		bg.setBounds(0, 0, 600, 400);
		town.setBounds(150,  150, 128,  64);
		city.setBounds(322, 150, 128, 64);
		landscape.setBounds(150, 250, 128, 64);
		dungeon.setBounds(322, 250, 128, 64);
		back.setBounds(269, 325, 64, 30);
		info.setBounds(283, 215, 32, 32);
	
		add(info);
		add(back);
		
		add(landscape);
		add(town);
		add(city);
		add(dungeon);
		setSize(600, 400);
		getContentPane().add(bg);
		setUndecorated(true);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		town.addMouseListener(new MouseAdapter() {
			//override the method
			public void mousePressed(MouseEvent arg0) {
				new Compress(Interface.textureLog);
				String genre = "Town";
				new SaveMap(genre);
				
			}

		});
		

		info.addMouseListener(new MouseAdapter() {
		
			//override the method
			public void mousePressed(MouseEvent arg0) {
				
			//new getData("genreDesc", "genre", "genreID = 2");
			try {
				new DescriptionBox();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}

		});
		
		
		back.addMouseListener(new MouseAdapter() {
			//override the method
			public void mousePressed(MouseEvent arg0) {
			
			dispose();
			}

		});
	}
}
