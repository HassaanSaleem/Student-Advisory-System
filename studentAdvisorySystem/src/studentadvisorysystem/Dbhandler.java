/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentadvisorysystem;
import java.sql.*;
import java.sql.SQLException;

/**
 *
 * @author muaaz
 */
public class Dbhandler {
       private Connection con; //connection type variable
    private Statement st;
    public PreparedStatement stt; //for prepared statement used later
    private ResultSet rs;
    public Dbhandler()
    {try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
             st = con.createStatement();
            System.out.println("connected");
             }catch(ClassNotFoundException | SQLException ex){
        System.out.println("error :"+ ex);
    }
    }
    public void create_database () throws SQLException
    {
        String query;
        query="CREATE DATABASE IF NOT EXISTS AdvisorySystem";
        st.executeUpdate(query);

        System.out.println("database has successfully been created");
    }
    public void create_table () throws SQLException
    {
        
        String query = "CREATE TABLE IF NOT EXISTS AdvisorySystem.Student("
                + "student_id INT(5) NOT NULL AUTO_INCREMENT,"
                + "name VARCHAR(45) NOT NULL,"
                + "email VARCHAR(50) DEFAULT NULL,"
                + "PRIMARY KEY (student_id)"
                + ");";

        st.executeUpdate(query);

        System.out.println("Student table has successfully been created");
    }
    public void insert_data() throws SQLException
     {
        String qurey="INSERT INTO AdvisorySystem.Student (student_id,name,email) VALUES(3,'Muaaz','muaazanwar@gmail.com')";
        st.executeUpdate(qurey);
        System.out.println("inserted");
         
     }
    public void insert_Prepared_Statement() throws SQLException
    {
        String query;
        query="insert into AdvisorySystem.Student (student_id,name,email )" +"VALUES(?, ?, ?)";
       stt=con.prepareStatement(query);
      //stt is the prepared statement type variable declare in the class
       stt.setInt(1,7);
       stt.setString(2,"Ali");
       stt.setString(3,"Alibinarshad@yahoo.com"); 
       stt.setInt(1,4);
       stt.setString(2, "hassaan");
       stt.setString(3,"hassansaleem@hotmail.com");
       
       stt.execute();
       stt.close();
            }
    public void getdata() throws SQLException
        {
            
                String query;
                query = "SELECT * FROM AdvisorySystem.Student";
                rs=st.executeQuery(query);
                System.out.println("Records from database:");
                while(rs.next()){
                    String name=rs.getString("name");
                   //’name’ is the attribute of table persons 
                    String email=rs.getString("email");
                   //rs is the result set variable declare in class
                    System.out.println(name);
                    System.out.println(email);
                    
                }       
        }
        public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Dbhandler connect =new Dbhandler();
        connect.create_database();
        connect.create_table();
        connect.insert_Prepared_Statement();
        connect.insert_data();
        connect.getdata();
    }

    
}
