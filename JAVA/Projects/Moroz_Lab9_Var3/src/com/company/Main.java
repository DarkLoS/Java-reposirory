package com.company;
import java.io.*;
import java.security.*;
import java.sql.*;
import java.util.*;
import java.text.*;

public class Main {
    public static void main(String[] args) throws IOException,ParseException,ClassNotFoundException,NoSuchAlgorithmException,SQLException{
        Access access=new Access();
        ChangeFile change=new ChangeFile();
        ListCarInSalon list=new ListCarInSalon("input.txt");
        // ListCarInSalon list=new ListCarInSalon("output.xml","xml");
        //ListCarInSalon list=new ListCarInSalon("output.bin","bin");
        System.out.println(list.toString());
        list.saveToXML("output.xml");
        list.saveBin("output.bin");
        list.writeToDatabase();
        change.change("input2.txt",5,"****");
    }
}
