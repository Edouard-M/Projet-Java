/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Model.DAO.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author dwans
 */
public class OrderedProduct
{
    private int OrderNumber;
    private String name;
    private int quantity;
    private double price;
 

    public OrderedProduct(int OrderNumber, int quantity, String name) throws Exception
    {
        this.OrderNumber = OrderNumber;
        this.quantity = quantity;
        this.name = name;
        price=findprice();
        insertOrderedProduct();
    }
    public double findprice()
    {
        // A FAIRE
        return 0;
    }
    
      public void insertOrderedProduct() throws Exception
    {
        try{
            query("INSERT INTO OrderedProduct (OrderNumber, name,quantity, price) VALUES ('"+OrderNumber+"', '"+name+"', '"+quantity+"', '"+price+"')");
        } 
        catch(Exception e){System.out.println(e);}
    }
    
}
