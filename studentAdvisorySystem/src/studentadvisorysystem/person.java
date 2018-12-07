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
public class person {
    
    private String name;
    private char gender;
    private String Address;
    private String age;
    private String NIC;
    private String CoNo;

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setCoNo(String CoNo) {
        this.CoNo = CoNo;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public String getAge() {
        return age;
    }

    public String getCoNo() {
        return CoNo;
    }

    public char getGender() {
        return gender;
    }

    public String getNIC() {
        return NIC;
    }

    public String getName() {
        return name;
    }
    
       
}
