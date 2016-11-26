package com.company;
import java.io.*;
import java.util.*;
public class Cars{
    private int K;
    private Hashtable hash;
    public Double [][] mas;
    public Cars(String str) throws IOException{
        hash=new  Hashtable();
        Scanner sc = new Scanner(new BufferedReader(new FileReader(str)));
        BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt"));
        int N=sc.nextInt();
        K=sc.nextInt();
        for(int i=1;i<=N;i++){
            int x0=sc.nextInt();
            int v=sc.nextInt();
            hash.put(new String(x0+" "+i),new Integer(v));
        }
        mas=new Double[(N*(N-1))/2][5];
        Set<String> keys = hash.keySet();
        Iterator<String> itr = keys.iterator();
        while (itr.hasNext()) {
            str = itr.next();
            bw.append("Key: "+str+" & Value: "+hash.get(str)+System.getProperty("line.separator"));
        }
        bw.close();
    }
    public void solve(){
        Enumeration enm = hash.keys();
        List<String> list = Collections.list(enm);
        int a=0;
        for(int i=0;i<list.size();i++) {
            for (int j = i + 1; j < list.size(); j++) {
                String key1 = list.get(i);
                String key2 = list.get(j);
                int x1=Integer.parseInt(key1.substring(0,key1.indexOf(" ")));
                int x2=Integer.parseInt(key2.substring(0,key2.indexOf(" ")));
                int v1 = (int) hash.get(key1);
                int v2 = (int) hash.get(key2);
                double t=(x1-x2)*1.0/(v2-v1)*1.0;
                if(t<=0.0) t=Double.MAX_VALUE;
                mas[a][0]=t;
                mas[a][1]=Double.parseDouble(key1.substring(key1.indexOf(" "),key1.length()));
                mas[a][2]=v1*1.0;
                mas[a][3]=Double.parseDouble(key2.substring(key2.indexOf(" "),key2.length()));
                mas[a][4]=v2*1.0;
                a++;
            }
        }
        Arrays.sort(mas, new DoubleComparator());
    }
    public void printOvertake(){
        for(int i=0;i<K;i++) {
            int a;int b;
            if(mas[i][2]>mas[i][4]) {
                a=mas[i][1].intValue();
                b=mas[i][3].intValue();
            }
            else{
                a=mas[i][3].intValue();
                b=mas[i][1].intValue();
            }
            if(mas[i][0]==Double.MAX_VALUE){
                System.out.println("Больше обгонов нет");
                break;
            }
            System.out.println(i+1+"-ый обгон случится через "+mas[i][0]+" секунд - "+a+"-ая машина обгонит "+b+"-ую");
        }
    }
}