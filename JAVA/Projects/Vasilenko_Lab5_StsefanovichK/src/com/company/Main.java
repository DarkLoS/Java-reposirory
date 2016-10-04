package com.company;
import java.io.*;
import java.util.*;
import java.util.regex.*;
public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader bn = new BufferedReader(new InputStreamReader(new FileInputStream("in.txt"), "Cp1251"));
        BufferedReader bn2 = new BufferedReader(new InputStreamReader(new FileInputStream("words.txt"), "Cp1251"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));
        BufferedWriter bw2 = new BufferedWriter(new FileWriter("out2.txt"));
        BufferedWriter bw3 = new BufferedWriter(new FileWriter("out3.txt"));
        String line;
        String str="";
        String buffer="";
        while((line=bn.readLine())!=null) {
            str+=line+"\n";
            buffer+=line;
        }
        String s1="";
        String s2=".*";
        for(int i=0;i<10;i++) {
            str = str.replaceAll("<"+s2+"?>", s1);
            s1+="\n";
            s2+=".*\n";
        }
        buffer=buffer.replaceAll(">.*?<","><");
        String[] parts=buffer.split("[<>]+");
        HashSet<String> set=new HashSet<>();
        for(String s:parts)
            if(!s.equals(""))
            set.add(s.toLowerCase());
        String[] string=set.toArray(new String[set.size()]);
        Arrays.sort(string,new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return  a.length()>b.length() ? 1 : a.length()<b.length()? -1 :0;
            }});
        for(String s:string)
           bw.append("<"+s+">"+System.getProperty("line.separator"));
        parts=str.split("\n");
        while((line=bn2.readLine())!=null) {
            String[] lines=line.split(";");
            for(int i=0;i<lines.length;i++) {
                int check=0;
                for (int j = 0; j < parts.length; j++) {
                    if ((parts[j].toLowerCase()).contains(lines[i].toLowerCase())) {
                        bw2.append(String.valueOf(j) + ";");
                        check=1;
                        break;
                    }
                }
                if(check==0) {
                    bw2.append(String.valueOf(-1) + ";");
                    bw3.append(lines[i] + ";");
                }
            }
        }
        bw.close();
        bw2.close();
        bw3.close();
    }
}
