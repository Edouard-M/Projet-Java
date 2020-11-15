
package View;

import static Model.DAO.*;
import Model.Product;
import java.awt.Color;
import java.awt.GridLayout;
import static java.awt.SystemColor.window;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * @author Edouard MIGNIEN
 * @author Clément BOUVARD
 */
public class Window extends JFrame
{
    final int WIDTH_WINDOW = 800;
    final int HEIGHT_WINDOW = 400;
    
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
        buildPanel();
        setVisible(true);
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
        
        table.setBackground(Color.BLACK);
        table.setForeground(Color.WHITE);
        
        scrollTable.setBackground(Color.WHITE);
        scrollTable.setForeground(Color.WHITE);
        
        //URL url = window.class.getResource("/res/images/animated.gif");
        String image = "path.gif";
        imageIcon = new ImageIcon("src/"+ image);
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
    
    
}