package com.company;
import java.util.*;
import java.text.SimpleDateFormat;
class Company {
    private String name;
    private String shortTitle;
    private String dateUpdate;
    private String address;
    private Calendar dateFoundation;
    private int countEmployees;
    private String auditor;
    private String phone;
    private String email;
    private String branch;
    private String activity;
    private String internetAddress;
    public Company(String str){
        String[] parts=str.split(";");
        name=parts[0];
        shortTitle=parts[1];
        dateUpdate=parts[2];
        address=parts[3];
        dateFoundation= new GregorianCalendar(Integer.parseInt(parts[4].substring(6,10)),Integer.parseInt(parts[4].substring(3,5)),Integer.parseInt(parts[4].substring(0,2)));
        countEmployees=Integer.parseInt(parts[5]);
        auditor=parts[6];
        phone=parts[7];
        email=parts[8];
        branch=parts[9];
        activity=parts[10];
        internetAddress=parts[11];
    }
    public Company(){}
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd");
        return "name: "+name+"\nshortTitle: "+shortTitle+"\ndateUpdate: "+dateUpdate+"\naddress: "+address+"\ndateFoundation: "+sdf.format(dateFoundation.getTime())+"\ncountEmployees: "+countEmployees+"\nauditor: "+auditor+"\nphone: "+phone+"\nemail: "+email+"\nbranch: "+branch+"\nactivity: "+activity+"\ninternetAddress: "+internetAddress+"\n\n";
    }
    public String getShortTitle() {
        return shortTitle;
    }
    public String getBranch() {
        return branch;
    }
    public String getActivity() {
        return activity;
    }
    public int getCountEmployees() {
        return countEmployees;
    }
    public Calendar getDateFoundation() {
        return dateFoundation;
    }
}