package com.company;
import java.io.*;
import java.text.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException,ParseException {
        BufferedReader br = new BufferedReader(new FileReader("in.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));
        DateFormat dateFormat = new SimpleDateFormat("MMM.ww.EEEE.m.S");
        SimpleDateFormat format = new SimpleDateFormat("D.s.S");
        Date date;
        System.out.println("Увелечение даты в Date:");
        bw.append("Увелечение даты в Date:"+System.getProperty("line.separator"));
        for(int i=0;i<20;i++) {
            date=new Date();
            date.setDate(date.getDate()+i);
            date.setMinutes(date.getMinutes()+i);
            System.out.println( (new Formatter()).format("date: %s", dateFormat.format(date)));
            bw.append(dateFormat.format(date)+System.getProperty("line.separator"));
        }
        System.out.println("Увелечение даты в Calendar:");
        bw.append("Увелечение даты в Calendar:"+System.getProperty("line.separator"));
        Calendar cal = Calendar.getInstance();
        for(int i=0;i<20;i++) {
            cal.add(Calendar.DAY_OF_YEAR,1);
            cal.add(Calendar.SECOND,1);
            cal.setTimeInMillis(cal.getTimeInMillis()+1);
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
