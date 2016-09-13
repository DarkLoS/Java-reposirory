package com.company;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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