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
public class student extends person {
    private int stRedNo;
    private char sec;
    private int batch;

    public void setStRedNo(int stRedNo) {
        this.stRedNo = stRedNo;
    }

    public void setSec(char sec) {
        this.sec = sec;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public char getSec() {
        return sec;
    }

    public int getBatch() {
        return batch;
    }

    public int getStRedNo() {
        return stRedNo;
    }
    
    
}
