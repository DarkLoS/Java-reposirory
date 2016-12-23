package com.company;
import java.text.*;
interface InterfaceCarInSalon extends  InterfaceCarCharacteristics{
    String show();
    void setPrice(String price);
    String getPrice();
}
public class CarInSalon extends CarCharacteristics implements  InterfaceCarInSalon{
    private String price;
    public CarInSalon(){}
    public CarInSalon(String []mas) throws ParseException{
        super(mas[0],mas[1],mas[2],mas[3]);
        this.price=mas[4];
    }
    public String getPrice(){
        return  price;
    }
    public void setPrice(String price){
        this.price=price;
    }
    public String show(){
       return "mark: "+getMark()+" date: "+getDate()+"  mileage: "+getMileage()+" capacity: "+getCapacity()+" price: "+price;
    }
}