package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingUtilities;

public class Interface extends JFrame{
	ArrayList<JLabel> aLabels;

	boolean first = true;
	String[][] names = new String[6][3];
	int q = 0;
	int yVal = 0;
	JLayeredPane layers = new JLayeredPane();
	boolean isdown = false;
	int pageNum = 1; 
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

		layers.setPreferredSize(new Dimension(1000, 660));
		String paths = "res/bg.png";
		File files = new File(paths);
		BufferedImage images = ImageIO.read(files);

		aLabels = new ArrayList<JLabel>();
		JLabel labels = new JLabel(new ImageIcon(images));
		labels.setBounds(0,  0,  1000,  660);
		layers.add(labels, new Integer(1));
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


				layers.add(label, new Integer(2));
			}
		}
		File countFile = new File("res/count.png");
		BufferedImage imagcount = ImageIO.read(countFile);

		File prevFile = new File("res/prev.png");
		BufferedImage prevIMG = ImageIO.read(prevFile);

		File nextFile = new File("res/next.png");
		BufferedImage nextIMG = ImageIO.read(nextFile);

		JLabel count = new JLabel(new ImageIcon(imagcount));
		JLabel cNum = new JLabel("Page " + pageNum);
		JLabel prev = new JLabel(new ImageIcon(prevIMG));
		JLabel next = new JLabel(new ImageIcon(nextIMG));
		prev.setBounds(675, 545, 70, 54);
		next.setBounds(898, 545, 70, 54);
		count.setBounds(757,  540,  128, 64);
		cNum.setBounds(778, 550, 120, 40);
		cNum.setFont(new Font("Arial Black", Font.PLAIN, 23));
		layers.add(next, new Integer(2));
		layers.add(prev, new Integer(2));
		layers.add(count, new Integer(2));
		layers.add(cNum, new Integer(3));

		prev.addMouseListener(new MouseAdapter() {
			//override the method
			public void mousePressed(MouseEvent arg0) {
				pageNum -= 1;
				try {
					first = false;
					textureSelection();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		next.addMouseListener(new MouseAdapter() {
			//override the method
			public void mousePressed(MouseEvent arg0) {
				pageNum -= 1;
				first = false;
				//textureSelection();
				change();
			}

		});
		textureSelection();

		setResizable(false);

		getContentPane().add(layers);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pack();

		setVisible(true);
		setLocationRelativeTo(null);
	}

	String[] textureimg =  {"res/grass.png", "res/water.png", "res/dirt.png", "res/bridgestartgrass.png", "res/bridgeendgrass.png", "res/bridgegrass.png"};
	String[] texturepage2 = {"res/bridgestartgrass.png", "res/bridgeendgrass.png", "res/bridgegrass.png", "res/bridgestartgrass.png", "res/bridgestartgrass.png", "res/bridgestartgrass.png"};
	String[] pageimages = null;
	int val = 0;
	public void textureSelection() throws IOException {
		//292
		//JLabel[] textureVal= new JLabel[18];
		q = 0;
		if(pageNum == 1 ) {
			pageimages = textureimg;
		}else if(pageNum== 2) {
			pageimages =texturepage2;
		}
		// pageNum = 2;
		// IDEA, give each jlabel a (NAME) and store this in an array, when repainting go through each JLabel name in the array and change the image attached to such a JLabel
		//make array of jlabels? 
		//store jlabels in external array that isnt themselves!?!!?!?!?!?!?!?!?!?!?!?!?

		int e = 0;
		if(first == false) {
			/*for(int u = 0; u < 14; u++) {
				textureVal[u].setIcon(new ImageIcon(ImageIO.read(new File(pageimages[e]))));
				if(e==2) {
					e = 0;
				}else {
					e++;		 
				}
*/

		//	}
		}

if(first = false) {
			
			System.out.println("killing the jables");
			
			for (JLabel j : aLabels) {
				layers.remove(j);
			
			}
			
			/*
			for(int firstRow = 0; firstRow < 5; firstRow++) {
				for(int secondRow = 0; secondRow < 5; secondRow++) {

					// TO DO LIST: CHANGE IMAGE OF JLABEL SET TO EACH NAME TO NEW IMAGE SET BY NEW PAGE YO REMEMBER THAT? GOOD 
					//		 names[firstRow][secondRow] 
					// DO STUFF

				}
			}
			*/
		}

		for(int x = 704; x < 946; x+=84) {
			for(int y = 10; y < 511; y+= 84) {

				File filer = new File(pageimages[q]);
				BufferedImage imager = ImageIO.read(filer);
				// JLabel textures = new JLabel(new ImageIcon(imager));
				JLabel textures = new JLabel();
				textures.setName(pageimages[q]);
				//System.out.println(pageimages[q]);
			//	names[q][yVal] = textures.getName();
				System.out.println("q: " + q + " Y: " + yVal);
				// System.out.println(textures.getName());
				textures.setBounds(x, y, 64, 64);
				
					//textureVal = textures;
					textures.setIcon(new ImageIcon(imager));
				
				//textures.setIcon(textureVal[val].getIcon());
				//System.out.println(textureVal[val].getIcon());
				layers.add(textures, new Integer(2));

				File border = new File("res/border.png");
				BufferedImage bordimg = ImageIO.read(border);
				JLabel bord = new JLabel(new ImageIcon(bordimg));
				bord.setBounds(x-3,  y-3,  70,  70);
				layers.add(bord, new Integer(3));

				textures.addMouseListener(new MouseAdapter() {

					public void mousePressed(MouseEvent arg0) {  		
						stringName = textures.toString();
						stringName = stringName.substring(stringName.indexOf("[" ) + 1);
						stringName = stringName.substring(0,  stringName.indexOf(","));		 
						System.out.println(stringName);
						System.out.println("WORKS");
						imgURLer = stringName;	
					}
				});
				if(q==5) {
					q = 0;
					yVal++;
				}else {
					q++;
				}
				val++;
				validate();
				repaint();

				aLabels.add(textures);
			}
		}
		
		//return textures;

	}
	
	public void change() {
		System.out.println("killing the jables");
		
		for (JLabel j : aLabels) {
			//layers.remove(j);
		//j.setBounds(30,30,30, 30);
			try {
				j.setIcon(new ImageIcon(ImageIO.read(new File("res/border.png"))));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
