package com.company;
import java.io.*;
import java.util.*;
class RegionByRu extends  Record{
    private int indexCities;
    private int indexNamesW;
    private int indexNamesM;
    private int indexSurnamesW;
    private int indexSurnamesM;
    private ArrayList<String>listCities=new ArrayList<>();
    private ArrayList<String>listnamesW=new ArrayList<>();
    private ArrayList<String>listnamesM=new ArrayList<>();
    private ArrayList<String>listsurnamesM=new ArrayList<>();
    private ArrayList<String>listsurnamesW=new ArrayList<>();
    private Random random = new Random();
    public RegionByRu(String region,double mistake)throws IOException {
        super(region,mistake);
        FillCities(region);
        FillNames(region);
        FillSurnames(region);
    }
    private void FillCities(String region)throws IOException{
        indexCities=0;
        String line;
        Random random = new Random();
        BufferedReader bnCities = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("Cities" + region + ".txt"), "UTF-8"));
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
    private void FillNames(String region)throws IOException{
        String line;
        indexNamesW=0;
        indexNamesM=0;
        BufferedReader bnNamesW = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream(region+"_names_womans.txt"),"UTF-8"));
        BufferedReader bnNamesM = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream(region+"_names_mans.txt"),"UTF-8"));
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
    }
    private void FillSurnames(String region)throws IOException{
        String line;
        indexSurnamesM=0;
        indexSurnamesW=0;
        BufferedReader bnSurnamesW = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream(region+"_surnames_woman.txt"),"UTF-8"));
        BufferedReader bnSurnamesM = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream(region+"_surnames_mans.txt"),"UTF-8"));
        while ((line = bnSurnamesW.readLine()) != null) {
            listsurnamesW.add(line);
            indexSurnamesW++;
        }
        while ((line = bnSurnamesM.readLine()) != null) {
            listsurnamesM.add(line);
            indexSurnamesM++;
        }
    }
    public StringBuilder generarePhone(){
        StringBuilder ph=new StringBuilder(150);
        ph.append(getFirstNumberLetters());
        if(getCountry().equals("RU"))ph.append((random.nextInt(100) + 900));
        else if(getCountry().equals("BY")) {
            int x;
            int rand=random.nextInt();
            if(rand%4==0)x=29;
            else if(rand%4==1)x=33;
            else if(rand%4==2)x=44;
            else x=25;
            ph.append(x);
        }
        ph.append("-");
        ph.append(random.nextInt(10));
        ph.append(random.nextInt(10));
        ph.append(random.nextInt(10));
        ph.append("-");
        ph.append(random.nextInt(10));
        ph.append(random.nextInt(10));
        ph.append(random.nextInt(10));
        ph.append(random.nextInt(10));
        return ph;
    }
    public StringBuilder generareName(){
        StringBuilder n=new StringBuilder(150);
        if(random.nextInt()%2==0) {
            int r = random.nextInt(indexSurnamesW);
            n.append(listnamesW.get(r % indexNamesW));
            n.append(" ");
            n.append(listsurnamesW.get(r));
        }
        else{
            int r = random.nextInt(indexSurnamesM);
            n.append(listnamesM.get(r % indexNamesM));
            n.append(" ");
            n.append(listsurnamesM.get(r));
        }
        return n;
    }
    public StringBuilder generateAdress(){
        int rs = random.nextInt(getStreets());
        StringBuilder adress=new StringBuilder(150);
        String city;
        city = listCities.get(random.nextInt(indexCities));
        adress.append("ул.");
        adress.append(liststreets.get(rs));
        adress.append(",");
        adress.append((random.nextInt(100) + 1));
        adress.append(",");
        adress.append((random.nextInt(500) + 1));
        adress.append(",");
        adress.append(city.substring(0, city.indexOf(';')));
        adress.append(",");
        adress.append(city.substring(city.indexOf(';') + 1, city.length()));
        adress.append(random.nextInt(1000));
        adress.append(","+getFullNameCountry());
        return adress;
    }
    public StringBuilder makeMistake(StringBuilder str) {
        int rand = random.nextInt(1000);
        if (rand % 3 == 0) {
            if(str.length()==0){}
            else {
                int t = random.nextInt(str.length());
                str.deleteCharAt(t);
            }
        } else if (rand % 3 == 1) {
            if(str.length()==0) str.append(random.nextInt(32) + 1072);
            int rnd = random.nextInt(str.length());
            int r = random.nextInt();
            if (r % 42 == 0 && getCountry().equals("BY"))
                str.insert(rnd, 'i');
            else if (r % 42 == 1&& getCountry().equals("BY"))
                str.insert(rnd, 'ў');
            else if (r % 42 >= 1&& r%42<=32)str.insert(rnd, (char) (random.nextInt(32) + 1072));
            else str.insert(rnd, (char) (random.nextInt(10) + 48));
        }
        else {
            if(str.length() - 1<=0){}
            else{
                int t = random.nextInt(str.length() - 1);
                char buf = str.charAt(t);
                str.setCharAt(t, str.charAt(t + 1));
                str.setCharAt(t + 1, buf);
            }
        }
        mistake -= 1.0;
        return  str;
    }
}