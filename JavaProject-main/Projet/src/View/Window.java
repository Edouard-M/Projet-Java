
package View;

import static Model.DAO.*;
import Model.Product;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import static java.awt.SystemColor.window;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * @author Edouard MIGNIEN
 * @author Clément BOUVARD
 */
public class Window extends JFrame
{
    final int WIDTH_WINDOW = 800;
    final int HEIGHT_WINDOW = 800;
    
    private JPanel panel;
    private JTable table;
    private JLabel label;
    private ImageIcon imageIcon;
    JScrollPane scrollTable;
    
    
    public Window() throws Exception
    {
        setTitle("Table Products");
        setSize(WIDTH_WINDOW, HEIGHT_WINDOW);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanelProduit();
        setVisible(true);
    }
    
    public void buildPanelProduit() throws Exception
    {
        panel = new JPanel();
        
        String [] colNames = getCol("Product");
        System.out.println("test 1");
        String [][] data = getLines("Product");
        System.out.println("test 2");
        

        table = new JTable(data,colNames);
        scrollTable = new JScrollPane(table);
        table.getColumnModel().getColumn(6).setCellRenderer(new ImageCellRenderer());
        //URL url = window.class.getResource("/res/images/animated.gif");
        imageIcon = new ImageIcon("src/path.gif");
        label = new JLabel(imageIcon);
        
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        
        panel1.add(label);
        panel2.add(scrollTable);
        panel.setLayout(new GridLayout(3,1));
        
        
        panel.add(panel1);
        panel.add(panel2);
        add(panel);
        //add(label);
        //add(scrollTable);
        
        //panel.add(scrollTable);
        //add(panel);
    }
     public void buildPanel() throws Exception
    {
        panel = new JPanel();
        
        String [] colNames = getCol("Product");
        System.out.println("test 1");
        String [][] data = getLines("Product");
        System.out.println("test 2");
        

        table = new JTable(data,colNames);
        scrollTable = new JScrollPane(table);
       
        //URL url = window.class.getResource("/res/images/animated.gif");
        imageIcon = new ImageIcon("src/path.gif");
        label = new JLabel(imageIcon);
        
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        
        panel1.add(label);
        panel2.add(scrollTable);
        panel.setLayout(new GridLayout(3,1));
        
        
        panel.add(panel1);
        panel.add(panel2);
        add(panel);
        //add(label);
        //add(scrollTable);
        
        //panel.add(scrollTable);
        //add(panel);
    }
     
    public final static class ImageCellRenderer extends DefaultTableCellRenderer {
 
		@Override
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
 
			Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
 
			JLabel label = (JLabel)component;
			String cheminImage = String.valueOf(value);
 
			ImageIcon icon = new ImageIcon(cheminImage);
 
			if ( icon.getImageLoadStatus()==java.awt.MediaTracker.COMPLETE ) {
				label.setIcon(icon);
				table.setRowHeight(row, icon.getIconHeight());
			}
			else {
				label.setIcon(null);
				table.setRowHeight(row, table.getRowHeight());
			}
			label.setText(""); // on efface le texte
 
                            System.out.println("TEST");
			return component;
		}
 
 
	}
    
    
}