/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentadvisorysystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author salee
 */
public class StudentAdvisorySystem {

    static Vector<student> std=new Vector();
    static Vector<teacher> tr=new Vector();
    static Vector<course> cr=new Vector();
    static TokyoUniversity uni;
       
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException 
    {
        
        Connection con;
        Statement st=null; 
        ResultSet rs,rs2,rs3;
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","");
                st = con.createStatement();
                System.out.println("connected");
            }
            catch(ClassNotFoundException | SQLException ex)
            {
                System.out.println("error :"+ ex);
            }
        
            String query,query2,query3;    
            query = "SELECT * FROM AdvisorySystem.Stdata";
            query2 = "SELECT * FROM AdvisorySystem.teacher";
            query3 = "SELECT * FROM AdvisorySystem.course";
            rs=st.executeQuery(query);
            while(rs.next())                        //Students
            {
                int id=rs.getInt("ID");
                int age=rs.getInt("age");
                float sgpa1=rs.getFloat("sgpa1");
                float sgpa2=rs.getFloat("sgpa2");
                float sgpa3=rs.getFloat("sgpa3");
                String sex=rs.getString("sex");
                //’name’ is the attribute of table persons 
                String name=rs.getString("Name");
                String section=rs.getString("section");
                //rs is the result set variable declare in class         
                
                std.add(new student(id,section,name,sex,age,sgpa1,sgpa2,sgpa3));
            }
           
            int count=1;
            rs2=st.executeQuery(query2);
            while(rs2.next())                   //teachers
            {
                int id=count++; 
                String name=rs2.getString("first_name");
                
                tr.add(new teacher(id,name));
            
            }
            
            rs3=st.executeQuery(query3);
            while(rs3.next())                               //course
            { 
                String code=rs3.getString("code");
                String name=rs3.getString("name");
                
                cr.add(new course(code,name));
            
            }
            
            uni=new TokyoUniversity(std,tr,cr);
            
            for(int x=0;x<145;x++)            //Assigning Teachers To Student for current semester
                for(int y=0;y<5;y++)
                {
                    std.elementAt(x).AssignTeacher(new teacher(tr.elementAt(4).getStRedNo(),tr.elementAt(4).getName()));
                }
            
            for(int x=0;x<145;x++)            //Assigning student To teacher for current semester
            {
                if(std.elementAt(x).getSec()=="A")
                    for(int y=0;y<5;y++)
                        tr.elementAt(x).AssignStudent(new student(std.elementAt(y).getStRedNo(),std.elementAt(y).getSec(),std.elementAt(y).getName(),
                        std.elementAt(y).getGender(),std.elementAt(y).getAge(),std.elementAt(y).getsgpa1(),std.elementAt(y).getsgpa3(),std.elementAt(y).getsgpa1())
                        );
                
                if(std.elementAt(x).getSec()=="B")
                    for(int y=5;y<10;y++)
                        tr.elementAt(x).AssignStudent(new student(std.elementAt(y).getStRedNo(),std.elementAt(y).getSec(),std.elementAt(y).getName(),
                        std.elementAt(y).getGender(),std.elementAt(y).getAge(),std.elementAt(y).getsgpa1(),std.elementAt(y).getsgpa3(),std.elementAt(y).getsgpa1())
                        );
                
                if(std.elementAt(x).getSec()=="C")
                    for(int y=10;y<15;y++)
                        tr.elementAt(x).AssignStudent(new student(std.elementAt(y).getStRedNo(),std.elementAt(y).getSec(),std.elementAt(y).getName(),
                        std.elementAt(y).getGender(),std.elementAt(y).getAge(),std.elementAt(y).getsgpa1(),std.elementAt(y).getsgpa3(),std.elementAt(y).getsgpa1())
                        );
                
                if(std.elementAt(x).getSec()=="D")
                    for(int y=15;y<20;y++)
                        tr.elementAt(x).AssignStudent(new student(std.elementAt(y).getStRedNo(),std.elementAt(y).getSec(),std.elementAt(y).getName(),
                        std.elementAt(y).getGender(),std.elementAt(y).getAge(),std.elementAt(y).getsgpa1(),std.elementAt(y).getsgpa3(),std.elementAt(y).getsgpa1())
                        );
            }
            
            
            for(int x=0;x<145;x++)              //assign courses to students
                for(int y=0;y<10;y++)
                    std.elementAt(y).Assigncourse(new course(cr.elementAt(y).crId,cr.elementAt(y).crName));
            
            
            for(int x=0;x<145;x++)              //assign courses to teacher
                for(int y=0;y<10;y++)
                    tr.elementAt(y).Assigncourse(new course(cr.elementAt(y).crId,cr.elementAt(y).crName));
            
       
            Login user=new Login();
            user.setVisible(true);
            
    }
    
}
