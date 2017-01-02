package gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
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
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * This class does blah.
 * 
 * @author MikeDesktop
 *
 */
public class Interface extends JFrame{
	static JPanel screenshotPanel = new JPanel();
	
	static int r;
	/**
	 * pageNum stores which page number you are on
	 */
	int pageNum = 1; 

	/**
	 * aLabels stores texture images for texture pane.
	 */
	ArrayList<JLabel> aLabels;
	
	/**
	 * textureLog stores a log of all the textures in the map, ready for it to be saved and compressed
	 */
	static String textureLog[] = new String[100];
	
	/**
	 * cNum displays the page number
	 */
	JLabel cNum = new JLabel("Page " + pageNum);

	/**
	 * Variable to tell whether the window has just been opened.
	 */
	boolean first = true;

	/**
	 * Stores which texture each image in selection pane will hold
	 */
	int q = 0;

	/**
	 * Panel to layer all images.
	 */
	static JLayeredPane layers = new JLayeredPane();

	/**
	 * Stores whether the mouse is clicked.
	 */
	static boolean isdown = false;

	/**
	 *  Stores which texture you've pressed on. 
	 */
	String stringName;

	/**
	 * PUT INSIDE CONSTRUCTOR
	 */
	static String imgURLer = "res/dirt.png";
	
	/**
	 * Strings to store the textures of each image in the texture selection pane
	 */
	String[] textureimg =  {"res/grass.png", "res/water.png", "res/dirt.png", "res/sand.png", "res/forest.png", "res/mountain.png", "res/stone.png", "res/pebbles.png"};
	String[] texturepage2 = {"res/bridgestartgrass.png", "res/bridgeendgrass.png", "res/bridgegrass.png", "res/bridgestartgrass.png", "res/bridgestartgrass.png", "res/bridgestartgrass.png"};
	
	/**
	 * Stores a reference to which texture array shall be used
	 */
	String[] pageimages = null;

	/**
	 * Constructor for the user interface.
	 */
	public Interface(String[] decompressed, boolean newMap) throws IOException {
		r = 0;
		layers.setPreferredSize(new Dimension(1000, 660));
		String paths = "res/bg.png";
		File files = new File(paths);
		BufferedImage images = ImageIO.read(files);
		aLabels = new ArrayList<JLabel>();
		JLabel labels = new JLabel(new ImageIcon(images));
		labels.setBounds(0,  0,  1000,  660);
		layers.add(labels, new Integer(1));
		if(newMap == true) {
		createGrid();
		}else {
			loadGrid(decompressed);
		}
		File countFile = new File("res/count.png");
		BufferedImage imagcount = ImageIO.read(countFile);
		File prevFile = new File("res/prev.png");
		BufferedImage prevIMG = ImageIO.read(prevFile);
		File nextFile = new File("res/next.png");
		BufferedImage nextIMG = ImageIO.read(nextFile);
		JLabel count = new JLabel(new ImageIcon(imagcount));
		JLabel prev = new JLabel(new ImageIcon(prevIMG));
		JLabel next = new JLabel(new ImageIcon(nextIMG));
		JLabel save = new JLabel(new ImageIcon(ImageIO.read(new File("res/save.png"))));
		JLabel back = new JLabel(new ImageIcon(ImageIO.read(new File("res/back.png"))));
		JLabel export = new JLabel(new ImageIcon(ImageIO.read(new File("res/export.png"))));
		export.setBounds(878, 615, 64, 30);
		save.setBounds(789, 615, 64, 30);
		back.setBounds(700, 615, 64, 30);
		prev.setBounds(675, 540, 70, 54);
		next.setBounds(898, 540, 70, 54);
		count.setBounds(757,  535,  128, 64);
		cNum.setBounds(778, 545, 120, 40);
		cNum.setFont(new Font("Arial Black", Font.PLAIN, 23));
		layers.add(export, new Integer(2));
		layers.add(back, new Integer(2));
		layers.add(save, new Integer(2));
		layers.add(next, new Integer(2));
		layers.add(prev, new Integer(2));
		layers.add(count, new Integer(2));
		layers.add(cNum, new Integer(3));

		prev.addMouseListener(new MouseAdapter() {
			//override the method
			public void mousePressed(MouseEvent arg0) {
				pageNum--;
				first = false;
				//textureSelection();
				change();

			}

		});
		next.addMouseListener(new MouseAdapter() {
			//override the method
			public void mousePressed(MouseEvent arg0) {
				pageNum++;
				first = false;
				//textureSelection();
				change();
			}

		});
		back.addMouseListener(new MouseAdapter() {
			//override the method
			public void mousePressed(MouseEvent arg0) {
				dispose();
				try {
					new Launcher();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					}

		});
		save.addMouseListener(new MouseAdapter() {
			//override the method
			public void mousePressed(MouseEvent arg0) {
		
				try {
					new MapType();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
	
		textureSelection();
		setResizable(false);
		getContentPane().add(layers);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		
		export.addMouseListener(new MouseAdapter() {
			//override the method
			public void mousePressed(MouseEvent arg0) {
		
				new Export(getContentPane());

			}

		});
	 
	}

	/**
	* Creates the texture selection pane user interface.
	* 
	* @throws IOException if file cannot be read.
	*/
	public void textureSelection() throws IOException {

		q = 0;

		pageimages = textureimg;


		for(int x = 704; x < 946; x+=84) {
			for(int y = 10; y < 511; y+= 84) {

				File filer = new File(pageimages[q]);
				BufferedImage imager = ImageIO.read(filer);
				JLabel textures = new JLabel();
				textures.setName(pageimages[q]);
				textures.setBounds(x, y, 64, 64);
				textures.setIcon(new ImageIcon(imager));
				layers.add(textures, new Integer(2));

				File border = new File("res/border.png");
				BufferedImage bordimg = ImageIO.read(border);
				JLabel bord = new JLabel(new ImageIcon(bordimg));
				bord.setBounds(x-3,  y-3,  70,  70);
				layers.add(bord, new Integer(3));

				textures.addMouseListener(new MouseAdapter() {

					public void mousePressed(MouseEvent arg0) {  		
						stringName = textures.getName();
						System.out.println(stringName);
						System.out.println("WORKS");
						imgURLer = stringName;	
					}
				});
				if(q==7) {
					q = 0;

				}else {
					q++;
				}

				validate();
				repaint();

				aLabels.add(textures);
			}
		}
	}

	/**
	 * Function to change the page of texture selection panes you are on.
	 */
	public void change() {
		if(pageNum == 1) {
			pageimages = textureimg;
		} else if(pageNum==2) {
			pageimages = texturepage2;
		}

		cNum.setText("Page " + Integer.toString(pageNum));
		System.out.println("killing the jables");
		q = 0;
		for (JLabel j : aLabels) {
			try {
				j.setIcon(new ImageIcon(ImageIO.read(new File(pageimages[q]))));
				j.setName(pageimages[q]);
			} catch (IOException e) {

				e.printStackTrace();
			}

			if(q==6) {
				q = 0;
			}else {
				q++;
			}
		}

	}

	/**
	 * Function to create the large map grid
	 * 
	 * @throws IOException if file cannot be read.
	 */
	public void createGrid() throws IOException {
		
		for (int i = 10; i < 650; i+= 64 )
		{
			for (int j = 10; j < 650; j+= 64)
			{
				
				String path = "res/grass.png";
				File file = new File(path);
				BufferedImage image = ImageIO.read(file);
				JLabel label = new JLabel(new ImageIcon(image));
				label.setBounds(i,  j,  64,  64);
				label.setName(Integer.toString(r));
				textureLog[r] = path;
				label.addMouseListener(new MouseAdapter() {
					
					//override the method
					public void mousePressed(MouseEvent arg0) {
						int z = r;
						isdown = true;
						System.out.println("isDown is now true");
						ImageIcon iconer = new ImageIcon(imgURLer);
						textureLog[Integer.parseInt(label.getName())] = imgURLer;
						label.setIcon(iconer); 				
					}
					
					public void mouseReleased(MouseEvent e) {
						isdown = false;
					}
					
					public void mouseEntered(java.awt.event.MouseEvent evt) {

						if(isdown== true) {
							ImageIcon iconer = new ImageIcon(imgURLer);
							
							textureLog[Integer.parseInt(label.getName())] = imgURLer;
							label.setIcon(iconer); 			
							System.out.println("yo yo yo i believe the image should be placed, yes? be i correct? i must be a genius!");
						}
					}
				});
				screenshotPanel.add(label);
				layers.add(label, new Integer(2));
				r++;
			}
		}
		
	}
	
	
	public static void loadGrid(String[] grid) throws IOException {
		int z = 0;
		for (int i = 10; i < 650; i+= 64 )
		{
			for (int j = 10; j < 650; j+= 64)
			{
				
				String path = grid[z];
				File file = new File(path);
				BufferedImage image = ImageIO.read(file);
				JLabel label = new JLabel(new ImageIcon(image));
				label.setBounds(i,  j,  64,  64);
				label.setName(Integer.toString(r));
				textureLog[r] = path;
				label.addMouseListener(new MouseAdapter() {
					
					//override the method
					public void mousePressed(MouseEvent arg0) {
						int z = r;
						isdown = true;
						System.out.println("isDown is now true");
						ImageIcon iconer = new ImageIcon(imgURLer);
						textureLog[Integer.parseInt(label.getName())] = imgURLer;
						label.setIcon(iconer); 				
					}
					
					public void mouseReleased(MouseEvent e) {
						isdown = false;
					}
					
					public void mouseEntered(java.awt.event.MouseEvent evt) {

						if(isdown== true) {
							ImageIcon iconer = new ImageIcon(imgURLer);
							
							textureLog[Integer.parseInt(label.getName())] = imgURLer;
							label.setIcon(iconer); 			
							System.out.println("yo yo yo i believe the image should be placed, yes? be i correct? i must be a genius!");
						}
					}
				});

				layers.add(label, new Integer(2));
				r++;
				z++;
			}
		}
	}
}
