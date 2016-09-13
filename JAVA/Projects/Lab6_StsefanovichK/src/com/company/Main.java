package com.company;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        try {
            RandomAccessFile fin =new  RandomAccessFile("1.txt","r");
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("out.txt"), "Cp1251"));
            bw.flush();
            String line;
            int n = Integer.parseInt(fin.readLine());
            Attraction[] place = new Attraction[n];
            for(int i=0;i<n;i++) {
                place[i]=new Attraction();
                line=new String(fin.readLine().getBytes("ISO-8859-1"), "windows-1251");
                String[] parts=line.split(" ");
                place[i].setNumberAttraction(Integer.parseInt(parts[0]));
                place[i].setName(parts[1]);
                place[i].setYearAcquisitionint(Integer.parseInt(parts[2]));
                place[i].setLifeTime(Integer.parseInt(parts[3]));
                place[i].setNumber(Integer.parseInt(parts[4]));
                place[i].setNameDirector(parts[5]);
                place[i].setAdress(parts[6]);
            }
            for(int i=0;i<n;i++) {
            System.out.println(place[i].toString());
            }
            n = Integer.parseInt(fin.readLine());
            Information[] inf = new Information[n];
            for(int i=0;i<n;i++) {
                inf[i]=new Information();
                line=new String(fin.readLine().getBytes("ISO-8859-1"), "windows-1251");
                String[] parts=line.split(" ");
                inf[i].setDate(new GregorianCalendar(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),Integer.parseInt(parts[2])));
                inf[i].setNumber(Integer.parseInt(parts[3]));
                inf[i].setNumberAttraction(Integer.parseInt(parts[4]));
                inf[i].setTickets(Integer.parseInt(parts[5]));
            }
            for(int i=0;i<n;i++) {
                System.out.println(inf[i].toString());
            }
            for(Information i :inf)
                for(Attraction a :place)
                {bw.flush();
                    if(a.getNumber()==i.getNumber() && a.getNumberAttraction()==i.getNumberAttraction())
                       bw.append(a.toString()+System.getProperty("line.separator"));
                }
        }
        catch (FileNotFoundException e){
            System.out.println(e);
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
}

