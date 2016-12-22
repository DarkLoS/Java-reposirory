package com.company;
import java.text.*;
interface InterfaceParkDriver extends  InterfaceDriver{
    String show();
    void setSalary(String salary);
    void setTabNumber(String tabNumber);
    String getSalary();
    String getTabNumber();
}
public class ParkDriver extends Driver implements  InterfaceParkDriver{
    private String salary;
    private String tabNumber;
    public ParkDriver(){}
    public ParkDriver(String []mas) throws ParseException{
        super(mas[0],mas[1],mas[2],mas[3],mas[4]);
        this.salary=mas[5];
        this.tabNumber=mas[6];
    }
    public String getSalary(){
        return  salary;
    }
    public String getTabNumber(){
        return  tabNumber;
    }
    public void setSalary(String salary){
        this.salary=salary;
    }
    public void setTabNumber(String tabNumber){
        this.tabNumber=tabNumber;
    }
    public String show(){
       return "name: "+getName()+" address: "+getAddress()+" date: "+getDate()+" category: "+getCategory()+" experience: "+getExperience()+" salary: "+salary+" tabNumber: "+tabNumber;
    }
}