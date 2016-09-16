package com.company;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedWriter out = new BufferedWriter(new FileWriter("out.txt"));
        Scanner sc = new Scanner(new File("1.txt"));
        while (sc.hasNextLine()) {
            int len=0;
            String str=sc.nextLine();
            StringTokenizer st = new StringTokenizer(str,".");
            if(str.charAt(0)!='.') {
                len+= st.nextToken().length();
            }
            while (st.hasMoreTokens()) {
                String s=st.nextToken();
                int buf=0;
                for(int i=0;i<s.length();i++)
                {
                    if(s.charAt(i)>'9' ||s.charAt(i)<'0') break;
                    buf++;
                }
                if(buf>=3) {
                    str=str.substring(0,len+3)+str.substring(len+buf+1);
                    System.out.println(str);
                    len=len-buf+2;
                }
                len+=s.length()+1;
            }
            out.append(str+System.getProperty("line.separator"));
        }
        out.close();
    }
}
