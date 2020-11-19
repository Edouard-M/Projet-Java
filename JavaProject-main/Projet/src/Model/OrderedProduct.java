/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Model.DAO.getConnection;
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
            boolean exist=false;
            Connection con = getConnection();
            
            PreparedStatement statement = con.prepareStatement("SELECT * FROM OrderedProduct ORDER BY OrderNumber");
            ResultSet result = statement.executeQuery();
            /*while(result.next())
            {
                if(name.equals(result.getString("name")))
                    exist = true;
            }
            if(exist == false)
            {*/
                PreparedStatement insert = con.prepareStatement("INSERT INTO OrderedProduct (OrderNumber, name,quantity, price) VALUES ('"+OrderNumber+"', '"+name+"', '"+quantity+"', '"+price+"')");
                insert.executeUpdate();
            //}

        } catch(Exception e){System.out.println(e);}
    }
    
}
