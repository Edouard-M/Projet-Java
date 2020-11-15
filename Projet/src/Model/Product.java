
package Model;

import static Model.DAO.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 * @author Edouard MIGNIEN
 * @author Clément BOUVARD
 */
public class Product
{
    private String name;
    private String category;
    private String description;
    private double price;
    private int stock;
    private String image;
    private Discount discount;
    
    public Product(String Name, String Category, String Description, double Price, int Stock, Discount Discount, String Image) throws Exception
    {
        name = Name;
        category = Category;
        description = Description;
        price = Price;
        stock = Stock;
        discount = Discount;
        image = Image;
        insertProduct();
    }
    
    public void addDiscount(int discountQuantity, double discountPrice) throws Exception
    {
        discount = new Discount(name, discountQuantity, discountPrice);
    }
    
    public void insertProduct() throws Exception
    {
        try{
            boolean exist=false;
            Connection con = getConnection();
            
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Product ORDER BY name");
            ResultSet result = statement.executeQuery();
            /*while(result.next())
            {
                if(name.equals(result.getString("name")))
                    exist = true;
            }
            if(exist == false)
            {*/
                PreparedStatement insert = con.prepareStatement("INSERT INTO Product (name, category, description, price, stock, image) VALUES ('"+name+"', '"+category+"', '"+description+"', '"+price+"', '"+stock+"', '"+image+"')");
                insert.executeUpdate();
            //}

        } catch(Exception e){System.out.println(e);}
    }
    
    
    
    public String getName()
    {
        return name;
    }
    public String getCategory()
    {
        return category;
    }
    public String getDescription()
    {
        return description;
    }
    public double getPrice()
    {
        return price;
    }
    public int getStock()
    {
        return stock;
    }
    public Discount getDiscount()
    {
        return discount;
    }
    
    
}