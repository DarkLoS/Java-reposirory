package com.company;
import java.io.*;
import java.text.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException,ParseException {
        BufferedReader br = new BufferedReader(new FileReader("in.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));
        DateFormat dateFormat = new SimpleDateFormat("M.MMMM.FF.h.s");
        SimpleDateFormat format = new SimpleDateFormat("H.m.s");
        Date date;
        System.out.println("Увелечение даты в Date:");
        bw.append("Увелечение даты в Date:"+System.getProperty("line.separator"));
        date=new Date();
        for(int i=0;i<20;i++) {
            date.setMonth(date.getMonth()+1);
            date.setDate(date.getDate()+1);
            date.setHours(date.getHours()+1);
            date.setSeconds(date.getSeconds()+1);
            System.out.println( (new Formatter()).format("date: %s", dateFormat.format(date)));
            bw.append(dateFormat.format(date)+System.getProperty("line.separator"));
        }
        System.out.println("Увелечение даты в Calendar:");
        bw.append("Увелечение даты в Calendar:"+System.getProperty("line.separator"));
        Calendar cal = Calendar.getInstance();
        for(int i=0;i<20;i++) {
            cal.add(Calendar.HOUR,1);
            cal.add(Calendar.SECOND,1);
            cal.add(Calendar.MINUTE,1);
            System.out.println("date: " + format.format(cal.getTime()));
            bw.append(format.format(cal.getTime())+System.getProperty("line.separator"));
        }
        String line;
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss", Locale.ENGLISH);
        System.out.println("Чтение из файла:");
        while ((line = br.readLine()) != null) {
            cal.setTime(sdf.parse(line));
            date=sdf.parse(line);
            System.out.println("date(as Calendar): " + sdf.format(cal.getTime()));
            System.out.println("date(as Date): " + sdf.format(date));
        }
        bw.close();
    }
}
