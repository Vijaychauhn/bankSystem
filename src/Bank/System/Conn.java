package Bank.System;
import java.sql.*;
//import com.mysql.cj.jdbc.Driver;
public class Conn{
    Connection c;
    Statement s;

    public Conn() {
        try{
          //  Class.forName(com.mysql.cj.jdbc.Driver);
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Vvch572@@");
            s= c.createStatement();
        }catch (Exception e){
            System.out.println(e);
        }

    }
    
}
