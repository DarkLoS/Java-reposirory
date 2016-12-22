package com.company;
import java.text.*;
interface InterfaceDriver {
    String show();
    void setCategory(String category);
    void setExperience(String experience);
    String getCategory();
    String getExperience();
}
public class Driver extends  People implements  InterfaceDriver{
    private String category;
    private String experience;
    public Driver(){}
    public Driver(String name,String address, String date,String category,String experience)throws ParseException{
        super(name,address,date);
        this.category=category;
        this.experience=experience;
    }
    public String getCategory(){
        return  category;
    }
    public String getExperience(){
        return  experience;
    }
    public void setCategory(String category){
        this.category=category;
    }
    public void setExperience(String experience){
        this.experience=experience;
    }
    public String show(){
       return "name: "+getName()+" address: "+getAddress()+" date: "+getDate()+" category: "+category+" experience: "+experience;
    }
}