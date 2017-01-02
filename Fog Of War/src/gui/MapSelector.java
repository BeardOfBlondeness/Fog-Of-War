package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class MapSelector extends JFrame {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	DefaultListModel<String> model = new DefaultListModel();
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JList list = new JList(model);
	 static JMenuItem item = new JMenuItem("Delete");
	 JScrollPane scrollpane;
	 static JPopupMenu menu = new JPopupMenu("Popup");
	 
	  @SuppressWarnings({ })
	  
	public MapSelector() {
        
	    super("Select Save");
	    menu.add(item);
	    int i = 1;
	   
	    getData.getIntNoCondition("max(mapID)", "map");
	    int max = getData.value;
		String categories[] = new String[max];
		 String realVal[] = new String[max];
	    do {
	    new getData("saveLocation", "map", "mapID = " + i);
	    String saveName = getData.val;
	    realVal[i-1] = getData.val;
	    System.out.println(getData.val);
	    int idx = saveName.replaceAll("\\\\", "/").lastIndexOf("/");
	    System.out.println(idx);
	   saveName = saveName.substring(idx + 1, saveName.length());
	   System.out.println(saveName);
	   categories[i-1] = saveName;
	   model.addElement(categories[i-1]);
	   i++;
	   
	    } while (i <= max);
	    
	    setSize(300, 200);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);

	
	    
	    scrollpane = new JScrollPane(list);
		setLocationRelativeTo(null);
	    getContentPane().add(scrollpane, BorderLayout.CENTER);
	    setVisible(true);
	    
	    list.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {  	
					if (SwingUtilities.isLeftMouseButton(event) || event.isControlDown())      {
					if (event.getClickCount() == 2) {
					    System.out.println("double clicked");
					    String listVal = list.getSelectedValue().toString();
					    selected(listVal, categories, realVal);
					  }
					}
					 if (SwingUtilities.isRightMouseButton(event) || event.isControlDown())      {
			                System.out.println("Right Worked");
			                menu.show(event.getComponent(), event.getX(), event.getY());
			                item.addActionListener(new ActionListener() {
				        	      public void actionPerformed(ActionEvent e) {
				        	        System.out.println("Menu item Test1");
				        	        int index = list.getSelectedIndex();
				        	        if(index >= 0){ //Remove only if a particular item is selected
				        	        	 System.out.println(index);
				        	        	 deleteItem(model.getElementAt(index), categories, realVal);
				        	            model.removeElementAt(index);
				        	           
				        	        }
				        	      }
				        	    });
			            }
				}
			});
	  }


	  
	  static int x = -1;
	  public static void selected(String listVal, String[] categories, String[] realVal) {
		  System.out.println(listVal);
		  for(int z = 0; z < categories.length; z++) {
			  if (listVal == categories[z]) {
				  x = z;
			  }
			 
		  }
		  if(x == -1) {
			  System.out.println("Error, cannot find file specified at " + listVal);
		  }
		  System.out.println(realVal[x]);
		  new loadMap(realVal[x]);
	  }
	  

	  public static void deleteItem(String indexVal, String[] categories, String[] realVal) {
		  for(int z = 0; z < categories.length; z++) {
			  if (indexVal== categories[z]) {
				  x = z;
			  }
			 
		  }
		  if(x == -1) {
			  System.out.println("Error, cannot find file specified at " + indexVal);
		  }
		  new DeleteMap(realVal[x]);
	  }
	}


