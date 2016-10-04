package com.company;
import java.io.*;
import java.util.*;
import java.lang.*;
import org.json.simple.*;
import com.thoughtworks.xstream.XStream;
import java.sql.*;
public class Main {
    static void  calculate(String str) throws IOException,SQLException,ClassNotFoundException {
        BufferedReader bn = new BufferedReader(new FileReader(str));
        String line;
        Class.forName("org.sqlite.JDBC");
        final Connection c = DriverManager.getConnection("jdbc:sqlite:file.sdb");
        Statement statmt;
        ResultSet resSet;
        statmt = c.createStatement();
        int i=0;
        while((line=bn.readLine())!=null) {
            i++;
            BufferedWriter bw2 = new BufferedWriter(new FileWriter( "request"+i+".xml"));
            BufferedWriter bw = new BufferedWriter(new FileWriter( "request"+i+".json"));
            XStream xstream = new XStream();
            xstream.alias("serializableclass", List.class);
            JSONArray ar = new JSONArray();
            resSet = statmt.executeQuery(line);
            while(resSet.next())
            {
                String string = resSet.getString("name")+";"+ resSet.getString("shortTitle")+";"+
                                resSet.getString("dateUpdate") +";"+resSet.getString("address")+ ";"+
                                resSet.getString("dateFoundation") +";"+resSet.getString("countEmployees")+";"+
                                resSet.getString("auditor")+";"+resSet.getString("phone")+";"+
                                resSet.getString("email")+";"+resSet.getString("branch")+";"+
                                resSet.getString("activity")+";"+resSet.getString("internetAddress");
                System.out.println( "result= " + string );
                Company comp=new Company(string);
                System.out.println(comp);
                ar.add(comp);
                bw2.append(xstream.toXML(comp));
            }
            bw.append(ar.toJSONString());
            bw.close();
            bw2.close();
        }
    }
    public static void main(String[] args) throws IOException,SQLException,ClassNotFoundException {
        calculate("req.txt");
    }
}