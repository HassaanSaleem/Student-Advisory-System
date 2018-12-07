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
public class Departments {
    
    private String deptName;
    private String deptId;
    private Vector<student> std;   //Agression

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setStd(Vector<student> std) {
        this.std = std;
    }

    public String getDeptId() {
        return deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public Vector<student> getStd() {
        return std;
    }
    
}
