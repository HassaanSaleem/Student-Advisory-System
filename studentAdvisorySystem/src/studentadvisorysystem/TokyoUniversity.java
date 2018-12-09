/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentadvisorysystem;

import java.util.Vector;

/**
 *
 * @author Hassaan
 */
public class TokyoUniversity 
{
    private String name;
    private String location;
    private int HECregistrationNumber;
    private Departments CS,ME;
    
    TokyoUniversity()
    {
        
    }
    
    TokyoUniversity(Vector<student> std,Vector<teacher> tr,Vector<course> cr)
    {
        this.name="Tokyo University";
        this.location="ABC,XYZ";
        this.HECregistrationNumber=2254;
        
        Vector<student> cstd=new Vector();  //CS Students
        Vector<student> mstd=new Vector();  //Mechanical Engineering Students

       for(int x=0;x<99;x++)
           cstd.add(std.elementAt(x));
       
       for(int x=99;x<=145;x++)
           mstd.add(std.elementAt(x));
        
       
        CS=new Departments(453,"CS",cstd,tr,cr);
        ME=new Departments(123,"CS",mstd,tr,cr);
    }

    public void setHECregistrationNumber(int HECregistrationNumber) {
        this.HECregistrationNumber = HECregistrationNumber;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHECregistrationNumber() {
        return HECregistrationNumber;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
    
    
}
