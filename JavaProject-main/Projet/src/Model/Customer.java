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
public class Customer extends Person
{
    private int fidelityPoint;

    public Customer(String name, String firstName, int age, String phone, String address, String email, String password) throws Exception
    {
        super(name, firstName, age, phone, address, email, password);
        fidelityPoint=0;
        insertCustomer();
    }
    
        public void insertCustomer() throws Exception
    {
        try{
            boolean exist=false;
            Connection con = getConnection();
            
           PreparedStatement statement = con.prepareStatement("SELECT * FROM Customer ORDER BY email");
           ResultSet result = statement.executeQuery();
            /*while(result.next())
            {
                if(name.equals(result.getString("name")))
                    exist = true;
            }
            if(exist == false)
            {*/
                PreparedStatement insert = con.prepareStatement("INSERT INTO Customer (name, firstName, age, phone, address, email, password, fidelityPoint) VALUES ('"+name+"', '"+firstName+"', '"+age+"', '"+phone+"', '"+address+"', '"+email+"', '"+password+"', '"+fidelityPoint+"')");
                insert.executeUpdate();
            //}

        } catch(Exception e){System.out.println(e);}
    }
    
}
