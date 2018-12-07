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
public class TokyoUniversity {
    private String name;
    private String location;
    private String HECregistrationNumber;
    private Vector<Departments> dept;               //composed
    private Vector<degProg> degree;  //composition 

    public void setHECregistrationNumber(String HECregistrationNumber) {
        this.HECregistrationNumber = HECregistrationNumber;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHECregistrationNumber() {
        return HECregistrationNumber;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
    
    
}
