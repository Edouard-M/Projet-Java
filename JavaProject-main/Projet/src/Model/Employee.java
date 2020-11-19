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
public class Employee extends Person
{

    public Employee(String name, String firstName, int age, String phone, String address, String email, String password) throws Exception
    {
        super(name, firstName, age, phone, address, email, password);
        insertEmployee();
    }
        public void insertEmployee() throws Exception
    {
        try{
            boolean exist=false;
            Connection con = getConnection();
            
           PreparedStatement statement = con.prepareStatement("SELECT * FROM Employee ORDER BY email");
           ResultSet result = statement.executeQuery();
            /*while(result.next())
            {
                if(name.equals(result.getString("name")))
                    exist = true;
            }
            if(exist == false)
            {*/
                PreparedStatement insert = con.prepareStatement("INSERT INTO Employee (name, firstName, age, phone, address, email, password) VALUES ('"+name+"', '"+firstName+"', '"+age+"', '"+phone+"', '"+address+"', '"+email+"', '"+password+"')");
                insert.executeUpdate();
            //}

        } catch(Exception e){System.out.println(e);}
    }
    
}
