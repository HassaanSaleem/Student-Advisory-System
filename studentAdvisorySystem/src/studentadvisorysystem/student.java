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
public class student
{
    private int stRedNo;
    private String sec;
    private int batch;
    private String name;
    private String gender;
    private int age;
    private float [] sgpa=new float[8];
    private Vector<teacher> tr=new Vector();
    Vector<course> cr=new Vector();

    student(int id,String sec,String name,String gender,int age,float sgpa1,float sgpa2,float sgpa3)
    {
        this.stRedNo=id;
        this.sec=sec;
        this.age=age;
        this.batch=2017;
        this.gender=gender;
        this.name=name;
        this.sgpa[0]=sgpa1;
        this.sgpa[1]=sgpa2;
        this.sgpa[2]=sgpa3;
    }
    
    public void AssignTeacher(teacher e)
    {
        tr.add(e);
    }
    
    public void Assigncourse(course e)
    {
        cr.add(e);
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStRedNo(int stRedNo) {
        this.stRedNo = stRedNo;
    }

    public void setSec(String sec) {
        this.sec = sec;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public String getSec() {
        return sec;
    }

    public int getBatch() {
        return batch;
    }

    public int getStRedNo() {
        return stRedNo;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    
    public float getsgpa1()
    {
        return sgpa[0];
    }
    
    public float getsgpa2()
    {
        return sgpa[1];
    }
    
    public float getsgpa3()
    {
        return sgpa[2];
    }
}
