
package Controller;
import static Model.DAO.*;
import Model.*;
import View.Window;
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
        
        //getConnection();
        createTableProduct();
        createTableDiscount();
        createTableCustomer();
        createTableEmployee();
        createTableOrderedProduct();
        Product banane = new Product("Banane", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "image");
        Product banane2 = new Product("Banane1", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "image");
        Product banane3 = new Product("Banane2", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "image");
        Product banane4 = new Product("Banane3", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "image");
        Product banane5 = new Product("Banane4", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "image");
        Product banane6 = new Product("Banane5", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "image");
        Product banane7 = new Product("Banane6", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "image");
        Product banane8 = new Product("Banane7", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "image");
        Product banane9 = new Product("Banane8", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "image");
        Product kiwi = new Product("Kiwi", "Fruit", "Un bon gros Kiwi !", 3.99, 35, null, "image");
        Customer Marc = new Customer("Marc", "Dampierre", 23, "0640787637", " 6 rue jean mermoz rueil-malmaison 92500", "marc.damp@gmail.com", "pass123");
        Employee Fred =new Employee("Fred", "Blanchard", 33, "0678964572", "3 rue des moulins maison lafittes", "fredbla@laposte.net", "pass123");
        OrderedProduct OrderedBanane= new OrderedProduct(1,1,"Banane");
        kiwi.addDiscount(10, 25);
        
        selectAllProduct();
        
        
       Window wind = new Window();
    }
}