package com.company;
import java.io.*;
import java.util.*;
public abstract class Record {
    StringBuilder phone;
    StringBuilder name;
    StringBuilder adress;
    private String country;
    private String firstNumberLetters;
    private String fullNameCountry;
    public double mistake;
    public double m;
    public ArrayList<String> liststreets=new ArrayList<>();
    private Random random = new Random();
    private int indexstreets;
    public Record(String region,double mistake) throws IOException{
        if(region.equals("BY")) {firstNumberLetters="375-";fullNameCountry="Беларусь";}
        else if(region.equals("RU")) {firstNumberLetters="7-";fullNameCountry="Россия";}
        else if(region.equals("US")){ firstNumberLetters="1-";fullNameCountry="USA";}
        indexstreets=0;
        BufferedReader bnStreets = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("Streets"+region+".txt"), "UTF-8"));
        String line;
        while ((line = bnStreets.readLine()) != null) {
            liststreets.add(line);
            indexstreets++;
        }
        country=region;
        this.mistake=mistake;
        m=mistake;
    }
    public String getFirstNumberLetters(){return firstNumberLetters;}
    public String getFullNameCountry(){return fullNameCountry;}
    public String getCountry(){return country;}
    public int getStreets(){return indexstreets;}
    public StringBuilder generare(){
        if(mistake>=1000.0) mistake=1000.0;
        StringBuilder str=new StringBuilder(100);
        phone=generarePhone();
        name=generareName();
        adress=generateAdress();
        while(mistake>1.0) {
            int rand=random.nextInt(1000);
            if(rand%3==0)
                name=makeMistake(name);
            else if(rand%3==1)
                adress=makeMistake(adress);
            else if(rand%3==2)
                phone=makeMistake(phone);
        }
        mistake+=m;
        str.append(name);
        str.append(";");
        str.append(adress);
        str.append(";");
        str.append(phone);
        return str;
    }
    public abstract StringBuilder generarePhone();
    public abstract StringBuilder generareName();
    public abstract StringBuilder generateAdress();
    public  abstract StringBuilder makeMistake(StringBuilder str);
}

