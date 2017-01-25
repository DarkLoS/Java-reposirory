package com.company;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));
        TextParser textParser=new TextParser("Alice.txt");
        Map<String,String> map =textParser.parse();
        for (Map.Entry<String, String> entry : map.entrySet()){
            bw.append("key=" + entry.getKey().substring(0,entry.getKey().indexOf(';')) + ", value=" + entry.getValue()+"\r\n");
        }
        bw.close();
    }
}
