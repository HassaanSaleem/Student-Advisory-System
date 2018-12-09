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
    private int duration;

    
    degProg(String name)
    {
        this.dgName=name;
        this.duration=4;
    }

    public void setDgName(String dgName) {
        this.dgName = dgName;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDgName() {
        return dgName;
    }

    public int getDuration() {
        return duration;
    }    
}
