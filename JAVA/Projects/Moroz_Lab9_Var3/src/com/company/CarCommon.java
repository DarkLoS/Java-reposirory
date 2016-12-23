package com.company;
import java.util.*;
import java.text.*;
public abstract class CarCommon implements java.io.Serializable{
    private String mark;
    private Date date;
    private transient SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    public CarCommon(){}
    public CarCommon(String mark,String date)throws ParseException{
        this.mark=mark;
        this.date=sdf.parse(date);
    }
    public String getMark(){
        return mark;
    }
    public String getDate(){
        return date.toString();
    }
    public void setMark(String mark){
        this.mark=mark;
    }
    public void setDate(Date date){
        this.date=date;
    }
    public String show(){return "";}
}