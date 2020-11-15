
package Model;

import static Model.DAO.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * @author Edouard MIGNIEN
 * @author Clément BOUVARD
 */
public class Discount
{
    private int quantity;
    private double price;
    private String name;
    
    public Discount(String Name, int Quantity, double Price) throws Exception
    {
        quantity = Quantity;
        price =Price; 
        name = Name;
        insertDiscount();
    }
    
    public void insertDiscount() throws Exception
    {
        try{
            boolean exist=false;
            Connection con = getConnection();
            
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Discount ORDER BY name");
            ResultSet result = statement.executeQuery();
            /*while(result.next())
            {
                if(name.equals(result.getString("name")))
                    exist = true;
            }
            
            if(exist == false)
            { */
                PreparedStatement posted = con.prepareStatement("INSERT INTO Discount (name, quantity, price) VALUES ('"+name+"', '"+quantity+"', '"+price+"')");
                posted.executeUpdate();
            //}
        } catch(Exception e){System.out.println(e);}
    }
}