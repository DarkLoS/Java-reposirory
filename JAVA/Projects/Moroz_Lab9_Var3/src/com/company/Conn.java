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
        conn = DriverManager.getConnection("jdbc:sqlite:database.sdb");
        System.out.println("База Подключена!");
    }
    public static void createDB() throws ClassNotFoundException, SQLException{
        try{
            BufferedWriter fout = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("database.sdb")));
            fout.flush();
            fout.write("");
            fout.close();
        }
        catch (IOException e){
            System.out.println(e);
        }
        statmt = conn.createStatement();
        statmt.execute("CREATE TABLE if not exists 'cars' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'mark' text,'date' text,' mileage' text,'capacity' text,'price' text);");
        System.out.println("Таблица создана или уже существует.");
    }
    public static void writeDB(List<CarInSalon> list) throws SQLException{
        for(CarInSalon p:list) {
            statmt.execute("INSERT INTO 'cars' ('mark','date',' mileage','capacity','price') VALUES ('"+p.getMark()+"', '"+p.getDate()+"','"+p.getMileage()+"','"+p.getCapacity()+"','"+p.getPrice()+"'); ");
        }
        System.out.println("Таблица заполнена");
    }
}