package com.company;
import java.io.*;
import java.util.*;
import org.json.simple.*;
import com.thoughtworks.xstream.XStream;
class List extends Company {
    ArrayList<Company> list ;
    public List(String str) throws IOException {
        list=new ArrayList<>();
        BufferedReader bn = new BufferedReader(new FileReader(str));
        String line;
        while((line=bn.readLine())!=null) {
            list.add(new Company(line));
        }
    }
    public void findByShortTitle(String str,String file,String file2)throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        BufferedWriter bw2 = new BufferedWriter(new FileWriter(file2));
        XStream xstream = new XStream();
        xstream.alias("serializableclass", List.class);
        JSONArray ar = new JSONArray();
        for(Company c:list) {
            if ((c.getShortTitle().toLowerCase()).equals(str.toLowerCase())) {
                ar.add(c);
                bw2.append(xstream.toXML(c));
            }
        }
        bw.append("findByShortTitle: "+System.getProperty("line.separator"));
        bw.append(ar.toJSONString());
        bw.close();
        bw2.close();
    }
    public void findByBranch(String str,String file,String file2)throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        BufferedWriter bw2 = new BufferedWriter(new FileWriter(file2));
        XStream xstream = new XStream();
        xstream.alias("serializableclass", List.class);
        JSONArray ar = new JSONArray();
        for(Company c:list) {
            if ((c.getBranch().toLowerCase()).equals(str.toLowerCase())) {
                ar.add(c);
                bw2.append(xstream.toXML(c));
            }
        }
        bw.append("findByBranch: "+System.getProperty("line.separator"));
        bw.append(ar.toJSONString());
        bw.close();
        bw2.close();
    }
    public void findByActivity(String str,String file,String file2)throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        BufferedWriter bw2 = new BufferedWriter(new FileWriter(file2));
        XStream xstream = new XStream();
        xstream.alias("serializableclass", List.class);
        JSONArray ar = new JSONArray();
        for(Company c:list) {
            if ((c.getActivity().toLowerCase()).equals(str.toLowerCase())) {
                ar.add(c);
                bw2.append(xstream.toXML(c));
            }
        }
        bw.append("findByActivity: "+System.getProperty("line.separator"));
        bw.append(ar.toJSONString());
        bw.close();
        bw2.close();
    }
    public void findByCountEmployees(int x1,int x2,String file,String file2)throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        BufferedWriter bw2 = new BufferedWriter(new FileWriter(file2));
        XStream xstream = new XStream();
        xstream.alias("serializableclass", List.class);
        JSONArray ar = new JSONArray();
        for(Company c:list) {
            if (c.getCountEmployees()>=x1 && c.getCountEmployees()<=x2) {
                ar.add(c);
                bw2.append(xstream.toXML(c));
            }
        }
        bw.append("findByActivity: "+System.getProperty("line.separator"));
        bw.append(ar.toJSONString());
        bw.close();
        bw2.close();
    }
    public void findByDateFoundation(Calendar x1,Calendar x2,String file,String file2)throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        BufferedWriter bw2 = new BufferedWriter(new FileWriter(file2));
        XStream xstream = new XStream();
        xstream.alias("serializableclass", List.class);
        JSONArray ar = new JSONArray();
        for(Company c:list) {
            if (c.getDateFoundation().compareTo(x1)>0 && c.getDateFoundation().compareTo(x2)<0) {
                ar.add(c);
                bw2.append(xstream.toXML(c));
            }
        }
        bw.append("findByDateFoundation: "+System.getProperty("line.separator"));
        bw.append(ar.toJSONString());
        bw.close();
        bw2.close();
    }
}