
package db;

import java.sql.Connection;
import java.sql.DriverManager;


public class Db {
    private static Connection conn = null;
     public static Connection java_db() throws Exception{
        
        if(conn == null){
            Class.forName("org.sqlite.JDBC");
          conn = DriverManager.getConnection("jdbc:sqlite:mydb.sqlite");
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory?","root", "root");
            
             //C:\\Users\\mount\\Documents\\NetBeansProjects\\Employee Payroll\\
            System.out.println("Connection success");
        }
       
          
            return conn;
            
       
        }
   
    
}
