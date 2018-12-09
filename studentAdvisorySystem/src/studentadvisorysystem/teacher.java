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
public class teacher {
    private int stRedNo;
    private String name;
    private Vector<student> std=new Vector();
    Vector<course> cr=new Vector();
    
    teacher(int id,String name)
    {
        this.stRedNo=id;
        this.name=name;
    }
    
    public void Assigncourse(course e)
    {
        cr.add(e);
    }
    
    public void AssignStudent(student e)
    {
        this.std.add(e);
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setStRedNo(int stRedNo) {
        this.stRedNo = stRedNo;
    }

    public String getName() {
        return name;
    }

    public int getStRedNo() {
        return stRedNo;
    }
     
}
