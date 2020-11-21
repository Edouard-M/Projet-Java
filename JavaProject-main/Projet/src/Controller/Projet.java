
package Controller;
import static Model.DAO.*;
import Model.*;
import View.Window;
import View.Window2;
import java.sql.*;
import java.util.ArrayList;

/**
 * @author Edouard MIGNIEN
 * @author Clément BOUVARD
 */
public class Projet
{
    public static void main(String[] args) throws Exception
    {
        dropAllTable();
        createAllTable();
        
        testDB();
        
        //selectAllProduct();
        
       //Window2 wind = new Window2();
        Window wind = new Window();
    }
    
    public static void testDB() throws Exception
    {
        Product banane = new Product("Banane", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "BananeImg.jpg");
        Product banane2 = new Product("Banane1", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "BananeImg.jpg");
        Product banane3 = new Product("Banane2", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "BananeImg.jpg");
        //Product banane4 = new Product("Banane3", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "image");
        //Product banane5 = new Product("Banane4", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "image");
        //Product banane6 = new Product("Banane5", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "image");
        //Product banane7 = new Product("Banane6", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "image");
        //Product banane8 = new Product("Banane7", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "image");
        //Product banane9 = new Product("Banane8", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "image");
        Product kiwi = new Product("Kiwi", "Fruit", "Un bon gros Kiwi !", 3.99, 35, null, "KiwiImg.jpg");
        Product kiwi2 = new Product("Kiwi2", "Fruit", "Un bon gros Kiwi !", 3.99, 35, null, "KiwiImg.jpg");
        Customer Marc = new Customer("Marc", "Dampierre", 23, "0640787637", " 6 rue jean mermoz rueil-malmaison 92500", "marc.damp@gmail.com", "pass123");
        Employee Fred =new Employee("Fred", "Blanchard", 33, "0678964572", "3 rue des moulins maison lafittes", "fredbla@laposte.net", "pass123");
        OrderedProduct OrderedBanane= new OrderedProduct(1,1,"Banane");
        OrderedProduct OrderedKiwi= new OrderedProduct(1,1,"Kiwi");
        Discount DiscountBanane = new Discount("DiscountBanane", 10, 9);
        kiwi.addDiscount(10, 25);
    }
    
    public static void dropAllTable()
    {
        query("DROP TABLE Product");
        query("DROP TABLE Discount");
        query("DROP TABLE Customer");
        query("DROP TABLE Employee");
        query("DROP TABLE OrderedProduct");
    }
    
    
}