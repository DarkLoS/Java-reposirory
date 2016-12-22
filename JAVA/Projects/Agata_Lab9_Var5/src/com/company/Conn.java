package com.company;
import java.sql.*;
import java.io.*;
import java.util.*;
class Database {
    public static Connection conn;
    public static Statement statmt;
    public static void connect() throws ClassNotFoundException, SQLException{
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:123.sdb");
        System.out.println("База Подключена!");
    }
    public static void createDB() throws ClassNotFoundException, SQLException{
        try{
            BufferedWriter fout = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("123.sdb")));
            fout.flush();
            fout.write("");
            fout.close();
        }
        catch (IOException e){
            System.out.println(e);
        }
        statmt = conn.createStatement();
        statmt.execute("CREATE TABLE if not exists 'drivers' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'address' text,'date' text,'category' text,'experience' text,'salary' text,'tabNumber' text);");
        System.out.println("Таблица создана или уже существует.");
    }
    public static void writeDB(List<ParkDriver> list) throws SQLException{
        for(ParkDriver p:list) {
            statmt.execute("INSERT INTO 'drivers' ('name', 'address','date','category','experience','salary','tabNumber') VALUES ('"+p.getName()+"', '"+p.getAddress()+"', '"+p.getDate()+"','"+p.getCategory()+"','"+p.getExperience()+"','"+p.getSalary()+"','"+p.getTabNumber()+"'); ");
        }
        System.out.println("Таблица заполнена");
    }
}