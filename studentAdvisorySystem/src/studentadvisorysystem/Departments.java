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
    private int deptId;
    protected Vector<student> std;
    protected Vector<teacher> tr;
    protected Vector<course> cr;
    
    Departments(int id,String name,Vector<student> std,Vector<teacher> tr,Vector<course> cr)
    {
        this.deptId=id;
        this.deptName=name;
        this.std=std;
        this.tr=tr;
        this.cr=cr;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getDeptId() {
        return deptId;
    }

    public String getDeptName() {
        return deptName;
    }
    
}
