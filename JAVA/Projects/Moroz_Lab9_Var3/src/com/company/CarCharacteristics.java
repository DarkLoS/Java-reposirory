package com.company;
import java.text.*;
interface InterfaceCarCharacteristics {
    String show();
    void setMileage(String  mileage);
    void setCapacity(String capacity);
    String getMileage();
    String getCapacity();
}
public class CarCharacteristics extends  CarCommon implements  InterfaceCarCharacteristics{
    private String mileage;
    private String capacity;
    public CarCharacteristics(){}
    public CarCharacteristics(String mark, String date,String  mileage,String capacity)throws ParseException{
        super(mark,date);
        this.mileage= mileage;
        this.capacity=capacity;
    }
    public String getMileage(){
        return   mileage;
    }
    public String getCapacity(){
        return  capacity;
    }
    public void setMileage(String  mileage){
        this.mileage= mileage;
    }
    public void setCapacity(String capacity){
        this.capacity=capacity;
    }
    public String show(){
       return "mark: "+getMark()+" date: "+getDate()+" mileage: "+ mileage+" capacity: "+capacity;
    }
}