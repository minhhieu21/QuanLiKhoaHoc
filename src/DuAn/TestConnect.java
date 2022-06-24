/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DuAn;
import java.sql.*;

/**
 *
 * @author asus
 */
public class TestConnect {

    /**
     * @param args the command line arguments
     */
     public static void main(String []agrs){
    Connection connec;
    String url;
    try{
        url= "jdbc:sqlserver://localhost:1433;databaseName=EduSys;user=sa;password=minhhieu21";
        //url= "jdbc:mysql://localhost:3306/edusys";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //Class.forName("com.mysql.jdbc.Driver");//my sql
        connec= DriverManager.getConnection(url);
        System.out.println("ok");
    }catch(Exception ex){
            ex.printStackTrace();
    }
  }  
}
