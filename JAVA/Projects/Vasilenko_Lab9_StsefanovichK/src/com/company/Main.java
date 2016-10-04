package com.company;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Regex> list = new ArrayList<>();
        BufferedReader bn = new BufferedReader(new FileReader("in.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));
        String line;
        while((line=bn.readLine())!=null) {
            list.add(new Regex(line));
        }
        for(int i=0;i<list.size();i++)
        {
            if(i%3==0)
              list.get(i).calculateBrackets();
            if(i%3==1)
                list.get(i).calculateDeleteAfterTwo();
            if(i%3==2)
                list.get(i).calculateDeleteZero();
            bw.append(list.get(i).toString()+System.getProperty("line.separator"));
        }
        bw.close();
    }
}
