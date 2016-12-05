package com.company;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args)throws IOException {
        String country=args[0];
        double mistake=Double.parseDouble(args[2]);
        int step=Integer.parseInt(args[1]);
        Random random = new Random();
        BufferedReader bnNames=new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("us.txt"),"UTF-8"));
        BufferedReader bnSurnames=new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("us1.txt"),"UTF-8"));
        BufferedReader bnNamesW=new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("russian_names_womans.txt"),"UTF-8"));
        BufferedReader bnNamesM=new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("russian_names_mans.txt"),"UTF-8"));
        BufferedReader bnSurnamesW=new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("russian_surnames_woman.txt"),"UTF-8"));
        BufferedReader bnSurnamesM=new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("russian_surnames_mans.txt"),"UTF-8"));
        BufferedReader bnStreets=new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("StreetsRus.txt"),"UTF-8"));
        BufferedReader bnCities=new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("russian_cities.txt"),"UTF-8"));
        BufferedReader bnCodes=new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("codes.txt"),"UTF-8"));
        HashMap<String,String> hashMap=new HashMap<>();
        if(country.equals(new String("RU"))) {
        }
        else if(country.equals(new String("BY"))) {
            bnNamesW = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("belarus_names_womans.txt"),"UTF-8"));
            bnNamesM = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("belarus_names_mans.txt"),"UTF-8"));
            bnSurnamesW = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("belarus_surnames_woman.txt"),"UTF-8"));
            bnSurnamesM = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("belarus_surnames_mans.txt"),"UTF-8"));
            bnStreets = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("StreetsBel.txt"),"UTF-8"));
            bnCities = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("belarus_cities.txt"),"UTF-8"));
        }
        else if(country.equals(new String("US"))) {
            bnStreets = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("USA_streets.txt"),"UTF-8"));
            bnCities = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("usa_cities.txt"),"UTF-8"));
        }
        String line;
        ArrayList<String>listnames=new ArrayList<>();
        ArrayList<String>listsurnames=new ArrayList<>();

        ArrayList<String>listnamesW=new ArrayList<>();
        ArrayList<String>listnamesM=new ArrayList<>();
        ArrayList<String>listsurnamesM=new ArrayList<>();
        ArrayList<String>listsurnamesW=new ArrayList<>();
        ArrayList<String>liststreets=new ArrayList<>();
        ArrayList<String>listCities=new ArrayList<>();
        int indexNamesW=0,indexNamesM=0,indexSurnamesW=0,indexSurnamesM=0,indexstreets=0,indexCities=0,indexNames=0,indexSurnames=0;
        if(country.equals(new String("BY"))||country.equals(new String("RU"))) {
            while ((line = bnNamesW.readLine()) != null) {
                String[] arr = line.split(";");
                for (int i = 0; i < Integer.parseInt(arr[1]); i++) {
                    listnamesW.add(arr[0]);
                    indexNamesW++;
                }
            }
            while ((line = bnNamesM.readLine()) != null) {
                String[] arr = line.split(";");
                for (int i = 0; i < Integer.parseInt(arr[1]); i++) {
                    listnamesM.add(arr[0]);
                    indexNamesM++;
                }
            }
            while ((line = bnSurnamesW.readLine()) != null) {
                listsurnamesW.add(line);
                indexSurnamesW++;
            }
            while ((line = bnSurnamesM.readLine()) != null) {
                listsurnamesM.add(line);
                indexSurnamesM++;
            }
        }
        else{
            while ((line = bnSurnames.readLine()) != null) {
                listsurnames.add(line);
                indexSurnames++;
            }
            while ((line = bnNames.readLine()) != null) {
                listnames.add(line);
                indexNames++;
            }
        }
        while ((line = bnStreets.readLine()) != null) {
            liststreets.add(line);
            indexstreets++;
        }
        if(country.equals(new String("BY"))||country.equals(new String("RU"))) {
            while ((line = bnCities.readLine()) != null) {
                String buffer = "";
                String[] arr = line.split(",");
                for (int i = 0; i < Integer.parseInt(arr[1]); i++) {
                    if (Integer.parseInt(arr[3]) > Integer.parseInt(arr[2]))
                        buffer = arr[0] + ";" + (random.nextInt(Integer.parseInt(arr[3]) - Integer.parseInt(arr[2])) + Integer.parseInt(arr[3]));
                    else
                        buffer = arr[0] + ";" + Integer.parseInt(arr[3]);
                    buffer = buffer.replace(' ', ' ');
                    listCities.add(buffer);
                    indexCities++;
                }
            }
        }
        else
        {
            while ((line = bnCodes.readLine()) != null) {
                String buf=line.substring(line.lastIndexOf(' '));
                String buf2=line.substring(0,line.lastIndexOf(' '));
                hashMap.put(buf2,buf);
            }
            while ((line = bnCities.readLine()) != null) {
                String buffer = "";
                String[] arr = line.split(" ");
                for (int i = 0; i < Integer.parseInt(arr[1]); i++) {
                    if (Integer.parseInt(arr[3]) > Integer.parseInt(arr[2]))
                        buffer = arr[0] + ";" + (random.nextInt(Integer.parseInt(arr[3]) - Integer.parseInt(arr[2])) + Integer.parseInt(arr[3]));
                    else
                        buffer = arr[0] + ";" + Integer.parseInt(arr[3]);
                    for(int j=0;j<buffer.length();j++)
                        if(buffer.charAt(j)>150)
                            buffer = buffer.replace(buffer.charAt(j), ' ');
                    String b=hashMap.get(arr[0].substring(arr[0].indexOf(',')+1));
                    b=b.substring(1);
                    int x=(random.nextInt(b.length()/3))*3;
                    b=b.substring(x,x+3);
                    listCities.add(buffer+";"+b);
                    indexCities++;
                }
            }
        }
        int r,rs,rnd,rand;
        StringBuilder str;
        char buf;
        int t;
        double m=mistake;
        String city;
        if(country.equals(new String("RU"))) {
            for (int i = 0; i < step; i++) {
                if(random.nextInt()%2==0) {
                    r = random.nextInt(indexSurnamesW);
                    rs = random.nextInt(indexstreets);
                    city = listCities.get(random.nextInt(indexCities));
                    str = new StringBuilder(listnamesW.get(r % indexNamesW) + " " + listsurnamesW.get(r) + ";ул." + liststreets.get(rs) + "," + (random.nextInt(100) + 1) + "," + (random.nextInt(500) + 1) + "," + city.substring(0, city.indexOf(';')) + "," + city.substring(city.indexOf(';') + 1, city.length()) + random.nextInt(1000) + ",Россия;+7-" + (random.nextInt(100) + 900) + "-" + random.nextInt(10)+ random.nextInt(10) + random.nextInt(10) + "-" + random.nextInt(10) + random.nextInt(10) + random.nextInt(10) + random.nextInt(10));
                }
                else{
                    r = random.nextInt(indexSurnamesM);
                    rs = random.nextInt(indexstreets);
                    city = listCities.get(random.nextInt(indexCities));
                    str = new StringBuilder(listnamesM.get(r % indexNamesM) + " " + listsurnamesM.get(r) + ";ул." + liststreets.get(rs) + "," + (random.nextInt(100) + 1) + "," + (random.nextInt(500) + 1) + "," + city.substring(0, city.indexOf(';')) + "," + city.substring(city.indexOf(';') + 1, city.length()) + random.nextInt(1000) + ",Россия;+7-" + (random.nextInt(100) + 900) + "-" + random.nextInt(10)+ random.nextInt(10) + random.nextInt(10) + "-" + random.nextInt(10) + random.nextInt(10) + random.nextInt(10) + random.nextInt(10));
                }
                if (mistake > str.length()) mistake = str.length();
                while(mistake>1.0) {
                    rand=random.nextInt();
                    if (rand % 3 == 0) {
                        while (true) {
                            t = random.nextInt(str.length());
                            if (str.charAt(t) != ' ') {
                                str.deleteCharAt(t);
                                break;
                            }
                        }
                    } else if (rand % 3 == 1) {
                        rnd = random.nextInt(str.length());
                        if ((rnd < str.length() - 1 && str.charAt(rnd + 1) >= 'а' && str.charAt(rnd + 1) <= 'я') || (rnd > 0 && str.charAt(rnd - 1) >= 'а' && str.charAt(rnd - 1) <= 'я'))
                            str.insert(rnd, (char) (random.nextInt(32) + 1072));
                        if ((rnd < str.length() - 1 && str.charAt(rnd + 1) >= '0' && str.charAt(rnd + 1) <= '9') || (rnd > 0 && str.charAt(rnd - 1) >= '0' && str.charAt(rnd - 1) <= '9'))
                            str.insert(rnd, (char) (random.nextInt(10) + 48));
                    } else {
                        t = random.nextInt(str.length() - 1);
                        buf = str.charAt(t);
                        str.setCharAt(t, str.charAt(t + 1));
                        str.setCharAt(t + 1, buf);
                    }
                    mistake-=1.0;
                }
                System.out.println(str + System.getProperty("line.separator"));
                mistake+=m;
            }
        }
        else if(country.equals(new String("BY"))) {
            int x=0;rand=0;
            for (int i = 0; i < step; i++) {
                rand=random.nextInt();
                if(rand%4==0)x=29;
                else if(rand%4==1)x=33;
                else if(rand%4==2)x=44;
                else x=25;
                if(random.nextInt()%2==0) {
                    r = random.nextInt(indexSurnamesW);
                    rs = random.nextInt(indexstreets);
                    city = listCities.get(random.nextInt(indexCities));
                    str = new StringBuilder(listnamesW.get(r % indexNamesW) + " " + listsurnamesW.get(r) + ";ул." + liststreets.get(rs) + "," + (random.nextInt(100) + 1) + "," + (random.nextInt(500) + 1) + "," + city.substring(0, city.indexOf(';')) + "," + city.substring(city.indexOf(';') + 1, city.length()) + random.nextInt(1000) + ",Беларусь;+375-" + x + "-" + random.nextInt(10) + random.nextInt(10)+ random.nextInt(10) + "-" + random.nextInt(10) + random.nextInt(10) + random.nextInt(10) + random.nextInt(10));
                }
                else{
                    r = random.nextInt(indexSurnamesM);
                    rs = random.nextInt(indexstreets);
                    city = listCities.get(random.nextInt(indexCities));
                    str = new StringBuilder(listnamesM.get(r % indexNamesM) + " " + listsurnamesM.get(r) + ";ул." + liststreets.get(rs) + "," + (random.nextInt(100) + 1) + "," + (random.nextInt(500) + 1) + "," + city.substring(0, city.indexOf(';')) + "," + city.substring(city.indexOf(';') + 1, city.length()) + random.nextInt(1000) + ",Беларусь;+375-" + x + "-" + random.nextInt(10) + random.nextInt(10)+ random.nextInt(10) + "-" + random.nextInt(10) + random.nextInt(10) + random.nextInt(10) + random.nextInt(10));
                }
                if (mistake > str.length()) mistake = str.length();
                while(mistake>1.0) {
                    rand=random.nextInt();
                    if (rand % 3 == 0) {
                        while (true) {
                            t = random.nextInt(str.length());
                            if (str.charAt(t) != ' ') {
                                str.deleteCharAt(t);
                                break;
                            }
                        }
                    } else if (rand % 3 == 1) {
                        rnd = random.nextInt(str.length());
                        if ((rnd < str.length() - 1 && str.charAt(rnd + 1) >= 'а' && str.charAt(rnd + 1) <= 'я') || (rnd > 0 && str.charAt(rnd - 1) >= 'а' && str.charAt(rnd - 1) <= 'я')||str.charAt(rnd)=='і'||str.charAt(rnd)=='ў') {
                            r=random.nextInt();
                            if(r%32==0)
                                str.insert(rnd, 'i');
                            else if(r%32==1)
                                str.insert(rnd, 'ў');
                            else str.insert(rnd, (char) (random.nextInt(32) + 1072));
                        }
                        if ((rnd < str.length() - 1 && str.charAt(rnd + 1) >= '0' && str.charAt(rnd + 1) <= '9') || (rnd > 0 && str.charAt(rnd - 1) >= '0' && str.charAt(rnd - 1) <= '9'))
                            str.insert(rnd, (char) (random.nextInt(10) + 48));
                    } else {
                        t = random.nextInt(str.length() - 1);
                        buf = str.charAt(t);
                        str.setCharAt(t, str.charAt(t + 1));
                        str.setCharAt(t + 1, buf);
                    }
                    mistake-=1.0;
                }
                System.out.println(str + System.getProperty("line.separator"));
                mistake+=m;
            }
        }
        else if(country.equals(new String("US"))) {
            for (int i = 0; i < step; i++) {
                    r = random.nextInt(indexSurnames);
                    rs = random.nextInt(indexstreets);
                    city = listCities.get(random.nextInt(indexCities));
                    str = new StringBuilder(listnames.get(r % indexNames) + " " + listsurnames.get(r)+";"+(random.nextInt(200)+1)+" "+ liststreets.get(rs)+","+(random.nextInt(1000)+1)+","+ city.substring(0, city.indexOf(';')) + "," + city.substring(city.indexOf(';') + 1, city.lastIndexOf(';')) + random.nextInt(1000)+",USA;"+"+1-"+ city.substring(city.lastIndexOf(';')+1)+"-"+random.nextInt(10) + random.nextInt(10)+ random.nextInt(10) + "-" + random.nextInt(10) + random.nextInt(10) + random.nextInt(10) + random.nextInt(10));
                if (mistake > str.length()) mistake = str.length();
                while(mistake>1.0) {
                    rand=random.nextInt();
                    if (rand % 3 == 0) {
                        while (true) {
                            t = random.nextInt(str.length());
                            if (str.charAt(t) != ' ') {
                                str.deleteCharAt(t);
                                break;
                            }
                        }
                    } else if (rand % 3 == 1) {
                        rnd = random.nextInt(str.length());
                        if ((rnd < str.length() - 1 && str.charAt(rnd + 1) >= 'a' && str.charAt(rnd + 1) <= 'z') || (rnd > 0 && str.charAt(rnd - 1) >= 'a' && str.charAt(rnd - 1) <= 'z'))
                            str.insert(rnd, (char) (random.nextInt(26) + 97));
                        if ((rnd < str.length() - 1 && str.charAt(rnd + 1) >= '0' && str.charAt(rnd + 1) <= '9') || (rnd > 0 && str.charAt(rnd - 1) >= '0' && str.charAt(rnd - 1) <= '9'))
                            str.insert(rnd, (char) (random.nextInt(10) + 48));
                    } else {
                        t = random.nextInt(str.length() - 1);
                        buf = str.charAt(t);
                        str.setCharAt(t, str.charAt(t + 1));
                        str.setCharAt(t + 1, buf);
                    }
                    mistake-=1.0;
                }
                System.out.println((str + System.getProperty("line.separator")));
                mistake+=m;
            }
        }
    }
}
