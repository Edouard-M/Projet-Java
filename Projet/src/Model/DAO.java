/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
/**
 * @author Edouard MIGNIEN
 * @author Clément BOUVARD
 */
public class DAO 
{
    private final Connection connect;
    
    public DAO() throws Exception
    {
        connect = getConnection();
    }
    
    public static Connection getConnection() throws Exception
    {
       try{ 
           String driver="com.mysql.cj.jdbc.Driver";
           String url = "jdbc:mysql://dbtest.cfuu3y9e8cbz.eu-west-3.rds.amazonaws.com:3306/DB";
           String username="admin";
           String password="Jolipuzzle";
           
           Class.forName(driver);
           Connection con= DriverManager.getConnection(url,username,password);
           //System.out.println("Connected to server !");
           return con;
        }
        catch (Exception e) 
        {
           System.out.println(e);
        }
        return null;
    }
    
    public static Product getProduct()
    {
        Product product;
        
        return null;
    }
    
    
    
    public static void createTableProduct() throws Exception
    {
        try
        {
            Connection con = getConnection();
            //PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS Product(id int NOT NULL AUTO_INCREMENT, name varchar(255), category varchar(255), description varchar(255), price double, stock int, discountId int, PRIMARY KEY(id))");
            PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS Product( name varchar(255), category varchar(255), description varchar(255), price double, stock int, discountId int, image varchar(255), PRIMARY KEY(name))");
            create.executeUpdate();
            //System.out.println("Succeed creation of Product Table");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    
    public static void createTableDiscount() throws Exception
    {
        try
        {
            Connection con = getConnection();
            //PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS Discount(id int NOT NULL AUTO_INCREMENT, name varchar(255), quantity int, price double, PRIMARY KEY(id))");
            PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS Discount( name varchar(255), quantity int, price double, PRIMARY KEY(name))");
            create.executeUpdate();
            //System.out.println("Succeed creation of Discount Table");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    
    
    public static ArrayList<String> selectAllProduct() throws Exception
    {
        try{
            Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Product ORDER BY name");
            
            ResultSet result = statement.executeQuery();
            
            ArrayList<String> array = new ArrayList<String>();
            while(result.next())
            {
                System.out.println(result.getString("name") + " | " + result.getString("category") + " | " + result.getString("description") + " | " + result.getString("price") + "€ | " + result.getString("stock") + " | " + result.getString("discountId"));
                
                array.add(result.getString("name"));
            }
            System.out.println("All records have been selected!");
            return array;
            
        }catch(Exception e){System.out.println(e);}
        return null;
    }
    
    public static int getRowSize(String tableName) throws Exception
    {
        ArrayList<String> array = new ArrayList<>();
        Connection con = getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM " + tableName);
        ResultSet result = statement.executeQuery();
        
        while(result.next())
        {
            array.add(result.getString("name"));
        }
      
        
        return array.size();
    }
    
    public static String[] getCol(String tableName) throws Exception
    {
        String[] col;
        
        Connection con = getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM " +tableName+ " ORDER BY name");
        ResultSet result = statement.executeQuery();
        ResultSetMetaData meta = result.getMetaData();
        
        col = new String[meta.getColumnCount()];
        
        for (int i = 0; i < meta.getColumnCount(); i++)
        {
            // Get a column name.
            col[i] = meta.getColumnLabel(i+1);
        }
        
        return col;
    }
    
    public static String[][] getLines(String tableName) throws Exception
    {
        int numRows = getRowSize(tableName);
        String[][] lines;
   
        
        Connection con = getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM " +tableName+ " ORDER BY name");
        ResultSet result = statement.executeQuery();
        ResultSetMetaData meta = result.getMetaData();
        
        lines = new String[numRows][meta.getColumnCount()];
        
        while(result.next())
        {
        for (int row = 0; row < numRows; row++)
         {
            for (int col = 0; col < meta.getColumnCount(); col++)
            {
                lines[row][col] = result.getString(col + 1);
            }
            // Go to the next row in the ResultSet.
            result.next();
         }
        }
        
        
        return lines;
    }
    
    
}