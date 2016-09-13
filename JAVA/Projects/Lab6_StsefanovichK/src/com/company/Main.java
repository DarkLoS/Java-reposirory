package com.company;
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
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
interface InterfaceArea {
    public String toString();
    public void Show();
    public void setNumber(int number);
    public void setNameDirector(String nameDirector);
    public void setAdress(String adress);
    public int getNumber();
    public String getNameDirector();
    public String getAdress();
}
interface InrerfaceAttraction extends  InterfaceArea {
    public int getNumberAttraction();
    public int getYearAcquisitionint();
    public int getLifeTime();
    public String getname();
    public void setNumberAttraction(int numberAttraction);
    public void setYearAcquisitionint(int yearAcquisitionint);
    public void setLifeTime(int lifeTime);
    public void setName(String name);
}
abstract class Places
{
    private String address;
    public Places(String address){
        this.address=address;
    };
    public Places(){};
    public String getAdress()
    {
        return address;
    }
    public void setAdress(String adress)
    {
        this.address=adress;
    }
    public void Show(){};
}
class Area extends Places implements InterfaceArea
{
    private String nameDirector;
    private int number;
    public Area(int number,String nameDirector,String adress) {
        super(adress);
        this.number=number;
        this.nameDirector=nameDirector;
    }
    public Area(){};
    public void Show() {
        System.out.println("number: "+number+" nameDirector: "+nameDirector+" address: "+this.getAdress());
    }
    @Override
    public String toString() {
        return "number: "+number+" nameDirector: "+nameDirector+" address: "+this.getAdress();
    }
    public String getNameDirector()
    {
        return nameDirector;
    }
    public int getNumber()
    {
        return number;
    }
    public void setNameDirector(String nameDirector)
    {
        this.nameDirector=nameDirector;
    }
    public void setNumber(int number)
    {
        this.number=number;
    }
}
class Attraction extends Area implements InrerfaceAttraction
{
    private int numberAttraction;
    private String name;
    private int yearAcquisitionint;
    private int lifeTime;
    public Attraction(int numberAttraction,String name,int yearAcquisitionint,int lifeTime,int number,String nameDirector,String adress) {
        super(number,nameDirector,adress);
        this.numberAttraction=numberAttraction;
        this.name=name;
        this.yearAcquisitionint=yearAcquisitionint;
        this.lifeTime=lifeTime;
    }
    public Attraction(){};
    @Override
    public String toString() {
        return "number: "+this.getNumber()+" nameDirector: "+this.getNameDirector()+" address: "+this.getAdress()+" numberAttraction: "+numberAttraction+" name: "+name+" yearAcquisitionint: "+yearAcquisitionint+" lifeTime: "+lifeTime;
    }
    public void Show() {
        System.out.println("number: "+this.getNumber()+" nameDirector: "+this.getNameDirector()+" address: "+this.getAdress()+" numberAttraction: "+numberAttraction+" name: "+name+" yearAcquisitionint: "+yearAcquisitionint+" lifeTime: "+lifeTime);
    }
    public int getNumberAttraction()
    {
        return numberAttraction;
    }
    public int getYearAcquisitionint()
    {
        return yearAcquisitionint;
    }
    public int getLifeTime()
    {
        return lifeTime;
    }
    public String getname()
    {
        return name;
    }
    public void setNumberAttraction(int numberAttraction)
    {
        this.numberAttraction=numberAttraction;
    }
    public void setYearAcquisitionint(int yearAcquisitionint) {
        this.yearAcquisitionint=yearAcquisitionint;
    }
    public void setLifeTime(int lifeTime)
    {
        this.lifeTime=lifeTime;
    }
    public void setName(String name)
    {
        this.name=name;
    }
}
class Information
{
    private Calendar date;
    private int number;
    private int numberAttraction;
    private int tickets;
    public Information(){};
    public Information(Calendar date,int number,int numberAttraction,int tickets) {
        this.numberAttraction=numberAttraction;
        this.number=number;
        this.date=date;
        this.tickets=tickets;
    }
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd");
        return "date: "+sdf.format(date.getTime())+" number: "+number+" numberAttraction: "+numberAttraction+" tickets: "+tickets;
    }
    public void Show() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd");
        System.out.println("date: "+sdf.format(date.getTime())+" number: "+number+" numberAttraction: "+numberAttraction+" tickets: "+tickets);
    }
    public Calendar getDate()
    {
        return date;
    }
    public int getNumber()
    {
        return number;
    }
    public int getNumberAttraction()
    {
        return numberAttraction;
    }
    public int getTickets()
    {
        return tickets;
    }
    public void setDate( Calendar date)
    {
        this.date=date;
    }
    public void setNumberAttraction( int numberAttraction) {
        this.numberAttraction=numberAttraction;
    }
    public void setNumber(int number)
    {
        this.number=number;
    }
    public void setTickets(int tickets)
    {
        this.tickets=tickets;
    }
}