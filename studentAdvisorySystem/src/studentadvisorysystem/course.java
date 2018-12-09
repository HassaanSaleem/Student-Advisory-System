/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentadvisorysystem;

/**
 *
 * @author Hassaan
 */
public class course 
{
    String crId;
    String crName;
    
    course(String id,String name)
    {
        this.crId=id;
        this.crName=name;
    }

    public String getCrId() {
        return crId;
    }

    public String getCrName() {
        return crName;
    }

    public void setCrId(String crId) {
        this.crId = crId;
    }

    public void setCrName(String crName) {
        this.crName = crName;
    }
   
    
}