package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class Settings {
	static JFrame f = new JFrame("Settings");
	static JLayeredPane layers = new JLayeredPane();
	public Settings() throws IOException {
		layers.setPreferredSize(new Dimension(800, 600));
		JLabel settingsbg = new JLabel(new ImageIcon(ImageIO.read(new File("res/settingsbg.png"))));
		JMenuBar menubar = new JMenuBar();
		JMenu textures = new JMenu("Textures");
		JMenu maps = new JMenu("Maps");
		JMenu help = new JMenu("Help");
		
		
		JMenuItem maptex = new JMenuItem("View most used textures");
		JMenuItem mapgenre = new JMenuItem("Change map genres");
		
		JMenuItem view = new JMenuItem("View Textures");
		JMenuItem change = new JMenuItem("Texture Locations");
		
		view.setToolTipText("Exit application");	
		
		view.addActionListener((ActionEvent event) -> {
			System.exit(0);
		});
		
		help.addMenuListener(new MenuListener() {

	        @Override
	        public void menuSelected(MenuEvent e) {
	            System.out.println("menuSelected");
	            try {
					helpPage();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

	        }

			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
	    });
		layers.add(settingsbg, new Integer(1));
		f.setSize(800, 600);
		
		textures.add(view);
		textures.add(change);
		maps.add(maptex);
		maps.add(mapgenre);
		
		menubar.add(textures);
		menubar.add(maps);
		menubar.add(help);
		settingsbg.setBounds(0, 0, 800, 600);
		
		f.setJMenuBar(menubar);
		f.setResizable(false);
		
		f.getContentPane().add(layers);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.pack();
		
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		
	}
	
	public static void helpPage() throws IOException {
		JLabel desc1 = new JLabel("• To Create a map, return to the main menu and press 'new map'");
		JLabel desc1bg = new JLabel();
		desc1.setFont(new Font("Arial Black", Font.PLAIN, 16));
		desc1.setForeground(Color.white);
		desc1bg.setIcon(new ImageIcon(ImageIO.read(new File("res/helpbg.png"))));
		desc1bg.setBounds(50, 50, 700, 60);
		desc1.setBounds(90, 50, 700, 60);
		layers.add(desc1bg, new Integer(2));
		layers.add(desc1, new Integer(3));
		
		JLabel desc2 = new JLabel("• To Load a saved map, return to the main menu and press 'Load map'");
		JLabel desc2bg = new JLabel();
		desc2.setFont(new Font("Arial Black", Font.PLAIN, 16));
		desc2.setForeground(Color.white);
		desc2bg.setIcon(new ImageIcon(ImageIO.read(new File("res/helpbg.png"))));
		desc2bg.setBounds(50, 140, 700, 60);
		desc2.setBounds(90, 140, 700, 60);
		layers.add(desc2bg, new Integer(2));
		layers.add(desc2, new Integer(3));
		
		JLabel desc3 = new JLabel("• The genre selection is to have an easier time finding old maps");
		JLabel desc3bg = new JLabel();
		desc3.setFont(new Font("Arial Black", Font.PLAIN, 16));
		desc3.setForeground(Color.white);
		desc3bg.setIcon(new ImageIcon(ImageIO.read(new File("res/helpbg.png"))));
		desc3bg.setBounds(50, 230, 700, 60);
		desc3.setBounds(90, 230, 700, 60);
		layers.add(desc3bg, new Integer(2));
		layers.add(desc3, new Integer(3));
		
		JLabel desc4 = new JLabel("<html>• After exporting the maps during the creation window, you may print <br> them to use in a tabletop game, or upload them to a  site such as roll20</html>");
		JLabel desc4bg = new JLabel();
		desc4.setFont(new Font("Arial Black", Font.PLAIN, 16));
		desc4.setForeground(Color.white);
		desc4bg.setIcon(new ImageIcon(ImageIO.read(new File("res/helpbg.png"))));
		desc4bg.setBounds(50, 320, 700, 60);
		desc4.setBounds(90, 320, 700, 60);
		layers.add(desc4bg, new Integer(2));
		layers.add(desc4, new Integer(3));
		
		JLabel desc5 = new JLabel("<html>• Anything made in this program belongs to the creator, <br> I do not take credit for anything anybody else creates </html>");
		JLabel desc5bg = new JLabel();
		desc5.setFont(new Font("Arial Black", Font.PLAIN, 16));
		desc5.setForeground(Color.white);
		desc5bg.setIcon(new ImageIcon(ImageIO.read(new File("res/helpbg.png"))));
		desc5bg.setBounds(50, 410, 700, 60);
		desc5.setBounds(90, 410, 700, 60);
		layers.add(desc5bg, new Integer(2));
		layers.add(desc5, new Integer(3));
	}
}
