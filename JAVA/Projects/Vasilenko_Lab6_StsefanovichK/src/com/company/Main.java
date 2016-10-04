package com.company;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.logging.*;
public class Main {
    public static void main(String[] args) throws IOException {
        List list=new List("1.csv");
        Scanner in =new Scanner(System.in);
        int x=in.nextInt();
        switch (x) {
            case 1:  list.findByShortTitle("AugInc","out.json","1.xml");
                break;
            case 2:  list.findByBranch("software development","out.json","1.xml");
                break;
            case 3:  list.findByActivity("software development","out.json","1.xml");
                break;
            case 4:  list.findByCountEmployees(1,500,"out.json","1.xml");
                break;
            case 5:  list.findByDateFoundation(new GregorianCalendar(1990,0,31),new GregorianCalendar(2013,0,31),"out.json","1.xml");
                break;
            default:
                System.out.println("Wrong!!!");;
                break;
        }
}
}
