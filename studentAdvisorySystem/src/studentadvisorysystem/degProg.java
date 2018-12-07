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
public class degProg {
    
    private String dgName;
    private int degid;
    private int duration;
    private Vector<course> cr;

    public void setDegid(int degid) {
        this.degid = degid;
    }

    public void setCr(Vector<course> cr) {
        this.cr = cr;
    }

    public void setDgName(String dgName) {
        this.dgName = dgName;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Vector<course> getCr() {
        return cr;
    }

    public int getDegid() {
        return degid;
    }

    public String getDgName() {
        return dgName;
    }

    public int getDuration() {
        return duration;
    }    
}
