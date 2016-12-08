package com.company;
import java.io.*;
import java.util.*;
class RegionUS extends Record{
    private int indexCities;
    private int indexNames;
    private int indexSurnames;
    private ArrayList<String>listCities=new ArrayList<>();
    private ArrayList<String>listnames=new ArrayList<>();
    private ArrayList<String>listsurnames=new ArrayList<>();
    HashMap<String,String> hashMap=new HashMap<>();
    private Random random = new Random();
    public RegionUS(String region,double mistake)throws IOException {
        super(region,mistake);
        FillCities(region);
        FillNames(region);
        FillSurnames(region);
    }
    private void FillNames(String region)throws IOException{
        String line;
        indexNames=0;
        BufferedReader bnNames = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream(region+"_names.txt"),"UTF-8"));
        while ((line = bnNames.readLine()) != null) {
            listnames.add(line);
            indexNames++;
        }
    }
    private void FillSurnames(String region)throws IOException{
        String line;
        indexSurnames=0;
        BufferedReader bnSurnames = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream(region+"_surnames.txt"),"UTF-8"));
        while ((line = bnSurnames.readLine()) != null) {
            listsurnames.add(line);
            indexSurnames++;
        }
    }
    private void FillCities(String region)throws IOException{
        indexCities=0;
        String line;
        Random random = new Random();
        BufferedReader bnCities = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("Cities" + region + ".txt"), "UTF-8"));
        BufferedReader bnCodes=new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("codes.txt"),"UTF-8"));
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
    public StringBuilder generarePhone(){
        StringBuilder city = new StringBuilder(listCities.get(random.nextInt(indexCities)));
        StringBuilder ph=new StringBuilder(150);
        ph.append(getFirstNumberLetters());
        ph.append(city.substring(city.lastIndexOf(";")+1));
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
        int r = random.nextInt(indexSurnames);
        n.append(listnames.get(r % indexNames));
        n.append(" ");
        n.append(listsurnames.get(r));
        return n;
    }
    public StringBuilder generateAdress(){
        int rs = random.nextInt(getStreets());
        StringBuilder adress=new StringBuilder(150);
        StringBuilder city = new StringBuilder(listCities.get(random.nextInt(indexCities)));
        adress.append((random.nextInt(200)+1));
        adress.append(" ");
        adress.append(liststreets.get(rs));
        adress.append(",");
        adress.append((random.nextInt(1000)+1));
        adress.append(",");
        adress.append(city.substring(0, city.indexOf(";")));
        adress.append(",");
        adress.append(city.substring(city.indexOf(";") + 1, city.lastIndexOf(";")));
        adress.append(random.nextInt(1000));
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
            if(str.length()==0) str.append(random.nextInt(10) + 48);
            int rnd = random.nextInt(str.length());
            int r = random.nextInt();
            if (r % 3 == 0 )
                str.insert(rnd, (char) (random.nextInt(26) + 97));
            else if (r % 3 == 1 )
                str.insert(rnd, (char) (random.nextInt(26) + 65));
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