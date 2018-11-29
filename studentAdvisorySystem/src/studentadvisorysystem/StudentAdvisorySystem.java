/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentadvisorysystem;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author salee
 */
public class StudentAdvisorySystem {

    protected Login log;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
        
        Login log=new Login();
        log.setVisible(true);
       
    }
    
}
