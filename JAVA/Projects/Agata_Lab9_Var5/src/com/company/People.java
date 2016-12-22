package com.company;
import java.util.*;
import java.text.*;
public abstract class People implements java.io.Serializable{
    private String name;
    private String address;
    private Date date;
    private transient SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd", Locale.ENGLISH);
    public People(){}
    public People(String name,String address, String date)throws ParseException{
        this.address=address;
        this.name=name;
        this.date=sdf.parse(date);
    }
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public String getDate(){
        return sdf.format(date);
    }
    public void setName(String name){
        this.name=name;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public void setDate(Date date){
        this.date=date;
    }
    public String show(){return "";}
}