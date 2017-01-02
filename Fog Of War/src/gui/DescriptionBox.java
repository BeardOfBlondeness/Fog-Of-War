package gui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DescriptionBox extends JFrame {

	public DescriptionBox() throws IOException {
		
		JLabel bg = new JLabel(new ImageIcon(ImageIO.read(new File("res/desc.png"))));
		new getData("genreDesc", "genre", "genreID = 1");
		JLabel one = new JLabel(getData.val);
		System.out.println(getData.val);
		new getData("genreDesc", "genre", "genreID = 2");
		JLabel two = new JLabel("<html>" + getData.val.substring(0, 41) + "<br>" + getData.val.substring(41, getData.val.length()) + "</html>");
		System.out.println(getData.val);
		new getData("genreDesc", "genre", "genreID = 3");
		JLabel three = new JLabel("<html>" + getData.val.substring(0, 49) + "<br>" + getData.val.substring(49, getData.val.length()) + "</html>");
		System.out.println(getData.val);
		new getData("genreDesc", "genre", "genreID = 4");
		JLabel four = new JLabel("<html>" + getData.val.substring(0, 41) + "<br>" + getData.val.substring(41, getData.val.length()) + "</html>");
		System.out.println(getData.val);
		JButton back = new JButton(new ImageIcon(ImageIO.read(new File("res/back.png"))));
		
		back.setBounds(70,  210,  64,  32);
		one.setBounds(180, 30, 700, 80);
		two.setBounds(180, 80, 700, 80);
		three.setBounds(180, 130, 700, 80);
		four.setBounds(180, 180, 700, 80);
		one.setFont(new Font("Arial Black", Font.PLAIN, 15));
		two.setFont(new Font("Arial Black", Font.PLAIN, 15));
		three.setFont(new Font("Arial Black", Font.PLAIN, 15));
		four.setFont(new Font("Arial Black", Font.PLAIN, 15));
		
		add(one);
		add(two);
		add(three);
		add(four);
		add(back);
		setSize(600, 400);
		getContentPane().add(bg);
		setUndecorated(true);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		back.addMouseListener(new MouseAdapter() {
			//override the method
			public void mousePressed(MouseEvent arg0) {
			
			dispose();
			}

		});
	}
}
