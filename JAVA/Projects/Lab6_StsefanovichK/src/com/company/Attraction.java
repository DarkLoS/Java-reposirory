package com.company;
interface InterfaceArea {
    String toString();
    void Show();
    void setNumber(int number);
    void setNameDirector(String nameDirector);
    void setAdress(String adress);
    int getNumber();
    String getNameDirector();
    String getAdress();
}
interface InrerfaceAttraction extends InterfaceArea {
    int getNumberAttraction();
    int getYearAcquisitionint();
    int getLifeTime();
    String getname();
    void setNumberAttraction(int numberAttraction);
    void setYearAcquisitionint(int yearAcquisitionint);
    void setLifeTime(int lifeTime);
    void setName(String name);
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
class Area extends com.company.Places implements com.company.InterfaceArea
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
class Attraction extends com.company.Area implements com.company.InrerfaceAttraction
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