/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author filippocrinzi
 */
public class Client {
    private String name;
    private String referent;
    private String phoneNumber;
    private String email;
    private String adress;
    
    public Client(String name, String referent, String phoneNumber, String email, String adress){
        this.name = name;
        this.referent = referent;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.adress = adress;
    }
    //setter
    public void setName(String name){
        this.name = name;
    }
    public void setReferent(String referent){
        this.referent = referent;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setAdress(String adress){
        this.adress = adress;
    }
    //getter
    public String getName(){
        return name;
    }
    public String getReferent(){
        return referent;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public String getEmail(){
        return email;
    }
    public String getAdress(){
        return adress;
    }
}
